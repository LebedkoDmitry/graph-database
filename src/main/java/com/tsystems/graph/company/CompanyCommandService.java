package com.tsystems.graph.company;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyCommandService {

    private final CompanyRepository companyRepository;

    public CompanyCommandService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    public Company create(Company company) {
        if (company == null) {
            throw new IllegalArgumentException("The company argument cannot be null.");
        }
        return companyRepository.save(company);
    }

}
