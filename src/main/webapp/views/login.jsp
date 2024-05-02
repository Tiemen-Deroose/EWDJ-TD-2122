<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="login.usernamePlaceholder" var="usernamePlaceholder" />
<spring:message code="login.passwordPlaceholder" var="passwordPlaceholder" />
<spring:message code="login.buttonSubmit" var="buttonSubmit" />
<spring:message code="login.error" var="loginError" />
<spring:message code="login.msg" var="loginMsg" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<spring:url value="/css/style.css" var="urlCss"/>
<spring:url value="/css/login.css" var="urlLoginCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<link rel="stylesheet" href="${urlLoginCss}" type="text/css" />
</head>

    <body id="login-body" onload='document.loginForm.username.focus();'>

        <div id="login-box">
            <c:if test="${param.error != null}">
                <div class="error-msg">${loginError}</div>
            </c:if>
                
            <c:if test="${param.logout != null}">
                <div class="msg">${loginMsg}</div>
            </c:if>

           	<form action="login" method="POST">
           
           		<input class="login-textbox" type='text' name='username' value='' placeholder="${usernamePlaceholder}">
				<input class="login-textbox" type='password' name='password' placeholder="${passwordPlaceholder}"/>
                <input id="login-button" name="submit" type="submit" value="${buttonSubmit}" />
                
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                      
            </form>
        </div>

    </body>
</html>