package com.singlePage.repo;

import com.singlePage.vo.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContaining(String title);

    List<Post> findByPublished(boolean published);
}

