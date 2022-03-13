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
    public long createEmprunt(String name) {
        final Emprunt emprunt = Emprunt.builder().name(name).build();
        save(emprunt);
        return emprunt.getId();
    }

    @Override
    public long createDocument(String titre, String auteur, String editeur, LocalDate anneePub, int nbrPage, String genre, String type) {
        Document document = Document.builder()
                .titre(titre)
                .auteur(auteur)
                .editeur(editeur)
                .anneePub(anneePub)
                .nbrPage(nbrPage)
                .genre(genre)
                .type(type)
                .build();
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

        Client client = em.find(Client.class,clientId);

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

        Emprunt emprunt = em.find(Emprunt.class,empruntId);

        em.getTransaction().commit();
        em.close();
        return emprunt;
    }

    @Override
    public Document getDocument(long docId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Document document = em.find(Document.class,docId);

        em.getTransaction().commit();
        em.close();
        return document;
    }
}