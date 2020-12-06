package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqSoft.baseService.dao.ComentarioDao;
import ar.edu.ucc.arqSoft.baseService.dto.ComentarioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.ComentarioResponseDto;
import ar.edu.ucc.arqSoft.baseService.dto.TareaResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Comentario;
import ar.edu.ucc.arqSoft.baseService.model.Tarea;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

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

public ComentarioResponseDto getComentarioById(Long id) throws EntityNotFoundException, BadRequestException{
	
	 if (id <= 0) {
			
			throw new BadRequestException();
		}
	    
	    Comentario comentario = comentarioDao.load(id);
		//TareaResponseDto response = new TareaResponseDto();		
		ComentarioResponseDto response = (ComentarioResponseDto) new ModelDtoConverter().convertToDto(comentario, new ComentarioResponseDto());	
		response.setTareaComentario(comentario.getTarea().getNombre());
		response.setUsuarioComentario((comentario.getUsuario().getNombre()) + " " +(comentario.getUsuario().getApellido()));
		return response;
	}


}
