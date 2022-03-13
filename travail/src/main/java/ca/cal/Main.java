package ca.cal;

import ca.cal.model.Document;
import ca.cal.model.Emprunt;
import ca.cal.persistence.EmpruntDaoJpaH2;
import ca.cal.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service(new EmpruntDaoJpaH2());

        var empruntId = service.createEmprunt("gros");
        System.out.println(empruntId);
        var clientId = service.createClient("toto","fr");

        LocalDate date = LocalDate.now();
        LocalDate date2 = LocalDate.now().plusDays(8);

        var doc1 = service.createDocument("ttrrrout","gerald","poner",date, 30,"hip","livre");
        var doc2 = service.createDocument("lopipo","erve","matou",date2, 60,"lop","scolaire");

        final Document document1 = service.getDocument(doc1);
        System.out.println(document1);
        service.addDocumentToEmprunt(doc1,empruntId);
//        empruntService.addProfToCours(profId, coursId);
//        final Client client = empruntService.getClientAvecCours(clientId);
//        System.out.println(client);

        final Emprunt emprunt = service.getEmprunt(empruntId);
        System.out.println(emprunt);



        //service.addEmpruntToClient(clientId,empruntId);

//        empruntService.addEtudiantToCours(etudiant1Id, coursId);
//        empruntService.addEtudiantToCours(etudiant2Id, coursId);


    }
}
