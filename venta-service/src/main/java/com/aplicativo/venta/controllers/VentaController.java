package com.aplicativo.venta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.aplicativo.venta.models.dto.ProductoDto;
import com.aplicativo.venta.models.dto.VentaDto;
import com.aplicativo.venta.models.entity.Venta;
import com.aplicativo.venta.services.VentaService;




@RestController
@RequestMapping("/api/ventas")

public class VentaController {
	
	   @Autowired
	    private  VentaService ventaService;
	   
	   

		@GetMapping("/listar")
	
		public List<Venta> listar() {
			return ventaService.findAll();
		}
		
		@GetMapping("/ver/{id}")
	
		public Venta detalle(@PathVariable Long id) throws Exception {
			return ventaService.findById(id);
		}
		
		@GetMapping("/buscarProducto/{id}")
		
		public ProductoDto producto(@PathVariable Long id) throws Exception {
			return ventaService.findByIdProducto(id);
		}
		
		
		  @PutMapping("update/{id}")
		    public ProductoDto actualizarproductoRestTemplate(@PathVariable Long id, @RequestBody ProductoDto productoDto)throws Exception {
			
		       try {
		    	   
		    	 return ventaService.actualizarproductoRestTemplate(id, productoDto);
		    	   
		       } catch (Exception e) {
					throw new Exception(e.getMessage());
				}
		      
		        
		  }
		  
		  
		  @PutMapping("updateFei/{id}")
		    public ProductoDto editarProductoFeing(@PathVariable Long id, @RequestBody ProductoDto productoDto)throws Exception {
			
		       try {
		    	   
		    	 return ventaService.editarProductoFeing(id, productoDto);
		    	   
		       } catch (Exception e) {
					throw new Exception(e.getMessage());
				}
		      
		        
		  }
		   
			
		   @PostMapping("/guadarproducto")
			@ResponseStatus(HttpStatus.CREATED)
			public ProductoDto crear(@RequestBody ProductoDto producto) throws Exception {
				return ventaService.saveproducto(producto);
			}
		   
		   
		   
		   
		   @PostMapping("/saveproducto")
			@ResponseStatus(HttpStatus.CREATED)
			public ProductoDto  saveproductoRestTemplate(@RequestBody ProductoDto producto) throws Exception {
				return ventaService.saveproductoRestTemplate(producto);
			}
		  
	   @PostMapping("/realiarventa")
	
	    public ResponseEntity<Venta> procesarVenta(@RequestBody VentaDto ventaDTO) {
		   
	
		    Venta ventaGuardada =   ventaService.RealizarVenta(ventaDTO);
	        return new ResponseEntity<>( ventaGuardada,HttpStatus.CREATED);
	        
		  
	        
	        
	    }
	   
	   @GetMapping("/buscar/{nombre}")
	   
		public List<ProductoDto> BuscarPorNombre(@PathVariable String nombre) throws Exception {
			return ventaService.buscarProductoPorNombre(nombre);
		}
	   
	   @PutMapping("/{id}")
	    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody VentaDto ventaDTO) {
	        Venta ventaActualizada = ventaService.ActualizarVenta(id, ventaDTO);
	        if (ventaActualizada != null) {
	            return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}
