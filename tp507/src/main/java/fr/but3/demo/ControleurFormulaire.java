package fr.but3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControleurFormulaire {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/etudiants")
    public List<Etudiant> afficherFormulaire() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @PostMapping("/etudiants")
    public String ajouterEtudiant(@RequestBody Etudiant etudiant, BindingResult result) {
        if (result.hasErrors()) {
            return "Erreur de validation: " + result.getAllErrors();
        }
        etudiantRepository.save(etudiant);
        return "Etudiant ajouté avec succès";
    }
}