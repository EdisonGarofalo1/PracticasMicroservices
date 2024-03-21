package com.aplicativo.categoria.services;

import java.util.List;

import com.aplicativo.categoria.models.entity.Categoria;



public interface CategoriaService {
	
	public List<Categoria> findAll();
	public Categoria findById(Long id) throws Exception;
	public Categoria save(Categoria categoria) throws Exception;
	public List<Categoria> search(String filtro);
	


}
