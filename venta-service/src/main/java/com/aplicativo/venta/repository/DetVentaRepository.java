package com.aplicativo.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicativo.venta.models.entity.DetalleVenta;



public interface DetVentaRepository   extends  JpaRepository<DetalleVenta , Long>{

}
