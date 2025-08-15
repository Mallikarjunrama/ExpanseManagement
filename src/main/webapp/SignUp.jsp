<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User SignUp Form</title>
</head>
<style>
body {
	margin: 0;
	height: 80vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	width: 300px;
            padding: 20px;
            border: 2px solid #333;
            border-radius: 10px;
            background-color: #f9f9f9;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
}
input {
            display: block;
            width: 100%;
            margin: 10px 0;
            padding: 8px;
        }
</style>
<body>
	<div class="container">
	<form action ="signup" method ="post">
		<div>
			<h2 class="signUpFormText">Sign Up Below</h2>
			<label for="username"> <input type="text" id="username" name ="username"
				placeholder="Enter your name" required>
			</label>
		</div>
		<div>
			<label for="email"> <input type="email" id="email" name ="email"
				placeholder="Enter your email" required>
			</label>
		</div>
		<div>
			<label for="password"> <input type="password" id="password" name ="password"
				placeholder="Enter your password" required>
			</label>
		</div>
		<div>
		<button type="submit">SignUp</button>
		</div>
		<div>
		<p>Existing User <a href="index.html">Login</a></p>
		</div>
		</form>
	</div>
</body>
</html>