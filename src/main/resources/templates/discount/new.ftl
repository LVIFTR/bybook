<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Create new discount</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/admin/discounts/new" method="POST">
            <h2 class="form-heading text-center p-3">Додати нову знижку</h2>

            <#if discountCannotBeCreated??>
                <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                    ${discountCannotBeCreated}
                </div>
            </#if>

            <div class="form-group">
                <input name="name" type="text" class="form-control m-3" placeholder="Ім'я знижки"
                       required/>
                <input name="percentOfDiscount" type="number" step="any" min="1" max="99" class="form-control m-3" placeholder="Відсоток знижки (1-99)"
                       required/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-row justify-content-center">
                    <button class="btn btn-primary p-3 w-50" type="submit">Створити</button>
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>