package ca.cal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "emprunt",fetch = FetchType.EAGER)
    private List<Document> documentList = new ArrayList<>();

    @OneToOne(mappedBy = "empruntClient")
    private Client client;


    public void addDocument(Document document) {
        documentList.add(document);
        document.setEmprunt(this);
    }

    public List<Document> getDocumentList() {
        return documentList;
    }
}
