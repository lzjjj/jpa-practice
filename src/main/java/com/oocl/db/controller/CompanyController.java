package com.oocl.db.controller;

import com.oocl.db.entity.Company;
import com.oocl.db.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company) {
        return companyRepository.save( company );
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Company> findAll() {
        return companyRepository.findAll();
    }

    @Transactional
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company updateCompany(@RequestBody Company company) {
        return companyRepository.save( company );
    }

    @Transactional
    @DeleteMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Company> delete(@RequestBody Company company) {
        companyRepository.delete( company );
        return companyRepository.findAll();
    }


    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public Optional<Company>  findById(@PathVariable Long id) {
        return companyRepository.findById(id);
    }
}
