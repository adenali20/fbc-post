package com.example.fbcpost.controller;

import com.example.fbcpost.domain.Post;
import com.example.fbcpost.domain.User;
import com.example.fbcpost.dto.FriendsDto;
import com.example.fbcpost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fbc/post")
public class PostsController {



    @Autowired
    UserService userService;

    @PostMapping("/makePost")
    public Post savePost(@RequestBody Post post,Authentication authentication) {

        String id = UUID.randomUUID().toString();

        post.setPostedBy(authentication.getName());
        post.setPostId(id);
        post.setMainPostId("");
        post.setParentId("");
        post.setMain(true);

        User loggedInUser =userService.findUserByUserName(authentication.getName());

        loggedInUser.getPosts().add(post);

        userService.saveUser(loggedInUser);

        return post;
    }

    @GetMapping("/getPost")
    public List<Post>  getPosts(Authentication authentication) {

        User loggedInUser =userService.findUserByUserName(authentication.getName());

        Set<String> users = loggedInUser.getFriends().stream().map(e->e.getFriendUserName()).collect(Collectors.toSet());
        users.add(authentication.getName());

        List<Post> posts = new ArrayList<>();

        users.forEach(e->{
            posts.addAll(userService.findUserByUserName(e).getPosts());
        });

        Collections.reverse(posts);
        return posts;
    }
}
