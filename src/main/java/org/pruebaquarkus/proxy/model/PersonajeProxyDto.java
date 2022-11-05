package org.pruebaquarkus.proxy.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mongodb.lang.Nullable;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.validation.constraints.Null;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeProxyDto {

    private int id;
    private String french_name;
    private String job;
    private String size;
    private String  birthday;
    private String age;
    private String bounty;
    private String status;
    private Integer crewId;
    private Integer fruitId;

    @JsonbProperty("2ndFruitId")
    private Integer ndFruitId;


}
