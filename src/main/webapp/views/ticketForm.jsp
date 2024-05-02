<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="fifa.worldcupHeader" var="cupHeader" />
<spring:message code="fifa.stadiumHeader" var="stadiumheader" />
<spring:message code="ticketForm.aantalTicketsHeader" var="aantalTicketsHeader" />
<spring:message code="ticketForm.labelEmail" var="labelEmail" />
<spring:message code="ticketForm.labelNrTickets" var="labelNrTickets" />
<spring:message code="ticketForm.labelVoetbalCode1" var="labelVoetbalCode1" />
<spring:message code="ticketForm.labelVoetbalCode2" var="labelVoetbalCode2" />
<spring:message code="ticketForm.buttonSubmit" var="buttonSubmit" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FIFA</title>
<spring:url value="/css/style.css" var="urlCss"/>
<spring:url value="/css/ticketForm.css" var="urlTicketFormCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" />
<link rel="stylesheet" href="${urlTicketFormCss}" type="text/css" />
</head>
<body>
	<h1>${cupHeader}</h1>
	<h2>${stadiumheader}: ${stadium.naam}</h2>
	<h3>${wedstrijdTicket.wedstrijd}</h3>
	<h3>${aantalTicketsHeader}: ${wedstrijdTicket.tickets}</h3>
	<form:form method="POST" modelAttribute="aankoop">
		
		<table>
			<tr>
				<td>${labelEmail}:</td>
				<td><form:input path="email" size="15"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>${labelNrTickets}:</td>
				<td><form:input path="aantalTickets" size="15"/></td>
				<td><form:errors path="aantalTickets" cssClass="error"/></td>
			</tr>
			<tr>
				<td>${labelVoetbalCode1}:</td>
				<td><form:input path="voetbalCode1" size="15"/></td>
				<td><form:errors path="voetbalCode1" cssClass="error"/></td>
			</tr>
			<tr>
				<td>${labelVoetbalCode2}:</td>
				<td><form:input path="voetbalCode2" size="15"/></td>
				<td><form:errors path="voetbalCode2" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="button" type="submit" value="${buttonSubmit}" /></td>
			</tr>
			
		</table>
            
        </form:form>
</body>
</html>