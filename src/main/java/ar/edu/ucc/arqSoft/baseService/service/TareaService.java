package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqSoft.baseService.dao.EstadoDao;
import ar.edu.ucc.arqSoft.baseService.dao.TareaDao;
import ar.edu.ucc.arqSoft.baseService.dto.TareaRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.TareaResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Tarea;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Service
@Transactional
public class TareaService {

	@Autowired
	private TareaDao tareaDao;
	
	@Autowired
	private EstadoDao estadoDao;
	
 public TareaResponseDto insertTarea(TareaRequestDto request){
		
		Tarea tarea = (Tarea) new ModelDtoConverter().convertToEntity(new Tarea(), request);
		
		tareaDao.insert(tarea);
		
		TareaResponseDto response = new TareaResponseDto();
		
		response.setId(tarea.getId());
		response.setNombre(tarea.getNombre());
		response.setDescripcion(tarea.getDescripcion());
		response.setIdUsuario(tarea.getUsuario().getId());
		response.setIdProyecto(tarea.getProyecto().getId());
		response.setIdEstado(tarea.getEstado().getId());
		
		
		return response;
	}
 
 
 public List<TareaResponseDto> getAllTareas() {
		List<Tarea> tareas = tareaDao.getAll();
		
		List<TareaResponseDto> response = new ArrayList<TareaResponseDto>();
		 
		for (Tarea tarea : tareas) {
			response.add((TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto()));
		}
		
		return response;
	}
 
 public TareaResponseDto getTareaByName(String name) {
		
		Tarea tarea = (Tarea) tareaDao.findByName(name);
				
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		return response;
	}
 
 
 public TareaResponseDto getTareaById(Long id) throws EntityNotFoundException, BadRequestException{
	
	 if (id <= 0) {
			
			throw new BadRequestException();
		}
	    
	    Tarea tarea = tareaDao.load(id);
				
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		return response;
	}
 
 public TareaResponseDto cambioEstado(Long id, Long request) throws EntityNotFoundException {
	 
	    Tarea tarea = tareaDao.load(id);

		tarea.setEstado(estadoDao.load(request));
		tareaDao.update(tarea);

		Tarea task_after_update = tareaDao.load(id);
		TareaResponseDto response = new TareaResponseDto();

		response.setId(task_after_update.getId());
		response.setNombre(task_after_update.getNombre());
		response.setDescripcion(task_after_update.getDescripcion());
		response.setIdUsuario(task_after_update.getUsuario().getId());
		response.setIdProyecto(task_after_update.getProyecto().getId());
		response.setIdEstado(task_after_update.getEstado().getId());
		return response;
	}
 
	
}