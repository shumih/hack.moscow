package com.example.demo.repository;

import com.example.demo.model.entity.OfficialPersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfficialPersonRepository extends MongoRepository<OfficialPersonEntity, String> {

}
