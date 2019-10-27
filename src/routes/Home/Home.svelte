<script>
  import { Link } from "svelte-routing";
  import Button, {Label} from '@smui/button';
</script>

<style>
  .app {
		display: grid;
		grid-gap: 20px;
		width: 400px;
		justify-content: center;
    text-align: center;
    grid-template-columns: 100%
	}

	.app-title {
		text-align: center;
		font-size: 24px;
	}

	.app-icon {
		background: url(/assets/icons/main.svg) no-repeat 50% 50%;
		width: 100%;
		height: 200px;
		margin: auto;
	}
	.app-nav {
		display: grid;
		grid-gap: 12px;
	}
	.app-addition {
		color: #8B8B8B;
		font-size: 14px
	}
	.activen {
		color: #54B4EE;
	}
	.app-nav {
		text-align: center;
	}
</style>

<div class="app">
	<div class="app-icon"></div>
	<h1 class="app-title">
    Участвуй<br>
    в опросах - открой<br>
    для себя новую<br>
    <span class="activen">политику</span>
	</h1>
  <nav class="app-nav">
    <Link to="placeman">
      <Button variant="raised">
        <Label>Какой ты чиновник?</Label>
      </Button>
    </Link>
    <Link to="incom">
      <Button variant="raised">
        <Label>Угадай доход</Label>
      </Button>
    </Link>
  </nav>
  <p class="app-addition">Мы анализируем Ваши личные данные<br>в соответствии с политикой<br>конфиденциальности</p>
</div>
