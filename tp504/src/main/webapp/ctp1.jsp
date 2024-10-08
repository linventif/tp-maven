<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // Déclaration des variables de session et d'application
    // Récupérer ou initialiser le compteur de session
    AtomicInteger sessionCounter = (AtomicInteger) session.getAttribute("sessionCounter");
    if (sessionCounter == null) {
        sessionCounter = new AtomicInteger(0);
        session.setAttribute("sessionCounter", sessionCounter);
    }
    sessionCounter.incrementAndGet();

    // Récupérer ou initialiser le compteur d'application
    AtomicInteger appCounter = (AtomicInteger) application.getAttribute("appCounter");
    if (appCounter == null) {
        appCounter = new AtomicInteger(0);
        application.setAttribute("appCounter", appCounter);
    }
    appCounter.incrementAndGet();
%>
<html>
<body>
<h2>Vous avez accédé <%= sessionCounter.get() %> fois à cette page sur les <%= appCounter.get() %> au total</h2>
</body>
</html>