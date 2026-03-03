package com.example.foro.controller;

import com.example.foro.dto.TopicoRequest;
import com.example.foro.model.Topico;
import com.example.foro.repository.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoRepository repository;
    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Topico> crear(@Valid @RequestBody TopicoRequest request) {

        var usuario = usuarioRepository.findById(request.getUsuarioId()).orElseThrow();

        Topico topico = new Topico();
        topico.setTitulo(request.getTitulo());
        topico.setMensaje(request.getMensaje());
        topico.setCurso(request.getCurso());
        topico.setUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(topico));
    }
}
