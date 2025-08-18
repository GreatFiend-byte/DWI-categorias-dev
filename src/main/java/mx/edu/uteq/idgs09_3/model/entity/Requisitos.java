package mx.edu.uteq.idgs09_3.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Requisitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "tipo_requisito_id")
    private TiposRequisitos tipoRequisito;
}
