<%@page import="com.Expanses"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Dashboard</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 20px;
        text-align: center;
    }

    h1 {
        color: #333;
        margin-bottom: 30px;
    }

    .btn {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    .btn:hover {
        background-color: #0056b3;
    }

    table {
        margin: 0 auto;
        border-collapse: collapse;
        width: 80%;
        background-color: white;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    th, td {
        padding: 12px 15px;
        border: 1px solid #ddd;
        text-align: center;
    }

    th {
        background-color: #007bff;
        color: white;
    }

    td a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    td a:hover {
        text-decoration: underline;
    }

    .action-links {
        display: flex;
        justify-content: center;
        gap: 10px;
    }
</style>
</head>
<body>
<h1>Welcome <%= request.getAttribute("name") %></h1>
<% int id = (int)session.getAttribute("id");
session.setAttribute("id", id);%>

<a href="AddNewExpanse.jsp?id=<%=id %>" class="btn">➕ Add Expense</a>
<a href="index.html" class="btn">Logout</a>

<br><br>

<% List<Expanses> expanses = (List<Expanses>) request.getAttribute("expanses"); %>
<table>
    <tr>
        <th>Expense ID</th>
        <th>Amount</th>
        <th>Description</th>
        <th>Spent On</th>
        <th colspan="2">Actions</th>
    </tr>
    <% for(Expanses e : expanses) { %>
    <tr>
        <td><%= e.getExpanseId() %></td>
        <td>₹<%= e.getAmount() %></td>
        <td><%= e.getDescription() %></td>
        <td><%= e.getSpenton() %></td>
        <td><a href="getExpanse?expid=<%=e.getExpanseId()%>">✏️ Update</a></td>
        <td><a href="delete?expid=<%=e.getExpanseId()%>">🗑️ Delete</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
