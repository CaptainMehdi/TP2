package ca.cal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Cd extends Document{

    private LocalDate dateRetour;
    private int duree;
    private LocalDate empruntDoc;

    public Cd (String titre, String auteur, String editeur, LocalDate anneePub,
               String genre, String type,int duree, LocalDate emprunt){
        super(titre,auteur,editeur,anneePub,genre,type);
        this.duree = duree;
        this.empruntDoc = emprunt;
        setDateRetour(emprunt);
    }

    public void setDateRetour(LocalDate emprunt) {
        this.dateRetour = emprunt.plusDays(14) ;
    }
}
