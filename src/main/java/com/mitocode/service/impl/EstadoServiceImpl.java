package com.mitocode.service.impl;

import com.mitocode.model.Departamentos;
import com.mitocode.model.Estado;
import com.mitocode.model.Municipios;
import com.mitocode.repo.IEstadoRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl extends CRUDImpl<Estado,Integer> implements IEstadoService {

    @Autowired
    private IEstadoRepo repo;

    @Override
    protected IGenericRepo<Estado, Integer> getRepo() {
        return repo;
    }
}
