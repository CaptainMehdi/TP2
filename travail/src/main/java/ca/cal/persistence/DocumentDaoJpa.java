package ca.cal.persistence;

import ca.cal.model.Document;

import java.util.List;

public interface DocumentDaoJpa {
    void createDocument(Document document);
    List<Document> findDocument(String nomDoc);
}
