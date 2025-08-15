<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Expense</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #ece9e6, #ffffff);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        width: 350px;
        text-align: center;
        animation: fadeIn 0.6s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-10px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h1 {
        font-size: 1.4rem;
        margin-bottom: 20px;
        color: #333;
    }

    label {
        display: block;
        text-align: left;
        margin: 12px 0 6px;
        font-weight: bold;
        color: #555;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
        transition: border-color 0.3s;
    }

    input[type="text"]:focus {
        border-color: #4CAF50;
        outline: none;
    }

    button {
        margin-top: 18px;
        width: 100%;
        padding: 12px;
        background: #4CAF50;
        color: white;
        font-size: 16px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        transition: background 0.3s ease;
    }

    button:hover {
        background: #45a049;
    }
</style>
</head>
<body>
    <div class="container">
        <%
            int id = (int) session.getAttribute("id");
        %>
        <h1>Add New Expanse</h1>

        <form action="newexpanse" method="post">
            <input type="hidden" id="userid" value="<%= id %>" name="userid">
            
            <label for="desc">Description</label>
            <input id="desc" type="text" name="desc" required>

            <label for="amount">Amount</label>
            <input id="amount" type="text" name="amount" required>

            <button type="submit">Add</button>
        </form>
    </div>
</body>
</html>