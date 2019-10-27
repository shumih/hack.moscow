<script>
  import Poll from "../../common/Poll.svelte";
  import Button, {Label} from '@smui/button';
  import { Link } from "svelte-routing";

  let valueOutlinedEnhanced;
</script>

<style>
  .done-icon {
    background: url(/assets/icons/jirik.svg) no-repeat 50% 50%;
    background-size: auto;
		width: 290px;
		height: 290px;
    margin: auto;
    border-radius: 100%;
    border: 12px #54B4EE solid;
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
  }
  .social {
    width: 100px;
    display: flex;
    margin: 8px auto;
    justify-content: space-between;
  }
  .vk {
    background: url(/assets/icons/vk.svg) no-repeat 50% 50%;
    width: 28px;
    height: 28px;
  }
  .twitter {
    background: url(/assets/icons/twitter.svg) no-repeat 50% 50%;
    width: 28px;
    height: 28px;
  }
  .inst {
    background: url(/assets/icons/insta.svg) no-repeat 50% 50%;
    width: 28px;
    height: 28px;
  }
  .share {
    font-size: 12px;
    color: #8B8B8B;
  }
  .controls {
    display: grid;
    grid-gap: 4px;
  }
</style>

<div class="done">
  <div class="done-icon"></div>
  <h1 class="done-title">Больше всего ты похож<br>на Жириновского!</h1>
  <div class="info">
    Да-да, это не ошибка.<br>
    Ваши уровень жизни очень близок.<br>
    Возможно, ты такой же хороший оратор,<br>
    как и он. Стоит проверить!<br>
    <br>
    Нажимая на кнопку ниже, у тебя есть возможность<br>
    узнать больше о Жириновском и о других,<br>
    интересующих тебя чиновниках
  </div>
  <div class="controls">
    <Button variant="raised">
      <Label>Больше информации</Label>
    </Button>
      <Link to="/incom">
        <Button variant="raised">
          <Label>Пройти тест “Угадай доход”</Label>
        </Button>
      </Link>
  </div>
  <div class="social">
    <div class="vk"></div>
    <div class="twitter"></div>
    <div class="inst"></div>
  </div>
  <div class="share">Расскажи друзьям!</div>
</div>

