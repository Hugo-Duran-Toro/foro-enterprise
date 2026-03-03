package com.example.foro.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TopicoRequest {

    @NotBlank
    @Size(min = 5)
    private String titulo;

    @NotBlank
    @Size(min = 10)
    private String mensaje;

    @NotBlank
    private String curso;

    @NotNull
    private Long usuarioId;
}
