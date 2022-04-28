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

                        <label for="username" class="col-4 col-form-label">Email</label>
                        <div class="col-8">
                            <span>${user.getUsername()}</span>
                        </div>

                        <label for="nickname" class="col-4 col-form-label">Нікнейм</label>
                        <div class="col-8">
                            <span>${user.getNickname()}</span>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>