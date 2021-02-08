package com.example.dima.repository;

import com.example.dima.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "User")
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);
}
