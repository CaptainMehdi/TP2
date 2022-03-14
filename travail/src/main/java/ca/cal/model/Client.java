package ca.cal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person {

    public Client(String nom, String prenom) {
       super(nom,prenom);
    }

    @OneToOne
    @ToString.Include
    public Emprunt emprunt;

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public List<Document> getListEmprunt(){
        return emprunt.getDocumentList();
    }

}
