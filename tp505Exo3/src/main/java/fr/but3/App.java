package fr.but3;

import fr.but3.model.Auteur;
import fr.but3.model.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Livre livre = em.find(Livre.class, (long) 1);
        System.out.println(livre);

        Auteur auteur = em.find(Auteur.class, (long) 1);
        System.out.println(auteur);

        for (Livre l : auteur.getLivres()) {
            System.out.println(l);
        }

        em.close();
        emf.close();
    }
}
