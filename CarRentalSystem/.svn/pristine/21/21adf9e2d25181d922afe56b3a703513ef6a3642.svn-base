<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Rental History</title>
 <link
 href="http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800"
 rel="stylesheet" type="text/css">
<!-- Bootstrap and Font Awesome css -->
  <link rel="stylesheet"
 href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet"
 href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<style>
#pageof
{
position: fixed;
top:88%;
left:37%;
font-size:15px;
font-weight: bold;
border-radius: 3px;
border: solid 1px #c0c0c0;
box-shadow: inset 0px 1px 0px rgba(255,255,255, .7), 0px 1px 3px rgba(0,0,0, .1);
text-shadow: 1px 1px 0px rgba(255,255,255, 0.7);
background: #eee;
color: #555;
-webkit-box-shadow: inset -1px 2px 5px rgba(0,0,0,0.25);
-moz-box-shadow: inset -1px 2px 5px rgba(0,0,0,0.25);
box-shadow: inset -1px 2px 5px rgba(0,0,0,0.25);
}
#page
{
position: fixed;
top:78%;
left:37%;
font-size:24px;
border: solid 1px white !important;
box-shadow: inset 0px 1px 0px rgba(255,255,255, .7), 0px 1px 3px rgba(0,0,0, .1);
text-shadow: 1px 1px 0px rgba(255,255,255, 0.7);
background: #eee;
color: #555;
-webkit-box-shadow: inset -1px 2px 5px rgba(0,0,0,0.25);
-moz-box-shadow: inset -1px 2px 5px rgba(0,0,0,0.25);
box-shadow: inset -1px 2px 5px rgba(0,0,0,0.25);
}
.table td {
   text-align: center;   
}
#customer-orders
{
padding-top:1cm;
padding-left:3cm;
font-size:16px;
}
#content
 {
 width:43cm;
 padding-left:1cm;
 padding-top:1cm;
 } 
 .col-md-7
 {
 padding-left:13cm;
 }
 </style>
<body>
<form action="CRSRenew" method="post">
<div id = "header">
<%@include file="header.jsp" %>
</div>
<div id="content">
<%@include file="menu.jsp" %>
</div>
<div class="col-md-7">
<br><br><br>
<h2 style="text-align:center">
<b><u>My Rental History</u></b></h2>
</div>
<div class="col-md-9" id="customer-orders"><br>
<div class="box">
<div class="table-responsive">
<c:choose>
<c:when test="${not empty RentalList}">
    <table class="table table-striped table-bordered table-condensed table-hover">
        <tr>
            
            <th class="text-center">Transaction ID</th>
            <th class="text-center">Car License No</th>
            <th class="text-center">Rental Start Date</th>
            <th class="text-center">Rental End Date</th>
            <th class="text-center">Reserved Date</th>
            <th class="text-center">Status</th>
            <th class="text-center">Renew?</th>
        </tr>
 
        <c:forEach var="RentalHistory" items="${RentalList}">
            <tr>
                <td>#${RentalHistory.transactionId}</td>
                <td>${RentalHistory.carLicenseNo}</td>
                <td>${RentalHistory.startDateTime}</td>
                <td>${RentalHistory.endDateTime}</td>
                <td>${RentalHistory.reservedDate}</td>
                <td><span class="label ${RentalHistory.statusLabel}">${RentalHistory.status}</span></td>
                <td>${RentalHistory.renew}</td>
            </tr>
        </c:forEach>
    </table>
  </c:when>
<c:otherwise>
<h1 style="text-align:center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Your Rental History is empty!!</h1>
</c:otherwise>
    </c:choose>
 <div id=page>
     <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table class="centered-table" border="1" cellpadding="10" cellspacing="10">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>Page:${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="order.do?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
             <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="order.do?page=${currentPage - 1}" style="color:red">Previous Page</a></td>
         <div id=pageof>
    Page ${currentPage} of ${noOfPages}
  </div>
    </c:if>
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="order.do?page=${currentPage + 1}" style="color:red">Next Page</a></td>
        <div id=pageof>
    Page ${currentPage} of ${noOfPages}
  </div>
    </c:if>
        </tr>
    </table>
    
    </div>
    
    
<!-- /.table-responsive -->
</div>
<!-- /.box -->
</div>
</div>
</form>
  <div id="footer" style="position: fixed; top: 24cm;">
				<%@include file="footer.jsp" %>
			</div>
</body>
</html>