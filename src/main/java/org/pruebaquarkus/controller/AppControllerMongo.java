package org.pruebaquarkus.controller;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.pruebaquarkus.business.IPersonajeBusiness;
import org.pruebaquarkus.business.IPersonajeDocumentBusiness;
import org.pruebaquarkus.business.Impl.PersonajeDocumentBusiness;
import org.pruebaquarkus.mapper.IPesonajeMapper;
import org.pruebaquarkus.model.dto.ErrorResponse;
import org.pruebaquarkus.service.IPersonajeDcoumentService;
import org.pruebaquarkus.service.IPersonajeService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v2")
@RequiredArgsConstructor
public class AppControllerMongo {
    @Inject
    @Named("PersonajeDocumentBusiness")
    private IPersonajeDocumentBusiness personajeDocumentBusiness;


    @GET
    @Path("/characters/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllPersonaje() {
        try
        {
            return Response.ok().entity(  personajeDocumentBusiness.findAll()).build();
        }catch (Exception  e){
            return  Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }


    }

    @GET
    @Path("/characters/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response getPersonajeById(@PathParam("id") Integer id) {
        try
        {
            return Response.ok().entity(  personajeDocumentBusiness.findById(id)).build();
        }catch (Exception  e){
            return  Response.status(HttpStatus.SC_CONFLICT).entity(new ErrorResponse(e.getMessage())).build();
        }


    }

}
