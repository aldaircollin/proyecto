package com.practica.CrudEjemplo.repository;

import org.springframework.data.repository.CrudRepository;

import com.practica.CrudEjemplo.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
