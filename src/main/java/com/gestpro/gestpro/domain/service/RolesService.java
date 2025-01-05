package com.gestpro.gestpro.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.roles.RolEmpNuevoDTO;
import com.gestpro.gestpro.domain.dto.roles.RolUsrNuevoDTO;
import com.gestpro.gestpro.domain.dto.roles.RolesNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.roles.IRolEmpService;
import com.gestpro.gestpro.domain.service.interfaces.roles.IRolUsrService;
import com.gestpro.gestpro.domain.service.interfaces.roles.IRolesService;
import com.gestpro.gestpro.persistence.entity.roles.RolEmp;
import com.gestpro.gestpro.persistence.entity.roles.RolEmpPK;
import com.gestpro.gestpro.persistence.entity.roles.RolUsr;
import com.gestpro.gestpro.persistence.entity.roles.RolUsrPK;
import com.gestpro.gestpro.persistence.entity.roles.Roles;
import com.gestpro.gestpro.persistence.repository.roles.RolEmpRepository;
import com.gestpro.gestpro.persistence.repository.roles.RolUsrRepository;
import com.gestpro.gestpro.persistence.repository.roles.RolesRepository;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
public class RolesService implements IRolesService, IRolUsrService, IRolEmpService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private RolUsrRepository rolUsrRepository;

    @Autowired
    private RolEmpRepository rolEmpRepository;

    // ROLES

    @Override
    public Roles guardarRol(RolesNuevoDTO rol) {
        return rolesRepository.save(convertRolesDTOToEntity(rol));
    }

    // ROL USUARIO

    @Override
    public RolUsr guardarRolUsr(RolUsrNuevoDTO rolUsr) {
        return rolUsrRepository.save(convertRolUsrDTOToEntity(rolUsr));
    }

    @Override
    public Boolean eliminarRolUsr(RolUsrPK rolUsr) {
        if (rolUsrRepository.existsById(rolUsr)) {
            rolUsrRepository.deleteById(rolUsr);
            return true;
        }
        return false;
    }

    // ROL EMPLEADO

    @Override
    public RolEmp guardarRolEmp(RolEmpNuevoDTO rolEmp) {
        return rolEmpRepository.save(convertRolEmpDTOToEntity(rolEmp));
    }

    @Override
    public Boolean eliminarRolEmp(RolEmpPK rolEmp) {
        if (rolEmpRepository.existsById(rolEmp)) {
            rolEmpRepository.deleteById(rolEmp);
            return true;
        }
        return false;
    }

    // CONVERTERS

    private Roles convertRolesDTOToEntity(RolesNuevoDTO rol) {
        Roles roles = new Roles();
        roles.setRol(rol.getRol());
        return roles;
    }

    private RolUsr convertRolUsrDTOToEntity(RolUsrNuevoDTO rolUsr) {
        RolUsr rolUsrEntity = new RolUsr();
        RolUsrPK rolUsrPK = new RolUsrPK();

        rolUsrPK.setRol(rolUsr.getRol());
        rolUsrPK.setUsuario(rolUsr.getUsuario());

        rolUsrEntity.setId(rolUsrPK);

        return rolUsrEntity;
    }

    private RolEmp convertRolEmpDTOToEntity(RolEmpNuevoDTO rolEmp) {
        RolEmp rolEmpEntity = new RolEmp();
        RolEmpPK rolEmpPK = new RolEmpPK();

        rolEmpPK.setRol(rolEmp.getRol());
        rolEmpPK.setEmpleado(rolEmp.getEmpleado());

        rolEmpEntity.setId(rolEmpPK);

        return rolEmpEntity;
    }
}
