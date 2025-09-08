package com.example.demo;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserRepository extends ListCrudRepository<User, Long>{
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
}
