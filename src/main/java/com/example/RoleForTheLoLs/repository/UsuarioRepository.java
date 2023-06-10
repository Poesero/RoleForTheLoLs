package com.example.RoleForTheLoLs.repository;

import com.example.RoleForTheLoLs.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query(value =" select post_id from post_usuario where usuario_id = : usuarioId",nativeQuery = true)
    List<Integer> findPostByUsuarioId(Integer usuarioId);

   /* Me rindo...

    @Query(value =" select user_name from usuario where user_name = : username",nativeQuery = true)
    List<String> findUserByName(String username);
    */

}
