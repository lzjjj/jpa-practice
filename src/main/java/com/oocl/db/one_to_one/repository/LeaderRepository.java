package com.oocl.db.one_to_one.repository;

import com.oocl.db.one_to_n.entity.Employee;
import com.oocl.db.one_to_one.entity.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepository extends JpaRepository<Leader,Long>{
}
