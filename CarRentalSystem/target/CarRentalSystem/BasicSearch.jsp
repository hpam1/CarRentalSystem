<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
  <head>
     <%@ page isELIgnored="false" %>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>CAR RENTAL</title>
     <link rel="stylesheet" type="text/css" href="styles/Search-Catalogue-CSS.css">
 	 <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
     <script type="text/javascript">
     	$(document).ready(function() {
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
			    <form action = "AdvancedSearchController" method="post">
                       <table cellspacing="30" align="center">
                            <tr> 
                               <td> <label style="color:blue"> SEARCH CAR </label> <input type="text" name="searchtextbox" required title="Search String cannot be empty"> </td>
                               <td> <label style="color:black"> By: </label> </td>
                               <td> <input type="radio" name="radiobuttonchoice" value="Car Model" checked>Car Model</td>
                               <td> <input type="radio" name="radiobuttonchoice" value="Car Manufacturer"> Car Manufacturer</td>
          					   <td> <input type="radio" name="radiobuttonchoice" value="Car Type"> Car Type</td>
          					   <td> <input type="submit" name="gobutton" id="go" value="GO"> <td>
                               <td> <button type="reset" value="clear" id="clear"> clear</button> </td>
                           </tr>
                       </table>
                </form>
 
                <br><br>
                <c:if test="${msg!= null}">
			           <div class="erorrMsg"> ${msg} </div>
		        </c:if>
 
 				<form action="InsertingEstimate" method = "post">
                <table align="center">
                    <c:forEach items="${carslist}" var="car" varStatus ="myIndex">
                       <tr style="outline:thin solid">
                            <td width="400" height="200"><img src="images/cars/${car.carimgpath}" width="400" height="200"></img></td>
                            <td width="275" Style="padding:10">
                                   <label> Car Model: ${car.carmodel}                          </label><br>
                                   <label> Car Manufacturer: ${car.carmake}                    </label><br>
          		                   <label> Car type: ${car.carclass}                           </label><br>
          		                   <label> Car Description:${car.cardescription}               </label><br>
          		                   <label> Car color: ${car.carcolor}                          </label><br>
          		                   <label> Car Availability:${car.caravailablity}              </label><br>
          		                   <label> Car Capacity: ${car.carcapacity}                    </label><br>
          		                   <label> Car Rental cost:$${car.carrentalcost} per day       </label><br>
          		                   <label> Car Insurance cost: ${car.carinsurancecost}per day </label><br>
          		                   <input type="submit" name="rentcar" id="${myIndex.index}" class="rentacar" value="RENT A CAR">
          						   <input type = "hidden" name = "carid" id="hid${myIndex.index}" value= "${car.carid}">
                            </td>
                       </tr> 
                    </c:forEach>
                </table>
                <input type = "hidden" name = "carsids" id="finalcarid" value="0">
                </form>
                <br><br>
            </div>  
            <div id="footer">
				<%@include file="footer.jsp" %>
			</div>
     </div>
     
  </body>
 </html>