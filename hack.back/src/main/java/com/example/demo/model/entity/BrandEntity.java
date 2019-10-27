
package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("Brands")
@NoArgsConstructor
public class BrandEntity {
    @Id
    private String id;
    @Field("brand_id")
    private Integer brandId;
    private String name;
}
