<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<br>
<a href="AnswerServlet?action=new">New Answer</a>
<table>
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Mark</th>
			<th>Question</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${answers }" var="ans" varStatus="row">
		<tr>
			<td>${row.count }</td>
			<td>${ans.name }</td>
			<td>${ans.mark }</td>
			<td>${ans.question.name }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>