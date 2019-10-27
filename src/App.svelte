<script>
	import { Router, Route } from "svelte-routing";
	import Maps from './routes/Maps/Maps.svelte';
	import NavBar from './components/NavBar.svelte';
	import Politicians from './pages/Politicians.svelte';
	import Sidebar from "./components/Sidebar.svelte";

	export let url = 'politicians';
</script>

<style>
	.app-outlet {
		width: 100%;
		margin: 0 auto;
		height: 100%;
		display: flex;
		flex-direction: column;
		justify-content: center;
	}

	:global(body) {
		--mdc-theme-primary: #54B4EE;
		--mdc-theme-secondary: #54B4EE;
	}
	:global(a:hover) {
		text-decoration: none;
	}
	:global(.mdc-button) {
		width: 100%;
		text-transform: none;
		background-color: #54B4EE;
		font-family: 'Gilroy';
		font-weight: bold;
		box-shadow: none !important;
	}
	:global(.mdc-button.selected) {
		background-color: #54B4EEAA;
	}
	:global(.mdc-select) {
		width: 100%;
	}
	:global(.mdc-slider__track-container) {
		height: 5px;
		border-radius: 5px;
		background-color: #C4C4C4 !important;
	}
	:global(.mdc-slider__thumb) {
		transform: none;
	}
	:global(.mdc-select) {
		height: 40px;
	}
	:global(.mdc-select__selected-text) {
		padding: 0 12px !important;
		height: 100%;
		transform: none !important;
		line-height: 40px;
	}
	:global(.mdc-floating-label) {
		top: 0 !important;
		height: 100%;
		line-height: 40px !important;
	}
	:global(.mdc-select:not(.mdc-select--disabled).mdc-select--focused .mdc-floating-label) {
		color: #54B4EE ;
	}
	:global(.mdc-select__dropdown-icon) {
		top: 50%;
		transform: translateY(-50%);
	}
	:global(.mdc-select--outlined.mdc-notched-outline--upgraded .mdc-floating-label--float-above, .mdc-select--outlined .mdc-notched-outline--upgraded .mdc-floating-label--float-above) {
		transform: translateY(-35%) scale(.75);
		display: none;
	}
	:global(.mdc-notched-outline__notch) {
		width: 0px;
		padding: 0 !important;
		width: auto !important;
	}
	:global(.mdc-select--activated .mdc-select__dropdown-icon) {
		transform: rotate(180deg) translateY(50%);
	}
	:global(h1), :global(h2), :global(h3), :global(h4) {
		font-family: 'Gilroy';
	}
	:global(html, body) {
		height: 100%;
		width: 100%;
	}

	:global(body) {
		padding: 0;
		margin: 0;

		--text-black: #313131;
		--text-grey: #A9A9A9;
		--text-header-size: 16px;
	}

	:global(body *) {
		box-sizing: border-box;
	}
	.app {
		width: 100%;
		height: 100%;
		display: grid;
		grid-template-columns: 200px 1fr;
		grid-template-rows: 64px 1fr;
		grid-template-areas:
			"sidebar header"
			"sidebar content"
			"sidebar content";
	}
	.header {
		grid-area: header;
		border-bottom: 1px solid var(--text-grey);
	}
	.sidebar {
		grid-area: sidebar;
		box-shadow: 0 0 17px rgba(100, 100, 100, 0.12)
	}
	.content {
		grid-area: content;
		padding: 8px 24px;
		background: #f7f7ff;
	}


</style>
<div class="app">
	<Router {url} >
		<header class="header">
			<NavBar />
		</header>
		<div class="sidebar">
			<Sidebar />
		</div>
		<div class="content">
			<Route path="politicians" component={Politicians} />
			<Route path="maps/*" component="{Maps}" />
			<Route path="*" component={Politicians} />
		</div>
	</Router>
</div>


