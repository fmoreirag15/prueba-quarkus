package org.pruebaquarkus.business.Impl;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.pruebaquarkus.business.IPersonajeBusiness;
import org.pruebaquarkus.business.IPersonajeDocumentBusiness;
import org.pruebaquarkus.mapper.IPesonajeMapper;
import org.pruebaquarkus.model.dto.PersonajeDto;
import org.pruebaquarkus.proxy.IPersonajeProxy;
import org.pruebaquarkus.service.IPersonajeDcoumentService;
import org.pruebaquarkus.service.IPersonajeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Named("PersonajeDocumentBusiness")
@ApplicationScoped
public class PersonajeDocumentBusiness  implements IPersonajeDocumentBusiness {

    @Inject
    private IPersonajeDcoumentService personajeService;

    @Inject
    @RestClient
    private IPersonajeProxy iPersonajeProxy;

    @Inject
    private IPesonajeMapper  mapper;
    @Override
    public List<PersonajeDto> findAll() {
        return iPersonajeProxy.getAll()
                .stream().map(mapper::toDtoProxy)
                .collect(Collectors.toList());
    }

    @Override
    public PersonajeDto findById(Integer id) throws Exception {
        PersonajeDto personajeDto= personajeService.findById(id);
        if(personajeDto == null){
            PersonajeDto perdtoProxy = mapper.toDtoProxy(iPersonajeProxy.getById(id));
            if(perdtoProxy != null)
            {
                personajeService.save(perdtoProxy);
                return perdtoProxy;
            }
            throw new Exception("No se encontro personaje con el id => " + id);

        }

        return personajeDto;
    }

    @Override
    public PersonajeDto save(PersonajeDto personajeDto) {
        return null;
    }

    @Override
    public PersonajeDto update(PersonajeDto personajeDto, Integer id) {
        return null;
    }
}
