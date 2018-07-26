package com.oocl.db.one_to_one.controller;

import com.oocl.db.one_to_n.entity.Company;
import com.oocl.db.one_to_n.entity.Employee;
import com.oocl.db.one_to_n.repository.CompanyRepository;
import com.oocl.db.one_to_n.repository.EmployeeRepository;
import com.oocl.db.one_to_one.entity.Klass;
import com.oocl.db.one_to_one.entity.Leader;
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
        if (klass.getLeader() != null) {
            klass.getLeader().setKlass( klass );
        }
        return klassRepository.save( klass );
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Klass> findAll() {
        return klassRepository.findAll();
    }

    @Transactional
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateKlass(@RequestBody Klass klass) {
        if (klass.getLeader() != null) {
            klass.getLeader().setKlass( klass );
        }
        klassRepository.save( klass );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
    }

    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass delete(@PathVariable Long id) {
        Klass klass = klassRepository.findById( id ).get();
        klassRepository.delete( klass );
        return klass;
    }


    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public Optional <Klass> findById(@PathVariable Long id) {
        return klassRepository.findById( id );
    }

    @Transactional
    @DeleteMapping(path = "/leader/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity deleteLeader(@PathVariable Long id) {
        Leader leader = leaderRepository.findById( id ).get();
            leaderRepository.delete( leader );
            return ResponseEntity.status( HttpStatus.MULTI_STATUS ).build();
    }

    @Transactional
    @GetMapping(path = "/leader", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Leader> getLeaders() {
        return leaderRepository.findAll();
    }
}
