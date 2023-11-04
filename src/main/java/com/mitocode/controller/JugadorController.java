package com.mitocode.controller;


import com.mitocode.dto.JugadorDTO;
import com.mitocode.dto.MedicDTO;
import com.mitocode.model.Jugador;
import com.mitocode.model.Medic;
import com.mitocode.repo.IJugadorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorRepo jugadorRepository;


    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<JugadorDTO>> findAll() {
        List<JugadorDTO> list = jugadorRepository.findAll().stream().map(p -> mapper.map(p, JugadorDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody JugadorDTO dto) {
        Jugador p = jugadorRepository.save(mapper.map(dto, Jugador.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
