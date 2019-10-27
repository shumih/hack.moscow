package com.example.demo.repository;

import com.example.demo.model.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<PersonEntity, String> {
}
