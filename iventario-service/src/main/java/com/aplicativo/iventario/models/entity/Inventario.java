package com.aplicativo.iventario.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "inventario",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Inventario  implements Serializable{
	
	



	private static final long serialVersionUID = 1049661891877381871L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invetario_id;


	@Column(name = "nombre")
	    private String nombre;
	


	@Column(name = "cantidad")
	    private Integer cantidad;
	
	



	public Inventario() {
		super();
	}



	public Long getInvetario_id() {
		return invetario_id;
	}



	public void setInvetario_id(Long invetario_id) {
		this.invetario_id = invetario_id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	


}
