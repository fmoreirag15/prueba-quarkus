package org.pruebaquarkus.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Builder;
import lombok.Data;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Null;
@Entity
@Table(name = "Personaje")
@Data
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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