package com.oocl.db.n_to_n.controller.dto;

import com.oocl.db.n_to_n.entity.User;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private final Long id;
    private final String name;
    private final ZonedDateTime createDate;
    private final List<Long> groups;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public List <Long> getGroups() {
        return groups;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.createDate = user.getCreate_time();
        this.groups = user.getGroups().stream().map( group->group .getId() ).collect( Collectors.toList() );
    }
}
