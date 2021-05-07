package com.user;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Document(collection = "users")
public class Users {
    @Id //primart key
    private String id;
    private String name;
    private String password;

    public Users(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;

    }
}
