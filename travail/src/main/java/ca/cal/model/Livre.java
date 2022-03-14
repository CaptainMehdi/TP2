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
    private LocalDate dateRetour;

    public Livre (String titre, String auteur, String editeur, LocalDate anneePub,
               String genre, String type,int nbrPage){
        super(titre,auteur,editeur,anneePub,genre,type);

        this.nbrPage = nbrPage;
    }

}
