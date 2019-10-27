<script>
  import Poll from "../../common/Poll.svelte";
  import Button, {Label} from '@smui/button';

  let value;
</script>

<Poll
  title="Какой ты чиновник?"
  position="5"
  totalPosition="5"
  link="rich"
  back="child"
  value={value}
  text="И напоследок, сколько у тебя машин?">
  <Button variant="raised" class={value === 1 ? 'selected' : ''} on:click={() => value = 1 }>
    <Label>Нет машин</Label>
  </Button>
  <Button variant="raised" class={value === 2 ? 'selected' : ''} on:click={() => value = 2 }>
    <Label>1</Label>
  </Button>
  <Button variant="raised" class={value === 3 ? 'selected' : ''} on:click={() => value = 3 }>
    <Label>2</Label>
  </Button>
  <Button variant="raised" class={value === 4 ? 'selected' : ''} on:click={() => value = 4 }>
    <Label>3</Label>
  </Button>
  <Button variant="raised" class={value === 5 ? 'selected' : ''} on:click={() => value = 5 }>
    <Label>4 и более</Label>
  </Button>
</Poll>
