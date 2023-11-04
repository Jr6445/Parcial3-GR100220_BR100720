package com.mitocode.service.impl;

import com.mitocode.model.Departamentos;
import com.mitocode.model.Jugador;
import com.mitocode.model.Medic;
import com.mitocode.repo.IDepartamentoRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IJugadorRepo;
import com.mitocode.service.DepartamentoService;
import com.mitocode.service.IMedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl extends CRUDImpl<Departamentos, Integer> implements DepartamentoService {

    @Autowired
    private IDepartamentoRepo repo;

    @Override
    protected IGenericRepo<Departamentos, Integer> getRepo() {
        return repo;
    }
}
