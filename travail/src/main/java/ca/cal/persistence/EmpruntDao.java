package ca.cal.persistence;

import ca.cal.model.Client;
import ca.cal.model.Emprunt;

import java.time.LocalDate;

public interface EmpruntDao {
    <T> void save(T t);
    <T> void merge(T t);
    long createEmprunt();

    long createDocument(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type);

    long createClient(String nom, String prenom);

    Client getClient(long profId);

    Client getClientAvecCours(long profId);

    Emprunt getEmprunt(long coursId);
}
