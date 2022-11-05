package org.pruebaquarkus.service;

import org.pruebaquarkus.model.dto.PersonajeDto;
import org.pruebaquarkus.model.entity.PersonajeEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface IPersonajeService {

    List<PersonajeDto> findAll();
    PersonajeDto save(PersonajeDto personajeDto);
    PersonajeDto update(PersonajeDto personajeDto);
    PersonajeDto findById(int id);
    boolean delete(int id);
}
