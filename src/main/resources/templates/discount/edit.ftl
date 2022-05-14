<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Update discount</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/admin/discounts/${discount.id}/edit" method="POST">
            <h2 class="form-heading text-center p-3">Редагувати знижку</h2>

            <#if discountCannotBeUpdated??>
                <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                    ${discountCannotBeUpdated}
                </div>
            </#if>

            <div class="form-group">
                <input name="name" type="text" class="form-control m-3" placeholder="Ім'я знижки"
                       value="${discount.name}" required/>
                <input name="percentOfDiscount" type="number" step="any" min="1" max="99" class="form-control m-3" placeholder="Відсоток знижки (1-99)"
                       value="${discount.percentOfDiscount}" required/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-row justify-content-center">
                    <button class="btn btn-primary p-3 w-50" type="submit">Зберегти зміни</button>
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>