package com.example.demo.repository;

import com.example.demo.model.entity.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrandRepository extends MongoRepository<BrandEntity, String> {
}
