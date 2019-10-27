package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "OfficialPersonShort")
@NoArgsConstructor
@AllArgsConstructor
public class OfficialPersonShortEntity {
    @Id
    private String id;
    @Field("full_name")
    private String fullName;
    private String sex;
    private String position;
    private Double income;
    @Field("total_real_estate")
    private Double totalRealEstate;
    @Field("real_entities")
    private List<RealEstateEntity> realEstates;
    @Field("vehicle_entities")
    private List<VehicleEntity> vehicleEntities;

    public OfficialPersonShortEntity(OfficialPersonEntity officialPersonEntity) {
        this.fullName = officialPersonEntity.getMain().getPerson().getName();
        this.position = createFullPosition(officialPersonEntity);
        this.income = getIncome(officialPersonEntity);
        this.totalRealEstate = getTotalRealEstate(officialPersonEntity);
        this.vehicleEntities = officialPersonEntity.getVehicleEntities();
        this.realEstates = officialPersonEntity.getRealEstates();
    }

    private Double getTotalRealEstate(OfficialPersonEntity officialPersonEntity) {
        return officialPersonEntity.getRealEstates()
                .stream()
                .mapToDouble(RealEstateEntity::getSquare)
                .sum();
    }

    private Double getIncome(OfficialPersonEntity officialPersonEntity) {
        return officialPersonEntity.getIncomes()
                .stream()
                .mapToDouble(IncomeEntity::getSize)
                .sum();

    }

    private String createFullPosition(OfficialPersonEntity officialPersonEntity) {
        StringBuilder stringBuilder = new StringBuilder();
        OfficeEntity office = officialPersonEntity.getMain().getOffice();

        stringBuilder.append(office.getName())
                .append(" ")
                .append(office.getTypeEntity().getName());

        return stringBuilder.toString();
    }
}
