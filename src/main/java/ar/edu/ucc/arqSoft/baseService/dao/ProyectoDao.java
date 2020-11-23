package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Proyecto;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;
@Repository
public interface ProyectoDao extends GenericDao<Proyecto, Long>{

    public List<Proyecto> findByName(String name);

}
