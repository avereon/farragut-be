package com.avereon.farragut.adapter.api;

import org.openapitools.api.CompanyApi;
import org.openapitools.model.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController implements CompanyApi {
    @Override
    public ResponseEntity<Company> getCompany(String id) {
        return null;
    }
}
