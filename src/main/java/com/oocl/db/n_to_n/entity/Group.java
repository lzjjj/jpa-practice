//package com.oocl.db.n_to_n.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.oocl.db.one_to_n.entity.Company;
//import org.springframework.data.annotation.CreatedDate;
//
//import javax.persistence.*;
//import java.time.ZonedDateTime;
//import java.util.List;
//
//@Table(name = "u_group")
//@Entity
//public class Group {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String name;
//
//    @CreatedDate
//    private ZonedDateTime create_time = ZonedDateTime.now();
//
////    @JsonIgnore
////    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "user_group", fetch = FetchType.LAZY)
////    @JoinColumn(name = "user_id")
//    private List<User> users;
//
//    public Group() {
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
//    public List <User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List <User> users) {
//        this.users = users;
//    }
//}
