<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h3>Question Create</h3>
<form action="QuestionServlet" method="post">
Name:<input type="text" name="name" /><br>
<input type="submit" value="Save" name="action" />
</form>
</body>
</html>