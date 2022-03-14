package ca.cal.model;

import ca.cal.persistence.EmpruntDaoJpaH2;
import ca.cal.service.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Employe extends Person {

    private String bibliotheque;
    private Service service = new Service(new EmpruntDaoJpaH2());

    public Employe(String nom, String prenom,String bibliotheque) {
        super(nom,prenom);
        this.bibliotheque = bibliotheque;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public Service getService() {
        return service;
    }

}
