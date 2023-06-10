package com.example.RoleForTheLoLs.controller;

import com.example.RoleForTheLoLs.model.Post;
import jakarta.annotation.Nonnull;
import com.example.RoleForTheLoLs.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.RoleForTheLoLs.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService us;

    @PostMapping("/addUsuario")
    public ResponseEntity addUsuario(@RequestBody final @Nonnull Usuario u) {return  us.addUsuario(u);
    }

    @GetMapping("/getall")
    public List<Usuario> getAll(){return us.getAll();
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateUsuario(@PathVariable final @Nonnull Integer id, @RequestBody final @Nonnull Usuario u){
        return us.updateUsuario(id, u);
    }

    @PostMapping("/{id}/delete")
    public  ResponseEntity deleteUsuario(@PathVariable final @Nonnull Integer id) {
        return  us.deleteUsuario(id);
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable final @Nonnull Integer id){
       return us.getUsuario(id);
    }

    @GetMapping("/{id}/user-posts")
    public List<Post> findPostByUsuarioId(@PathVariable Integer id){ return us.findPostByUsuarioId(id);}
}
