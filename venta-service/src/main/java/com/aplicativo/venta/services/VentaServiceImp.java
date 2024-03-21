package com.aplicativo.venta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aplicativo.venta.exception.MyException;
import com.aplicativo.venta.feignventa.Productofeignventa;
import com.aplicativo.venta.models.dto.ProductoDto;
import com.aplicativo.venta.models.dto.VentaDto;



import com.aplicativo.venta.models.entity.Venta;

import com.aplicativo.venta.repository.VentaRepository;


import org.springframework.core.ParameterizedTypeReference;



@Service
public class VentaServiceImp  implements VentaService{

	
	@Autowired
	private  RestTemplate restTemplate;

	//@Autowired
	//private  Productofeignventa productofeignventa;
	
	@Autowired
	private Productofeignventa productofeignventa;
	
	 
	
	@Autowired
	private VentaRepository ventaRepository;
	
	
	
    
    
//	@Autowired
//	private DetVentaRepository detVentaRepository;
	@Override
	public List<Venta> findAll() {
	      return(List<Venta>) ventaRepository.findAll();
	}

	
	
	
	@Override
	public Venta  RealizarVenta(VentaDto ventaDTO) {
		
		try {
			
			
			Venta venta = new Venta();
			
			venta.setFecha(ventaDTO.getFecha()); 
			venta.setTotal(ventaDTO.getTotal()); 
			
			  if (ventaDTO.getTotal() == null) {
	              throw new IllegalArgumentException("El tota no puede ser nula");
	          }
			  
			  if (ventaDTO.getCliente_id() == null) {
	              throw new IllegalArgumentException("El id clientess no puede ser nula");
	          }

			 
			  
			  return null;
	    	  
			 /*
			    if (result != null) {
			    	
			    	  System.out.println("La solicitud fue exitosa. Resultado obtenido: " + result);
			    	  
			    	  return null;
			    	  
			    	  venta.setCliente(result); 
			    	
			    	  
			    	  
			    	  for (DetalleVentaDTO detalleDTO : ventaDTO.getDetallesVenta()) {
			    		  
			    		  
			    		
			    		  Producto producto = this.webClientBuilder.build()
					                .get()
					                .uri("http://localhost:8184/api/producto/ver/{id}",detalleDTO.getProducto_id())
					                
					               // .contentType(MediaType.APPLICATION_JSON) // Tipo de contenido del cuerpo de la solicitud
					               /// .bodyValue(ventaDTO) // Los datos a enviar para guardar, puedes pasar un objeto VentaDTO directamente si coincide con la estructura esperada en el servicio
					                
					               // .bodyValue(detalleDTO.getProducto_id())
					                .retrieve()
					                .bodyToMono(Producto.class)
					                .block();
			    		  
			    		   if (producto.getStock() < detalleDTO.getCantidad()) {
				                throw new RuntimeException("No hay suficiente stock para el producto " + producto.getNombre());
				            }
			    		   
			    		   DetalleVenta detalleVenta = new DetalleVenta();
				            detalleVenta.setProducto(producto);
				            detalleVenta.setCantidad(detalleDTO.getCantidad());
				            detalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
				            detalleVenta.setSubtotal(detalleDTO.getSubtotal());
				            detalleVenta.setVenta(venta);
				            venta.agregarDetalleVenta(detalleVenta);
				            // Actualizar el stock del producto
				            producto.setStock(producto.getStock() - detalleDTO.getCantidad());
				           // productoRepository.save(producto);
				            
				            BaseResponse resulta = this.webClientBuilder.build()
				            		.put()
				                    .uri("http://localhost:8184/api/producto/editar/{id}",producto.getProducto_id())
				             
						             .bodyValue(producto) // Los datos a enviar para guardar, puedes pasar un objeto VentaDTO directamente si coincide con la estructura esperada en el servicio
						                
				                    .retrieve()
				                    .bodyToMono(BaseResponse.class)
				                    .block();
				            
				            if (resulta != null && !resulta.hasErrors()) {
				            	
				            	
				            	 throw new IllegalArgumentException("se actualizo corretamente");
				            	
				            }else {
				            	
				            	
				            	 throw new IllegalArgumentException("no se puedo actualizar");
				            }
				            
				            
			    	  }
			    	  
			 		
			    	  
			    	  Venta ventaGuardada = ventaRepository.save(venta);
			 		 
			 		 return ventaGuardada;
			 		 
			 		 
			 	
			    	
			    }else {
			  	  System.out.println("La solicitud fue exitosa. Resultado obtenido: " + result);
			    	
			    	return null;
			    }
			*/
		
			
		}catch (Exception e) {
		       
            throw new MyException("Error al procesar la venta completa", e);
        }

		
	}




