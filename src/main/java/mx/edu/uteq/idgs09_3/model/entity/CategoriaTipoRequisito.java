package mx.edu.uteq.idgs09_3.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(CategoriaTipoRequisitoId.class)
public class CategoriaTipoRequisito {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "tipo_requisito_id")
    private TiposRequisitos tipoRequisito;
}
