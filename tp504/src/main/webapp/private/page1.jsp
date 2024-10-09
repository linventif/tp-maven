<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<style>
    .center {
        text-align: center;
    }
</style>
<body>
<div class="center">
    <h2>Page secret 1 ✨</h2>
    <h2>Bienvenue <%= request.getSession().getAttribute("login") %>
    </h2>
</div>
</body>
</html>