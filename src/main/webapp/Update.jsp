<%@ page import="com.Expanses"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    Integer id = (Integer) session.getAttribute("eid");
    Expanses expe = (Expanses) session.getAttribute("expanse");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Expense</title>
<style>
body {
	background-color: #f4f6f8;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
}

.card {
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 400px;
	padding: 30px;
	box-sizing: border-box;
}

.card h2 {
	margin: 0 0 20px;
	color: #333333;
	font-size: 1.5rem;
	text-align: center;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 8px;
	font-weight: 600;
	color: #555555;
}

.form-group input[type="text"], .form-group input[type="number"] {
	width: 100%;
	padding: 10px 12px;
	font-size: 1rem;
	border: 1px solid #cccccc;
	border-radius: 4px;
	box-sizing: border-box;
	transition: border-color 0.2s ease;
}

.form-group input:focus {
	border-color: #007bff;
	outline: none;
}

.actions {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.btn {
	display: inline-block;
	padding: 10px 20px;
	font-size: 1rem;
	font-weight: 600;
	color: white;
	text-decoration: none;
	border-radius: 4px;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-primary {
	background-color: #007bff;
}

.btn-primary:hover {
	background-color: #0056b3;
}

.btn-secondary {
	background-color: #6c757d;
}

.btn-secondary:hover {
	background-color: #5a6268;
}
</style>
</head>
<body>
	<div class="card">
		<h2>Update Expense</h2>
		<form action="update" method="post">
			<input type="hidden" name="eid" value="<%= id %>">

			<div class="form-group">
				<label for="desc">Description</label> <input type="text" id="desc"
					name="desc" value="<%= expe.getDescription() %>" required>
			</div>

			<div class="form-group">
				<label for="amount">Amount (₹)</label> <input type="number"
					id="amount" name="amount" value="<%= expe.getAmount() %>" min="0"
					step="0.01" required>
			</div>

			<div class="actions">
				<button type="submit" class="btn btn-primary">Update</button>
				<a href="home" class="btn btn-secondary">Cancel</a>
			</div>
		</form>
	</div>
</body>
</html>
