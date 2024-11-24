package pe.edu.tecsup.springbootapp.services;

import pe.edu.tecsup.springbootapp.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll() throws Exception;

    List<Producto> findByName(String nombre) throws Exception;

    Producto findById(Long id) throws Exception;

    void save(Producto producto) throws Exception;

    void deleteById(Long id) throws Exception;

    void update(Producto producto) throws Exception;

}
