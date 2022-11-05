package org.pruebaquarkus.repository.mongo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.pruebaquarkus.model.document.PersonajeDocument;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonajeDocumentRepository implements PanacheMongoRepository<PersonajeDocument> {

    public PersonajeDocument findByIdPersonaje(Integer id){
        return find("id",id).firstResult();
    }
}
