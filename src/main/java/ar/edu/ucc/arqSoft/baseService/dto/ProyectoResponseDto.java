package ar.edu.ucc.arqSoft.baseService.dto;


import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class ProyectoResponseDto implements DtoEntity{
	
	private String nombre;
	private String descripcion;
	private Long id;
	
	
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
	
	
	
	

}