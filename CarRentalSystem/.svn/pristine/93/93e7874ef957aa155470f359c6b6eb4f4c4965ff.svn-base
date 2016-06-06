<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<%@ page isELIgnored="false" %>
		<meta charset="US-ASCII">
		<title>Login Page</title>
		<link rel="stylesheet" type="text/css" href="styles/CRSStyles.css">
		<script>
			function resetValues() {
				document.getElementById("user").value = "";
				document.getElementById("password").value = "";
			}
		</script>		
	</head>
	<body>
		<div id="wrapper">
			<div id = "header">
				<%@include file="header.jsp" %>
			</div>
			<div id = "content">
				<div style="text-align: center">
					<h4> Please login with your credentials </h4>
				</div>
				<form action="Login" method="post">
					<div id = "centerDiv">
						<c:if test="${msg != null}">
							<div class="erorrMsg"> ${msg} </div>
						</c:if>
						<div class="informationalMsg">
							<span>
								<label class ="star">*</label>
								indicates mandatory field
							</span>
						</div>
						<div class="loginDivs">
							<div>
								<span>
									<label> User name </label>
									<label class="star"> * </label>
								</span>
							</div>
							<div>
								<input type="email" name="user" id="user" placeholder="someemail@company.com" required title="User name is mandatory"/>
							</div>
						</div>
						<div class="loginDivs">
							<div>
								<span>
									<label>Password</label>
									<label class="star"> * </label>
								</span>
							</div>
							<div>
								<input type="password" name="pwd" id="password" placeholder="********" required title="Password is mandatory" />
							</div>
						</div>
						<div class="loginDivs">
							<input type="submit" value="Login" />
							<input type="button" value="Clear" onclick="resetValues()"/>
						</div>
						<div class="loginDivs">
							Do not have an account yet? <a href="RegView.jsp"> Click here to Sign Up</a>
						</div>
					</div>	
				</form>
			</div>
			<div id="footer">
				<%@include file="footer.jsp" %>
			</div>
		</div>
	</body>
</html>