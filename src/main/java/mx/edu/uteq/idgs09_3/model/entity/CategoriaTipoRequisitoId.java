package mx.edu.uteq.idgs09_3.model.entity;

import java.io.Serializable;

public class CategoriaTipoRequisitoId implements Serializable {
    private int categoria;
    private int tipoRequisito;
    
    public CategoriaTipoRequisitoId() {}
    
    public CategoriaTipoRequisitoId(int categoria, int tipoRequisito) {
        this.categoria = categoria;
        this.tipoRequisito = tipoRequisito;
    }
    
    // equals y hashCode son requeridos para claves compuestas
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CategoriaTipoRequisitoId that = (CategoriaTipoRequisitoId) obj;
        return categoria == that.categoria && tipoRequisito == that.tipoRequisito;
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(categoria, tipoRequisito);
    }
}
