package ar.edu.ucc.arqSoft.baseService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class ComentarioResponseDto implements DtoEntity {
	
	private String detalle;
	@JsonIgnore
	private Long idUsuario;
	@JsonIgnore
	private Long idTarea;
	private Long id;
	@JsonProperty("tarea_comentario")
	private String tareaComentario;
	@JsonProperty("usuario_comentario")
	private String usuarioComentario;
	
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTareaComentario() {
		return tareaComentario;
	}
	public void setTareaComentario(String tareaComentario) {
		this.tareaComentario = tareaComentario;
	}
	public String getUsuarioComentario() {
		return usuarioComentario;
	}
	public void setUsuarioComentario(String usuarioComentario) {
		this.usuarioComentario = usuarioComentario;
	}
	
	

}
