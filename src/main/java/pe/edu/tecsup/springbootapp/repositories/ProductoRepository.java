package pe.edu.tecsup.springbootapp.repositories;

import pe.edu.tecsup.springbootapp.entities.Producto;

import java.util.List;

public interface ProductoRepository {

    List<Producto> findAll() throws Exception;

    List<Producto> findByName(String nombre) throws Exception;

    Producto findById(Long id) throws Exception;

    void save(Producto producto) throws Exception;

    void update(Long id, String nombreProducto) throws Exception;

    void deleteById(Long id) throws Exception;

}


