package mx.edu.uteq.idgs09_3.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import jakarta.persistence.CascadeType;


@Entity
@Data
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    private Categorias categoriaPadre;
    
    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Categorias> categoriasHijas;
    
    private String categoria_federal;
    private String categoria_estatal;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CategoriaTipoRequisito> categoriaTipoRequisitos;
    
    private boolean activo = true;
}

