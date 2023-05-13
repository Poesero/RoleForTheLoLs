package com.example.RoleForTheLoLs.repository;

import com.example.RoleForTheLoLs.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query(value =" select usuario_id from usuario_post where post_id = : postId",nativeQuery = true)
    List<Integer> findUsuarioByPostid(Integer postId);
}
