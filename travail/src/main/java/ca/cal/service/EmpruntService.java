package ca.cal.service;

import ca.cal.model.Client;
import ca.cal.model.Emprunt;
import ca.cal.persistence.EmpruntDao;

import java.time.LocalDate;

public class EmpruntService {
  private EmpruntDao dao;

  public EmpruntService(EmpruntDao dao) {
    this.dao = dao;
  }

  public long createEmprunt(){
    return dao.createEmprunt();
  }

  public long createDocument(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type) {
    return dao.createDocument(titre,auteur,editeur,anneePub,nbrPage,genre,type);
  }

  public long createClient(String prenom, String nom) {
    return dao.createClient(prenom, nom);
  }

//  public void addClientToCours(long clientId, long empruntId) {
//    var client = dao.getClientAvecCours(clientId);
//    var emprunt = dao.getEmprunt(empruntId);
//    //prof.addCours(cours);
//    emprunt.setClient(client);
//    dao.merge(client);
//    dao.merge(emprunt);
//  }

  public void addDocumentToCours(long etudiant1Id, long coursId) {
  }

  public String coursToStringEmprunt(long coursId) {
    return "";
  }

  public Client getClient(long profId) {
    return dao.getClient(profId);
  }

  public Client getClientAvecCours(long profId) {
    return dao.getClientAvecCours(profId);
  }

  public Emprunt getEmprunt(long coursId) {
    return dao.getEmprunt(coursId);
  }

}
