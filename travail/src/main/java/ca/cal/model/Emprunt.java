package ca.cal.model;

import lombok.*;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "emprunt",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Document> documentList = new ArrayList<>();

    @OneToOne(mappedBy = "emprunt",cascade = CascadeType.ALL)
    private Client client;


    public void addDocument(Document document) {
        documentList.add(document);
        document.setEmprunt(this);
    }

    public void addClient(Client client){
        client.setEmprunt(this);
    }
}
