<script>
  import Poll from "../../common/Poll.svelte";
  import Select, { Option } from "@smui/select";
  import Button, {Label} from '@smui/button';

  let value;
</script>

<Poll
  title="Какой ты чиновник?"
  position="4"
  totalPosition="5"
  link="car"
  back="self"
  value={value}
  text="Так, становится интересно. А сколько у тебя детей?">
  <Button variant="raised" class={value === 1 ? 'selected' : ''} on:click={() => value = 1 }>
    <Label>Нет детей</Label>
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
