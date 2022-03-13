package ca.cal.persistence;

import ca.cal.model.Client;
import ca.cal.model.Document;

import java.util.List;

public interface ClientDAO {
    void save(Client clientDAO);

    List<Client> findClient(String nameClient);

}
