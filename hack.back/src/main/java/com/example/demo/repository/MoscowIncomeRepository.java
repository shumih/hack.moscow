package com.example.demo.repository;

import com.example.demo.model.entity.MoscowIncomePerson;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MoscowIncomeRepository extends MongoRepository<MoscowIncomePerson, String> {
    List<MoscowIncomePerson> findAllByAuthority(String auth);
    List<MoscowIncomePerson> findAllByOrderByIncome();


}
