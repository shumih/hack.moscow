package com.example.demo.controller;

import com.example.demo.model.entity.MoscowIncomePerson;
import com.example.demo.service.MoscowIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MoscowPersonController {
    private final MoscowIncomeService moscowIncomeService;

    @GetMapping("/getAllMoscowEntities")
    public List<MoscowIncomePerson> getAllMoscowEntities() {
        return moscowIncomeService.getAllMoscowEntities();
    }

    @GetMapping("/getPersonById")
    public MoscowIncomePerson getPersonById(String id) {
        return moscowIncomeService.getPersonById(id);
    }

    @GetMapping("/getAllByAuthorities")
    public List<MoscowIncomePerson> getAllByAuthorities(String auth) {
        return moscowIncomeService.getAllByAuthorities(auth);
    }

    @GetMapping("/getAllOrderByAuthority")
    public List<MoscowIncomePerson> getAllOrderByAuthority() {
        return moscowIncomeService.getAllOrderByAuthority();
    }
}
