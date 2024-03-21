package com.aplicativo.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicativo.venta.models.entity.Venta;

public interface VentaRepository  extends  JpaRepository<Venta , Long> {

}
