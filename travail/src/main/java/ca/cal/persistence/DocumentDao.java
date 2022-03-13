package ca.cal.persistence;

import ca.cal.model.Client;
import ca.cal.model.Document;

import javax.persistence.*;
import javax.print.Doc;
import java.util.List;

public class DocumentDao implements DocumentDaoJpa {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
    @Override
    public void createDocument(Document document) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(document);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Document> findDocument(String nomDoc) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select p from Document p where name like :nameToSearch", Document.class);
        query.setParameter("nameToSearch", "%"+nomDoc+"%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }


}
