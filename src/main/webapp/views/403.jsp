<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="errorPage.403.accessDenied" var="accessDenied" />
<spring:message code="logout.buttonLogout" var="buttonLogout" />


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>${accessDenied}</title>
    </head>
    <body>
        <h1>HTTP 403 - ${accessDenied}</h1>

        <form action="/logout" method="post">
            <input type="submit" value="${buttonLogout}" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
    </form>

    </body>
</html>