package tp502;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class MonFiltre extends HttpFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        // Log the request
        System.out.println("[GLOBAL FILTER] Request received: " + req.getRequestURI());
        // actions à réaliser avant exec de la requête
        chain.doFilter(req, res);
        // actions à réaliser après exec de la requête
    }
}