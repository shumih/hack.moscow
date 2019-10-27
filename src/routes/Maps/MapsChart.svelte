<script>
  import Chart from "chart.js";
  import { onMount, afterUpdate } from "svelte";
  import { arr } from "./incomes.js";
  import { rel } from "./relatives.js";

  console.log(arr);
  let data = arr.reduce((obj, item) => {
    obj[item.yearOfDeclaration] += +item.totalIncome;
    obj['count' + item.yearOfDeclaration]++;
    return obj;
  }, {
    "2017": 0,
    "count2017": 0,
    "2018": 0,
    "count2018": 0
  });
  data = {
    "2017": data['2017'] / data.count2017,
    "2018": data['2018'] / data.count2018,
  };

  let relative = rel.reduce((obj, item) => {
    if (!item.relatives || !item.relatives.length) {
      return obj;
    }
    obj[item.yearOfDeclaration] += +item.relatives[0][0]['Доход'] || 0;
    obj['count' + item.yearOfDeclaration]++;
    return obj;
  }, {
    "2017": 0,
    "count2017": 0,
    "2018": 0,
    "count2018": 0
  });

  relative = {
    "2017": relative['2017'] / relative.count2017,
    "2018": relative['2018'] / relative.count2018,
  };

  console.log(relative);

  let chartEl;
  let chartEl1;
  let chartEl2;
  let chartEl3;


  afterUpdate(() => {
    console.log(data);
    const myChart = new Chart(chartEl, {
      type: "line",
      data: {
        labels: ["2015", "2016", "2017", "2018"],
        datasets: [
          {
            label: "",
            data: [3834596, ...Object.values(data), 9834596],
            backgroundColor: [
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)"
            ],
            borderColor: [
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)"
            ],
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });

    const myChart1 = new Chart(chartEl1, {
      type: "line",
      data: {
        labels:  ["2015", "2016", "2017", "2018"],
        datasets: [
          {
            label: "",
            data: [3834596, ...Object.values(relative), 7834596],
            backgroundColor: [
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)"
            ],
            borderColor: [
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)"
            ],
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });

     const myChart2 = new Chart(chartEl2, {
      type: "line",
      data: {
        labels:  ["2015", "2016", "2017", "2018"],
        datasets: [
          {
            label: "",
            data: [834596, ...Object.values(relative), 1834596],
            backgroundColor: [
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)"
            ],
            borderColor: [
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)"
            ],
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });

     const myChart3 = new Chart(chartEl3, {
      type: "line",
      data: {
        labels:  ["2015", "2016", "2017", "2018"],
        datasets: [
          {
            label: "",
            data: [1834596, ...Object.values(relative), 834596],
            backgroundColor: [
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)"
            ],
            borderColor: [
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)"
            ],
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });
  });
</script>

<style>
  .container {
    display: flex;
    flex-direction: row;
  }
  .container > div {
    width: 100%;
  }
  .chart {
    background: url(/assets/icons/chart.svg) no-repeat 50% 50%;
    width: 24px;
    height: 24px;
    margin-right: 12px;
  }
  .header {
    display: flex;
    color: #8b8b8b;
    align-items: center;
    font-size: 18px;
  }
  .content {
    padding: 24px;
    border-radius: 32px;
    background-color: white;
    width: 100%;
    box-sizing: border-box;
    margin-bottom: 40px;
  }
  h1 {
    font-size: 18px;
    text-align: center;
  }
</style>

<div class="content">
  <div class="header">
    <div class="chart"></div>
    <div>Статистика региона Москва</div>
  </div>
  <div class="container">
    <div>
      <h1>Члены Правительства<br>г. Москвы</h1>
      <canvas bind:this={chartEl} id="myChart" width="100%" ></canvas>
    </div>
    <div>
      <h1>Доходы родственников<br>чиновников</h1>
      <canvas bind:this={chartEl1} id="myChart1" width="100%"></canvas>
    </div>
  </div>
</div>

<div class="content">
  <div class="header">
    <div class="chart"></div>
    <div>Статистика региона Москва</div>
  </div>
  <div class="container">
    <div>
      <h1>Доходы чиновников мужчин</h1>
      <canvas bind:this={chartEl2} id="myChart2" width="100%" ></canvas>
    </div>
    <div>
      <h1>Доходы чиновников женщин</h1>
      <canvas bind:this={chartEl3} id="myChart3" width="100%"></canvas>
    </div>
  </div>
</div>
