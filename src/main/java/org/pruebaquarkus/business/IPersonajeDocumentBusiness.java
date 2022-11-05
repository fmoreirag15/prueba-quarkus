package org.pruebaquarkus.business;

import org.pruebaquarkus.model.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeDocumentBusiness {
    List<PersonajeDto> findAll();

    PersonajeDto findById(Integer id) throws Exception;
    PersonajeDto save(PersonajeDto personajeDto);
    PersonajeDto update(PersonajeDto personajeDto, Integer id);

}
