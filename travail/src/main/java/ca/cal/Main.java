package ca.cal;

import ca.cal.model.Cd;
import ca.cal.model.Client;
import ca.cal.model.Document;
import ca.cal.model.Emprunt;
import ca.cal.persistence.EmpruntDaoJpaH2;
import ca.cal.service.Service;
import org.w3c.dom.CDATASection;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service(new EmpruntDaoJpaH2());

        var empruntId = service.createEmprunt("gros");
        System.out.println(empruntId);
        var clientId = service.createClient("toto","fr");

        LocalDate date = LocalDate.now().plusDays(1);
        LocalDate date2 = LocalDate.now().plusDays(8);

        var doc1 = service.createLivre("ttrrrout","gerald","poner",date, 30,"hip","livre");
        var doc2 = service.createCd("pour","toto","oder",date,"action","cd",20);

        Document document1 = service.getDocument(doc1);
        System.out.println(document1);
        service.addDocumentToEmprunt(doc1,empruntId);

        Document document2 = service.getDocument(doc2);
        System.out.println(document2);
        service.addDocumentToEmprunt(doc2,empruntId);

        Emprunt emprunt = service.getEmprunt(empruntId);
        System.out.println(emprunt);

        Client client = service.getClient(clientId);

        System.out.println(service.getDocumentByTitle("tt"));


    }
}
