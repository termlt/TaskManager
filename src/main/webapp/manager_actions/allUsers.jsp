<%@ page import="com.example.tasks.manager.UserManager" %>
<%@ page import="com.example.tasks.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<table border="1">
    <tr>
        <th style="background-color: #ccc; text-align: center;">Name</th>
        <th style="background-color: #ccc; text-align: center;">Surname</th>
        <th style="background-color: #ccc; text-align: center;">Email</th>
        <th style="background-color: #ccc; text-align: center;">Role</th>
    </tr>
    <%
        UserManager userManager = new UserManager();
        List<User> users = userManager.getAllUsers();
        for(User user : users) {
    %>
    <tr>
        <td><%= user.getName() %></td>
        <td><%= user.getSurname() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getRole() %></td>
        <%
            }
        %>
    </tr>
</body>
</html>
