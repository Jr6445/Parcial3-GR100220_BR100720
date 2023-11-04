package com.mitocode.service.impl;

import com.mitocode.model.Municipios;
import com.mitocode.model.Sueldo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMunicipioRepo;
import com.mitocode.repo.ISueldoRepo;
import com.mitocode.service.IMunicipioService;
import com.mitocode.service.ISueldoService;
import com.mitocode.service.impl.CRUDImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class SueldoServiceImpl extends CRUDImpl<Sueldo,Integer> implements ISueldoService {

    @Autowired
    private ISueldoRepo repo;

    @Override
    protected IGenericRepo<Sueldo, Integer> getRepo() {
        return repo;
    }


}