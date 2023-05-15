package com.example.RoleForTheLoLs.controller;

import jakarta.annotation.Nonnull;
import com.example.RoleForTheLoLs.model.Post;
import com.example.RoleForTheLoLs.model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RoleForTheLoLs.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService ps;

    @PostMapping("/addPost")
    public ResponseEntity addPost(@RequestBody final @Nonnull Post p) {
        return ps.addPost(p);
    }

    @GetMapping("/{id}/usuarios")
    public List<UsuarioDTO> findUsuarioByPostId(@PathVariable Integer id){
        return ps.findUsuarioByPostId(id);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updatePost(@PathVariable final @Nonnull Integer id, @RequestBody final  @Nonnull Post p){
        return ps.updatePost(id,p);
    }

    @GetMapping("/getAll")
    public List<Post> getAll(){
        return ps.getAll();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable final @Nonnull Integer id){
        return ps.getPost(id);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deletePost (@PathVariable final @Nonnull Integer id){
        return ps.deletePost(id);
    }

}

