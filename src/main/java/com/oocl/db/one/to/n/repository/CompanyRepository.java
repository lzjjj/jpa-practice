package com.oocl.db.one.to.n.repository;

import com.oocl.db.one.to.n.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
    public List<Company> findAll();
}
