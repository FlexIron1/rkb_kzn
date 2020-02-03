<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/" class="pull-left"><img src=https://kazan.spravka.city/public_files/company/logo/138/logo-1130965-kazan.png></a>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <#if user??>
                <#if !isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/zayavki">Подать заявку</a>
                    </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Список техники</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user-messages/${currentUserId}">Сообщения</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/user">Список отделений</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/user-custom">Заявки</a>
                    </li>
                </#if>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>