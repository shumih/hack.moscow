package com.example.demo.repository;

import com.example.demo.model.entity.IncomeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<IncomeEntity, String> {
}
