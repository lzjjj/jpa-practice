package com.oocl.db.n_to_n.repository;

import com.oocl.db.n_to_n.entity.User;
import com.oocl.db.one_to_n.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
