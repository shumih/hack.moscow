package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("RelativeEstateOwner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelativeEstateOwner {
    @Id
    private String id;
    @Field("id_person")
    private String idPerson;
    private String authority;
    private String declarationType;
    @Field("full_name")
    private String fullName;
    private String position;
    private String region;
    @Field("relative_type")
    private String relativeType;
    @Field("real_estate_entity")
    private List<RealEstateEntity> realEstateEntities;
}
