<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.but3.model.Auteur" %>
<html>
<head>
    <title>Liste des Auteurs et Livres</title>
</head>
<body>
<h1>Liste des Auteurs et de leurs Livres</h1>

<%-- Récupérer la liste des auteurs passée depuis la servlet --%>
<%
    List<fr.but3.model.Auteur> auteurs = (List<fr.but3.model.Auteur>) request.getAttribute("auteurs");
%>

<table border="1">
    <thead>
        <tr>
            <th>Auteur</th>
            <th>Livres</th>
        </tr>
    </thead>
    <tbody>
    <% if (auteurs != null) { %>
        <% for (fr.but3.model.Auteur auteur : auteurs) { %>
            <tr>
                <td>
                    <%= auteur.getPrenom() %> <%= auteur.getNom() %> (<%= auteur.getEmail() %>)
                </td>
                <td>
                    <ul>
                        <% for (fr.but3.model.Livre livre : auteur.getLivres()) { %>
                            <li><%= livre.getTitre() %></li>
                        <% } %>
                    </ul>
                </td>
            </tr>
        <% } %>
    <% } else { %>
        <tr>
            <td colspan="2">Aucun auteur trouvé.</td>
        </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
