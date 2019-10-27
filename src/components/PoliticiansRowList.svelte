<script>
    import PersonCard from "./PersonCard.svelte";
    export let politicians;
</script>

<style>
    .politician-row-list {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-auto-flow: row;
        grid-gap: 8px;
    }
</style>

<div class="politician-row-list">
    {#each politicians as politician}
        <div class="politician-row">
            <PersonCard {politician} />
        </div>
    {/each}
</div>
