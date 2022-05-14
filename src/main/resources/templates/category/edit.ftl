<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Update category</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/admin/categories/${category.id}/edit" method="POST">
            <h2 class="form-heading text-center p-3">Редагувати категорію</h2>

            <#if categoryCannotBeUpdated??>
                <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                    ${categoryCannotBeUpdated}
                </div>
            </#if>

            <div class="form-group">
                <input name="name" type="text" class="form-control m-3" placeholder="Ім'я категорії"
                       value="${category.name}" required/>
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