<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyProject</title>
</head>
<body>
	<center>
		<div><h3 style="padding:10px; color: red">${message}</h3></div>
		<br><br>
		<div>
			<form name="loginForm" action="<%=response.encodeURL("LoginServlet")%>" method="post">
			<table>
			<td>
			<input style="color: green;" type="submit" value="Go To Login">
			</td>
			</table>
			</form>
		</div>
	</center>
</body>
</html>