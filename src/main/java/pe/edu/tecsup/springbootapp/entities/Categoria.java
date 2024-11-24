package pe.edu.tecsup.springbootapp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    private Integer orden;
}