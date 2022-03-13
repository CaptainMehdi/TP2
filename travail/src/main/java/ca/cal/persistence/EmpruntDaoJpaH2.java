package ca.cal.persistence;

import ca.cal.model.Client;
import ca.cal.model.Document;
import ca.cal.model.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class EmpruntDaoJpaH2 implements EmpruntDao{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public <T> void merge(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createEmprunt() {
        final Emprunt emprunt = new Emprunt();
        save(emprunt);
        return emprunt.getId();
    }

    @Override
    public long createDocument(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type) {
        final Document document = new Document(titre,auteur,editeur,anneePub,nbrPage,genre,type);
        save(document);
        return document.getId();
    }

    @Override
    public long createClient(String nom, String prenom) {
        final Client client = new Client(nom,prenom);
        save(client);
        return client.getId();
    }

    @Override
    public Client getClient(long clientId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Client client = em.find(Client.class,clientId);

        em.getTransaction().commit();
        em.close();
        return client;
    }

    @Override
    public Client getClientAvecCours(long profId) {
        return null;
    }

    @Override
    public Emprunt getEmprunt(long empruntId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Emprunt emprunt = em.find(Emprunt.class,empruntId);

        em.getTransaction().commit();
        em.close();
        return emprunt;
    }
}
