<script>
  import IncomWelcome from './IncomWelcome.svelte';
  import IncomGuess from './IncomGuess.svelte';
  import IncomResult from './IncomResult.svelte';

  import { Router, Link, Route } from "svelte-routing";

  let url;
</script>

<Router url="{url}" basepath="/incom">
  <Route path="/" component="{IncomWelcome}" />
  <Route path="guess" component="{IncomGuess}" />
  <Route path="result/:sum" component="{IncomResult}" />
</Router>
