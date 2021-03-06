<#include "security.ftl" >
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <span class="navbar-brand">ByBook</span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/products">Магазин<span class="sr-only">(current)</span></a>
            </li>
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/discounts">Знижки<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/categories">Категорії<span class="sr-only">(current)</span></a>
                </li>
            </#if>
        </ul>

        <div class="btn-group dropleft">
            <button class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                ${fullName}
            </button>
            <div class="dropdown-menu">
                <form action="/user" method="GET">
                    <button class="dropdown-item" type="submit">Сторінка користувача</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <#if isAdmin>
                    <form action="/products/new" method="get">
                        <button type="submit" class="dropdown-item">Додати продукт(книгу)</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </#if>

                <form action="/logout" method="POST">
                    <button class="dropdown-item" type="submit">Вийти</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>

    </div>
</nav>