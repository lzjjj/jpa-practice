//package com.oocl.db.n_to_n.entity;
//
//import com.oocl.db.one_to_n.entity.Employee;
//import org.springframework.data.annotation.CreatedDate;
//
//import javax.persistence.*;
//import java.time.ZonedDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Table(name = "user")
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String name;
//
//    @CreatedDate
//    private ZonedDateTime create_time = ZonedDateTime.now();
//
////    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//    private List <Group> groups;
//
//
//
//    public User(long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public User() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public ZonedDateTime getCreate_time() {
//        return create_time;
//    }
//
//    public void setCreate_time(ZonedDateTime create_time) {
//        this.create_time = create_time;
//    }
//
//    public List <Group> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(List <Group> groups) {
//        this.groups = groups;
//    }
//}
