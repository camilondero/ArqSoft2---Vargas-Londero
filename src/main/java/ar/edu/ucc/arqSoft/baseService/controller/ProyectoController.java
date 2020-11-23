package ar.edu.ucc.arqSoft.baseService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.ucc.arqSoft.baseService.dto.ProyectoRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.ProyectoResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.ProyectoService;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {
	
	
	@Autowired
    private ProyectoService proyectoService;
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody ProyectoResponseDto insertProyecto(@RequestBody ProyectoRequestDto request)
    {
        return proyectoService.insertProyecto(request);
    }

	 @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody List<ProyectoResponseDto> getAllProyecto()
	    {
	        return proyectoService.getAllProyecto();
	    }
	 
	 @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody ProyectoResponseDto lookupProyectoById(@PathVariable("id") Long id)
	    {
	        
	    try {
			ProyectoResponseDto dto = proyectoService.getProyectoById(id);		
			return dto;
		} catch (EntityNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyecto no encontrado", e);
			
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
	}
	    }


}