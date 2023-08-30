<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<h1><%= "Please login" %>
</h1>
<div class="login-form">
    <form method="post" action="LoginServlet">
        <div class="content">
            <div class="input-field">
                <label>
                    <input type="email" name="email" placeholder="Email">
                </label>
            </div>
            <div class="input-field">
                <label>
                    <input type="password" name="password" placeholder="Password">
                </label>
            </div>
        </div>
        <div class="action">
            <button>Sign in</button>
        </div>
    </form>
</div>
</body>
</html>