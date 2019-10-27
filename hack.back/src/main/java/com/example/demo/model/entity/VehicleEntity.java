package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("vehicle")
public class VehicleEntity {
    @Id
    private String id;
    private String name;
    @Field("type_entity")
    private TypeEntity typeEntity;
    @Field("manufacture_year")
    private Integer manufactureYear;
    @Field("brand_entity")
    private BrandEntity brandEntity;
    private String comment;
    @Field("relative_entity")
    private RelativeEntity relativeEntity;
}
