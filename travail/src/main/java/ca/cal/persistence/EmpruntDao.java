package ca.cal.persistence;

import ca.cal.model.Client;
import ca.cal.model.Document;
import ca.cal.model.Emprunt;

import java.time.LocalDate;

public interface EmpruntDao {
    <T> void save(T t);
    <T> void merge(T t);

    long createEmprunt(String name);

    long createLivre(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type);

    long createCd(String titre, String auteur, String editeur, LocalDate anneePub, String genre, String type,int duree);

    long createDvd(String titre, String auteur, String editeur, LocalDate anneePub, String genre, String type,int duree);
    long createClient(String nom, String prenom);

    Client getClient(long profId);

    Emprunt getEmprunt(long coursId);

    Document getDocument(long docId);

    Document getDocumentByTitle(String title);
}
