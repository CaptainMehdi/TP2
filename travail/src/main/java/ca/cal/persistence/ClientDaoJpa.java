package ca.cal.persistence;

import ca.cal.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDaoJpa implements ClientDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
    @Override
    public void save(Client clientDAO) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(clientDAO);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Client> findClient(String nameClient) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Client> query = em.createQuery("select p from Client p where name like :nameToSearch", Client.class);
        query.setParameter("nameToSearch", "%"+nameClient+"%");
        final List<Client> clients = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return clients;
    }

}
