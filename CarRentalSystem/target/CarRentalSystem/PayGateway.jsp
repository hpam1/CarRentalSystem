<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
 <script src="Jquery/jquery.min.js"></script>

<head>
  <meta content="text/html; charset=ISO-8859-1"
 http-equiv="content-type">
  <title>Secured Payment Gateway</title>
  <style type="text/css">
body {
font-size: 30px;
padding-right: 10cm;
}
#loading
{
text-align: center;
}
#loading1
{
text-align: center;
}
 
  </style>
 
</head>
<body>

<div id = "header" style="align: center"> <img alt="" src="images/Payment.jpg"
 style="width: 1744px; height: 200px;"><br>
</div>

</div>
<br>
<br>
<br>
<br>
<br>
<div id="loading" style="align: center"> <img alt="" src="images/loading.gif"
 style="width: auto; height: auto;"><br>
</div>
<div id="loading1" style="text-align: center;"><span
 style="font-family: Andalus;">&nbsp;&nbsp; </span><span
 style="font-weight: bold; font-family: Andalus;">Your payment is being submitted. Please do not close this window or click the Back button on your browser.</span>
 </div>
</div>
<div id="loading2" style="text-align: center;"><span style="font-weight: bold; font-family: Andalus;">&nbsp; &nbsp;Your payment was successful!! You will now be redirected to the respective Home page</span></div>
<script type="text/javascript">
$('#loading').delay(5000).fadeOut('slow');
$('#loading1').delay(5000).fadeOut('slow');
$("#loading2").hide();
$('#loading2').delay(5000).show('slow');
    </script>   
<meta http-equiv="Refresh" content="10;FinalRentingCars">
<%response.setHeader("Refresh", "10;url=/Sprint2/FinalRentingCars"); %>
<div id = "footer" style="align: center; position: fixed; top: 19cm; left: 15.5cm;"> <img alt="" src="images/payfooter.png"
 style="width: 400px; height: auto;"><br>
</div>
</body>
</html>
    