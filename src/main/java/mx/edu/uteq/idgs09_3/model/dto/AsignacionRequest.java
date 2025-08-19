package mx.edu.uteq.idgs09_3.model.dto;

// Clase DTO para la request
public class AsignacionRequest {
    private int profesorId;
    private int categoriaId;
    
    // getters y setters
    public int getProfesorId() { return profesorId; }
    public void setProfesorId(int profesorId) { this.profesorId = profesorId; }
    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
}
