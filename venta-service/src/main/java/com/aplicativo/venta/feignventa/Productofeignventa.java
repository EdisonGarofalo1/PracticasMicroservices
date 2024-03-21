package com.aplicativo.venta.feignventa;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


import com.aplicativo.venta.models.dto.ProductoDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "producto-service",url = "http://localhost:8184")
@RequestMapping("/api/producto")

public interface Productofeignventa {
	

	@PostMapping("/crear")
	public ProductoDto save(@RequestBody ProductoDto producto);
	
	@GetMapping("/ver/{id}")
	public ProductoDto buscaridProducto(@PathVariable("id") Long id);
	
	
	@PutMapping("/editar/{id}")
	public ProductoDto editarProductoFeing( @PathVariable Long id, @RequestBody ProductoDto producto);
	

}
