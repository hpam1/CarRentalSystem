<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title>Registration Successful</title>
  <style type="text/css">
body {
font-size: 30px;
padding-right: 10cm;
}
  </style>
</head>
<body>
<div id = "header">
<%@include file="header.jsp" %>
</div>
<form action="CRSRegisterSuccController" method="post">
<p id="p"></p>
<br>
<br>
<br>
<br>
<br>
<div style="text-align: center;"><span
 style="font-family: Andalus;">&nbsp;&nbsp; </span><span
 style="font-weight: bold; font-family: Andalus;">Your
account has been
created successfully and
is ready to use!!!</span><br>
<br>
</div>
<div style="text-align: center;"><span
 style="font-family: Andalus;">&nbsp; &nbsp; <small>Click
below to access our catalog menu</small></span></div>
<div style="text-align: center;"><input value="Catalog Menu"
 type="submit" style="height:28px; width:150px; font-size: 20px;"></div></form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="footer">
<%@include file="footer.jsp" %>
</div>
</body>
</html>
    