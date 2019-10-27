<script>
  import Poll from "../../common/Poll.svelte";
  import Select, { Option } from "@smui/select";
  import Button, {Label} from '@smui/button';

  let value;
</script>

<Poll
  title="Какой ты чиновник?"
  position="3"
  totalPosition="5"
  link="child"
  back="incom"
  value={value}
  text="Теперь еще проще! Выбери ответ, относящийся к тебе">
  <Button variant="raised" class={value === 1 ? 'selected' : ''} on:click={() => value = 1 }>
    <Label>Нет квартиры/дома в собственности</Label>
  </Button>
  <Button variant="raised" class={value === 2 ? 'selected' : ''} on:click={() => value = 2 }>
    <Label>Есть квартира</Label>
  </Button>
  <Button variant="raised" class={value === 3 ? 'selected' : ''} on:click={() => value = 3 }>
    <Label>Есть дом</Label>
  </Button>
  <Button variant="raised" class={value === 4 ? 'selected' : ''} on:click={() => value = 4 }>
    <Label>Есть квартира и дом</Label>
  </Button>
  <Button variant="raised" class={value === 5 ? 'selected' : ''} on:click={() => value = 5 }>
    <Label>Есть больше, чем 1 квартира и/или 1 дом</Label>
  </Button>
</Poll>
