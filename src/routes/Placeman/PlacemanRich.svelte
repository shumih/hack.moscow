<script>
  import Poll from "../../common/Poll.svelte";
  import Button, {Label} from '@smui/button';

  let value;
</script>

<Poll
  title="Какой ты чиновник?"
  link="done"
  back="car"
  value={value}
  text="А яхта есть? :) Честно, это последний вопрос">
  <Button variant="raised" class={value === 1 ? 'selected' : ''} on:click={() => value = 1 }>
    <Label>Да, есть</Label>
  </Button>
  <Button variant="raised" class={value === 2 ? 'selected' : ''} on:click={() => value = 2 }>
    <Label>Да, есть, только никому не говори</Label>
  </Button>
  <Button variant="raised" class={value === 3 ? 'selected' : ''} on:click={() => value = 3 }>
    <Label>Нету</Label>
  </Button>
</Poll>
