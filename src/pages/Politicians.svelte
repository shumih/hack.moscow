<script>
  import {onMount, onDestroy} from 'svelte';
  import {selectedFilters, availableFilters} from '../storage';
  import Button from '@smui/button/Button.svelte';
  import PoliticiansCardList from '../components/PoliticiansRowList.svelte';
  import PoliticiansRowList from "../components/PoliticiansRowList.svelte";
  import PoliticianBarFilters from "../components/PoliticianBarFilters.svelte";
  import PoliticiansSideFilters from "../components/PoliticiansSideFilters.svelte";

  onDestroy(async () => {
    unsubscribe();
  });
  const unsubscribe = selectedFilters.subscribe(async selected => {
    const response = await getAllPersons();
    politicians = await response.json();
  });

  function getAllPersons() {
    return fetch(`http://172.31.16.158:8080/allPersons?filters=${selected => selected.map(s => s.id).join(',')}`);
  }

  function toggleFilterSelection({ detail }) {
    selectedFilters.update(filters =>
      filters.some(f => f.id === detail.id) ? filters.filter(f => f.id !== detail.id) : [...filters, detail].filter(f => !detail.opposites.includes(f.id))
    );
  }

  let response;
  let isCardsSelected = true;
  let politicians;

</script>

<style>
  .wrapper {
    display: flex;
    width: 100%;
  }
  .politicians {
    display: flex;
    width: 100%;
    flex: 1;
    flex-direction: column;
  }
  .filters {
    width: 220px;
    padding: 30px 20px;
    flex-shrink: 0;
  }

  .politicians-bar {
    display: flex;
    width: 100%;
    justify-content: space-between;
    align-items: center;
    background: #ececec;
    padding: 30px 20px;
  }

  .politicians-bar-filters {
    max-width: 80%;
  }

  .politicians-bar-title {
    font-family: Helvetica CE, sans-serif;
    font-size: var(--text-header-size);
    line-height: 20px;
  }

  .politicians-bar-view-types {
    display: flex;
  }
  .politicians-bar-view-types > svg {
    cursor: pointer;
  }
  .politicians-bar-view-types * + * {
    margin-left: 8px;
  }

  .politicians-bar-actions {
    --mdc-theme-primary: #313131;
  }
  .politicians-bar-action {
    height: 24px;
  }

  .politicians-list {
    padding: 8px;
  }
</style>

<div class="wrapper">
  <div class="politicians">
    <div class="politicians-bar">
      <h2 class="politicians-bar-title">Чиновники</h2>
      <div class="politicians-bar-view-types">
        <svg
                width="16"
                height="12"
                viewBox="0 0 16 12"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
                on:click={() => (isCardsSelected = false)}>
          <rect width="16" height="2" rx="1" fill={!isCardsSelected ? '#4066FF' : '#D8D4FF'} />
          <rect y="5" width="16" height="2" rx="1" fill={!isCardsSelected ? '#4066FF' : '#D8D4FF'} />
          <rect y="10" width="16" height="2" rx="1" fill={!isCardsSelected ? '#4066FF' : '#D8D4FF'} />
        </svg>
        <svg
                width="16"
                height="12"
                viewBox="0 0 16 12"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
                on:click={() => (isCardsSelected = true)}>
          <rect width="6.85714" height="5" rx="1" fill={isCardsSelected ? '#4066FF' : '#D8D4FF'} />
          <rect y="7" width="6.85714" height="5" rx="1" fill={isCardsSelected ? '#4066FF' : '#D8D4FF'} />
          <rect x="9.14282" width="6.85714" height="5" rx="1" fill={isCardsSelected ? '#4066FF' : '#D8D4FF'} />
          <rect x="9.14282" y="7" width="6.85714" height="5" rx="1" fill={isCardsSelected ? '#4066FF' : '#D8D4FF'} />
        </svg>
      </div>
    </div>
    <div class="politicians-bar">
      <PoliticianBarFilters filters={$selectedFilters} on:remove={filter => toggleFilterSelection(filter)} />
      <div class="politicians-bar-actions">
        <Button class="politicians-bar-action">Фильтры</Button>
      </div>
    </div>
    <div class="politicians-list">
      {#if politicians}
        {#if isCardsSelected}
          <PoliticiansCardList {politicians} />
        {:else}
          <PoliticiansRowList {politicians} />
        {/if}
      {/if}
    </div>
  </div>
  <div class="filters">
    <PoliticiansSideFilters filters={$availableFilters} selected={$selectedFilters} on:toggle={filter => toggleFilterSelection(filter)} />
  </div>
</div>
