<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    form {
        display: flex;
        flex-direction: column;
        width: 200px;
        margin: 0 auto;
    }

    label {
        margin-top: 10px;
    }

    input {
        margin-bottom: 10px;
    }

    .error {
        color: red;
        text-align: center;
    }
</style>
<body>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
<div class="error"><%= errorMessage %>
</div>
<% } %>
<form action="/tp504/Verif" method="post">
    <label for="login">Login</label>
    <input type="text" id="login" name="login" required>
    <label for="password">Password</label>
    <input type="password" id="password" name="password" required>
    <input type="submit" value="Submit">
</form>
</body>
</html>