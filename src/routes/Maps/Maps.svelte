<script>
  import MapsMap from './MapsMap.svelte';
  import MapsChart from './MapsChart.svelte';

  import { Router, Link, Route } from "svelte-routing";

  let url;
</script>

<style>
  h1 {
    font-size: 14px;
    margin-bottom: 20px;
  }
</style>

<h1>Статистика</h1>
<Router url="{url}" basepath="/maps">
  <Route path="/" component="{MapsMap}" />
  <Route path="chart" component="{MapsChart}" />
</Router>