	@Override
	public Venta findById(Long id) throws Exception {
	
		try {
			return ventaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}



	//ResponseEntity<String> 
	//return ResponseEntity.ok("Venta al por mayor realizada con éxito");
	@Override
	public Venta ActualizarVenta(Long id, VentaDto ventaDTO) {
		
		/*
		
		  try {
	
	    Venta ventaExistente = ventaRepository.findById(id).orElse(null);
        if (ventaExistente != null) {
    		
        Cliente cliente = clienteRepository.findById(ventaDTO.getCliente_id())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + ventaDTO.getCliente_id()));
    		

        ventaExistente.setCliente(cliente);
        ventaExistente.setFecha(ventaDTO.getFecha());
        ventaExistente.setTotal(ventaDTO.getTotal());
        // Actualizar los detalles de venta
       // List<DetalleVentaDTO> nuevosDetalles = ventaDTO.getDetallesVenta();

        // Eliminar los detalles de venta existentes
        //detVentaRepository.deleteAll(ventaExistente.getDetVenta());
        // Crear y asociar los nuevos detalles de venta
        for (DetalleVentaDTO detalleDTO : ventaDTO.getDetallesVenta()) {
            DetalleVenta detalleExistente = ventaExistente.getDetVenta()
                    .stream()
                    .filter(detalle -> detalle.getDetalleVenta_Id().equals(detalleDTO.getId_det_ventas()))
                    .findFirst()
                    .orElse(null);
        	
            Producto producto = productoRepository.findById(detalleDTO.getProducto_id())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + detalleDTO.getProducto_id()));

            if (detalleExistente != null) {
  
                detalleExistente.setCantidad(detalleDTO.getCantidad());
                detalleExistente.setPrecioUnitario(detalleDTO.getPrecioUnitario());
                detalleExistente.setSubtotal(detalleDTO.getSubtotal());
                
               
            } else {
        	
     
            if (producto.getStock() < detalleDTO.getCantidad()) {
                throw new RuntimeException("No hay suficiente stock para el producto " + producto.getNombre());
            }
            DetalleVenta NuevodetalleVenta = new DetalleVenta();
            NuevodetalleVenta.setProducto(producto);
            NuevodetalleVenta.setCantidad(detalleDTO.getCantidad());
            NuevodetalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
            NuevodetalleVenta.setSubtotal(detalleDTO.getSubtotal());
            NuevodetalleVenta.setVenta(ventaExistente);
            ventaExistente.agregarDetalleVenta(NuevodetalleVenta);
            producto.setStock(producto.getStock() - detalleDTO.getCantidad());
            productoRepository.save(producto);
        }
            
        }

     
            return ventaRepository.save(ventaExistente);
        } else {
            return null;
        }   
        
		  } catch (Exception e) {
	       
	            throw new MyException("Error al procesar la venta completa", e);
	        }
	        
	        */
		return null;
	}







	@Override
	public List<ProductoDto> buscarProductoPorNombre(String nombre) throws Exception {
		try {
		
		//List<ProductoDto> producto = restTemplate.getForObject("http://localhost:8184/api/producto/Buscar/" + nombre, List.class);
			
		//	return producto;
			
			
			   ResponseEntity<List<ProductoDto>> response = restTemplate.exchange(
		                "http://localhost:8184/api/producto/Buscar/" + nombre,
		                HttpMethod.GET,
		                null,
		                new ParameterizedTypeReference<List<ProductoDto>>() {}
		        );
			
			   return response.getBody();
	 } catch (Exception e) {
	       
         throw new MyException("Error al processar la Busqueda Producto", e);
     }
		
	}


	@Override
	public ProductoDto saveproductoRestTemplate(ProductoDto productoDto) throws Exception {
	
	     HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<ProductoDto> requestEntity = new HttpEntity<>(productoDto, headers);
	        
	        String url = "http://localhost:8184/api/producto/crear";
	       // restTemplate.postForObject(url, requestEntity, ProductoDto.class);
	       /// ResponseEntity<ProductoDto> responseEntity = restTemplate.postForEntity(url, requestEntity, productoDto.class);
		return restTemplate.postForObject(url, requestEntity, ProductoDto.class);
	}
	

	@Override
	public ProductoDto actualizarproductoRestTemplate(Long id, ProductoDto productoDto) throws Exception {
		
	    HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductoDto> requestEntity = new HttpEntity<>(productoDto, headers);
        
        String url = "http://localhost:8184/api/producto//editar/"+id;
        
        
        ResponseEntity<ProductoDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                ProductoDto.class
        );

       
       // restTemplate.put(url, requestEntity);
        
	return  responseEntity.getBody();
	}
	
	
	
	@Override
	public ProductoDto editarProductoFeing(Long id, ProductoDto producto) throws Exception {
		
		try {
			return productofeignventa.editarProductoFeing(id, producto);
			
			//return null;
		} catch (Exception e) {
			 throw new MyException("Error al processar la Busqueda Producto", e);
		}
	}

	

	public ProductoDto saveproducto(ProductoDto productoDto)  throws Exception {
	
		try {
			return productofeignventa.save(productoDto);
			
			//return null;
		} catch (Exception e) {
			 throw new MyException("Error al processar la Busqueda Producto", e);
		}
	}




	@Override
	public ProductoDto findByIdProducto(Long id) throws Exception {
	
		try {
			return productofeignventa.buscaridProducto(id);
			
			//return null;
		} catch (Exception e) {
			 throw new MyException("Error al processar la Busqueda Producto", e);
		}
	}








	






}
