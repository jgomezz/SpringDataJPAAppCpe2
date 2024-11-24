package pe.edu.tecsup.springbootapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.springbootapp.entities.Producto;
import pe.edu.tecsup.springbootapp.repositories.ProductoRepository;

import java.util.List;

@Slf4j
@Service
public class ProductoServiceImpl implements  ProductoService{

    ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() throws Exception {
        log.info("call findAll()");
        return this.productoRepository.findAll();
    }

    @Override
    public List<Producto> findByName(String nombre) throws Exception {
        log.info("call findByName()");
        return this.productoRepository.findByName(nombre);

    }

    @Override
    public Producto findById(Long id) throws Exception {
        log.info("call findById()");
        return this.productoRepository.findById(id);
    }

    @Override
    public void save(Producto producto) throws Exception {
        log.info("call save()");
        this.productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        log.info("call deleteById()");
        this.productoRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String nombreProducto) throws Exception {
        log.info("call update()");
        this.productoRepository.update(id, nombreProducto);
    }
}
