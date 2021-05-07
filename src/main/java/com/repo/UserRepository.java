package com.repo;

import com.user.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {

    Users findFirstByName(String name);

    @Query("{name:'?0'}")
    List<Users> findCustomByName(String name);


}
