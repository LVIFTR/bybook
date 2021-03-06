<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Registration</title>
</head>
<body>
<div class="w-100 h-100 d-flex align-items-center justify-content-center">
    <div class="col-md-8">
        <form action="/user/register" method="POST" class="form-signin">
            <h2 class="form-heading text-center p-3">Реєстрація</h2>

            <#if userCannotBeCreated??>
                <div class="form-row form-control m-3 alert alert-danger justify-content-center" role="alert">
                    ${userCannotBeCreated}
                </div>
            </#if>

            <div class="form-group">
                <input name="firstName" type="text" class="form-control m-3" placeholder="Ім'я"
                       required/>
                <input name="lastName" type="text" class="form-control m-3" placeholder="Прізвище"
                       required/>
                <input name="nickname" type="text" class="form-control m-3" placeholder="Введіть ваш нікнейм(5-20 символів, має бути унікальним)"
                       required/>
                <input name="address" type="text" class="form-control m-3" placeholder="Введіть вашу адресу проживання"
                       required/>
                <input name="zipCode" type="text" class="form-control m-3" placeholder="Введіть ваш поштовий індекс"
                       required/>
                <input name="phoneNumber" type="text" class="form-control m-3" placeholder="Введіть ваш номер телефону"
                       required/>
                <input name="username" type="email" class="form-control m-3" placeholder="Email"
                       required/>
                <input name="password" type="password" class="form-control m-3" placeholder="Пароль" required/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form-row justify-content-center">
                    <button class="btn btn-primary p-3 w-50" type="submit">Зареєстуватися</button>
                </div>
            </div>

        </form>
    </div>
</div>
<form action="/login" method="get">
    <div class="form-row justify-content-center">
        <input type="submit" class="btn btn-light m-3" value="Увійти"/>
    </div>
</form>
</body>
</html>