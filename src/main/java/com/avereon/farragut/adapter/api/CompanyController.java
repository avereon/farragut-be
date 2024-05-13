package com.avereon.farragut.adapter.api;

import com.avereon.farragut.adapter.api.model.Company;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController implements CompanyApi {
//    @Override
//    public ResponseEntity<List<Company>> getCompanies() {
//        return ResponseEntity.ofNullable(List.of());
//    }

    @Override
    public ResponseEntity<List<Company>> getCompanies(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Company> getCompany(String id) {
        return null;
    }
}
