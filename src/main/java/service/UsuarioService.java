package service;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import repository.UsuarioRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Service
public class UsuarioService {

    private final UsuarioRepository ur;

    @Autowired
    public ServicioUsuario(UsuarioRepository ur){this.ur = ur;}

    public ResponseEntity addUsuario(Usuario u){
        ur.save(u);
        return ResponseEntity.status(CREATED).build();
    }

    public List<Usuario> getAll(){return ur.findAll();}

    public ResponseEntity updateUsuario(Integer id, Usuario u) {
        Usuario ut = ur.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "usuario no encontrado"));
        ut.setUserName(u.getUserName());
    }
}
