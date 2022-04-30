<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>${user.nickname}</title>
</head>
<#include "../include/navbar.ftl">
<body>
<form action="/user" method="get">
    <button type="submit" class="btn btn-primary">Назад</button>
</form>
<div class="container">
    <div class="col-md-11.5">
        <div class="card">
            <div class="card-body">

                <div class="col-md-12">
                    <h4>Редагувати користувача</h4>
                    <hr>
                    <#if userCannotBeUpdated??>
                        <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                            ${userCannotBeUpdated}
                        </div>
                    </#if>
                </div>

                <div class="col-md-12">
                    <div class="form-group row">

                        <form action="/user/update" method="post">
                            <div class="form-group">

                                <div class="form-group row">
                                    <label for="firstName" class="col-4">Ім'я</label>
                                    <div class="col-8">
                                        <input name="firstName" type="text" class="form-control" placeholder="Ім'я"
                                               value="${user.getFirstName()}" required/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="firstName" class="col-4">Прізвище</label>
                                    <div class="col-8">
                                        <input name="lastName" type="text" class="form-control"
                                               placeholder="Прізвище"
                                               value="${user.getLastName()}" required/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="username" class="col-4">Email</label>
                                    <div class="col-8">
                                        <input name="username" type="email" class="form-control" placeholder="Email"
                                               value="${user.getUsername()}" required/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="nickname" class="col-4">Нікнейм</label>
                                    <div class="col-8">
                                        <input name="nickname" type="text" class="form-control"
                                               placeholder="Введіть ваш нікнейм"
                                               value="${user.getNickname()}" required/>
                                        <span><small>Від 5 до 20 символів, має бути унікальним</small></span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="address" class="col-4">Адреса</label>
                                    <div class="col-8">
                                        <input name="address" type="text" class="form-control"
                                               placeholder="Введіть вашу адресу проживання"
                                               value="${user.getAddress()}" required/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="zipCode" class="col-4">Поштовий індекс</label>
                                    <div class="col-8">
                                        <input name="zipCode" type="text" class="form-control"
                                               placeholder="Введіть ваш поштовий індекс"
                                               value="${user.getZipCode()}" required/>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="phoneNumber" class="col-4">Номер телефону</label>
                                    <div class="col-8">
                                        <input name="phoneNumber" type="text" class="form-control"
                                               placeholder="Введіть ваш номер телефону"
                                               value="${user.getPhoneNumber()}" required/>
                                    </div>
                                </div>

                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                                <div class="form-row justify-content-center">
                                    <button class="btn btn-primary p-3 w-50" type="submit">
                                        Зберегти зміни
                                    </button>
                                    <span><small>Після збережння ви будете перенаправлені на сторінку входу</small></span>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>