<jsp:useBean id="username" scope="request" type="java.lang.String"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Public</title>
</head>
<body>
<h1>Public</h1>
<p>Welcome, ${username}!</p>
</body>
</html>