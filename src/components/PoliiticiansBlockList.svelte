<script>
    import PersonCard from "./PersonCard.svelte";
    export let politicians;
</script>

<div class="politician-card-list">
    {#each politicians as politician}
        <div class="politician-card">
            <PersonCard {politician} />
        </div>
    {/each}
</div>
