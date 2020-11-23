package ar.edu.ucc.arqSoft.baseService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table( name = "COMENTARIO")
public class Comentario extends GenericObject {

	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "DETALLE")
	String detalle;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Tarea_ID")
	private Tarea tarea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuario;

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}