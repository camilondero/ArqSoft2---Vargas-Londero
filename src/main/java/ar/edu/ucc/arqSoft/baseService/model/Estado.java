package ar.edu.ucc.arqSoft.baseService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table(name = "ESTADO")
public class Estado extends GenericObject {
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="estado", fetch = FetchType.LAZY)
	private Set<Tarea> tarea;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Tarea> getTarea() {
		return tarea;
	}

	public void setTarea(Set<Tarea> tarea) {
		this.tarea = tarea;
	}

	@Override
	public String toString() {
		return "Estado [nombre=" + nombre + "]";
	}

	

}