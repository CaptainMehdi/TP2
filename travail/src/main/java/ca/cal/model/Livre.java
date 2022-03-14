package ca.cal.model;

import jdk.jfr.Enabled;
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
public class Livre extends Document{
    private int nbrPage;
    private LocalDate empruntDoc;
    private LocalDate dateRetour;

    public Livre (String titre, String auteur, String editeur, LocalDate anneePub,
               String genre, String type,int nbrPage, LocalDate emprunt){
        super(titre,auteur,editeur,anneePub,genre,type);
        this.nbrPage = nbrPage;
        this.empruntDoc = emprunt;
        setDateRetour(emprunt);
    }

    public void setDateRetour(LocalDate emprunt) {
        this.dateRetour = emprunt.plusDays(21);
    }
}
