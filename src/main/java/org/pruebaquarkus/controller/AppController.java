package org.pruebaquarkus.controller;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.pruebaquarkus.business.IPersonajeBusiness;
import org.pruebaquarkus.mapper.IPesonajeMapper;
import org.pruebaquarkus.model.dto.ErrorResponse;
import org.pruebaquarkus.model.entity.PersonajeEntity;
import org.pruebaquarkus.service.IPersonajeService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
@RequiredArgsConstructor
public class AppController {

    private final IPersonajeBusiness iPersonajeBusiness;
    private final  IPersonajeService iPersonajeService;

    private final IPesonajeMapper mapper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok().entity(iPersonajeService.findAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(PersonajeEntity personajeEntity) {
        iPersonajeService.save(mapper.toDto(personajeEntity));
        return Response.ok().entity(iPersonajeService.findAll()).build();
    }

    @GET
    @Path("/characters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getPersonajeById(@PathParam("id") Integer id) {
        try
        {
            return Response.ok().entity(  iPersonajeBusiness.findById(id)).build();
        }catch (Exception  e){
            return  Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }


    }
    @GET
    @Path("/characters/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllPersonaje() {
        try
        {
            return Response.ok().entity(  iPersonajeBusiness.findAll()).build();
        }catch (Exception  e){
            return  Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }


    }


}