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
import ar.edu.ucc.arqSoft.common.exception.InvalidRequestException;

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
		//TareaResponseDto response = new TareaResponseDto();		
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		response.setEstadoTarea(tarea.getEstado().getNombre());
		response.setUsuarioTarea((tarea.getUsuario().getNombre()) + " " +(tarea.getUsuario().getApellido()));
		return response;
	}
 
 public TareaResponseDto cambioEstado(Long id, Long request) throws InvalidRequestException, EntityNotFoundException {
	 
	   
	    Tarea tarea = tareaDao.load(id);

	    if(tarea.getEstado().getId() == 1 )
	    {
	    	throw new InvalidRequestException();
	    }
	    
	    else if(tarea.getEstado().getId() == 2 && request == 3 )
	    {
	    	throw new InvalidRequestException();
	    }

	    else if(tarea.getEstado().getId() == 4 && request == 3 && request == 1)
	    {
	    	throw new InvalidRequestException();
	    }
	    
		tarea.setEstado(estadoDao.load(request));
		
		tareaDao.update(tarea);


		Tarea updateTarea = tareaDao.load(id);
		TareaResponseDto response = new TareaResponseDto();
	

		response.setId(updateTarea .getId());
		response.setNombre(updateTarea .getNombre());
		response.setDescripcion(updateTarea .getDescripcion());
		response.setIdUsuario(updateTarea.getUsuario().getId());
		response.setIdProyecto(updateTarea .getProyecto().getId());
		response.setIdEstado(updateTarea.getEstado().getId());
		
		return response;
	}
 
	
}