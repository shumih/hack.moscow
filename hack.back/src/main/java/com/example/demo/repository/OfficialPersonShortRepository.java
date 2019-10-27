package com.example.demo.repository;

import com.example.demo.model.entity.OfficialPersonShortEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OfficialPersonShortRepository extends MongoRepository<OfficialPersonShortEntity, String> {
    List<OfficialPersonShortEntity> findByOrderByIncomeDesc();
    List<OfficialPersonShortEntity> findByRealEstatesDesc();
    List<OfficialPersonShortEntity> findBySexAndOrderByIncomeDesc(String sex);



}
