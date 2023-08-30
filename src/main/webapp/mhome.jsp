<%@ page import="java.util.List" %>
<%@ page import="com.example.tasks.manager.UserManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager home</title>
</head>
<body>
<div class="task-form">
    <form method="post" action="AddNewTaskServlet">
        <h1>Create a new task</h1>
        <div class="content">
            <div class="input-field">
                <label>
                    <input type="text" name="taskName" placeholder="Name">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <input type="text" name="description" placeholder="Description">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <select name="selectedUser">
                        <option disabled selected>Select user</option>
                        <%
                            UserManager userManager = new UserManager();
                            List<String> users = userManager.getAllEmployees();
                            for (String user : users) {
                        %>
                        <option value="<%= user %>"><%= user %></option>
                        <%
                            }
                        %>
                    </select>
                </label>
            </div>
            <div class="input-field">
                <label>
                    <select name="status">
                        <option disabled selected>Select status</option>
                        <option value="TODO">TODO</option>
                        <option value="IN_PROGRESS">In Progress</option>
                        <option value="FINISHED">Finished</option>
                    </select>
                </label>
            </div>
            <div class="input-field">
                <label>
                    <input type="text" name="deadline" placeholder="Deadline (yyyy-mm-dd)">
                </label>
            </div>
        </div>
        <div class="action">
            <button>Create</button>
        </div>
    </form>
</div>

<div class="button-container">
    <form method="get" action="/manager_actions/allUsers.jsp">
        <button>Show All Users</button>
    </form>

    <form method="get" action="/manager_actions/allTasks.jsp">
        <button>Show All Tasks</button>
    </form>
</div>


</body>
</html>
