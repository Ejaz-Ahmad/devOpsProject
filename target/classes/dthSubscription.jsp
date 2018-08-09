<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<font size="5">DTH Subscription</font>
	<form:form  action="insertingDetails" commandName="subscriptionDetails"  method="post" >
		<table border="2px solid black">
			<tr>
				<td>Customer Subscription Id</td>
				<td><input type="text" path="subscriberId"/></td>
			</tr>
			<tr>
				<td>Channels</td>
				<td><select name="scrollId" path="channelId">

						<c:forEach items="${channels}" var="record">
							<option value="${record.getChannelId() }">${record.getChannelName() }</option>
						</c:forEach>





				</select></td>
			</tr>
			<tr>
				<td>Date Of Subscription</td>
				<td><input type="date" path="subscriptionDate"
					value="<%Date dNow = new Date( );
   SimpleDateFormat ft = 
   new SimpleDateFormat ("dd.MM.yyyy");
   out.print(ft.format(dNow));
%>">
				</td>
			</tr>
			<tr>
				<td><input type="button" name="clear" value="clear"
					onclick="location.href='Home.jsp'" /></td>
				<td><input type="submit" name="subscribe" value="subscribe"></td>
		</table>
	</form:form>
</body>
</html>