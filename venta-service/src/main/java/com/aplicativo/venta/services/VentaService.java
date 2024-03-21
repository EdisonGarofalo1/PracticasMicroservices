package com.aplicativo.venta.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aplicativo.venta.models.dto.ProductoDto;
import com.aplicativo.venta.models.dto.VentaDto;
import com.aplicativo.venta.models.entity.Venta;


@Service
public interface VentaService {
	public List<Venta> findAll();
	

	public Venta findById(Long id) throws Exception;
	public Venta  RealizarVenta(VentaDto  ventaDTO );
	public Venta  ActualizarVenta( Long id ,VentaDto  ventaDTO );
	
	
	//RestTemplate
	public List<ProductoDto> buscarProductoPorNombre( String nombre) throws Exception;
	public ProductoDto saveproductoRestTemplate(ProductoDto  productoDto ) throws Exception;
	public ProductoDto actualizarproductoRestTemplate(Long id ,ProductoDto  productoDto ) throws Exception;
	
	//Productofeignventa
	
	public ProductoDto saveproducto(ProductoDto  productoDto ) throws Exception;
	
	public ProductoDto  editarProductoFeing( Long id ,ProductoDto  producto)throws Exception;
	
	public ProductoDto findByIdProducto(Long id) throws Exception;
}
