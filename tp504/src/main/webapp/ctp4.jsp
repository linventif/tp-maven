<%@ page import="fr.but3.Cpt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<jsp:useBean id="sessionCounter" scope="session" class="fr.but3.Cpt"/>
<jsp:useBean id="appCounter" scope="application" class="fr.but3.Cpt"/>
<%
    if (sessionCounter == null) {
        sessionCounter = new Cpt();
        session.setAttribute("sessionCounter", sessionCounter);
    }
    sessionCounter.incr();

    if (appCounter == null) {
        appCounter = new Cpt();
        application.setAttribute("appCounter", appCounter);
    }
    appCounter.incr();
%>
<html>
<body>
<h2>Vous avez accédé ${sessionCounter.intValue()} fois à cette page sur les ${appCounter.intValue()} au total</h2>
</body>
</html>