package com.example.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document("political_parties")
public class PartyEntity {
    @Id
    private String id;
    @Field("party_id")
    private Long partyId;
    private String name;
}
