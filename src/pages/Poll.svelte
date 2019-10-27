
<script>
  import Button, { Label } from '@smui/button';
  import { Link } from "svelte-routing";

  export let title;
  export let position;
  export let totalPosition;
  export let text;
  export let link;
  export let back;
  export let value;
</script>

<style>
  .poll-container {
    height: 100%;
    display: flex;
    flex-direction: column;
  }
  .poll-header {
    width: 100%;
    height: 32px;
    display: flex;
    flex-direction: row;
    align-items: center;
    text-align: center;
    padding-top: 20px;
  }
  .poll-back {
    background: url(/assets/icons/back.svg) no-repeat 50% 50%;
    width: 32px;
    height: 32px;
  }
  .poll-next {
    width: 32px;
    height: 32px;
  }
  .poll-title {
    width: 100%;
    font-size: 14px;
    color: #8B8B8B;
  }
  .poll-content-container {
    text-align: left;
    height: 100%;
    display: flex;
    align-items: center;
  }
  .poll-position {
    font-size: 14px;
    color: #8B8B8B;
  }
  .poll-text {
    font-size: 24px;
  }
  .poll-control-container {
    min-height: 200px;
    margin: 24px 0;
  }
  .poll-control {
    display: grid;
    height: max-content;
    grid-gap: 8px;
  }

</style>

<div class="poll-container">
  <div class="poll-header">
    <Link to="{ back }">
      <div class="poll-back"></div>
    </Link>
    <div class="poll-title">{ title }</div>
    <div class="poll-next"></div>
  </div>
  <div class="poll-content-container">
    <div class="poll-content">
      {#if totalPosition}
        <div class="poll-position">{ position} / { totalPosition }</div>
      {/if}
      <h1 class="poll-text">{ text }</h1>
      <div class="poll-control-container">
        <div class="poll-control">
          <slot></slot>
        </div>
      </div>
      <Link to="{ link }">
        <Button variant="raised" disabled={!value}>
          <Label>Далее</Label>
        </Button>
      </Link>
    </div>
  </div>
</div>
