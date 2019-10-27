package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Document_type")
@NoArgsConstructor
public class DocumentTypeEntity {
    private Integer id;
    private String name;
}
