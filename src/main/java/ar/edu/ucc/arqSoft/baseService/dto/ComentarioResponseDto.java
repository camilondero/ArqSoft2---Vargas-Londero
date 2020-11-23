package ar.edu.ucc.arqSoft.baseService.dto;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class ComentarioResponseDto implements DtoEntity {
	
	private String description;
	private Long idUsurario;
	private Long idTarea;
	private Long id;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIdUsurario() {
		return idUsurario;
	}
	public void setIdUsurario(Long idUsurario) {
		this.idUsurario = idUsurario;
	}
	public Long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
