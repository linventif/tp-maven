package tp502;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Compteur")
public class Compteur extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        // Local counter session
        Integer localCount = (Integer) req.getSession().getAttribute("compteur");
        if (localCount == null) {
            localCount = 0;
        }
        localCount++;
        req.getSession().setAttribute("compteur", localCount);

        // Global counter application
        Integer globalCount = (Integer) getServletContext().getAttribute("compteur");
        if (globalCount == null) {
            globalCount = 0;
        }
        globalCount++;
        getServletContext().setAttribute("compteur", globalCount);

        // Store counters in request attributes
        req.setAttribute("localCount", localCount);
        req.setAttribute("globalCount", globalCount);

        out.println("<head><title>servet compteur</title>");
        out.println("<META content=\"charset=UTF-8\"></head><body><center>");
        out.println("<h3>Nombre de visites locales : " + localCount + "</h3>");
        out.println("<h3>Nombre de visites globales : " + globalCount + "</h3>");
        out.println("</center> </body>");
    }

    public static int[] getCounters(HttpServletRequest req) {
        Integer localCount = (Integer) req.getSession().getAttribute("compteur");
        if (localCount == null) {
            localCount = 0;
        }

        Integer globalCount = (Integer) req.getServletContext().getAttribute("compteur");
        if (globalCount == null) {
            globalCount = 0;
        }

        return new int[]{localCount, globalCount};
    }
}