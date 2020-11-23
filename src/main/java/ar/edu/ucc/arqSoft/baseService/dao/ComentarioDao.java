package ar.edu.ucc.arqSoft.baseService.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Comentario;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

@Repository
public interface ComentarioDao extends GenericDao<Comentario, Long>{

}
