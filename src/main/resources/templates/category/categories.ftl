<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <link rel="stylesheet" href="/css/category/categories.css">
    <title>Categories</title>
</head>
<body>
<#include "../include/navbar.ftl" >

<div class="container">
    <div class="row">
        <h3 class="h3">Список категорій</h3>
    </div>
    <form action="/admin/categories/new" method="get">
        <button class="btn btn-dark" type="submit">Створити категорію</button>
    </form>

    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th scope="col">Назва категорії</th>
            <th scope="col">Редагувати</th>
            <th scope="col">Видалити</th>
        </tr>
        </thead>
        <tbody>
        <#list categories as category>
            <tr class="list-group-item-action">
                <td>${category.name}</td>
                <td>
                    <form action="/admin/categories/${category.id}/edit" method="get">
                        <button class="btn btn-dark" type="submit">Редагувати</button>
                    </form>
                </td>
                <td>
                    <form action="/admin/categories/${category.id}/delete" method="POST">
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