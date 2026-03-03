package com.example.foro.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String curso;

    @ManyToOne
    private Usuario usuario;
}
