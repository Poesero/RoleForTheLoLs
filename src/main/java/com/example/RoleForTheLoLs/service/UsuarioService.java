package com.example.RoleForTheLoLs.service;

import com.example.RoleForTheLoLs.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import com.example.RoleForTheLoLs.repository.UsuarioRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class UsuarioService {

    private final UsuarioRepository ur;

    @Autowired
    public UsuarioService(UsuarioRepository ur){this.ur = ur;}


    public ResponseEntity addUsuario(Usuario u){

        try {
            ur.save(u);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public List<Usuario> getAll(){
        return ur.findAll();
    }

    public ResponseEntity updateUsuario(Integer id, Usuario u) {
        Usuario ut = ur.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "usuario no encontrado"));
        ut.setUserName(u.getUserName());
        ut.setUserMail(u.getUserMail());
        ur.save(ut);
        return ResponseEntity.status(OK).build();
    }

    public ResponseEntity deleteUsuario(Integer id){
        try {
            ur.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Usuario getUsuario(Integer id){
        return ur.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "usuario no encontrado"));
    }
}
