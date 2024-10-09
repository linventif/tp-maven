package fr.but3;

import jakarta.servlet.annotation.WebFilter;

@WebFilter("/private/*")
public class MyAuthentFilter extends jakarta.servlet.http.HttpFilter {
    public void doFilter(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse res, jakarta.servlet.FilterChain chain)
            throws java.io.IOException, jakarta.servlet.ServletException {
        String token = (String) req.getSession().getAttribute("token");

        if (token != null) {
            chain.doFilter(req, res);
            return;
        }

        req.setAttribute("origine", req.getRequestURI());
        req.getRequestDispatcher("/private/login.jsp").forward(req, res);
    }
}