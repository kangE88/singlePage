package com.singlePage.controller.dto;

import com.singlePage.vo.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toDocument() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    /*
    public Posts toDocument()
    - Posts Document의 Setter 메서드를 대체한 Builder를 이용하여 전달한다.
     */
}