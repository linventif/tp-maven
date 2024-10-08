<%@ page import="fr.but3.Cpt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // Récupérer ou initialiser le compteur de session
    Cpt sessionCounter = (Cpt) session.getAttribute("sessionCounter");
    if (sessionCounter == null) {
        sessionCounter = new Cpt();
        session.setAttribute("sessionCounter", sessionCounter);
    }
    sessionCounter.incr();

    // Récupérer ou initialiser le compteur d'application
    Cpt appCounter = (Cpt) application.getAttribute("appCounter");
    if (appCounter == null) {
        appCounter = new Cpt();
        application.setAttribute("appCounter", appCounter);
    }
    appCounter.incr();
%>
<html>
<body>
<h2>Vous avez accédé <%= sessionCounter.intValue() %> fois à cette page sur les <%= appCounter.intValue() %> au
    total</h2>
</body>
</html>