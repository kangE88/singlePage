package com.singlePage.controller;

import com.singlePage.repo.PostRepository;
import com.singlePage.services.CustomUserDetailService;
import com.singlePage.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PostController {

    private final PostRepository postRepository;
    private final CustomUserDetailService userService;

    public PostController(PostRepository postRepository, CustomUserDetailService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

//    public PostController(CustomUserDetailService userService, PostRepository postRepository){
//        this.userService = new CustomUserDetailService();
//        this.postRepository = postRepository;
//    }

//
//    @GetMapping("/posts")
//    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title){
//        try {
//            List<Post> posts = new ArrayList<Post>();
//
//            if( title == null )
//                postRepository.findAll().forEach(posts::add);
//            else
//                postRepository.findByTitleContaining(title).forEach(posts::add);
//
//            if( posts.isEmpty() ){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(posts, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @RequestMapping("/dashboard/kangPage")
    public ModelAndView kangPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        model.addAttribute("posts", postRepository.findAll());
        System.out.println(new StringBuilder().append("findALL >>>>").append(postRepository.findAll().toString()).toString());
        //return "/dashboard/kangPage";
        modelAndView.setViewName("dashboard/kangPage");
        return modelAndView;
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
