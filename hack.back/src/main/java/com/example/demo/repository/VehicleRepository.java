package com.example.demo.repository;

import com.example.demo.model.entity.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<VehicleEntity, String> {
}
