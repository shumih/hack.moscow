package com.example.demo.service;

import com.example.demo.repository.OfficialPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfficialPersonService {
    private final OfficialPersonRepository officialPersonRepository;



}
