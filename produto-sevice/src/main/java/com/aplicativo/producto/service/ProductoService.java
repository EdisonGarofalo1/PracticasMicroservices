package com.aplicativo.producto.service;

import java.util.List;

import com.aplicativo.producto.models.entity.Producto;


public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id) throws Exception;
	public Producto save(Producto producto) throws Exception;
	public List<Producto> BuscarProductoXcategoria(Long id)throws Exception;
	public List<Producto> search(String filtro) throws Exception;
	
	
}
