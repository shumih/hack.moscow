<script>
  import Poll from "../../common/Poll.svelte";
  import Slider from '@smui/slider';
  import FormField from '@smui/form-field';

  let valueOutlinedEnhanced;
  let value = 0;
</script>

<Poll
  title="Какой ты чиновник?"
  position="2"
  totalPosition="5"
  link="self"
  value={value}
  back="/"
  text="Оцени свой примерный уровень дохода. Только честно!">
    <div style="height: 100px; font-size: 14px; color: #8B8B8B">
      Доход = заплата + доп. источники.<br>
      А не только зарплата :)
    </div>
    <div>
      <Slider min={0} max={1000000} step={10000} bind:value />
      <span style="text-align: center; width: 100%; display: block; color: #8B8B8B">{ value } руб</span>
    </div>

</Poll>
