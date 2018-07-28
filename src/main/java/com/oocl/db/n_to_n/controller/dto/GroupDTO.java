package com.oocl.db.n_to_n.controller.dto;

import com.oocl.db.n_to_n.entity.Group;

import java.time.ZonedDateTime;
import java.util.List;

public class GroupDTO {
    private final Long id;
    private final String name;
    private final ZonedDateTime createDate;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }


    public GroupDTO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
        this.createDate = group.getCreate_time();
    }


}
