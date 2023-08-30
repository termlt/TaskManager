<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super Manager Home</title>
</head>
<body>
<div class="register-form">
    <form method="post" action="RegisterNewUserServlet">
        <h1>Register a new user</h1>
        <div class="content">
            <div class="input-field">
                <label>
                    <input type="text" name="name" placeholder="Name" autocomplete="nope">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <input type="text" name="surname" placeholder="Surname" autocomplete="nope">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <input type="email" name="email" placeholder="Email">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <input type="password" name="password" placeholder="Password" autocomplete="new-password">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <select id="newroleuser" name="newUserRole">
                        <option value="employee">Employee</option>
                        <option value="manager">Manager</option>
                    </select>
                </label>
            </div>
        </div>
        <div class="action">
            <button>Register</button>
        </div>
    </form>
</div>
</body>
</html>
