package org.pruebaquarkus.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Null;

@Data
public class PersonajeDto {
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

    private Integer ndFruitId;
}
