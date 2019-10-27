package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("own_types")
@NoArgsConstructor
public class OwnTypeEntity {
    @Id
    private String id;
    @Field("own_type_entity_id")
    private Integer ownTypeEntityId;
    private String name;
}
