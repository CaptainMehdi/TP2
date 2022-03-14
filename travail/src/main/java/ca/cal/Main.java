package ca.cal;

import ca.cal.model.*;
import ca.cal.persistence.EmpruntDaoJpaH2;
import ca.cal.service.Service;
import org.w3c.dom.CDATASection;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employe employe = new Employe("Resc","Javier","Javatown");
        Service service = employe.getService();

        var empruntId = service.createEmprunt("gros");
        System.out.println(empruntId);
        var clientId = service.createClient("toto","fr");

        LocalDate date = LocalDate.now().plusDays(1);
        LocalDate date2 = LocalDate.now().plusDays(8);
        LocalDate date3 = LocalDate.now();

        var doc1 = service.createLivre("ttrrrout","gerald","poner",date, 30,"hip","livre",date3);
        var doc2 = service.createCd("pour","toto","oder",date,"action","cd",20,date3);

        Document document1 = service.getDocument(doc1);
        System.out.println(document1);
        service.addDocumentToEmprunt(doc1,empruntId);

        Document document2 = service.getDocument(doc2);
        System.out.println(document2);
        service.addDocumentToEmprunt(doc2,empruntId);

        Emprunt emprunt = service.getEmprunt(empruntId);

        Client client = service.getClient(clientId);


        service.addEmpruntToClient(clientId,empruntId);

        System.out.println(emprunt);
       // System.out.println(client);

//        System.out.println(service.getDocumentByTitle("tt"));


    }
}
