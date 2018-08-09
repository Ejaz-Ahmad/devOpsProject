<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <table>
    <tr>
    <td>SubscriptionId</td><td>${object.customerId}</td>
    </tr>
    <tr>
    <td>CustomerName</td><td>${object.name}</td>
    </tr>
    <tr>
    <td>Total Subscription Cost</td><td>${object.totalSubscriptionCost}</td>
    </tr>
    </table>
    <table style="border:2px solid black;">
    <c:forEach items="${object.subscribedChannels}" var="record">
                            <tr>
                            <td>${record.getChannelName()}</td><td>${record.getCostPerMonth()}</td>
                            </tr> 
    </c:forEach>
    
    </table>
</body>
</html>