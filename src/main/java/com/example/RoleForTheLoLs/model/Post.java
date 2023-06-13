package com.example.RoleForTheLoLs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_Id")
    private Usuario usuario;

}
