package ca.cal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String titre;
    private String auteur;
    private String editeur;
    private LocalDate anneePub;
    private int nbrPage;
    private String genre;
    private String type;

    @ManyToOne
    private Document document;

    public Document(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePub = anneePub;
        this.nbrPage = nbrPage;
        this.genre = genre;
        this.type = type;
    }

}
