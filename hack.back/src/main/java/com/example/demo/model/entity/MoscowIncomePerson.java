package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("MoscowIncomes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoscowIncomePerson {
    @Id
    private String id;
    @Field("id_person")
    private String idPerson;
    private String authority;
    @Field("declaration_type")
    private String declarationType;
    @Field("full_name")
    private String fullName;
    private String position;
    private String region;
    private String income;
    @Field("relative_incomes")
    private List<RelativeIncome> relativeIncomes;
    @Field("relative_estate_owner")
    private List<RelativeEstateOwner> relativeEstateOwners;
}
