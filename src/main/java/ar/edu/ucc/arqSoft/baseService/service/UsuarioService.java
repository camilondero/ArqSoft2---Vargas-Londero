package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.UsuarioDao;
import ar.edu.ucc.arqSoft.baseService.dto.UsuarioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.UsuarioResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Usuario;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	public UsuarioResponseDto insertUsuario(UsuarioRequestDto request){
		
		Usuario usuario = (Usuario) new ModelDtoConverter().convertToEntity(new Usuario(), request);
		
		usuarioDao.insert(usuario);
		
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		
		return response;
	}
	
	public UsuarioResponseDto getUsuarioByName(String name) {
		
		Usuario usuario = (Usuario) usuarioDao.findByName(name);
				
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		return response;
	}
	
	public UsuarioResponseDto getUsuarioById(Long id) throws EntityNotFoundException, BadRequestException {

		if (id <= 0) {
			
			throw new BadRequestException();
		}
        
		Usuario usuario = usuarioDao.load(id);
				
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		return response;
	}
	
	public List<UsuarioResponseDto> getAllUsuarios() {
		
		List<Usuario> usuarios = usuarioDao.getAll();
		
		List<UsuarioResponseDto> response = new ArrayList<UsuarioResponseDto>();
		 
		for (Usuario usuario : usuarios) {
			response.add((UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto()));
		}
		
		return response;
	}
	
}
