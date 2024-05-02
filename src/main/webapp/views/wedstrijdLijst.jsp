<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<spring:message code="fifa.worldcupHeader" var="cupHeader" />
<spring:message code="fifa.stadiumHeader" var="stadiumHeader" />
<spring:message code="wedstrijdLijst.tabel.nummer" var="nummer" />
<spring:message code="wedstrijdLijst.tabel.voetbalmatch" var="voetbalmatch" />
<spring:message code="wedstrijdLijst.tabel.datum" var="datum" />
<spring:message code="wedstrijdLijst.tabel.aftrap" var="aftrap" />
<spring:message code="wedstrijdLijst.tabel.tickets" var="tickets" />
<spring:message code="logout.buttonLogout" var="buttonLogout" />

<spring:url value="/fifa/" var="fifaUrl" />

<spring:message code="date.format.pattern" var="dateFormatPattern" />
<spring:message code="time.format.pattern" var="timeFormatPattern" />
<spring:message code="locale" var="locale" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FIFA</title>
        <spring:url value="/css/style.css" var="urlCss"/>
        <spring:url value="/css/wedstrijdLijst.css" var="urlWedstrijdLijstCss"/>
        <link rel="stylesheet" href="${urlCss}" type="text/css" />
        <link rel="stylesheet" href="${urlWedstrijdLijstCss}" type="text/css" />
</head>
<body>

	<form action="/logout" method="post">
            <input class="button-logout" type="submit" value="${buttonLogout}" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
    </form>
    
	<h1>${cupHeader}</h1>
	<h2>${stadiumHeader}: ${stadium.naam}</h2>
	<table>
		<thead>
			<th>${nummer}</th><th>${voetbalmatch}</th><th>${datum}</th><th>${aftrap}</th><th>${tickets}</th>
		</thead>
		<tbody>
			<c:forEach var="ticket" items="${wedstrijdList}" varStatus="status">
				<tr>
					<td><a href="${fifaUrl}${ticket.id}">${status.count}</a></td>
					<td>${ticket.wedstrijd.landenAsString}</td>
					<td>
						<fmt:setLocale value="${locale}" scope="session"/>
						<fmt:parseDate value="${ticket.wedstrijd.datum}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDatum" type="both"/>
						<fmt:formatDate timeZone="UTC" type="date" dateStyle="long" value="${parsedDatum}" pattern="${dateFormatPattern}" />
					</td>
					<td>
						<fmt:formatDate timeZone="UTC" type="time" value="${parsedDatum}" pattern="${timeFormatPattern}" />
					</td>
					<td>${ticket.tickets}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>