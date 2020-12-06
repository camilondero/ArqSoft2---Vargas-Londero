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

import ar.edu.ucc.arqSoft.baseService.dto.ComentarioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.ComentarioResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.ComentarioService;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {
	@Autowired
    private ComentarioService comentarioService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ComentarioResponseDto> getAllComentarios()
    {
        return comentarioService.getAllComentarios();
    }

    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody ComentarioResponseDto insertComentario(@RequestBody ComentarioRequestDto request)
    {
        return comentarioService.insertComentario(request);
    }
    

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ComentarioResponseDto lookupTareaById(@PathVariable("id") Long id) 
    {
        try {
			ComentarioResponseDto dto = comentarioService.getComentarioById(id);	
			return dto;
			
		} catch (EntityNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comentario no encontrado" , e);
			
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
	}
    }

}