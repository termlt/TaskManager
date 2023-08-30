<%@ page import="com.example.tasks.manager.TaskManager" %>
<%@ page import="com.example.tasks.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tasks.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee home</title>
</head>
<body>
<h1>Your Tasks</h1>
<table border="1">
    <tr>
        <th style="background-color: #ccc; text-align: center;">Name</th>
        <th style="background-color: #ccc; text-align: center;">Description</th>
        <th style="background-color: #ccc; text-align: center;">Status</th>
        <th style="background-color: #ccc; text-align: center;">Deadline</th>
        <th style="background-color: #ccc; text-align: center;">Update Status</th>
    </tr>
    <%
        TaskManager taskManager = new TaskManager();
        User user = (User) session.getAttribute("user");
        List<Task> tasks = taskManager.getUserTasks(user.getId());
        for (Task task : tasks) {

    %>
    <tr>
        <td><%= task.getName() %></td>
        <td><%= task.getDescription() %></td>
        <td><%= task.getStatus() %></td>
        <td><%= task.getDeadline() %></td>
        <td>
            <form action="ChangeTaskStatusServlet" method="post">
                <input type="hidden" name="taskId" value="<%= task.getId() %>">
                <input type="text" name="newStatus" placeholder="New Status">
                <button type="submit">Update</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
