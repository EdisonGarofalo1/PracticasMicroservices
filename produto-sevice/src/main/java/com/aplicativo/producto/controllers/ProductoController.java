package com.aplicativo.producto.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aplicativo.producto.models.entity.Producto;
import com.aplicativo.producto.service.ProductoService;



@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private  ProductoService productoService;
	
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception {
		return productoService.findById(id);
	}
	
	@GetMapping("/Buscar/{nombre}")
	public List<Producto> BuscarPorNombre(@PathVariable String nombre) throws Exception {
		return productoService.search(nombre);
	}
	
	
	@GetMapping("/buscaCategoria/{id}")
	public List<Producto> ListarProductoCategoria(@PathVariable Long id) throws Exception {
		return productoService.BuscarProductoXcategoria(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) throws Exception {
		return productoService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) throws Exception {

		try {
			Producto productoDB = productoService.findById(id);
			productoDB.setCategoria_id(producto.getCategoria_id());
			productoDB.setNombre(producto.getNombre());
			productoDB.setPrecio(producto.getPrecio());
			
			productoDB.setStock(producto.getStock());
		
			return productoService.save(productoDB);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
