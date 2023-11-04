package com.mitocode.service.impl;

import com.mitocode.model.Jugador;
import com.mitocode.model.Municipios;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IJugadorRepo;
import com.mitocode.repo.IMunicipioRepo;
import com.mitocode.service.IJugadorService;
import com.mitocode.service.IMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioServiceImpl extends CRUDImpl<Municipios,Integer> implements IMunicipioService {

    @Autowired
    private IMunicipioRepo repo;

    @Override
    protected IGenericRepo<Municipios, Integer> getRepo() {
        return repo;
    }


}