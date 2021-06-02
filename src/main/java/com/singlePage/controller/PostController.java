package com.singlePage.controller;

import com.singlePage.repo.PostRepository;
import com.singlePage.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title){
        try {
            List<Post> posts = new ArrayList<Post>();

            if( title == null )
                postRepository.findAll().forEach(posts::add);
            else
                postRepository.findByTitleContaining(title).forEach(posts::add);

            if( posts.isEmpty() ){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/dashboard/kangPage")
    public String kangPage(Model model){
        model.addAttribute("posts", postRepository.findAll());
        return "/dashboard/kangPage";
    }
//
//    @PostMapping("/posts")
//    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
//        return postsService.save(requestDto);
//    }
//
//    @PutMapping("/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
//        return postsService.update(id, requestDto);
//    }
//
//    @GetMapping("/posts")
//    public List<PostsListResponseDto> findAll() {
//        return postsService.findAll();
//    }
//
//    @GetMapping("/posts/{id}")
//    public PostsResponseDto findById(@PathVariable Long id) {
//        return postsService.findById(id);
//    }
//
//    @DeleteMapping("/posts/{id}")
//    public Long delete(@PathVariable Long id) {
//        postsService.delete(id);
//        return id;
//    }
}
