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
     <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
     <script type="text/javascript" src="scripts/AdvancedSearchScript.js"></script>     
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
 
                <div id = "filters">
                        <span style="color:blue;margin-left:35px"> REFINE YOUR SEARCH</span><br><br>
                        <c:choose>
                              <c:when test="${searchcriteria == 'Car Model'}">
                                 <label> Car color </label> 
                                     <select id="selectcarcolor" style="width: 150px; margin-left:58px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carcolor}">${car.carcolor}</option>
                                        </c:forEach>
                                     </select><br><br>
                              </c:when>       
                                     
                              <c:when test="${searchcriteria == 'Car Manufacturer'}">
                                 <label> Car model</label>
                                    <select id="selectcarmodel" style="width: 150px;margin-left:52px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carmodel}">${car.carmodel}</option>
                                        </c:forEach>   
                                    </select> <br>
                                 <label> Car type</label>
                                    <select id="selectcartype" style="width: 150px;margin-left:65px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carclass}">${car.carclass}</option>
                                        </c:forEach>   
                                    </select><br>
                                 <label> Capacity</label>
                                    <select id="selectcarcapacity" style="width: 150px;margin-left:61px;margin-top:5px">
                                          <c:forEach items = "${carslist}" var="car">
                                             <option value="${car.carcapacity}">${car.carcapacity}</option>
                                          </c:forEach>
                                    </select> <br>
                                 <label> Car color </label> 
                                    <select id="selectcarcolor" style="width: 150px; margin-left:58px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carcolor}">${car.carcolor}</option>
                                        </c:forEach>
                                    </select><br><br>
                              </c:when>
                             
                              <c:when test="${searchcriteria == 'Car Type'}">
                                 <label> Car Manufacturer</label>
                                    <select id="selectcarmake" style="width: 150px;margin-left:5px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carmake}">${car.carmake}</option>
                                        </c:forEach>
                                    </select> <br>
                                 <label> Car model</label>
                                    <select id="selectcarmodel" style="width: 150px;margin-left:52px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carmodel}">${car.carmodel}</option>
                                        </c:forEach>   
                                    </select> <br>
                                 <label> Capacity</label>
                                    <select id="selectcarcapacity" style="width: 150px;margin-left:61px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carcapacity}">${car.carcapacity}</option>
                                        </c:forEach>
                                    </select> <br>
                                 <label> Car color </label> 
                                    <select id="selectcarcolor" style="width: 150px; margin-left:58px;margin-top:5px">
                                        <c:forEach items = "${carslist}" var="car">
                                           <option value="${car.carcolor}">${car.carcolor}</option>
                                        </c:forEach>
                                    </select><br><br>
                              </c:when>
                              
                              <c:otherwise><!--  
                                -->
                              </c:otherwise>    
                        </c:choose>
                        <input type="button" id ="ApplyFilterBtn"  value="Apply Filter" style="margin-left:10px">
                        <input type="button" id ="ResetFilterBtn"  value="Reset Filter" style="margin-left:5px">
                        
                        <div id="table">
                        <form action="InsertingEstimate" method = "post">
                           <table id="tbldata">
                               <c:forEach items="${carslist}" var="car" varStatus ="myIndex">
                                     <tr style="outline:thin solid">
                                           <td><img src="images/cars/${car.carimgpath}" width="400" height="200"></img></td>
                                           <td width="230" style="padding:25px">
                                                            Car Manufacturer: ${car.carmake}                    <br>
                                                            Car Model: ${car.carmodel}                          <br>
          		                                            Car type: ${car.carclass}                           <br>
          		                        					Car Capacity: ${car.carcapacity}                    <br>
          		                        					Car Rental cost:${car.carrentalcost} per day        <br>
          		                        					Car Insurance cost: ${car.carinsurancecost}per day  <br>
          		                        					Car Description:${car.cardescription}               <br>
          		                        					Car color: ${car.carcolor}                          <br>
                                           </td>
                                           <td width="185"><input type="submit" name="rentcar" id="${myIndex.index}" class="rentacar" value="RENT A CAR">
  		        							<input type = "hidden" name="hvar" value = "RentCar">
        		  							<input type = "hidden" name = "carid" id="hid${myIndex.index}" value= "${car.carid}"></td>
                                     </tr> 
                               </c:forEach>
                           </table>
                           <input type = "hidden" name = "carsids" id="finalcarid" value="0">
                           </form>
                        </div>      
                </div>  
                <br><br> 
            </div> 
            
            <!-- 
             <div id="footer">
				  <%@include file="footer.jsp" %>
		    </div> -->
     </div>
     
  </body>
 </html>