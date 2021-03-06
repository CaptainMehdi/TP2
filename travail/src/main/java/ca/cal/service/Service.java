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

  public long createLivre(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type,LocalDate emprunt){
    return dao.createLivre(titre, auteur, editeur, anneePub, nbrPage, genre, type,emprunt);
  }

  public long createDvd(String titre, String auteur, String editeur, LocalDate anneePub, String genre, String type,int duree,LocalDate emprunt){
    return dao.createDvd( titre, auteur, editeur, anneePub, genre, type, duree,emprunt);
  }

  public long createCd(String titre, String auteur, String editeur, LocalDate anneePub, String genre, String type,int duree,LocalDate emprunt){
    return dao.createCd( titre, auteur, editeur, anneePub, genre, type, duree,emprunt);
  }

  public long createClient(String prenom, String nom) {
    return dao.createClient(prenom, nom);
  }

  public void addDocumentToEmprunt(long docId, long empruntId) {
    var document = dao.getDocument(docId);
    var emprunt = dao.getEmprunt(empruntId);
    emprunt.addDocument(document);
    dao.merge(emprunt);
  }

  public void addEmpruntToClient(long clientId, long empruntId) {
    var client = dao.getClient(clientId);
    var emprunt = dao.getEmprunt(empruntId);
    emprunt.addClient(client);
    dao.merge(emprunt);
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


  public Document getDocumentByTitle(String title) {
    return dao.getDocumentByTitle(title);
  }
}
