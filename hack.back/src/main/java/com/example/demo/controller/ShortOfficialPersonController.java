package com.example.demo.controller;

import com.example.demo.model.entity.OfficialPersonShortEntity;
import com.example.demo.service.OfficialPersonShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ShortOfficialPersonController {
    private final OfficialPersonShortService officialPersonShortService;

    @GetMapping("/allPersons")
    public List<OfficialPersonShortEntity> getAllPersons() {
        return officialPersonShortService.getAllPersons();
    }

    @GetMapping("/personsByIncomes")
    public List<OfficialPersonShortEntity> getOfficialPersonShortBy() {
        return officialPersonShortService.getPersonByIncome();
    }

    @GetMapping("/personsBySex")
    public List<OfficialPersonShortEntity> getPersonsBySex(@RequestParam(defaultValue = "Ж") String sex) {
        return officialPersonShortService.getIncomeForSex(sex);
    }

    @GetMapping("/personsByEstate")
    public List<OfficialPersonShortEntity> getPersonsByEstate() {
        return officialPersonShortService.getPersonsByEstate();
    }
}
