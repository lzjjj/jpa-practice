package com.oocl.db.n_to_n.repository;

import com.oocl.db.n_to_n.entity.Group;
import com.oocl.db.one_to_n.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface GroupRepository extends JpaRepository<Group,Long>{
}
