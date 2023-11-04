package com.mitocode.controller;

import com.mitocode.dto.EmpleadosDTO;
import com.mitocode.dto.EstadoDto;
import com.mitocode.model.Empleados;
import com.mitocode.model.Estado;
import com.mitocode.repo.IEstadoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Inactivo")
public class EstadoController {

    @Autowired
    private IEstadoRepo estadoRepository;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EstadoDto>> findAll() {
        List<EstadoDto> list = estadoRepository.findAll().stream().map(p -> mapper.map(p, EstadoDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EstadoDto dto) {
        Estado p = estadoRepository.save(mapper.map(dto, Estado.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
