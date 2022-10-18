package com.practica.CrudEjemplo.service.impl;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.CrudEjemplo.model.Producto;
import com.practica.CrudEjemplo.repository.ProductoRepository;
import com.practica.CrudEjemplo.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public ArrayList<Producto> ListarProductos() {
		return (ArrayList<Producto>)productoRepository.findAll();
	}

	@Override
	public Optional<Producto> ProductoById(long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public Producto GuardarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public boolean EliminarProductoById(long id) {
		try {
			Optional<Producto>producto=ProductoById(id);
			productoRepository.delete(producto.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
}
