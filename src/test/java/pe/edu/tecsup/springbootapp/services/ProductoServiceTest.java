package pe.edu.tecsup.springbootapp.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.springbootapp.entities.Producto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class ProductoServiceTest {

    @Autowired
    ProductoService productoService;

    @Test
    void findAll() throws Exception {
        Boolean VALUE_EXPECTED = true;

        log.info("Start testing ");

        List<Producto> productos = this.productoService.findAll();
        productos.stream().forEach(prod -> log.info(prod.getNombre()));
        productos.isEmpty();

        assertEquals(VALUE_EXPECTED, !productos.isEmpty());

    }

    @Test
    void findByName() throws Exception {

        Boolean VALUE_EXPECTED = true;

        List<Producto> productos = this.productoService.findByName("AMD");

        log.info("Print by productos");
        productos.stream().forEach(prod -> log.info(prod.getNombre()));

        assertEquals(VALUE_EXPECTED, !productos.isEmpty());
    }

    @Test
    void findById() throws Exception {

        String NAME_EXPECTED = "Kingstone";
        Long ID = 1L;
        Producto producto = this.productoService.findById(ID);
        log.info(producto.toString());

        assertEquals(NAME_EXPECTED, producto.getNombre());

    }

    @Test
    void save() throws Exception {

        List<Producto> productos = this.productoService.findAll();
        int totalAntes = productos.size();

        Producto producto = new Producto();
        producto.setCategorias_id(1L);
        producto.setNombre("AMD");
        producto.setDescripcion("AMD X10");
        producto.setPrecio(280.0);
        producto.setStock(6);
        producto.setEstado(1);

        this.productoService.save(producto);

        productos = this.productoService.findAll();
        int totalDespues = productos.size();

        assertEquals(1, totalDespues - totalAntes);
    }

    @Test
    void deleteById() throws Exception {
        List<Producto> productos = this.productoService.findAll();
        int totalAntes = productos.size();
        if (productos.isEmpty()) {
            return; // test pass
        }

        Producto ultimoProducto = productos.get(productos.size() - 1);
        this.productoService.deleteById(ultimoProducto.getId());

        productos = this.productoService.findAll();
        int totalDespues = productos.size();

        assertEquals(1, totalAntes - totalDespues);
    }

    @Test
    void update() throws Exception {

        // Actualizar el nombre del producto
        Long id = 1L; // Relacionado con tus datos de pruebas
        String NOMBRE_ORIGINAL = "Kingstone" ;
        String NOMBRE_A_CAMBIAR = "Kingstone Cambiado" ;
        Producto prod = null;

        // Actualizar
        productoService.update(id, NOMBRE_A_CAMBIAR);


        // Buscar el producto
        prod = productoService.findById(id);

        // Verificar que el nombre ha sido cambiado
        assertEquals(NOMBRE_A_CAMBIAR, prod.getNombre());

        // Actualizar
        productoService.update(id, NOMBRE_ORIGINAL);


        // Buscar el producto
        prod = productoService.findById(id);

        // Verificar que el nombre ha sido cambiado
        assertEquals(NOMBRE_ORIGINAL,prod.getNombre());

    }
}