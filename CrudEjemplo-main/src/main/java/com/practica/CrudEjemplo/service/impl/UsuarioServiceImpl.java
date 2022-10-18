package com.practica.CrudEjemplo.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.CrudEjemplo.model.Usuario;
import com.practica.CrudEjemplo.repository.UsuarioRepository;
import com.practica.CrudEjemplo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public ArrayList<Usuario> ListarUsuarios() {
		// TODO Auto-generated method stub
		return (ArrayList<Usuario>)usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> UsuarioById(long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario GuardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	@Override
	public boolean EliminarUsuarioById(long id) {
		// TODO Auto-generated method stub
		try {
			Optional<Usuario>usuario=UsuarioById(id);
			usuarioRepository.delete(usuario.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
