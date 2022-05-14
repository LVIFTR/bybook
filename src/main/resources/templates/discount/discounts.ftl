<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <link rel="stylesheet" href="/css/discount/discounts.css">
    <title>Discounts</title>
</head>
<body>
<#include "../include/navbar.ftl" >

<div class="container">
    <div class="row">
        <h3 class="h3">Список знижок</h3>
    </div>
    <form action="/admin/discounts/new" method="get">
        <button class="btn btn-dark" type="submit">Створити знижку</button>
    </form>
    <#if messageSuccess??>
        <div class="form-row form-control m-3 alert alert-success justify-content-center" role="alert">
            ${messageSuccess}
        </div>
    </#if>

    <#if messageError??>
        <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
            ${messageError}
        </div>
    </#if>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th scope="col">Назва знижки</th>
            <th scope="col">Відсоток знижки</th>
            <th scope="col">Редагувати</th>
            <th scope="col">Видалити</th>
        </tr>
        </thead>
        <tbody>
        <#list discounts as discount>
            <tr class="list-group-item-action">
                <td>${discount.name}</td>
                <td>${discount.percentOfDiscount}</td>
                <td>
                    <form action="/admin/discounts/${discount.id}/edit" method="get">
                        <button class="btn btn-dark" type="submit">Редагувати</button>
                    </form>
                </td>
                <td>
                    <form action="/admin/discounts/${discount.id}/delete" method="POST">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <button class="btn btn-danger" type="submit">Видалити</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</div>
</body>
</html>