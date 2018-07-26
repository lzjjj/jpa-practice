package com.oocl.db.one_to_one.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oocl.db.one_to_n.entity.Company;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Table(name = "leader")
@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @CreatedDate
    private ZonedDateTime create_time = ZonedDateTime.now();

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klass_id")
    private Klass klass;

    public Leader(Long id,String name) {
        this.id = id;
        this.name = name;
    }
    public Leader() {
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

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
