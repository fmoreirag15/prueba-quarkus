package org.pruebaquarkus.proxy;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.pruebaquarkus.proxy.model.PersonajeProxyDto;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(configKey = "post-proxy")
public interface IPersonajeProxy {

 //https://api.api-onepiece.com/characters

     @GET
     @Path("characters/{id}")
     PersonajeProxyDto getById(@PathParam("id") int i);

    @GET
    @Path("characters")
    List<PersonajeProxyDto> getAll();

}
