<script>
    import { Link } from 'svelte-routing'

    const sidebarItems = [
        'Президент РФ',
        'Администрация Президента РФ',
        'Правительство РФ',
        'Министерства РФ',
        'Федеральные службы и агентства',
        'Совет Федерации',
        'Госдума',
        'Конституционный суд'
    ]
</script>

<style>
    .sidebar {
        display: flex;
        flex-direction: column;
    }

    .sidebar-item {
        display: flex;
        padding: 8px;
    }
    .sidebar-item-icon {
        display: block;
        margin: 0 8px;
    }
    .sidebar-item-text {
        font-family: Helvetica CE, sans-serif;
        font-size: 12px;
        line-height: 16px;
        color: var(--text-grey);
    }
    .sidebar-item-text:hover {
        cursor: pointer;
        color: var(--text-black);
    }

    .logo {
        height: 24px;
        display: flex;
        align-items: center;
        padding: 30px 20px;
    }

    .logo-text {
        margin-left: 12px;
        font-family: Helvetica CE, sans-serif;
        font-size: 14px;
        line-height: 18px;
        font-weight: bold;
        color: var(--text-black);
    }
    .map-segue-button {
        margin: 32px 8px 0;
        color: white;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
        border-radius: 30px;
        width: 90%;
        cursor: pointer;
        background: #4066FF;
    }
</style>


<Link to="/">
    <div class="logo">
        <img src="/assets/logo.svg" />
        <span class="logo-text">Declarator</span>
    </div>
</Link>

<div class="sidebar">
    {#each sidebarItems as sidebarItem}
        <div class="sidebar-item">
            <img class="sidebar-item-icon" src="/assets/sidebar-item-icon.svg" />
            <span class="sidebar-item-text">{sidebarItem}</span>
        </div>
    {/each}
    <Link to="maps">
        <button type="button" class="map-segue-button">Статистика</button>
    </Link>
</div>
