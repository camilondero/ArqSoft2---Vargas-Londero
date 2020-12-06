package ar.edu.ucc.arqSoft.baseService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.ucc.arqSoft.baseService.dto.TareaRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.TareaResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.TareaService;
import ar.edu.ucc.arqSoft.common.dto.GenericExceptionDto;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/tarea")

public class TareaController {
	
	@Autowired
    private TareaService tareaService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<TareaResponseDto> getAllTareas()
    {
        return tareaService.getAllTareas();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TareaResponseDto lookupTareaById(@PathVariable("id") Long id) 
    {
        try {
			TareaResponseDto dto = tareaService.getTareaById(id);	
			return dto;
			
		} catch (EntityNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada" , e);
			
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
	}
    }
    
    @RequestMapping(value = "/cambiarEstado/{id}", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> cambiarEstado(@PathVariable("id") Long id, @RequestBody Long request){
       
    	try {
    	TareaResponseDto dto = tareaService.cambioEstado(id, request);
    	return new ResponseEntity<Object>(dto, HttpStatus.OK);
    	} catch (EntityNotFoundException e) {
			GenericExceptionDto exDto = new GenericExceptionDto("404", "El estado o tarea no se encontraron");
			return new ResponseEntity<Object>(exDto, HttpStatus.NOT_FOUND);
    }
    	
    }
      
}