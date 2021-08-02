package com.singlePage.vo;

import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Getter
@Setter
@Document(collection = "posts")
public class Post {

    //@Transient
    //public static final String SEQUENCE_NAME = "posts_sequence";

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String title;
    private String content;
    private String author;

//    public void setId(Long id) {
//        this.id = id;
//    }

    /*
        Builder
        생성자 싱딘 선언 시 생성자에 포함되어 필드만 빌더에 포함된다.
        데이터베이스에 데이터를 넣기위한 Setter 메서드 대체
     */
    @Builder
    public Post(String id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
//
//    public void update(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    public Posts toDocument() {
//        return Posts.builder()
//                .title(title)
//                .content(content)
//                .author(author)
//                .build();
//    }
}
