package com.example.RoleForTheLoLs.service;

import com.example.RoleForTheLoLs.model.Post;
import com.example.RoleForTheLoLs.repository.PostRepository;
import com.example.RoleForTheLoLs.repository.UsuarioRepository;
import jakarta.annotation.Nonnull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service

public class PostService {

    private final PostRepository pr;

    private final UsuarioRepository ur;

    private final ModelMapper mm = new ModelMapper();

    @Autowired
    public PostService(PostRepository pr, UsuarioRepository ur) { this.pr = pr;
        this.ur = ur;}

    public ResponseEntity addPost(Post p){
        pr.save(p);
        return ResponseEntity.status(CREATED).build();
    }

    /*
    public List<UsuarioDTO> findUsuarioByPostId(Integer id) {
        List<Integer> usuarioIdList = pr.findUsuarioByPostid(id);
        List<UsuarioDTO> usuarios = new ArrayList<>();
        for (Integer usuarioId : usuarioIdList) {
            Usuario u = ur.findById(usuarioId).orElseThrow();
            usuarios.add(mm.map(u, UsuarioDTO.class));
        }
    return usuarios;
    }

     */

    public ResponseEntity deletePost(Integer id){
        try {
            pr.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updatePost(@Nonnull Integer id, Post post){
        try {
            post = pr.findById(id).orElseThrow(() -> new HttpClientErrorException(BAD_REQUEST, "Post not found"));
            post.setId(post.getId());
            post.setText(post.getText());
            post.setUsuario(post.getUsuario());
            pr.save(post);
            return ResponseEntity.status(OK).build();
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Post getPost(Integer id){
        return pr.findById(id).orElseThrow(() -> new HttpClientErrorException(BAD_REQUEST, "Post not found"));
    }

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        for (Post p : pr.findAll()) {
            posts.add(mm.map(p, Post.class));
        }
        return posts;
    }

}
