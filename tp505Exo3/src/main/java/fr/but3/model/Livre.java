package fr.but3.model;

import jakarta.persistence.*;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lno;
//    @Column(length = 6)
    private String categorie;
    private String titre;
//    many to one
    @ManyToOne
    @JoinColumn(name = "ano")
    private Auteur auteur;

    public Long getLno() {
        return lno;
    }

    public void setLno(Long lno) {
        this.lno = lno;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "lno=" + lno +
                ", categorie='" + categorie + '\'' +
                ", titre='" + titre + '\'' +
                ", auteur=" + auteur.toString() +
                '}';
    }
}
