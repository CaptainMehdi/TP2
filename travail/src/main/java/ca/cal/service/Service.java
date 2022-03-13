package ca.cal.service;

import ca.cal.model.Client;
import ca.cal.model.Document;
import ca.cal.model.Emprunt;
import ca.cal.persistence.EmpruntDao;

import java.time.LocalDate;

public class Service {
  private EmpruntDao dao;

  public Service(EmpruntDao dao) {
    this.dao = dao;
  }

  public long createEmprunt(String name){
    return dao.createEmprunt(name);
  }

  public long createDocument(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type) {
    return dao.createDocument(titre,auteur,editeur,anneePub,nbrPage,genre,type);
  }

  public long createClient(String prenom, String nom) {
    return dao.createClient(prenom, nom);
  }

  public void addDocumentToEmprunt(long docId, long empruntId) {
    var document = dao.getDocument(docId);
    var emprunt = dao.getEmprunt(empruntId);
    emprunt.addDocument(document);
    dao.merge(emprunt);
    dao.merge(document);
  }

  public void addEmpruntToClient(long clientId, long empruntId) {

  }

  public Client getClient(long profId) {
    return dao.getClient(profId);
  }

  public Document getDocument(long docId){
    return dao.getDocument(docId);
  }

  public Emprunt getEmprunt(long coursId) {
    return dao.getEmprunt(coursId);
  }


}
