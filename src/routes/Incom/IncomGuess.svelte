<script>
  import Poll from "../../common/Poll.svelte";
  import Slider from "@smui/slider";
  import FormField from "@smui/form-field";
  import Button, { Label } from "@smui/button";
  import { Link } from "svelte-routing";

  let valueOutlinedEnhanced;
  let value = 0;
</script>

<style>
  .container {
    display: flex;
    flex-direction: column;
    height: 100%;
  }
  .poll-header {
    width: 100%;
    height: 32px;
    padding-top: 20px;
    display: flex;
    flex-direction: row;
    align-items: center;
    text-align: center;
  }
  .poll-back {
    background: url(/assets/icons/back.svg) no-repeat 50% 50%;
    width: 32px;
    height: 32px;
  }
  .poll-title {
    width: 100%;
    font-size: 12px;
    color: #8b8b8b;
  }
  .poll-content-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  .poll-content {
    margin: 20px;
    display: grid;
    grid-gap: 20px;
    height: max-content;
  }

  .info {
    display: grid;
    grid-template-columns: 68px 1fr;
    grid-gap: 20px;
  }
  .info > .text {
    font-size: 14px;
    color: #8b8b8b;
  }
  .info > .text b {
    color: black;
  }
  .info h3 {
    font-size: 20px;
  }
  .house {
    background: url(/assets/icons/realty.svg) no-repeat 50% 50%;
    width: 68px;
    height: 68px;
  }
  .car {
    background: url(/assets/icons/car.svg) no-repeat 50% 50%;
    width: 68px;
    height: 68px;
  }
  .money {
    background: url(/assets/icons/money.svg) no-repeat 50% 50%;
    width: 68px;
    height: 68px;
  }
  h3 {
    color: black;
    margin: 0;
    margin-bottom: 4px;
  }
</style>

<div class="container">
  <div class="poll-header">
    <Link to="../">
      <div class="poll-back" />
    </Link>
    <div class="poll-title">Угадай доход</div>
    <div class="poll-next" />
  </div>
  <div class="poll-content-container">
    <div class="poll-conten">
     <div class="info">
      <div class="house" />
      <div class="text house-info">
        <h3>Недвижимость</h3>
        <div>
          Квартира,
          <b>308.1 кв.м</b>
          (в пользовании)
        </div>
        <div>
          Гараж,
          <b>26.8 кв.м</b>
        </div>
      </div>
      <div class="car" />
      <div class="text car-info">
        <h3>Машины</h3>
        <div>
          <b>0 шт</b>
        </div>
      </div>
      <div class="money" />
      <div class="text money-info">
        <h3>Депозиты</h3>
        <div>Нет</div>
      </div>
    </div>
    <h2 class="title">
      Как думаешь, сколько
      <br />
      зарабатывает этот чиновник?
    </h2>
    <Slider min={0} max={1000000} step={10000} bind:value />
    <span style="text-align: center; width: 100%; display: block; margin-bottom: 20px; color: #8B8B8B">
      {value} руб
    </span>
    <Link to={`result/${value}`}>
      <Button variant="raised">
        <Label>Угадать</Label>
      </Button>
    </Link>
  </div>
  </div>
</div>
