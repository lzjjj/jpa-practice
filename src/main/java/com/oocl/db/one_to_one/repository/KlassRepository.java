package com.oocl.db.one_to_one.repository;

import com.oocl.db.one_to_n.entity.Company;
import com.oocl.db.one_to_one.entity.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlassRepository extends JpaRepository<Klass,Long>{
}
