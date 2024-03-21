package com.aplicativo.iventario.services;

import java.util.List;

import com.aplicativo.iventario.models.entity.Inventario;



public interface InventarioService {
	
	public List<Inventario> findAll();
	public Inventario findById(Long id) throws Exception;
	public Inventario save(Inventario inventario) throws Exception;
	public List<Inventario> search(String filtro);
	

}
