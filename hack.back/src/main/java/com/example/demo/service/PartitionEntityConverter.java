package com.example.demo.service;

import com.example.demo.model.entity.OfficialPersonEntity;
import com.example.demo.model.entity.OfficialPersonShortEntity;
import com.example.demo.model.entity.RealEstateEntity;
import com.example.demo.repository.OfficialPersonRepository;
import com.example.demo.repository.OfficialPersonShortRepository;
import com.example.demo.repository.PersonAndWifeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PartitionEntityConverter {
    private static final String WIFE_COLUMN_NAME = "Супруг(а)";

    private final OfficialPersonRepository officialPersonRepository;
    private final OfficialPersonShortRepository officialPersonShortRepository;
    private final PersonAndWifeRepository personAndWifeRepository;

    @PostConstruct
    public void check() {

        officialPersonRepository.findAll()
                .stream()
                .map(OfficialPersonShortEntity::new)
                .forEach(officialPersonShortRepository::save);

    }

    private Map<String, List<OfficialPersonEntity>> getGroupedByWifeId() {
        return officialPersonRepository.findAll()
                .stream()
                .filter(this::findWifeExistence)
                .collect(Collectors.groupingBy(this::getWifeId));
    }

    private boolean findWifeExistence(OfficialPersonEntity officialPersonEntity) {
        List<RealEstateEntity> realEstates = officialPersonEntity.getRealEstates();

        return realEstates.stream()
                .anyMatch(es -> (es.getRelativeEntity() != null) && (es.getRelativeEntity().getName().equals(WIFE_COLUMN_NAME)));
    }

    private String getWifeId(OfficialPersonEntity officialPersonEntity) {
        List<RealEstateEntity> realEstates = officialPersonEntity.getRealEstates();

        return realEstates.stream()
                .filter(es -> es.getRelativeEntity() != null)
                .findFirst()
                .map(es -> es.getRelativeEntity().getId())
                .orElseThrow(() -> new IllegalArgumentException("Wrong value of wife ID"));
    }
}
