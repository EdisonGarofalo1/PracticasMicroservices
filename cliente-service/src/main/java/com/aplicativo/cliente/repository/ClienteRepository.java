package com.aplicativo.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicativo.cliente.models.entity.Cliente;


public interface ClienteRepository   extends  JpaRepository< Cliente, Long>{

}
