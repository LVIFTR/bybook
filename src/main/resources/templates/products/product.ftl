<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <link rel="stylesheet" href="/css/product/productPage.css">
    <title>Products</title>
</head>
<body>
<#include "../include/navbar.ftl" >

<div class="container">
    <div class="col-lg-8 border p-3 main-section bg-white">
        <div class="row heading m-0 pl-3 pt-0 pb-3">
            ${product.name}
        </div>
        <div class="row m-0">
            <div class="col-lg-4 left-side-product-box pb-3">
                <img src="${product.getImageUrl()}" class="border p-3" alt="${product.name}">
            </div>
            <div class="col-lg-8">
                <div class="right-side-pro-detail border p-3 m-0">
                    <div class="row">
                        <div class="col-lg-12">
                            <span>Автор:</span>
                            <p class="m-0 p-0">${product.authorName}</p>
                        </div>
                        <div class="col-lg-12">
                            <p class="m-0 p-0 price-pro">Ціна:${product.price} ₴</p>
                            <hr class="p-0 m-0">
                        </div>
                        <div class="col-lg-12 pt-2">
                            <h5>Опис книги</h5>
                            <span>${product.description}</span>
                            <hr class="m-0 pt-2 mt-2">
                        </div>
                        <div class="col-lg-12 mt-3">
                            <div class="row">
                                <div class="col-lg-6 pb-2">
                                    <a href="#" class="btn btn-danger w-100">Додати до кошика</a>
                                </div>
                                <div class="col-lg-6">
                                    <a href="#" class="btn btn-success w-100">Купити одразу!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>