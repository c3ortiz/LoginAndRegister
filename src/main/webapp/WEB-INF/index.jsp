<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>LogIn and Register</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-6">
                <h2>Registrate</h2>
                <form:form action="/register" method="post" modelAttribute="nuevoUsuario">
                    <div class="form-group">
                        <form:label path="name">Nombre:</form:label>
                        <form:input path="name" class="form-control" />
                        <form:errors path="name" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="email">Email:</form:label>
                        <form:input path="email" class="form-control" />
                        <form:errors path="email" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password:</form:label>
                        <form:password path="password" class="form-control" />
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="confirmPassword">Confirmacion:</form:label>
                        <form:password path="confirmPassword" class="form-control" />
                        <form:errors path="confirmPassword" class="text-danger" />
                    </div>

                    <input type="submit" class="btn btn-primary" value="Registrarme" />
                </form:form>
            </div>
            <div class="col-6">
                <h2>Inicia sesion</h2>
                <form:form action="/login" method="post" modelAttribute="nuevoLogin">
                    <div class="form-group">
                        <form:label path="email">Email:</form:label>
                        <form:input path="email" class="form-control" />
                        <form:errors path="email" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password:</form:label>
                        <form:password path="password" class="form-control" />
                        <form:errors path="password" class="text-danger" />
                    </div>

                    <input type="submit" class="btn btn-primary" value="Iniciar sesion" />
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>