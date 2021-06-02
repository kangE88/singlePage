package com.singlePage.controller;

import com.singlePage.repo.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

class PostControllerTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void postFindAll() throws Exception {
        //given
//        Post.java post = new Post.java();
//        post.setTitle("post Test");
//        post.setContent("tttt");
//        post.setAuthor("cerisetal@naver.com");
        //when

        //then

        //given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        //when
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
//        System.out.println("findMember == member: "+(findMember == member));
    }
}