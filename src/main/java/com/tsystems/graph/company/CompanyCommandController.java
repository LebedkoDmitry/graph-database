package com.tsystems.graph.company;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyCommandController {

    private final CompanyCommandService companyCommandService;

    public CompanyCommandController(CompanyCommandService companyCommandService) {
        this.companyCommandService = companyCommandService;
    }

    @PostMapping(path = "/companies")
    public Company createCompany(@RequestBody Company company) {
        return companyCommandService.create(company);
    }

    @PostMapping(path = "/movie-production-companies")
    public Company createMovieProductionCompany(@RequestBody MovieProductionCompany movieProductionCompany) {
        return companyCommandService.create(movieProductionCompany);
    }

}
