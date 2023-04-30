package controller;

import jakarta.annotation.Nonnull;
import model.Post;
import model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService ps;

    @PostMapping("")
    public ResponseEntity addPost(@RequestBody final @Nonnull Post p) { return ps.addPost(p);
    }

    @GetMapping("/{id}/usuarios")
    public List<UsuarioDTO> findUsuarioByPostId(@PathVariable Integer id){
        return ps.findUsuarioByPostId(id);
    }
}
