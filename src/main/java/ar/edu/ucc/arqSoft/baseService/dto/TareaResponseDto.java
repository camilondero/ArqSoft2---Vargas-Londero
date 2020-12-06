package ar.edu.ucc.arqSoft.baseService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class TareaResponseDto implements DtoEntity{

	private String nombre;
	private String descripcion;
	private Long id;
	@JsonIgnore
	private Long idProyecto;
	@JsonIgnore
	private Long idEstado;
	@JsonIgnore
	private Long idUsuario;
	@JsonProperty("nombre_proyecto")
	private String nombreProyecto;
	@JsonProperty("estado_tarea")
	private String estadoTarea;
	@JsonProperty("usuario_tarea")
	private String usuarioTarea;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getEstadoTarea() {
		return estadoTarea;
	}
	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}
	public String getUsuarioTarea() {
		return usuarioTarea;
	}
	public void setUsuarioTarea(String usuarioTarea) {
		this.usuarioTarea = usuarioTarea;
	}
    
	
	
	
}
