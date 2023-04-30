package service;

import model.Usuario;
import model.Post;
import model.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import repository.PostRepository;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

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

    public List<UsuarioDTO> findUsuarioByPostId(Integer id)
    {
        List<Integer> usuarioIdList = pr.findUsuarioByPostid(id);
        List<UsuarioDTO> usuarios = new ArrayList<>();
        for (Integer usuarioId : usuarioIdList) {
            Usuario u = ur.findById(usuarioId).orElseThrow();
            usuarios.add(mm.map(u, UsuarioDTO.class));
        }
    return usuarios;
    }
}
