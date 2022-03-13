package ca.cal.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
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
    private int nbrPage;
    private String genre;
    private String type;

    @ManyToOne
    @ToString.Exclude
    private Emprunt emprunt;

}
