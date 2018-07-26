package com.oocl.db.one_to_one.controller;

import com.oocl.db.one_to_n.entity.Company;
import com.oocl.db.one_to_n.entity.Employee;
import com.oocl.db.one_to_n.repository.CompanyRepository;
import com.oocl.db.one_to_n.repository.EmployeeRepository;
import com.oocl.db.one_to_one.entity.Klass;
import com.oocl.db.one_to_one.repository.KlassRepository;
import com.oocl.db.one_to_one.repository.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/klass")
public class KlassController {
    @Autowired
    private KlassRepository klassRepository;

    @Autowired
    private LeaderRepository leaderRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass save(@RequestBody Klass klass) {
        if(klass.getLeader()!=null){
            klass.getLeader().setKlass( klass );
        }
        return klassRepository.save( klass );
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Klass> findAll() {
        return klassRepository.findAll();
    }

//    @Transactional
//    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity updateCompany(@RequestBody Company company) {
//        company.getEmployees().stream()
//                .filter( employee -> employee.getCompany() == null )
//                .forEach( employee -> employee.setCompany( company ) );
//        companyRepository.save( company );
//        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
//    }
//
//    @Transactional
//    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Company delete(@PathVariable Long id) {
//        Company company = companyRepository.findById( id ).get();
//        companyRepository.delete( company );
//        return company;
//    }
//
//
//    @Transactional
//    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//
//    public Optional <Company> findById(@PathVariable Long id) {
//        return companyRepository.findById( id );
//    }
//
//    @Transactional
//    @DeleteMapping(path = "/employee/{Eid}", produces = MediaType.APPLICATION_JSON_VALUE)
//
//    public ResponseEntity deleteEmployee(@PathVariable Long Eid) {
//        Employee employee = employeeRepository.findById( Eid ).get();
//        employeeRepository.delete( employee );
//        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
//    }
//
//    @Transactional
//    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Employee> getEmployees() {
//        return employeeRepository.findAll();
//    }
}
