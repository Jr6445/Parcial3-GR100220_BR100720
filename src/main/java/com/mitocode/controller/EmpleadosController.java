package com.mitocode.controller;

import com.mitocode.dto.DepartamentoDTO;
import com.mitocode.dto.EmpleadosDTO;
import com.mitocode.model.Departamentos;
import com.mitocode.model.Empleados;
import com.mitocode.repo.IDepartamentoRepo;
import com.mitocode.repo.IEmpleadoRepo;
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
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private IEmpleadoRepo empleadoRepository;

    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<EmpleadosDTO>> findAll() {
        List<EmpleadosDTO> list = empleadoRepository.findAll().stream().map(p -> mapper.map(p, EmpleadosDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EmpleadosDTO dto) {
        Empleados p = empleadoRepository.save(mapper.map(dto, Empleados.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
