package com.practica.CrudEjemplo.repository;

import org.springframework.data.repository.CrudRepository;

import com.practica.CrudEjemplo.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
