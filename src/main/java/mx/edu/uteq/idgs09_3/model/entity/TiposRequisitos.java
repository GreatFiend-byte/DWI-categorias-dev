package mx.edu.uteq.idgs09_3.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import jakarta.persistence.CascadeType;

@Entity
@Data
public class TiposRequisitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @OneToMany(mappedBy = "tipoRequisito", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Requisitos> requisitos;
    
    @OneToMany(mappedBy = "tipoRequisito", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CategoriaTipoRequisito> categoriaTipoRequisitos;
}
