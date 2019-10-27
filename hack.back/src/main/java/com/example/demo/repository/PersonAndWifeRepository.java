package com.example.demo.repository;

import com.example.demo.model.entity.PersonAndWifeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonAndWifeRepository extends MongoRepository<PersonAndWifeEntity, String> {
}
