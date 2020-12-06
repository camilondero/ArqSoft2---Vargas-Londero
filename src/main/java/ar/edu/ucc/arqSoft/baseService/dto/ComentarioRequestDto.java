package ar.edu.ucc.arqSoft.baseService.dto;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class ComentarioRequestDto implements DtoEntity{
	
	
	private String detalle;
	private Long idUsuario;
	private Long idTarea;

	

	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	
}