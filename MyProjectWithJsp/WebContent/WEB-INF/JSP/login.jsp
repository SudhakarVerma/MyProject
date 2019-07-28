<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyProject</title>
<script type="text/javascript" src="JS/jquery-1.12.4.js"></script>
<script language="javascript">
 

 
</script>
</head>
<body>
<form name="loginForm" action="<%=response.encodeURL("LoginServlet")%>" method="post">
	<table>
		<tr>
			<td>
				User ID : <input type="text" name="userid" id="userid"><br>
				Password : <input type="text" name="password" id="password">
			<td>
				<input type="submit" value="Login">
				<!-- <a href="javascript:void(0);" onclick="validateUser();" >Login</a> -->
			</td>
			
		</tr>
	
	</table>

</form>
</body>
</html>