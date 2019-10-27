<script>
  import Poll from "../../common/Poll.svelte";
  import Button, {Label} from '@smui/button';
  import { Link } from "svelte-routing";

  let valueOutlinedEnhanced;
</script>

<style>
  .done-icon {
    background: url(/assets/icons/mayor.svg) no-repeat 50% 50%;
    background-size: 100%;
		width: 290px;
		height: 290px;
    margin: auto;
    border-radius: 100%;
    border: 12px #54B4EE solid;
    box-sizing: border-box;
    background-color: #54B4EE;
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
  .controls {
    display: grid;
    grid-gap: 4px;
  }
</style>

<div class="done">
  <div class="done-icon"></div>
  <h1 class="done-title">Знакомься, это<br>мэр города Москвы</h1>
  <div class="info">
    Тебе предстоит угадать его месячный доход,<br>
    исходя из нескольких данных.<br>
    Удачи!<br>
  </div>
  <div class="controls">
    <Link to="guess">
      <Button variant="raised">
        <Label>Узнать больше</Label>
      </Button>
    </Link>
  </div>
</div>

