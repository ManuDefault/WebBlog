package WebBlog.WebBlog.controllers;


import WebBlog.WebBlog.models.Posts;
import WebBlog.WebBlog.models.Users;
import WebBlog.WebBlog.servisec.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new Users());
        return "views/createUsers.html";
    }

    @PostMapping("/save")
    public String saveUsers(@ModelAttribute("user") Users users,Model model){
        users.setCreate_up(ZonedDateTime.now());
        users.setUpdate_at(ZonedDateTime.now());
        System.out.println(users);
        usersService.saveUsers(users);
        model.addAttribute("user",users);
        return "index.html";
    }

    @GetMapping("getUser/{id}")
    public String getUser( @PathVariable("id") int id,Model model){
        Users users =  usersService.getUsersById(id);
        List<Posts> postsList =new ArrayList<>();
        postsList.add(new Posts("Post1"));
        postsList.add(new Posts("Post2"));
        postsList.add(new Posts("Post3"));
        postsList.add(new Posts("Post4"));
        postsList.add(new Posts("Post5"));
        users.setPostsList(postsList);
        model.addAttribute("user", users );
         return "views/userOnly.html";
    }


    @GetMapping("/all")
    public String showAll(Model model){
        model.addAttribute("all",usersService.getAll());
        return "views/allUsers.html";
    }


}
