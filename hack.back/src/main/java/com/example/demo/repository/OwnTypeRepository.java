package com.example.demo.repository;

import com.example.demo.model.entity.OwnTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnTypeRepository extends MongoRepository<OwnTypeEntity, String> {
}
