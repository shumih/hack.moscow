package com.example.demo.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "PersonAndWifes")
public class PersonAndWifeEntity {
    @Id
    private String id;
    @Field("man_id")
    private Long manId;
    @Field("wife_id")
    private Long wifeId;
    @Field("man_income")
    private Double manIncome;
    @Field("wife_income")
    private Double wifeIncome;
}
