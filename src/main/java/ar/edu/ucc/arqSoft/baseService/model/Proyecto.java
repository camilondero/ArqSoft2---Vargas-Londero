package ar.edu.ucc.arqSoft.baseService.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.baseService.dto.ProyectoRequestDto;
import ar.edu.ucc.arqSoft.common.model.GenericObject;


@Entity
@Table(name = "PROYECTO")
public class Proyecto extends GenericObject{
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "NOMBRE")
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Usuario> usuarios;
   
   @OneToMany(mappedBy="proyecto", fetch = FetchType.LAZY)
	private Set<Tarea> Tareas;

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

public Set<Usuario> getUsuarios() {
	return usuarios;
}

public void setUsuarios(Set<Usuario> usuarios) {
	this.usuarios = usuarios;
}

public Set<Tarea> getTareas() {
	return Tareas;
}

public void setTareas(Set<Tarea> tareas) {
	Tareas = tareas;
}

public ProyectoRequestDto getUsuario() {
	// TODO Auto-generated method stub
	return null;
}

	
	
}

