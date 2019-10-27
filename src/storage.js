import { writable } from 'svelte/store';

const filters = [
  { id: 1, title: 'Крупнейший доход', description: 'Лица с самым большим доходом', opposites: [] },
  { id: 2, title: 'Крупнейший доход супругов', opposites: [] },
  { id: 3, title: 'Расхождения между декларациями', opposites: [] },
  { id: 4, title: 'Нет расхождения между декларациями', opposites: [5, 6] },
  { id: 5, title: 'Малое расхождение между декаларациями', opposites: [4, 6] },
  { id: 6, title: 'Большое расхождение между декларациями', opposites: [4, 5] },
  { id: 7, title: 'Группа 7' }
];

export let availableFilters = writable(filters);
export let selectedFilters = writable(filters.filter(f => [1, 3].includes(f.id)));
