package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    private final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> all() {
        return repository.findAll();
    }
    
    @PostMapping("/users")
    public String postMethodName(@RequestBody String entity) {
        log.info("post request received with: ", entity );
        return entity;
    }
    

    @PutMapping("users/{id}")
    public User putMethodName(@RequestBody User newUser, @PathVariable Long id) {
        
        log.info("put request received to add " + newUser);
        return repository.findById(id)
          .map( user -> {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            return repository.save(user);
          })
          .orElseGet(() -> {
            return repository.save(newUser);
          });
    
        }
}
