<script>
  import Input from '@smui/textfield/Input.svelte';
  import Textfield from '@smui/textfield/Textfield.svelte';
  import FloatingLabel from '@smui/floating-label';
  import NotchedOutline from '@smui/notched-outline';

  let inputValue;
</script>

<style>
  nav {
    display: flex;
    justify-content: space-between;
    padding: 20px 30px;
  }

  .mdc-text-field,
  .search-field {
    margin-left: auto;
    height: 32px;
  }
</style>

<nav>
<!--    <Textfield type="search" variant="outlined" class="search-field">-->
<!--      <Input bind:value={inputValue} id="search-input" />-->
<!--      <NotchedOutline>-->
<!--        <FloatingLabel for="search-input">Search</FloatingLabel>-->
<!--      </NotchedOutline>-->
<!--    </Textfield>-->
</nav>
