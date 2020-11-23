package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.ProyectoDao;
import ar.edu.ucc.arqSoft.baseService.dto.ProyectoRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.ProyectoResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Proyecto;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Service
@Transactional
public class ProyectoService {

	@Autowired
private ProyectoDao proyectoDao;
	
	public ProyectoResponseDto insertProyecto(ProyectoRequestDto request){
		
		Proyecto proyecto = (Proyecto) new ModelDtoConverter().convertToEntity(new Proyecto(), request);
		
		proyectoDao.insert(proyecto);
		
		ProyectoResponseDto response = new ProyectoResponseDto();	
		
		response.setId(proyecto.getId());
		response.setNombre(proyecto.getNombre());
		response.setDescripcion(proyecto.getDescripcion());
		
		return response;
	}
	
	public ProyectoResponseDto getProyectoByName(String name) {
		
		Proyecto proyecto = (Proyecto) proyectoDao.findByName(name);
				
		ProyectoResponseDto response = (ProyectoResponseDto) new ModelDtoConverter().convertToDto(proyecto, new ProyectoResponseDto());	
		return response;
	}
	
	public ProyectoResponseDto getProyectoById(Long id) throws EntityNotFoundException, BadRequestException {

		if (id <= 0) {
			
			throw new BadRequestException();
		}
		
		Proyecto proyecto = proyectoDao.load(id);
				
		ProyectoResponseDto response = (ProyectoResponseDto) new ModelDtoConverter().convertToDto(proyecto, new ProyectoResponseDto());	
		return response;
	}
	
	public List<ProyectoResponseDto> getAllProyecto() {
		
		List<Proyecto> proyectos = proyectoDao.getAll();
		
		List<ProyectoResponseDto> response = new ArrayList<ProyectoResponseDto>();
		 
		for (Proyecto proyecto : proyectos) {
			response.add((ProyectoResponseDto) new ModelDtoConverter().convertToDto(proyecto, new ProyectoResponseDto()));
		}
		
		return response;
	}
}
