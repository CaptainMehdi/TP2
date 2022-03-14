package ca.cal.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;

    private String prenom;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @OneToOne
    Emprunt emprunt;

    public void addEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
        emprunt.setClient(this);
    }

    public void getListeEmprunt(){
        System.out.println(emprunt.getDocumentList());
    }
    public void getDateDeRetour(){
        System.out.println();
    }
}
