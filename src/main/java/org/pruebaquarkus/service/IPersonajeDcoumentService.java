package org.pruebaquarkus.service;

import org.pruebaquarkus.model.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeDcoumentService {
    List<PersonajeDto> findAll();
    PersonajeDto findById(Integer id);
    PersonajeDto save(PersonajeDto personajeDto);
    PersonajeDto update(PersonajeDto personajeDto , Integer id);
}
