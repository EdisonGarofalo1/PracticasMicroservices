package com.aplicativo.iventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.aplicativo.iventario.models.entity.Inventario;
import com.aplicativo.iventario.repository.InventarioRepository;

public class InventarioServiceImp   implements InventarioService{
	

	@Autowired
	   private  InventarioRepository inventarioRepository;

	@Override
	public List<Inventario> findAll() {
	
		return (List<Inventario>) inventarioRepository.findAll();
	}

	@Override
	public Inventario findById(Long id) throws Exception {
		
		try {
			return inventarioRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Inventario save(Inventario inventario) throws Exception {
	
		
		try {
			return inventarioRepository.save(inventario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Inventario> search(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
