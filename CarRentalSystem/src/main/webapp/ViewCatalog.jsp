<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
   		<%@ page isELIgnored="false" %>
   		<meta charset="US-ASCII">
   		<title>CAR RENTAL</title>
   		<link rel="stylesheet" type="text/css" href="styles/Search-Catalogue-CSS.css">
   		<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
     	<script type="text/javascript">
      		$(document).ready(function () {
      			$("#go").click(function(){
    	   			$("input[type=radio]").hide();
            	});
          		$(".rentacar").click(function(){
          			var id=$(this).attr("id");
        	  		var value=$("#hid"+id).val();
        	  		$("#finalcarid").val(value);
          		});
      		});
      </script>
	</head>
	<body>
        <div id="wrapper">
			<div id = "header">
				<%@include file="header.jsp" %>
			</div>
			<div id="content">
           		<%@include file="menu.jsp" %>
       			<c:if test="${msg!= null}">
					<font color="red" face="arial"> ${msg}</font>
	 			</c:if>
	 			<form action="InsertingEstimate" method = "post">
 					<table align="center">
  						<c:forEach items="${carslist}" var="car" varStatus ="myIndex">
       						<tr style="outline:thin solid">
           						<td width="400" height="200"><img src="images/cars/${car.carimgpath}" width="400" height="200"></img></td>
            					<td width="275" Style="padding:10">
                					Car Manufacturer: ${car.carmake}                    <br>
                                    Car Model: ${car.carmodel}                          <br>
          		                    Car type: ${car.carclass}                           <br>
          		                    Car Capacity: ${car.carcapacity}                    <br>
          		                    Car Rental cost:${car.carrentalcost} per day        <br>
          		                    Car Insurance cost: ${car.carinsurancecost}per day  <br>
          		                    Car Description:${car.cardescription}               <br>
          		                    Car color: ${car.carcolor}                          <br>
          							<input type="submit" name="rentcar" id="${myIndex.index}" class="rentacar" value="RENT A CAR">
          							<input type = "hidden" name="hvar" value = "RentCar">
          							<input type = "hidden" name = "carid" id="hid${myIndex.index}" value= "${car.carid}">
          						</td>
       						</tr>
   						</c:forEach>
   					</table> 
   					<input type = "hidden" name = "carsids" id="finalcarid" value="0"> 
   				</form>
   			</div>
       		<div id="footer">
				<%@include file="footer.jsp" %>
			</div>
		</div>
	</body>
</html>