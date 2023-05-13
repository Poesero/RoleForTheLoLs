package com.example.RoleForTheLoLs.repository;

import com.example.RoleForTheLoLs.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {


}
