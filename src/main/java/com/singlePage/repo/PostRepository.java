package com.singlePage.repo;

import com.singlePage.vo.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Posts, String> {
}
