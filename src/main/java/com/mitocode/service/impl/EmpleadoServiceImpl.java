package com.mitocode.service.impl;

import com.mitocode.model.Empleados;
import com.mitocode.model.Exam;
import com.mitocode.repo.IEmpleadoRepo;
import com.mitocode.repo.IExamRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEmpleadoService;
import com.mitocode.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoServiceImpl extends CRUDImpl<Empleados, Integer> implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepo repo;

    @Override
    protected IGenericRepo<Empleados, Integer> getRepo() {
        return repo;
    }
}
