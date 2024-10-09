package fr.but3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Verif")
public class Verif extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String origine = req.getParameter("origine");

        if (login.equals(password)) {
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