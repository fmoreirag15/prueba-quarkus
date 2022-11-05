package org.pruebaquarkus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.pruebaquarkus.model.document.PersonajeDocument;
import org.pruebaquarkus.model.dto.PersonajeDto;
import org.pruebaquarkus.model.entity.PersonajeEntity;
import org.pruebaquarkus.proxy.model.PersonajeProxyDto;

@Mapper(componentModel = "cdi")
public interface IPesonajeMapper {
    @Mappings({     @Mapping(source = "ndFruitId", target = "ndFruitId", defaultValue = "0"),
                    @Mapping(source = "fruitId", target = "fruitId", defaultValue = "0"),
                    @Mapping(source = "crewId", target = "crewId", defaultValue = "0") })

    PersonajeDto toDto(PersonajeEntity personajeEntity);
    @Mappings({ @Mapping(source = "ndFruitId", target = "ndFruitId", defaultValue = "0"),
            @Mapping(source = "fruitId", target = "fruitId", defaultValue = "0"),
            @Mapping(source = "crewId", target = "crewId", defaultValue = "0") })

    PersonajeDto toDtoProxy(PersonajeProxyDto personajeProxyDto);
    @Mappings({ @Mapping(source = "ndFruitId", target = "ndFruitId", defaultValue = "0"),
            @Mapping(source = "fruitId", target = "fruitId", defaultValue = "0"),
            @Mapping(source = "crewId", target = "crewId", defaultValue = "0") })

    PersonajeProxyDto toProxyDto(PersonajeDto personajeDto);
    @Mappings({ @Mapping(source = "ndFruitId", target = "ndFruitId", defaultValue = "0"),
            @Mapping(source = "fruitId", target = "fruitId", defaultValue = "0"),
            @Mapping(source = "crewId", target = "crewId", defaultValue = "0"),
            @Mapping(ignore = true, target = "id")})
    PersonajeEntity toEntity(PersonajeDto personajeDto);

    @Mappings({ @Mapping(source = "ndFruitId", target = "ndFruitId", defaultValue = "0"),
            @Mapping(source = "fruitId", target = "fruitId", defaultValue = "0"),
            @Mapping(source = "crewId", target = "crewId", defaultValue = "0"),
            @Mapping(ignore = true, target = "id")})
    PersonajeDocument toDocument(PersonajeDto personajeDto);

    @Mappings({ @Mapping(source = "ndFruitId", target = "ndFruitId", defaultValue = "0"),
            @Mapping(source = "fruitId", target = "fruitId", defaultValue = "0"),
            @Mapping(source = "crewId", target = "crewId", defaultValue = "0"),
            @Mapping(ignore = true, target = "id")})
    PersonajeDto toDtoDocument(PersonajeDocument personajeDocument);

}
