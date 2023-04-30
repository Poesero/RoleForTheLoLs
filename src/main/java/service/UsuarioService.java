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
import static org.springframework.http.HttpStatus.OK;

@Service
public class UsuarioService {

    private final UsuarioRepository ur;

    @Autowired
    public UsuarioService(UsuarioRepository ur){this.ur = ur;}


    public ResponseEntity addUsuario(Usuario u){
        ur.save(u);
        return ResponseEntity.status(CREATED).build();
    }

    public List<Usuario> getAll(){return ur.findAll();}

    public ResponseEntity updateUsuario(Integer id, Usuario u) {
        Usuario ut = ur.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "usuario no encontrado"));
        ut.setUserName(u.getUserName());
        ut.setUserMail(u.getUserMail());
        ur.save(ut);
        return ResponseEntity.status(OK).build();
    }

    public ResponseEntity deleteUsuario(Integer id){
        ur.deleteById(id);
        return ResponseEntity.status(OK).build();
    }

    public Usuario getUsuario(Integer id){
        return ur.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "usuario no encontrado"));
    }
}
