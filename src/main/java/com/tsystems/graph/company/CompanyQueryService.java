package com.tsystems.graph.company;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static java.util.stream.StreamSupport.stream;

@Service
public class CompanyQueryService {

    private final CompanyRepository companyRepository;

    public CompanyQueryService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    public Stream<Company> getCompanies() {
        return stream(companyRepository.findAll().spliterator(), false);
    }

}
