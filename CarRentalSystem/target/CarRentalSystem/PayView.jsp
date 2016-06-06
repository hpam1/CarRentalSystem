<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
  <meta http-equiv="content-type"
 content="text/html; charset=ISO-8859-1">
  <title>Payment Page</title>
  <style>
.fixedimage img{
width:65% !important;
height:300px;
display:block;
background-attachment:scroll;
}
#formElement
{
position:absolute;
top:50%;
left:50%;
}
::-webkit-input-placeholder { /* WebKit browsers */
    color:    red;
    opacity:  0.7;
}
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
   color:    red;
   opacity:  0.7;
}
::-moz-placeholder { /* Mozilla Firefox 19+ */
   color:    red;
   opacity:  0.7;
}
:-ms-input-placeholder { /* Internet Explorer 10+ */
   color:    red;
   opacity:  0.7;
}
#cn1 {
width: 2.22cm;
height: 0.75cm;
}
#cn2 {
width: 2.2cm;
height: 0.75cm;
}
#cn3 {
width: 2.15cm;
height: 0.75cm;
}
#cn4 {
width: 2.2cm;
height: 0.8cm;
}
#cvv {
width: 1cm;
height: 0.82cm;
}
#cn {
width: 10.7cm;
height: 0.72cm;
}
#type1 {
width: auto;
margin-left: 3em;
}
#type2 {
width: auto;
margin-left: 3em;
}
#expireYY
{
width: 1.25cm;
height: 0.72cm;
}
#expireMM
{
width: 1.38cm;
height: 0.72cm;
}
#payamt
{
font-weight: 50px;
}
h1
{
margin-top: 1.8em;
text-align: center;
}
input.button {
    width: 2.5cm;  
    height: 2em;
    font-weight: bold;
    font-size: 20px;
}
body {
    overflow-x:hidden;
}
</style>
</head>
<body>
<table style="width: 1555px;" border="0"
 cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td><div id = "header">
<%@include file="header.jsp" %>
</div>
<div id="content">
              <%@include file="menu.jsp" %>
</div>
<div>
<form action="CRSPaymentController" method="post" name="isform">
  <h1>Please enter your card details here!!</h1>
</div>    
</td>
    </tr>
    <tr>
      <td style="width: 100%;">
      <div class="fixedimage"
 style="background-attachment: scroll;">
      <center><img src="images/creditcard.jpg"></center>
      <div class="cdn1"
 style="position: relative; top: -3.9cm; left: 8.5cm;">
      <input name="card1" id="cn1" type="text" maxlength=4 placeholder="XXXX" pattern="[4]{1}[0-9]{3}|[5]{1}[0-9]{3}" required title="Not a valid Visa/Master Card Number"></div>
      <div class="cdn2"
 style="position: relative; top: -4.75cm; left: 11.2cm;">
      <input name="card2" pattern="[0-9]{4}"
 placeholder="XXXX" required title="This is a mandatory field" id="cn2" type="text" maxlength=4></div>
      <div class="cdn3"
 style="position: relative; top: -5.64cm; left: 14cm;">
      <input name="card3" pattern="[0-9]{4}"
 placeholder="XXXX" required title="This is a mandatory field" id="cn3" type="text" maxlength=4></div>
      <div class="cdn4"
 style="position: relative; top: -6.54cm; left: 16.8cm;">
      <input name="card4" pattern="[0-9]{4}"
 placeholder="XXXX" required title="This is a mandatory field" id="cn4" type="text" maxlength=4></div>
 <div class="cvv"
 style="position: relative; top: -8.5cm; left: 29.3cm;">
      <input name="cvv" pattern="[0-9]{3}"
 placeholder="CVV" required title="This is a mandatory field" id="cvv" type="text" maxlength=3></div>     
 </div>
 <div id="payamt" style="position: relative; top: -4.5cm; left: 18.5cm; font-weight: 50px">
 <h2>Payment Amount ${sessionScope.TotalCost}$ </h2>
 </div>
 <div id="sub"style="position: relative; top: -4cm; text-align: center;">
 &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
<input class="button" value="Submit"
 type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </div>
      </td>
    </tr>
    <tr>
      <td style="height: 37px;"></td>
    </tr>
  </tbody>
</table>
<div class="Mon"
 style="position: relative; top: -11cm; left: 12.6cm;">
<select name="expireMM" required title="Mandatory field" id="expireMM">
<option value="">MM</option>
<option value="01">01</option>
<option value="02">02</option>
<option value="03">03</option>
<option value="04">04</option>
<option value="05">05</option>
<option value="06">06</option>
<option value="07">07</option>
<option value="08">08</option>
<option value="09">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
</div>
<div class="Year"
 style="position: relative; top: -11.7cm; left: 14.2cm;">
<select name="expireYY" required title="Mandatory field" id="expireYY">
<option value="">YY</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
</select>
</div>
<div class="cardname"
 style="position: relative; top: -11.4cm; left: 8.4cm;">
<input name="cardname" pattern="[a-zA-Z][a-zA-Z ]+" placeholder="CARD HOLDER NAME" required title="Card holder name should only be having Alphabets" id="cn" type="text"></div>
<div id="type"
 style="position: relative; top: -17.9cm; left: 13cm;">
<input name="cardtype" Value="Master Card" id="type1" type="radio" required"><label
 for="Master"><img src="images/MasterCard.png"
 alt="Master Card"></label>
 <input name="cardtype" Value="Visa" id="type2" type="radio" required><label for="Visa"><img
 src="images/visa.png" alt="Visa"></label></div>
 <div id="footer" style="position: relative; top: -6.7cm;">
				<%@include file="footer.jsp" %>
			</div>
 <script>
var Master = document.getElementById("type1");
var Visa = document.getElementById("type2");
var input = document.getElementById("cn1");

Master.onclick = function() {
    input.placeholder = "5XXX";
    input.title="Not a valid Master Card Number"
    input.pattern="[5]{1}[0-9]{3}"
  
}

    Visa.onclick = function() {
    input.placeholder = "4XXX";
    input.title="Not a valid Visa Card Number"
    input.pattern="[4]{1}[0-9]{3}"

}
  </script> 
</form>
</body>
</html>
