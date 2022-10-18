package com.practica.CrudEjemplo.service;

import java.util.ArrayList;
import java.util.Optional;

import com.practica.CrudEjemplo.model.Usuario;

public interface UsuarioService {
ArrayList<Usuario>ListarUsuarios();
Optional<Usuario>UsuarioById(long id);
Usuario GuardarUsuario(Usuario usuario);
boolean EliminarUsuarioById(long id);

}
