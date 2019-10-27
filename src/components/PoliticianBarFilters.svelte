<script>
    import { createEventDispatcher } from 'svelte';

    const dispatch = createEventDispatcher();

    export let filters;
</script>

<style>
    .politicians-bar-filters {
        display: grid;
        margin-right: 16px;
        flex: 1;
        grid-auto-flow: column;
        grid-template-columns: repeat(auto-fill, minmax(0, auto));
    }
    .politicians-bar-filter-item {
        position: relative;
        border-radius: 4px;
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow: hidden;
        width: 100%;
    }
    .politicians-bar-filters > * + * {
        padding-left: 8px;
    }
    .politicians-bar-filter-item-text-wrapper {
        display: flex;
        width: available;
        width: -webkit-fill-available;
        width: -moz-available;
    }
    .politicians-bar-filter-item-text {
        width: 100%;
        overflow: hidden;
        text-overflow: ellipsis;
        background: #d8d5ff;
        padding: 2px 16px 2px 8px;
    }
    .politicians-bar-filter-item:after {
        content: '';
        mask: url("assets/cross-icon.svg") 50% 50% no-repeat ;
        position: absolute;
        top: calc(50% - 2px);
        right: 6px;
        height: 5px;
        width: 5px;
        background-color: #666666;
        cursor: pointer;
    }
    .politicians-bar-filter-item:hover:after {
        background-color: black;
    }
</style>

<div class="politicians-bar-filters">
    {#each filters as filter}
        <div class="politicians-bar-filter-item" on:click={() => dispatch('remove', filter)}>
            <span class="politicians-bar-filter-item-text-wrapper">
                <span class="politicians-bar-filter-item-text">{filter.title}</span>
            </span>
        </div>
    {/each}
</div>
