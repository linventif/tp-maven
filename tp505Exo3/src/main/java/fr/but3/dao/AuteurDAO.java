package fr.but3.dao;

import fr.but3.model.Auteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.sql.ResultSet;
import java.util.List;

public class AuteurDAO {
    private final EntityManager entityManager;

    public AuteurDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Auteur> getAllAuteurs() {
        String jpql = "SELECT a FROM Auteur a";
        TypedQuery<Auteur> query = entityManager.createQuery(jpql, Auteur.class);
        List<Auteur> auteurs = query.getResultList();
        for (Auteur auteur : auteurs) {
            System.out.println(auteur);
        }
        return auteurs;
    }
}
