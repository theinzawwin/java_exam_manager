<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<br>
<a href="QuestionServlet?action=new">New Question</a>
<table>
	<thead>
	 <tr>
	 	<th>No</th>
	 	<th>Name</th>
	 </tr>
	</thead>
	<tbody>
		<c:forEach items="${questions}" var="question" varStatus="row">
			<tr>
			<td>${row.count }</td>
			<td>${question.name }</td>
			<td>
				<c:forEach items="${question.answers }" var="ans">
					<p>${ans.name }</p>
				</c:forEach>
			</td>
			</tr>
			
		</c:forEach>
	</tbody>
</table>
</body>
</html>