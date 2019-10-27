package com.example.demo.service;

import com.example.demo.model.entity.OfficialPersonShortEntity;
import com.example.demo.repository.OfficialPersonShortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficialPersonShortService {
    private final OfficialPersonShortRepository officialPersonShortRepository;

    public List<OfficialPersonShortEntity> getAllPersons() {
        return new ArrayList<>(officialPersonShortRepository.findAll());
    }

    public List<OfficialPersonShortEntity> getPersonByIncome() {
        return new ArrayList<>(officialPersonShortRepository.findByOrderByIncomeDesc());
   }

   public List<OfficialPersonShortEntity> getIncomeForSex(String sex) {
        return officialPersonShortRepository.findBySexAndOrderByIncomeDesc(sex);
   }

    public List<OfficialPersonShortEntity> getPersonsByEstate() {
        return officialPersonShortRepository.findByRealEstatesDesc();
    }
}
