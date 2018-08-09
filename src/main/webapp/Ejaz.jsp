<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
  function()
  {
	  alert("Hi bro");
	  var a=document.getElementById("a").value();
	  var b=document.getElementById("b").value();
	  
	  if(a=='' && b=='')
		  {
		  document.getElementById("a").innerHTML="Required";
	      document.getElementById("b").innerHTML="Required";
		  }
  }
</script>
<form action="Home.jsp" onsubmit="return function();">
Name:<input type="text" id="a" />
Age:<input type="text" id="b"  />
<input type="submit"/>
</form>
</body>
</html>