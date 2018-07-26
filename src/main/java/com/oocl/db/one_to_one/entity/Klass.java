package com.oocl.db.one_to_one.entity;

import com.oocl.db.one_to_n.entity.Employee;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "klass")
@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @CreatedDate
    private ZonedDateTime create_time = ZonedDateTime.now();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "klass", fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private Leader leader;


    public Klass(String name, Leader leader) {
        this.name = name;
        this.leader = leader;
    }

    public Klass() {
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(ZonedDateTime create_time) {
        this.create_time = create_time;
    }

}
