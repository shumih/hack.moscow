<script>
  import PlacemanCity from './PlacemanCity.svelte';
  import PlacemanIncom from './PlacemanIncom.svelte';
  import PlacemanSelf from './PlacemanSelf.svelte';
  import PlacemanChild from './PlacemanChild.svelte';
  import PlacemanCar from './PlacemanCar.svelte';
  import PlacemanRich from './PlacemanRich.svelte';
  import PlacemanDone from './PlacemanDone.svelte';
  import PlacemanResult from './PlacemanResult.svelte';

  import { Router, Link, Route } from "svelte-routing";

  let url;
</script>

<Router url="{url}" basepath="/placeman">
  <Route path="/" component="{PlacemanCity}" />
  <Route path="incom" component="{PlacemanIncom}" />
  <Route path="self" component="{PlacemanSelf}" />
  <Route path="child" component="{PlacemanChild}" />
  <Route path="car" component="{PlacemanCar}" />
  <Route path="rich" component="{PlacemanRich}" />
  <Route path="done" component="{PlacemanDone}" />
  <Route path="result" component="{PlacemanResult}" />
</Router>
