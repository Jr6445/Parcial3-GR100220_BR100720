package com.mitocode.controller;

import com.mitocode.dto.DepartamentoDTO;
import com.mitocode.dto.JugadorDTO;
import com.mitocode.dto.MunicipiosDTO;
import com.mitocode.dto.SueldoDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Departamentos;
import com.mitocode.model.Jugador;
import com.mitocode.model.Municipios;
import com.mitocode.repo.IDepartamentoRepo;
import com.mitocode.repo.IJugadorRepo;
import com.mitocode.repo.IMunicipioRepo;
import com.mitocode.service.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private IDepartamentoRepo departamentoRepository;


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DepartamentoService service;

    @GetMapping
    public ResponseEntity<List<DepartamentoDTO>> findAll() {
        List<DepartamentoDTO> list = departamentoRepository.findAll().stream().map(p -> mapper.map(p, DepartamentoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DepartamentoDTO dto) {
        Departamentos p = departamentoRepository.save(mapper.map(dto, Departamentos.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> findById(@PathVariable("id") Integer id) {
        DepartamentoDTO dtoResponse;
        Departamentos obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(obj, DepartamentoDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }





}
