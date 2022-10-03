<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Log</title>
</head>
<body>
<h1>Login</h1>
<img th:src="@{/images/TacoCloud.png}"/>
<div th:if="${error}">
  Unable to login. Check your username and password.
</div>
<p>New here? Click
  <a th:href="@{/register}">here</a> to register.</p>
<form method="POST" th:action="@{/login}" id="loginForm">
  <label for="username">Username: </label>
  <input type="text" name="username" id="username" /><br/>
  <label for="password">Password: </label>
  <input type="password" name="password" id="password" /><br/>
  <input type="submit" value="Login"/>
  <h4><a href="/registration">Зарегистрироваться</a></h4>
</form>
</body>
</html>