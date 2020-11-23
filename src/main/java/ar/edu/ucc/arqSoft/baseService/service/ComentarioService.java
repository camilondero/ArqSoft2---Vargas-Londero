package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqSoft.baseService.dao.ComentarioDao;
import ar.edu.ucc.arqSoft.baseService.dto.ComentarioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.ComentarioResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Comentario;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;

@Service
@Transactional
public class ComentarioService {

	@Autowired
private ComentarioDao comentarioDao;
	
	public ComentarioResponseDto insertComentario(ComentarioRequestDto request){
		
		Comentario comentario = (Comentario) new ModelDtoConverter().convertToEntity(new Comentario(), request);
		
		comentarioDao.insert(comentario);
		
		ComentarioResponseDto response = (ComentarioResponseDto) new ModelDtoConverter().convertToDto(comentario, new ComentarioResponseDto());	
		
		return response;
	}

public List<ComentarioResponseDto> getAllComentarios() {
		
		List<Comentario> comentarios = comentarioDao.getAll();
		
		List<ComentarioResponseDto> response = new ArrayList<ComentarioResponseDto>();
		 
		for (Comentario comentario : comentarios) {
			response.add((ComentarioResponseDto) new ModelDtoConverter().convertToDto(comentario, new ComentarioResponseDto()));
		}
		
		return response;
	}

}