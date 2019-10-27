package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("Offices")
@NoArgsConstructor
public class OfficeEntity {
    @Id
    private String id;
    @Field("office_id")
    private Integer officeId;
    private String name;
    @Field("region_entity")
    private RegionEntity regionEntity;
    @Field("type_entity")
    private TypeEntity typeEntity;
    private String url;
}
