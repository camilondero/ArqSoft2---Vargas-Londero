package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Usuario;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

@Repository
public interface UsuarioDao extends GenericDao<Usuario, Long> {
    
    public List<Usuario> findByName(String name);
}
