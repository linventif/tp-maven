package fr.but3;

import fr.but3.dao.AuteurDAO;
import fr.but3.model.Auteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/lister")
public class ListerServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            AuteurDAO auteurDAO = new AuteurDAO(em);

            List<Auteur> auteurs = auteurDAO.getAllAuteurs();
            request.setAttribute("auteurs", auteurs);

            request.getRequestDispatcher("/lister.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error accessing data", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
