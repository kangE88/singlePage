package com.security;

import com.repo.UserRepository;
import com.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @GetMapping("/")
    public String index(){
        System.out.println("home in");
        return "home";
    }

    public void run(String... args) throws Exception {
        deleteAll();
        addSampleData();
    }
    public void deleteAll() {
        System.out.println("Deleting all records..");
        repository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");
        repository.save(new Users("kang", "kang", "kang88"));
    }
}
