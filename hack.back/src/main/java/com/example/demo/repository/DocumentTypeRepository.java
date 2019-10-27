package com.example.demo.repository;

import com.example.demo.model.entity.DocumentTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentTypeRepository extends MongoRepository<DocumentTypeEntity, String> {
}
