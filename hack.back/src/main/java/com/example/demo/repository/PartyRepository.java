package com.example.demo.repository;

import com.example.demo.model.entity.PartyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<PartyEntity, String> {
}
