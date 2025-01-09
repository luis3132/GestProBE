package com.gestpro.gestpro.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.gestpro.gestpro.domain.dto.roles.RolEmpNuevoDTO;
import com.gestpro.gestpro.domain.dto.roles.RolUsrNuevoDTO;
import com.gestpro.gestpro.domain.dto.roles.RolesNuevoDTO;
import com.gestpro.gestpro.domain.service.interfaces.roles.IRolEmpService;
import com.gestpro.gestpro.domain.service.interfaces.roles.IRolUsrService;
import com.gestpro.gestpro.domain.service.interfaces.roles.IRolesService;
import com.gestpro.gestpro.persistence.entity.Usuario;
import com.gestpro.gestpro.persistence.entity.roles.RolEmp;
import com.gestpro.gestpro.persistence.entity.roles.RolEmpPK;
import com.gestpro.gestpro.persistence.entity.roles.RolUsr;
import com.gestpro.gestpro.persistence.entity.roles.RolUsrPK;
import com.gestpro.gestpro.persistence.entity.roles.Roles;
import com.gestpro.gestpro.persistence.repository.roles.RolEmpRepository;
import com.gestpro.gestpro.persistence.repository.roles.RolUsrRepository;
import com.gestpro.gestpro.persistence.repository.roles.RolesRepository;

import jakarta.transaction.Transactional;

/**
 * 
 * @autor Luis Andres Gonzalez Corzo
 */

@Service
@Transactional
public class RolesService implements IRolesService, IRolUsrService, IRolEmpService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private RolUsrRepository rolUsrRepository;

    @Autowired
    private RolEmpRepository rolEmpRepository;

    @Autowired
    @Lazy
    private UsuarioService usuarioService;

    // ROLES

    @Override
    public Optional<Roles> findById(Integer id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Roles guardarRol(RolesNuevoDTO rol) {
        return rolesRepository.save(convertRolesDTOToEntity(rol));
    }

    // ROL USUARIO

    @Override
    public List<RolUsr> guardarRolUsr(List<RolUsrNuevoDTO> rolUsr) {
        List<RolUsr> rolUsrEntity = new ArrayList<>();
        for (RolUsrNuevoDTO rolUsrNuevoDTO : rolUsr) {
            rolUsrEntity.add(convertRolUsrDTOToEntity(rolUsrNuevoDTO));
        }
        return rolUsrRepository.saveAll(rolUsrEntity);
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
        roles.setRoles(rol.getRoles());
        return roles;
    }

    private RolUsr convertRolUsrDTOToEntity(RolUsrNuevoDTO rolUsr) {
        RolUsr rolUsrEntity = new RolUsr();
        RolUsrPK rolUsrPK = new RolUsrPK();
        Optional<Usuario> usuario = usuarioService.findByCedula(rolUsr.getUsuario());
        Optional<Roles> roles = findById(rolUsr.getRoles());

        if (usuario.isPresent() && roles.isPresent()) {
            rolUsrPK.setRoles(rolUsr.getRoles());
            rolUsrPK.setUsuario(rolUsr.getUsuario());

            rolUsrEntity.setId(rolUsrPK);
            rolUsrEntity.setRoles(roles.get());
            rolUsrEntity.setUsuario(usuario.get());
        }

        return rolUsrEntity;
    }

    private RolEmp convertRolEmpDTOToEntity(RolEmpNuevoDTO rolEmp) {
        RolEmp rolEmpEntity = new RolEmp();
        RolEmpPK rolEmpPK = new RolEmpPK();

        rolEmpPK.setRoles(rolEmp.getRoles());
        rolEmpPK.setEmpleado(rolEmp.getEmpleado());

        rolEmpEntity.setId(rolEmpPK);

        return rolEmpEntity;
    }
}
