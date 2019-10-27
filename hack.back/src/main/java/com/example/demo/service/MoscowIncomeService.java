package com.example.demo.service;

import com.example.demo.model.entity.MoscowIncomePerson;
import com.example.demo.repository.MoscowIncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MoscowIncomeService {
    private final MoscowIncomeRepository moscowIncomeRepository;

    public List<MoscowIncomePerson> getAllMoscowEntities() {
        return moscowIncomeRepository.findAll();
    }

    public MoscowIncomePerson getPersonById(String id) {
        return moscowIncomeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Wrong element for ID = " + id));
    }

    public List<MoscowIncomePerson> getAllByAuthorities(String auth) {
        return moscowIncomeRepository.findAllByAuthority(auth);
    }

    public List<MoscowIncomePerson> getAllOrderByAuthority() {
        return moscowIncomeRepository.findAllByOrderByIncome();
    }
}
