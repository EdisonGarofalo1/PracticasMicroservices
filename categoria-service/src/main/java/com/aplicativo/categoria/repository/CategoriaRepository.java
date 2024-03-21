package com.aplicativo.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicativo.categoria.models.entity.Categoria;



public interface CategoriaRepository  extends  JpaRepository< Categoria, Long>{

}
