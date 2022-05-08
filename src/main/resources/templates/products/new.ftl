<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Create new product</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/products/new" method="POST" class="form-signin">
            <h2 class="form-heading text-center p-3">Реєстрація</h2>

            <#if productCannotBeCreated??>
                <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                    ${productCannotBeCreated}
                </div>
            </#if>

            <div class="form-group">
                <input name="name" type="text" class="form-control m-3" placeholder="Ім'я книги"
                       required/>
                <input name="authorName" type="text" class="form-control m-3" placeholder="Ім'я Автора"
                       required/>
                <input name="description" type="text" class="form-control m-3" placeholder="Опис книги"
                       required/>
                <input name="imageUrl" type="text" class="form-control m-3" placeholder="Посилання на зображення"
                       required/>
                <input name="price" type="number" step="any" class="form-control m-3" placeholder="Ціна книги"
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