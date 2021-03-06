<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Update product</title>
</head>
<body>
<#include "../include/navbar.ftl" >
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/products/${product.id}/update" method="POST" class="form-signin">
            <h2 class="form-heading text-center p-3">Обновити інформацію про книгу</h2>

            <#if productCannotBeUpdated??>
                <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                    ${productCannotBeUpdated}
                </div>
            </#if>

            <div class="form-group">
                <input name="name" type="text" class="form-control m-3" placeholder="Ім'я книги"
                       value="${product.name}" required/>
                <input name="authorName" type="text" class="form-control m-3" placeholder="Ім'я Автора"
                       value="${product.authorName}" required/>
                <input name="description" type="text" class="form-control m-3" placeholder="Опис книги"
                       value="${product.description}" required/>
                <input name="imageUrl" type="text" class="form-control m-3" placeholder="Посилання на зображення"
                       value="${product.imageUrl}" required/>
                <input name="price" type="number" step="any" min="0.1" class="form-control m-3" placeholder="Ціна книги"
                       value="${product.getPrice()}" required/>
                <select class="form-control m-3" name="discountId">
                    <option selected value="0">Виберіть(Щоб очистити знижку, виберіть цей варіант)</option>
                    <#list discounts as discount>
                        <#if discount.id == product.discountId>
                            <option value="${discount.id}" selected>${discount.name} ${discount.percentOfDiscount} %</option>
                        <#else>
                            <option value="${discount.id}">${discount.name} ${discount.percentOfDiscount} %</option>
                        </#if>
                    </#list>
                </select>
                <select class="form-control m-3" multiple name="categoriesIds">
                    <option disabled>Виберіть категорії</option>
                    <#list usedCategories as category>
                        <option value="${category.id}" selected>${category.name}</option>
                    </#list>
                    <#list notUsedCategories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
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