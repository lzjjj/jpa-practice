package com.oocl.db.one.to.n.repository;

import com.oocl.db.one.to.n.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
