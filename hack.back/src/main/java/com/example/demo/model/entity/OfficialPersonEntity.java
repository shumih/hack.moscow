package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "OfficialPersons")
@NoArgsConstructor
@AllArgsConstructor
public class OfficialPersonEntity {
    @Id
    private String id;
    private MainEntity main;
    private List<IncomeEntity> incomes = new ArrayList<>();
    @Field("real_estates")
    private List<RealEstateEntity> realEstates = new ArrayList<>();
    @Field("vehicle_entities")
    private List<VehicleEntity> vehicleEntities = new ArrayList<>();
    private List<String> savings = new ArrayList<>();
    private List<String> stocks = new ArrayList<>();
    private List<String> bonds = new ArrayList<>();
    private List<String> spendings = new ArrayList<>();
}
