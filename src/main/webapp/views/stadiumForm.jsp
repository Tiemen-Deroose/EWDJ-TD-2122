<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<spring:message code="fifa.worldcupHeader" var="cupHeader" />
<spring:message code="stadiumForm.labelStadiums" var="labelStadiums" />
<spring:message code="stadiumForm.buttonSubmit" var="buttonSubmit" />
<spring:message code="stadiumForm.ticketAangekocht" var="ticketAangekocht" />
<spring:message code="stadiumForm.ticketsAangekocht" var="ticketsAangekocht" />
<spring:message code="stadiumForm.matchUitverkocht" var="uitverkocht" />
<spring:message code="logout.buttonLogout" var="buttonLogout" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FIFA</title>
<spring:url value="/css/style.css" var="urlCss"/>
<spring:url value="/css/stadiumForm.css" var="urlStadiumFormCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<link rel="stylesheet" href="${urlStadiumFormCss}" type="text/css" />
</head>
<body>

    <form action="/logout" method="post">
            <input class="button-logout" type="submit" value="${buttonLogout}" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
    </form>
    
	
	<c:if test="${param.uitverkocht != null}">
		<div><a class="error-msg">${uitverkocht}</a></div>
	</c:if>
	<c:choose>
		<c:when test="${param.ticketsAangekocht == 1}">
			<div><a class="msg">${param.ticketsAangekocht} ${ticketAangekocht}</a></div>
		</c:when>
		<c:when test="${param.ticketsAangekocht > 1}">
			<div><a class="msg">${param.ticketsAangekocht} ${ticketsAangekocht}</a></div>
		</c:when>
	</c:choose>
	
	
	<h1>${cupHeader}</h1>
	<form:form method="POST" action="fifa" modelAttribute="stadium">
		
		<p>
	        ${labelStadiums}: 
			<form:select path="naam" multiple="false">
				<form:options items="${stadiumList}"/>
			</form:select>
		</p>
		<input class="button" type="submit" value="${buttonSubmit}" />
            
    </form:form>
</body>
</html>