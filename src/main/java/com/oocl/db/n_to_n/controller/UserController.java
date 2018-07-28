package com.oocl.db.n_to_n.controller;


import com.oocl.db.n_to_n.controller.dto.UserDTO;
import com.oocl.db.n_to_n.entity.User;
import com.oocl.db.n_to_n.repository.GroupRepository;
import com.oocl.db.n_to_n.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        user.getGroups().stream().forEach( i->groupRepository.save( i ) );
        return userRepository.save( user );
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAll() {
        return userRepository
                .findAll().stream()
                .map( user->new UserDTO( user ) )
                .collect( Collectors.toList() );
    }

    @Transactional
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCompany(@RequestBody User user) {
        if(user.getGroups().size()!=0){
            user.getGroups().stream()
                    .forEach( group -> {
                        if(group.getId()==null){
                            groupRepository.save( group );
                        }
                        else {
                            group.getId();
                        }
                    } );
        }
        userRepository.save( user );
        return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
    }
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
//    public Optional<Company> findById(@PathVariable Long id) {
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
