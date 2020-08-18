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
<body>
<%@ include file="menu.jsp" %>
<form action="AnswerServlet" method="post">
Question:<select name="question_id">
	<c:forEach items="${questions }" var="q">
		<option value="${q.id }">${q.name }</option>
	</c:forEach>
</select><br>
Name:<input type="text" name="name" /><br>
Mark:<input type="number" name="mark" /><br>
<input type="submit" value="Save" name="action" />
</form>
</body>
</html>