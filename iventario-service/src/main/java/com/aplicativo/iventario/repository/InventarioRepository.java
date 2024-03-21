package com.aplicativo.iventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicativo.iventario.models.entity.Inventario;

public interface InventarioRepository  extends  JpaRepository< Inventario, Long> {

}
