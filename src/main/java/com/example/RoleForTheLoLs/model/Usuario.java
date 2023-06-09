package com.example.RoleForTheLoLs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany (fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> postList;
}
