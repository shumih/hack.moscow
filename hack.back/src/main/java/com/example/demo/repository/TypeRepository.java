package com.example.demo.repository;

import com.example.demo.model.entity.TypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<TypeEntity, String> {
}
