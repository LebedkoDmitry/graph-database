package com.tsystems.graph.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;

@RestController
public class CompanyQueryController {

    private final CompanyQueryService companyQueryService;

    public CompanyQueryController(CompanyQueryService companyQueryService) {
        this.companyQueryService = companyQueryService;
    }

    @GetMapping(path = "/companies")
    public Collection<Company> getCompanies() {
        return companyQueryService.getCompanies().collect(toSet());
    }

}
