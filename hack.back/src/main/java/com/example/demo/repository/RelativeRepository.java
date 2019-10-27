package com.example.demo.repository;

import com.example.demo.model.entity.RelativeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelativeRepository extends MongoRepository<RelativeEntity, String> {
}
