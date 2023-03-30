package WebBlog.WebBlog.controllers;


import WebBlog.WebBlog.models.Posts;
import WebBlog.WebBlog.models.Users;
import WebBlog.WebBlog.servisec.PostsService;
import WebBlog.WebBlog.servisec.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@Controller
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/{id}/create")
    public String createPosts(@PathVariable("id") int id, Model model) {
        Posts posts = new Posts();
        model.addAttribute("post", posts);
        model.addAttribute("idUser", id);
        return "views/posts/createPosts.html";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute(name = "post") Posts posts, Model model,@RequestParam("idUser") int id) {
        Integer integer = (Integer) model.getAttribute("idUser");
        posts.setCreate_at(ZonedDateTime.now());
        posts.setUpdate_at(ZonedDateTime.now());
        Users u = usersService.getUsersById(id);
        posts.setUsers(u);
        System.out.println(u);
        System.out.println(integer);
        postsService.savePost(posts);
        return "redirect:/posts/allPost";
    }


    @GetMapping("/allPost")
    public String getAllPost(Model model) {
        model.addAttribute("allPost", postsService.getAll());
        return "views/posts/allPosts.html";
    }

    @GetMapping("/getPost/{id}")
    public String getOnlyPostById(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postsService.getPostById(id));
        return "views/posts/postById.html";
    }
}
