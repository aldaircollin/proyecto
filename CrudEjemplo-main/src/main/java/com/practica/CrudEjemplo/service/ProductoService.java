package com.practica.CrudEjemplo.service;

import java.util.ArrayList;
import java.util.Optional;

import com.practica.CrudEjemplo.model.Producto;


public interface ProductoService {
	
		ArrayList<Producto>ListarProductos();
		Optional<Producto>ProductoById(long id);
		Producto GuardarProducto(Producto producto);
		boolean EliminarProductoById(long id);

}
	

