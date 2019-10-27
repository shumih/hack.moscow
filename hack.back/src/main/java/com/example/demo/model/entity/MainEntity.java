package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Document("main_type")
public class MainEntity {
    @Id
    private String id;
    private PersonEntity person;
    private OfficeEntity office;
    private PartyEntity party;
    private Integer year;
    @Field("document_type")
    private DocumentTypeEntity documentTypeEntity;
}
