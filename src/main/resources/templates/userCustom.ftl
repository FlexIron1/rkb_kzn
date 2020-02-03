
<#import "parts/common.ftl" as c>
<@c.page>

    <table class="table table-condensed">
    <thead>
    <tr>

        <th>Отделение</th>
        <th>Проблема</th>
        <th>Номер</th>
        <th>Время подачи</th>
    </tr>
    </thead>
    <#list messages as message>

        <div class="m-2">
            <tbody>
            <tr>
                <td>${message.otdel}</td>
                <td>${message.problema}</td>
                <td>${message.number}</td>
                <td>${message.vremya}</td>
            </tr>
            </tbody>
        </div>
        </table>
    <#else>
        No message
    </#list>

</@c.page>