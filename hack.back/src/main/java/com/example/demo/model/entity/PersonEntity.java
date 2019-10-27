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
@Document("persons")
public class PersonEntity {
    @Id
    private String id;
    @Field("person_id")
    private Integer personId;
    private String name;
    @Field("family_name")
    private String familyName;
    @Field("given_name")
    private String givenName;
    @Field("patronymic_name")
    private String patronymicName;
    private String gender;
}
