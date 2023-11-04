package com.mitocode.controller;

import com.mitocode.dto.DepartamentoDTO;
import com.mitocode.dto.MunicipiosDTO;
import com.mitocode.model.Departamentos;
import com.mitocode.model.Municipios;
import com.mitocode.repo.IDepartamentoRepo;
import com.mitocode.repo.IMunicipioRepo;
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
@RequestMapping("/municipios")
public class MunicipiosController {

    @Autowired
    private IMunicipioRepo municipioRepository;
    @Autowired
    private IDepartamentoRepo departamentoRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public MunicipiosController(IDepartamentoRepo departamentoRepository, IMunicipioRepo municipioRepository) {
        this.departamentoRepository = departamentoRepository;
        this.municipioRepository = municipioRepository;
    }

    @GetMapping
    public ResponseEntity<List<MunicipiosDTO>> findAll() {
        List<MunicipiosDTO> list = municipioRepository.findAll().stream().map(p -> mapper.map(p, MunicipiosDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody MunicipiosDTO dto) {
        Municipios p = municipioRepository.save(mapper.map(dto, Municipios.class));
        //localhost:8080/medics/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }





}
