package com.example.demo.repository;

import com.example.demo.model.entity.MainEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainRepository extends MongoRepository<MainEntity, String> {
}
