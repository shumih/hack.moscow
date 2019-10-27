package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document("real_estate")
public class RealEstateEntity {
    private String name;
    private Double square;
    private String country;
    @Field("region_entity")
    private RegionEntity regionEntity;
    private String comment;
    @Field("type_entity")
    private TypeEntity typeEntity;
    @Field("own_type")
    private OwnTypeEntity ownType;
    private Double share;
    @Field("relative_entity")
    private RelativeEntity relativeEntity;
}
