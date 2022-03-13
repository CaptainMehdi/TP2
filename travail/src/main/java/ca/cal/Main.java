package ca.cal;

import ca.cal.model.Client;
import ca.cal.model.Emprunt;
import ca.cal.persistence.EmpruntDaoJpaH2;
import ca.cal.service.EmpruntService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EmpruntService empruntService = new EmpruntService(new EmpruntDaoJpaH2());

        var empruntId = empruntService.createEmprunt();
        System.out.println(empruntId);
        var clientId = empruntService.createClient("toto","fr");

        LocalDate date = LocalDate.now();
        var docId1 =empruntService.createDocument("ttrrrout","gerald","poner",date, 30,"hip","livre");

//        empruntService.addProfToCours(profId, coursId);
//        final Client client = empruntService.getClientAvecCours(clientId);
//        System.out.println(client);

        final Emprunt emprunt = empruntService.getEmprunt(empruntId);
        System.out.println(emprunt);

//        empruntService.addEtudiantToCours(etudiant1Id, coursId);
//        empruntService.addEtudiantToCours(etudiant2Id, coursId);


    }
}
