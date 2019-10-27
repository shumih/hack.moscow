<script>
  import Poll from "../../common/Poll.svelte";
  import Button, {Label} from '@smui/button';
  import { Link } from "svelte-routing";

  let valueOutlinedEnhanced;
  export let sum;
</script>

<style>
  .done-icon {
    background: url(/assets/icons/sad.svg) no-repeat 50% 50%;
    background-size: auto;
		width: 290px;
		height: 290px;
    margin: auto;
    border-radius: 100%;
    box-sizing: border-box;
  }
  .done-title {
    font-size: 24px;
  }
  .done {
    text-align: center;
  }
  .info {
    font-size: 14px;
    color: #8B8B8B;
    margin-bottom: 20px;
    display: grid;
    grid-gap: 20px;
    line-height: 18px;
  }
  .controls {
    display: grid;
    grid-gap: 4px;
  }
  b {
    color: black;
  }
</style>

<div class="done">
  <div class="done-icon"></div>
  <h1 class="done-title">Не угадал!</h1>
  <div class="info">
    <div>
      <b>Собянин Сергей Семенович</b><br>
      Ваш вариант: <b>{sum} руб</b><br>
      Реальная сумма: <b>630000 руб</b>
    </div>
    <div>
      Статус: <b>“Слуга народа”</b><br>
      Машины у него нет, зато дороги<br>
      в Москве ровные :)
    </div>
  </div>
  <div class="controls">
    <Button variant="raised">
      <Label>Больше информации</Label>
    </Button>
    <Link to="/incom">
      <Button variant="raised">
        <Label>Пройти еще раз</Label>
      </Button>
    </Link>
    <Link to="/placeman">
      <Button variant="raised">
        <Label>Пройти тест “Какой ты чиновник?”</Label>
      </Button>
    </Link>
  </div>
</div>

