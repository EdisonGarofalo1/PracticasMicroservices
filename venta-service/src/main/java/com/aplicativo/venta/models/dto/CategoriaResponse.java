package com.aplicativo.venta.models.dto;



public class CategoriaResponse {

	private Long categoria_id;

	private String nombre;

	public CategoriaResponse() {
		super();
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
