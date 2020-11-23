package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Tarea;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

@Repository
public interface TareaDao extends GenericDao<Tarea, Long>  {

	public List<Tarea> findByName(String name);
}
