<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>${user.nickname}</title>
</head>
<#include "../include/navbar.ftl">
<body>
<div class="container">
    <div class="col-md-11.5">
        <div class="card">
            <div class="card-body">

                <div class="col-md-12">
                    <h4>${user.getFirstName()} ${user.getLastName()}</h4>
                    <hr>
                </div>

                <div class="col-md-12">
                    <div class="form-group row">

                        <label for="username" class="col-4">Email</label>
                        <div class="col-8">
                            <span>${user.getUsername()}</span>
                        </div>

                        <label for="nickname" class="col-4">Нікнейм</label>
                        <div class="col-8">
                            <span>${user.getNickname()}</span>
                        </div>

                        <label for="address" class="col-4">Адреса</label>
                        <div class="col-8">
                            <span>${user.getAddress()}</span>
                        </div>

                        <label for="zipCode" class="col-4">Поштовий індекс</label>
                        <div class="col-8">
                            <span>${user.getZipCode()}</span>
                        </div>

                        <label for="phoneNumber" class="col-4">Номер телефону</label>
                        <div class="col-8">
                            <span>${user.getPhoneNumber()}</span>
                        </div>

                        <form action="/user/update" method="get">
                            <button type="submit" class="btn btn-primary">Редагувати</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>