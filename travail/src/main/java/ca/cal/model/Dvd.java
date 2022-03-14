package ca.cal.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class Dvd extends Document{

    private LocalDate dateRetour;
    private int duree;

    public Dvd (String titre, String auteur, String editeur, LocalDate anneePub,
               String genre, String type,int duree){
        super(titre,auteur,editeur,anneePub,genre,type);
        this.duree = duree;
    }

}
