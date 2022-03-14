package ca.cal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;

@Entity
@Data
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String titre;
    private String auteur;
    private String editeur;
    private LocalDate anneePub;
    private String genre;
    private String type;

    @ManyToOne
    @ToString.Exclude
    private Emprunt emprunt;

    public Document(String titre, String auteur, String editeur, LocalDate anneePub, String genre, String type) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePub = anneePub;
        this.genre = genre;
        this.type = type;
    }
}
