package ca.cal.service;

import ca.cal.model.Client;
import ca.cal.model.Document;
import ca.cal.persistence.ClientDAO;
import ca.cal.persistence.DocumentDao;

import java.util.List;

public class AdminService {
    private ClientDAO clientDao;
    private DocumentDao documentDao;

    public AdminService(ClientDAO clientDao, DocumentDao documentDao){
        this.clientDao = clientDao;
        this.documentDao = documentDao;
    }
    public void createClient(String nameCLient) {
       Client client = Client.builder().name(nameCLient).build();
       clientDao.save(client);
    }

    public List<Client> findClient(String nameClient){
        return clientDao.findClient(nameClient);
    }

    public void createDocument(String nomDoc) {
        Document doc = Document.builder().name(nomDoc).build();
        documentDao.createDocument(doc);
    }

    public List<Document> findDocument(String nomDoc) {
        return documentDao.findDocument(nomDoc);
    }
}
