package org.pruebaquarkus.service.impl;

import lombok.RequiredArgsConstructor;
import org.pruebaquarkus.mapper.IPesonajeMapper;
import org.pruebaquarkus.model.dto.PersonajeDto;
import org.pruebaquarkus.repository.mongo.PersonajeDocumentRepository;
import org.pruebaquarkus.service.IPersonajeDcoumentService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonajeDocumentServiceImpl implements IPersonajeDcoumentService {

    private final PersonajeDocumentRepository repository;
    private final IPesonajeMapper mapper;

    @Override
    public List<PersonajeDto> findAll() {
        return repository.listAll().stream()
                .map(mapper::toDtoDocument)
                .collect(Collectors.toList());
    }

    @Override
    public PersonajeDto findById(Integer id) {

        return mapper.toDtoDocument(repository.findByIdPersonaje(id));
    }

    @Override
    public PersonajeDto save(PersonajeDto personajeDto) {
        repository.persist(mapper.toDocument(personajeDto));
        return personajeDto;
    }

    @Override
    public PersonajeDto update(PersonajeDto personajeDto, Integer id) {
        return null;
    }
}
