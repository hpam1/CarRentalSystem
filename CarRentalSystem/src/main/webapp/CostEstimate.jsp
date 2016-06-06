<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<%@ page isELIgnored="false" %>
		<meta charset="US-ASCII">
		<title>Cost Estimation Page</title>
		<link rel="stylesheet" type="text/css" href="styles/CRSStyles.css">
		
		<link type="text/css" href="scripts/jquery-simple-datetimepicker-1.12.0/jquery.simple-dtpicker.css" rel="stylesheet" />
		<script type="text/javascript">
			function checkValue() {
				if(document.getElementById("hidden").value == "no") {
					return true;	
				} else {
					var startDate = document.getElementById('startdate');
					var endDate = document.getElementById("enddate");
				
					if(startDate == null || endDate == null) {
						return false;
					}
					startDate = startDate.value;
					endDate = endDate.value;
					
					if((startDate == null || endDate == null) || (startDate == undefined || endDate == undefined) || (startDate.length < 1 || endDate.length < 1)) {
						if(document.getElementById("hidden").value == "submit") {
							document.getElementById("error").innerHTML = "Start date and end date fields are mandatory";
							return false;
						} else if(document.getElementById("hidden").value == "no"){
							return true;
						} else
							return false;
					}
					var d1 = Date.parse(startDate);
					var d2 = Date.parse(endDate);
					if(d2 <= d1) {
						document.getElementById("error").innerHTML = "End date must be greater than start date";
						return false;
					} else {
						document.getElementById("error").innerHTML = "";
						return true;
					}
				}
			}
			function setValue(obj) {
				if(obj.value == "Continue")
					document.getElementById("hidden").value = "submit";
				else
					document.getElementById("hidden").value = "no";
			}
		</script>
	</head>
	<body>
		<div id="wrapper">
			<div id = "header">
				<%@include file="header.jsp" %>
			</div>
			<div id = "content">
				<%@include file="menu.jsp" %>
				<c:if test="${msg != null}">
					<div class="erorrMsg"> ${msg} </div>
				</c:if>
				<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
				<script type="text/javascript" src="scripts/jquery-simple-datetimepicker-1.12.0/jquery.simple-dtpicker.js"></script>
				<script type="text/javascript" src="scripts/JqueryDTPicker.js"></script>
				<div style="float: left; width: 30%;">
					<form action="CheckAvailability" method = "POST" onsubmit="return checkValue()">
						<div class = "loginDivs">
							<label> Start Date: </label>
							<input type="text" id="startdate" name="startDate" value="${sessionScope.startDate}" onchange="checkValue()"/>
						</div>
						<div class="loginDivs">
							<label>End Date:</label>
							<input type="text" id="enddate" name="endDate" value="${sessionScope.endDate}" onchange="checkValue()"/>
						</div>
						<div class="loginDivs">
							<span id="error"></span>
						</div>
						<div class="loginDivs">
							<input type="submit" name="action" value = "Continue" onclick="setValue(this)"/>
							<input type="submit" name = "action" value = "Back to search" onclick="setValue(this)"/>
							<input type="hidden" id="hidden" value="yes"/> 
						</div>
					</form>
				</div>
				<div style = "float: right; width: 70%;">
					<c:if test ="${costEstimate != null}">
						<form action="LockCar" method="POST">
							<input type="hidden" name="LockCarMech" id="LockCarMech" value="rental" /> 
							<c:forEach items="${costEstimate}" var="cost">
								<div class="loginDivs">
									<label> ${cost} </label>
								</div>
							</c:forEach>
							<div class="loginDivs">
								<input type = "Submit" value="Rent this car" />
							</div>
						</form>
					</c:if>
				</div>
			</div>
			<div id="footer">
				<%@include file="footer.jsp" %>
			</div>
		</div>
	</body>
</html>