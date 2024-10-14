package fr.but3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Verif")
public class Verif extends HttpServlet {
    private boolean isValidCredentials(String login, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connexion Effective !");

            String query = "SELECT * FROM public.utilisateurs WHERE login = ? AND mdp = MD5(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connexion Impossible");
            return false;
        }
    }

    private void updateDataBaseInfo(String login, String ip) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connexion Effective !");

            String query = "UPDATE public.utilisateurs SET ip = ?, dat = NOW() WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ip);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connexion Impossible");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String origine = req.getParameter("origine");

        if (isValidCredentials(login, password)) {
            updateDataBaseInfo(login, req.getRemoteAddr());
            req.getSession().setAttribute("token", "TODO");
            req.getSession().setAttribute("login", login);

            if (origine != null) {
                res.sendRedirect(origine);
                return;
            }

            res.sendRedirect("/tp504/private/page1.jsp");
            return;
        }

        req.setAttribute("errorMessage", "Login failed. Please try again.");
        req.getRequestDispatcher("/private/login.jsp").forward(req, res);
    }
}