package mx.edu.uteq.idgs09_3.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "profesor_categoria")
public class ProfesorCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "profesor_id")
    private int profesorId; // ID del profesor (podría ser una relación @ManyToOne si tienes la entidad Profesor)

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;

    // Puedes agregar campos adicionales como fecha de asignación, etc.
    private boolean activo = true;
}