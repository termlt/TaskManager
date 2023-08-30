<%@ page import="com.example.tasks.manager.TaskManager" %>
<%@ page import="com.example.tasks.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>All Tasks</title>
</head>
<body>
<table border="1">
  <tr>
    <th style="background-color: #ccc; text-align: center;">Name</th>
    <th style="background-color: #ccc; text-align: center;">Description</th>
    <th style="background-color: #ccc; text-align: center;">Status</th>
    <th style="background-color: #ccc; text-align: center;">Deadline</th>
  </tr>
    <%
        TaskManager taskManager = new TaskManager();
        List<Task> tasks = taskManager.getAllTasks();
        for(Task task : tasks) {
    %>
  <tr>
    <td><%= task.getName() %></td>
    <td><%= task.getDescription() %></td>
    <td><%= task.getStatus() %></td>
    <td><%= task.getDeadline() %></td>
    <%
      }
    %>
  </tr>
</body>
</html>
