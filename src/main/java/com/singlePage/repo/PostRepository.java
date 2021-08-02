package com.singlePage.repo;

import com.singlePage.vo.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAll();

   //List<Post> findByPublished(boolean published);
}

