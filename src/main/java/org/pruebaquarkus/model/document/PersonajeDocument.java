package org.pruebaquarkus.model.document;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "personaje")
public class PersonajeDocument {
    @BsonId
    private ObjectId id;
    private String french_name;
    private String job;
    private String size;
    private String  birthday;
    private String age;
    private String bounty;
    private String status;
    private Integer crewId;
    private Integer fruitId;
    @BsonProperty("2ndFruitId")
    private Integer ndFruitId;
}
