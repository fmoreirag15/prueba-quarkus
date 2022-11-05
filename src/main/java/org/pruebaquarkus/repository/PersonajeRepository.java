package org.pruebaquarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.pruebaquarkus.model.entity.PersonajeEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonajeRepository implements PanacheRepositoryBase<PersonajeEntity,Integer> {
}
