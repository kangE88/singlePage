package com.singlePage.controller;

import com.singlePage.controller.dto.PostsListResponseDto;
import com.singlePage.controller.dto.PostsResponseDto;
import com.singlePage.controller.dto.PostsSaveRequestDto;
import com.singlePage.controller.dto.PostsUpdateRequestDto;
import com.singlePage.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    @RequestMapping(value = "/dashboard/kangPage", method = RequestMethod.GET)
    public ModelAndView kangPage(Model model){
        List<PostsListResponseDto> posts = postsService.findAll();
        ModelAndView mav = new ModelAndView();
        model.addAttribute("posts", posts);
        mav.setViewName("dashboard/kangPage");
        return mav;
    }

    private final PostService postsService;

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/posts")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAll();
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
