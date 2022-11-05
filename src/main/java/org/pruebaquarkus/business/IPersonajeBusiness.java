package org.pruebaquarkus.business;

import org.pruebaquarkus.model.dto.PersonajeDto;

import javax.validation.Valid;
import java.util.List;

public interface IPersonajeBusiness {

    List<PersonajeDto> findAll();

    PersonajeDto findById(Integer id);
    PersonajeDto save(PersonajeDto personajeDto);
    PersonajeDto update(PersonajeDto personajeDto, Integer id);

}
