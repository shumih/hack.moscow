<script>
    import Card, {Content, PrimaryAction, Media, MediaContent, Actions, ActionButtons, ActionIcons} from '@smui/card';
    import Button, {Label} from '@smui/button';
    import IconButton, {Icon} from '@smui/icon-button';
    import { scale } from 'svelte/transition';

    export let politician;

    let isExpanded = false;

    function formattedIncome(incomes) {
        debugger
        return incomes.length;
        // return String(politician.income).replace(/\d(?=(\d{3})+\.)/g, '$& ');
    }

    function formattedVehicles(vehicles) {
      debugger
      return vehicles.length;

    }

    function formattedRealstates(realstates) {
        debugger;
        return realstates.length
    }

    function toggleCard() {
        isExpanded = !isExpanded;
    }

    function getAvatar(id) {
      return `http://localhost:5151/api/avatar/${id}`
    }

    id, name, incomes, realstates, vehicles
</script>

<style>
    .politician-content {
        display: flex;
    }
    .card {
        background: #FFFFFF;
        box-shadow: 2px 2px 7px rgba(100, 100, 100, 0.12);
        border-radius: 10px;
    }
    .politician-image {
        width: 72px;
        height: 72px;
        background-color: #E1E1E1;
        border-radius: 50%;
        margin-right: 8px;
    }

    .brief-info {
        display: flex;
        flex-direction: column;
    }
    .brief-info > * + * {
        margin-top: 8px;
    }
    .brief-info-photo {
        width: 72px;
        height: 72px;
    }
    .brief-info-facts {
        flex: 1;
    }
    .brief-info-fact {
        font-family: Helvetica CE, sans-serif;
        font-size: 9px;
        line-height: 12px;
        color: var(--text-grey);
    }
    .name {
        font-size: 12px;
        line-height: 16px;
        color: var(--text-black);
    }
    .details-info-item {

    }
    .details-info-item-label {

    }
    .details-info-item-value {

    }
    .brief-info-details-button {
        margin-top: auto;
        --mdc-theme-primary: #313131;
    }
</style>

    <Card>
        <Content>
            <div class="politician-content">
                <img class="politician-image"/>
                <div class="brief-info">
                    <div class="brief-info-fact">
                        <span class="brief-info-fact-label">Доход</span>
                        <span class="brief-info-fact-value">{formattedIncome(politician.incomes)}</span>
                    </div>
                    <div class="brief-info-fact">
                        <span class="brief-info-fact-label">Недвижимость</span>
                        <span class="brief-info-fact-value">{formattedRealstates(politician.realstates)}</span>
                    </div>
                    <div class="brief-info-fact">
                        <span class="brief-info-fact-label">Транспорт</span>
                        <span class="brief-info-fact-value">{formattedVehicles(politician.vehicles)}шт</span>
                    </div>
                </div>
            </div>

            <Button class="brief-info-details-button" on:click={toggleCard}>
                <Label>Details</Label>
            </Button>

            {#if isExpanded}

            {/if}
        </Content>
    </Card>
