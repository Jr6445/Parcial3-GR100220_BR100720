package com.mitocode.controller;

import com.mitocode.dto.DepartamentoDTO;
import com.mitocode.dto.PatientDTO;
import com.mitocode.dto.SueldoDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Departamentos;
import com.mitocode.model.Patient;
import com.mitocode.model.Sueldo;
import com.mitocode.repo.ISueldoRepo;
import com.mitocode.service.DepartamentoService;
import com.mitocode.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Sueldos")

public class SueldoController {

    @Autowired
    private ISueldoRepo SueldosRepository;


    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<SueldoDTO>> findAll() {
        List<SueldoDTO> list = SueldosRepository.findAll().stream().map(p -> mapper.map(p, SueldoDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SueldoDTO> save(@Valid @RequestBody SueldoDTO dto) {

        double salarioLiquido = calcularSalarioLiquido(dto.getSalario());
        dto.setSalarioLi(salarioLiquido);

        Sueldo p = SueldosRepository.save(mapper.map(dto, Sueldo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(p.getId())
                .toUri();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private double calcularSalarioLiquido(double salarioBruto) {
        double ISSS = 0.03;
        double AFP = 0.0725;
        double impuestoTotal = ISSS + AFP;
        double salario = salarioBruto;
        double salarioLiquido = salario - (impuestoTotal*salario);
        return salarioLiquido;
    }

}
