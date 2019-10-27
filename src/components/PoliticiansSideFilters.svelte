<script>
    import { createEventDispatcher } from 'svelte';
    export let selected;
    export let filters;

    const dispatch = createEventDispatcher();

    $: selectedIds = selected.map(f => f.id)
</script>

<style>
    .politicians-side-filters {
        display: flex;
        flex-direction: column;
        margin-top: 8px;
    }
    .politicians-side-filter-item:not(:first-of-type) {
        margin-top: 10px;
    }
    .politicians-side-filter-item {
        background: #FFFFFF;
        box-shadow: 2px 2px 8px rgba(86, 86, 86, 0.15);
        border-radius: 10px;
        color: var(--text-black);
        padding: 10px;
        user-select: none;
    }
    .politicians-side-filter-item.selected {
        background-color: #4066FF;
        color: #FFFFFF;
    }
    .politicians-side-filter-item:hover {
        cursor: pointer;
    }
    .politicians-side-filter-item:not(.selected):hover {
        background-color: rgba(64, 102, 255, 0.1);
    }
    h4 {
        font-family: Helvetica CE, sans-serif;
        font-size: var(--text-header-size);
        line-height: 20px;
        margin: 0;
    }
    p {
        margin: 0;
        font-family: Helvetica CE, sans-serif;
        font-size: 10px;
        line-height: 13px;
        color: var(--text-grey);
    }
</style>

<div class="filters">
    <h4>Списки</h4>
    <p>Кол-во людей: 132 892</p>
    <p>Кол-во деклараций: 275 302</p>
    <div class="politicians-side-filters">
        {#each filters as filter}
            <div
                    class="politicians-side-filter-item"
                    class:selected={selectedIds.includes(filter.id)}
                    on:click={() => dispatch('toggle', filter)}
            >{filter.title}</div>
        {/each}
    </div>
</div>
