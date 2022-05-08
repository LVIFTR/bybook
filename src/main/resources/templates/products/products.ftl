<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <link rel="stylesheet" href="/css/product/products.css">
    <title>Products</title>
</head>
<body>
<#include "../include/navbar.ftl" >

<div class="container">
    <h3 class="h3">Книжковий магазин</h3>
    <div class="row">
        <#list products as product>
            <div class="col-md-4 col-sm-6">
                <div class="product-grid8">
                    <div class="product-image8">
                        <img class="pic-1" src="${product.imageUrl}" alt="${product.name}">
                    </div>
                    <div class="product-content">
                        <div class="price">${product.price} ₴
                            <#--                            <span>£ 10.00</span>-->
                        </div>
                        <h3 class="title">${product.name}</h3>
                        <a class="all-deals" href="/products/${product.id}">Переглянути товар <i
                                    class="fa fa-angle-right icon"></i></a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>