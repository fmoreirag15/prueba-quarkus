package org.pruebaquarkus.service.impl;

import io.quarkus.runtime.logging.ConsoleConfig$$accessor;
import lombok.RequiredArgsConstructor;
import org.pruebaquarkus.mapper.IPesonajeMapper;
import org.pruebaquarkus.model.dto.PersonajeDto;
import org.pruebaquarkus.repository.PersonajeRepository;
import org.pruebaquarkus.service.IPersonajeService;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static io.smallrye.config.ConfigLogging.log;

@ApplicationScoped
@RequiredArgsConstructor
public class PersonajeServiceImpl implements IPersonajeService {
    private  final PersonajeRepository repository;
    private final IPesonajeMapper mapper;
    @Override
    public List<PersonajeDto> findAll() {
        return  repository.listAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonajeDto save(PersonajeDto personajeDto) {
        log.info(mapper.toEntity(personajeDto));
        repository.persist(mapper.toEntity(personajeDto));
        return personajeDto;
    }

    @Override
    public PersonajeDto findById(int id) {
        return mapper.toDto(repository.findById(id));
    }
}
