
<!DOCTYPE html>
<html >
<head>
<title>Login</title>
</head>
<body>
	<div class="container">
		
		<div class="content">
			<p th:if="${param.logout}" class="alert">You have been logged out</p>
			<p th:if="${param.error}" class="alert alert-error">There was an error, please try again</p>
			<h2>Login with Username and Password</h2>
			<form name="form" action="/login" method="POST">
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
				<fieldset>
					<input type="text" name="username" value="" placeholder="Username" />
					<input type="password" name="password" placeholder="Password" />
				</fieldset>
				<input type="submit" id="login" value="Login"
					class="btn btn-primary" />
			</form>
		</div>


	</div>
</body>
</html>