package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("Incomes")
@NoArgsConstructor
public class IncomeEntity {
    @Id
    private String id;
    private Double size;
    @Field("relative_entity")
    private RelativeEntity relativeEntity;
    private String comment;
}
