package fr.but3;

import fr.but3.model.Auteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Auteur auteur = new Auteur();
        auteur.setId(1L);
        auteur.setNom("Doe");
        auteur.setPrenom("John");
        auteur.setEmail("john@does.com");
        System.out.println(auteur);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(auteur);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }
}
