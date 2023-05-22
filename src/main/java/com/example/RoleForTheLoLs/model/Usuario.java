package com.example.RoleForTheLoLs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;
    private String userMail;


    @OneToMany (mappedBy = "usuarioId", cascade = CascadeType.ALL)
    private List<Post> postList;
}
