<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="border:2px solid blue; width:400px;">
<font size="5">View Details Form</font>
<form action="displayingdetails" method="post">
<table>
<tr>
<td>Subscription Id</td>
<td><input type="text" name="subscriptionId"/></td>
</tr>
<tr>
<td><input type="button" name="clear" value="clear" onclick="location.href='Home.jsp'" /></td>
<td><input type="submit" name="subscribe" value="subscribe" /></td>
</tr>
</table>
</form>
</div>
</body>
</html>
