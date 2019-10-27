package com.example.demo.repository;

import com.example.demo.model.entity.OfficeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfficeRepository extends MongoRepository<OfficeEntity, String> {
}
