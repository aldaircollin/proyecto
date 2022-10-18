package com.practica.CrudEjemplo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.CrudEjemplo.model.Usuario;
import com.practica.CrudEjemplo.service.UsuarioService;

@RestController
@RequestMapping(("api"))
public class ApiDemo {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/saludar")
	public String saludar() {
		return "prueba";
	}
	
	@GetMapping("/Listar")
	public ArrayList<Usuario>ListarUsuarios(){
		return usuarioService.ListarUsuarios();
	}
	
	@GetMapping("/BuscarPorId/{id}")
public Optional<Usuario>ListarUsuarioPorId(@PathVariable("id")long id){
		return usuarioService.UsuarioById(id);
	}
	
	@PostMapping("/Guardar")
	public Usuario GuardarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.GuardarUsuario(usuario);
}

	@DeleteMapping("/Eliminar/{id}")
	public String EliminarUsuarioPorId(@PathVariable("id")long id) {
	if (usuarioService.EliminarUsuarioById(id))
		return "se ha eliminado";
		
	else {
		return "no se ha elimnado";
	}
	
	}
	
}