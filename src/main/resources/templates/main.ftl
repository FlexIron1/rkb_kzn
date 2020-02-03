<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
                <button type="submit" class="btn btn-primary ml-2">Поиск</button>
            </form>
        </div>
    </div>



    <div class="card-columns">
        <#list messages as message>
            <div class="card my-3">
                <#--                <#if message.filename??>-->
                <#--                    <img src="/img/${message.filename}" class="card-img-top">-->
                <#--                </#if>-->
                <div class="m-2">
                    <span>${message.text}</span>
                    <i>${message.tag}</i>
                </div>
                <div class="card-footer text-muted">
                    ${message.authorName}
                </div>
            </div>
        <#--        <#else>-->

        </#list>
    </div>
</@c.page>