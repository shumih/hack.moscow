<script>
  import Poll from "../../common/Poll.svelte";
  import Button, {Label} from '@smui/button';
  import { Link } from "svelte-routing";

  let valueOutlinedEnhanced;
</script>

<style>
  .done-icon {
		background: url(/assets/icons/main.svg) no-repeat 50% 50%;
		width: 200px;
		height: 200px;
		margin: auto;
  }
  .done-title {
    font-size: 24px;
    height: 100px;
  }
  .done {
    text-align: center;
  }
</style>

<div class="done">
  <div class="done-icon"></div>
  <h1 class="done-title">Ты прошел опрос!<br>Поздравляю!</h1>
  <Link to="result">
    <Button variant="raised">
      <Label>Узнать результаты</Label>
    </Button>
  </Link>
</div>

