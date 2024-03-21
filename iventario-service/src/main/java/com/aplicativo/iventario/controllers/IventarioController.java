package com.aplicativo.iventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import com.aplicativo.iventario.models.entity.Inventario;
import com.aplicativo.iventario.services.InventarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/Iventario")
public class IventarioController {
	
	
	@Autowired
	private InventarioService  InventarioService;
	
	@GetMapping("/listar")

	public List<Inventario> listar() {
		return InventarioService.findAll();
	}
	
	@GetMapping("/ver/{id}")

	public Inventario detalle(@PathVariable Long id) throws Exception {
		return InventarioService.findById(id);
	}
	
	
	@PostMapping("/crear")

	@ResponseStatus(HttpStatus.CREATED)
	public Inventario crear(@RequestBody Inventario inventario) throws Exception {
		return InventarioService.save(inventario);
	}
	
	@PutMapping("/editar/{id}")

	@ResponseStatus(HttpStatus.CREATED)
	public Inventario editar(@RequestBody Inventario inventario, @PathVariable Long id) throws Exception {

		try {
			Inventario invetarioDB = InventarioService.findById(id);
			invetarioDB.setNombre(inventario.getNombre());
			invetarioDB.setCantidad(inventario.getCantidad());
			return InventarioService.save(invetarioDB);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


}
