package org.pruebaquarkus.controller;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.pruebaquarkus.business.IPersonajeBusiness;
import org.pruebaquarkus.mapper.IPesonajeMapper;
import org.pruebaquarkus.model.dto.ErrorResponse;
import org.pruebaquarkus.model.dto.PersonajeDto;
import org.pruebaquarkus.model.entity.PersonajeEntity;
import org.pruebaquarkus.service.IPersonajeService;

import javax.annotation.security.RolesAllowed;
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

    //SECCIÓN DE SERVICE
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllPersonajesEntity() {

        return Response.ok().entity(iPersonajeService.findAll()).build();
    }
    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getByIdPersonajesEntity(@PathParam("id") int id) {
        try
        {
           return Response.ok().entity(  iPersonajeService.findById(id)).build();
        }catch (Exception  e){
            return  Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(@Valid PersonajeEntity personajeEntity) {
        iPersonajeService.save(mapper.toDto(personajeEntity));
        return Response.ok().entity(iPersonajeService.findAll()).build();
    }
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@Valid PersonajeEntity personajeEntity) {
        PersonajeDto personajeDto= iPersonajeService.update(mapper.toDto(personajeEntity));
        if(personajeDto!=null)
        {
            return Response.ok().entity(iPersonajeService.findAll()).build();
        }
        return Response.notModified().tag("No existe el registro que desea modificar").build();
    }
    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") int id) {
        boolean bandera= iPersonajeService.delete(id);

        if(bandera!=false) {
            return Response.ok().tag("Registro eliminado con id: "+ id).build();
        }
        return Response.status(HttpStatus.SC_METHOD_FAILURE).tag("No se pudo eliminar el registro").build();
    }

    //SECCIÓN DE BUSINESS
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
    //@RolesAllowed("write")
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