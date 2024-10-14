<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="fr.but3.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<style>
    .center {
        text-align: center;
    }
</style>
<body>
<div class="center">
    <h2>Page secret 1 ✨</h2>
    <%
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connexion Effective !");

            String query = "SELECT * FROM public.utilisateurs WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, (String) request.getSession().getAttribute("login"));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                out.println("<h3>Bonjour Mr " + resultSet.getString("login") +
                        ", votre dernière connexion date de " + resultSet.getString("dat") +
                        " de la machine " +
                        resultSet.getString("ip") + "</h3>");
            } else {
                out.println("<h3>Erreur de connexion</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connexion Impossible");
        }
    %>
</div>
</body>
</html>