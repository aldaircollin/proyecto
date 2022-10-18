package com.practica.CrudEjemplo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.CrudEjemplo.excepciones.ResourceNotFoundException;
import com.practica.CrudEjemplo.model.Producto;
import com.practica.CrudEjemplo.service.ProductoService;


@RestController
@RequestMapping(("productos"))
@CrossOrigin("http://localhost:4200/")
public class ProductoController {
	@Autowired
	ProductoService productoService;

	
	@GetMapping("/Listar")
	public ArrayList<Producto>ListarUsuarios(){
		return productoService.ListarProductos();
	}
	
	@GetMapping("/BuscarPorId/{id}")
public Optional<Producto>ListarUsuarioPorId(@PathVariable("id")long id){
		return productoService.ProductoById(id);
	}
	
	@PostMapping("/Guardar")
	public Producto GuardarUsuario(@RequestBody Producto producto) {
		return productoService.GuardarProducto(producto);
}
	
	//este metodo sirve para actualizar proveedor
			@PutMapping("/Actualizar/{id}")
			public ResponseEntity<Producto> actualizarProveedor(@PathVariable Long id,@RequestBody Producto detallesProducto){
				Producto producto = productoService.ProductoById(id)
						            .orElseThrow(() -> new ResourceNotFoundException("No existe el proveedor con el ID : " + id));
				
				producto.setNombre(detallesProducto.getNombre());
				producto.setCategoria(detallesProducto.getCategoria());
				producto.setDescripcion(detallesProducto.getDescripcion());
				producto.setCantidad(detallesProducto.getCantidad());
				producto.setPrecio(detallesProducto.getPrecio());
				
				Producto productoActualizado = productoService.GuardarProducto(producto);
				return ResponseEntity.ok(productoActualizado);
		    }

	@DeleteMapping("/Eliminar/{id}")
	public String EliminarUsuarioPorId(@PathVariable("id")long id) {
	if (productoService.EliminarProductoById(id))
		return "se ha eliminado";
		
	else {
		return "no se ha elimnado";
	}
	
	}
}
