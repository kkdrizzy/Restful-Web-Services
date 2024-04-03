package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.exception.UserNotFoundException;
import com.example.restfulwebservices.model.Post;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.PostDaoService;
import com.example.restfulwebservices.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private PostDaoService postDaoService;



    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> retrieveById(@PathVariable Long id){
        Optional<User> user = userDaoService.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = userDaoService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userDaoService.deleteById(id);
    }



    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Long id, @Valid @RequestBody Post post){
        Optional<User> user = userDaoService.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }

        post.setUser(user.get());
        Post newPost = postDaoService.create(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
