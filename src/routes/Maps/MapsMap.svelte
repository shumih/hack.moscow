<script>
  import { onMount, afterUpdate } from 'svelte';
    import { navigate } from "svelte-routing";

  const types = [
    { text: 'Карта', type: 'map' },
    { text: 'По регионам', type: 'regions' },
    { text: 'По всей России', type: 'russia' },
  ];
  function init() {
    var map = new ymaps.Map('map', {
      center: [61.698653, 99.505405],
      zoom: 3,
      type: 'yandex#map',
      controls: ['zoomControl'],
    });
    map.controls.get('zoomControl').options.set({ size: 'small' });
    // Зададим цвета для раскрашивания.
    // Обратите внимание, для раскраски более крупных карт нужно задавать пятый цвет.
    var colors = ['#F0F075', '#FB6C3F', '#3D4C76', '#49C0B5'];
    var objectManager = new ymaps.ObjectManager();
    // Загрузим регионы.
    ymaps.borders
      .load('RU', {
        lang: 'ru',
        quality: 2,
      })
      .then(function(result) {
        // Очередь раскраски.
        var queue = [];
        // Создадим объект regions, где ключи это ISO код региона.
        var regions = result.features.reduce(function(acc, feature) {
          // Добавим ISO код региона в качестве feature.id для objectManager.
          var iso = feature.properties.iso3166;
          feature.id = iso;
          // Добавим опции региона по умолчанию.
          feature.options = {
            fillOpacity: 0.6,
            strokeColor: '#FFF',
            strokeOpacity: 0.5,
          };
          acc[iso] = feature;
          return acc;
        }, {});
        // Функция, которая раскрашивает регион и добавляет всех нераскрасшенных соседей в очередь на раскраску.
        function paint(iso) {
          var allowedColors = colors.slice();
          // Получим ссылку на раскрашиваемый регион и на его соседей.
          var region = regions[iso];
          var neighbors = region.properties.neighbors;
          // Если у региона есть опция fillColor, значит мы его уже раскрасили.
          if (region.options.fillColor) {
            return;
          }
          // Если у региона есть соседи, то нужно проверить, какие цвета уже заняты.
          if (neighbors.length !== 0) {
            neighbors.forEach(function(neighbor) {
              var fillColor = regions[neighbor].options.fillColor;
              // Если регион раскрашен, то исключаем его цвет.
              if (fillColor) {
                var index = allowedColors.indexOf(fillColor);
                if (index != -1) {
                  allowedColors.splice(index, 1);
                }
                // Если регион не раскрашен, то добавляем его в очередь на раскраску.
              } else if (queue.indexOf(neighbor) === -1) {
                queue.push(neighbor);
              }
            });
          }
          // Раскрасим регион в первый доступный цвет.
          region.options.fillColor = allowedColors[0];
        }
        for (var iso in regions) {
          // Если регион не раскрашен, добавим его в очередь на раскраску.
          if (!regions[iso].options.fillColor) {
            queue.push(iso);
          }
          // Раскрасим все регионы из очереди.
          while (queue.length > 0) {
            paint(queue.shift());
          }
        }
        // Добавим регионы на карту.
        result.features = [];
        for (var reg in regions) {
          result.features.push(regions[reg]);
        }
        objectManager.add(result);
        map.geoObjects.add(objectManager);
        map.geoObjects.events.add('click', (e) => {
          navigate("maps/chart");
        });
      });
  }
  afterUpdate(() => {
    ymaps.ready(init);
  });
  let selectedType = 'regions';
  let availableWidth;
  let availableHeight;
  let chartContainer;
  export let chart = null;
  $: if (chartContainer && chart) {
    setTimeout(() => {
      const { width, height } = chartContainer.getBoundingClientRect();
      availableHeight = height;
      availableWidth = width;
    });
  }
</script>

<style>
  .charts {
    width: 100%;
    height: 100%;
  }

  .map-container {
    padding: 24px;
    border-radius: 32px;
    background-color: white;
    width: 100%;
    height: 700px;
    box-sizing: border-box;
  }
</style>

<div class="map-container">
  <div class="charts full-size" id="map" />
</div>
