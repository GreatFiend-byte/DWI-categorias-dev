package mx.edu.uteq.idgs09_3.model.dto;

import lombok.Data;

@Data
public class Profesor {
    private int id;
    private String nombre;
    private String apellido;
    private String clavepe;
    private String genero;
    private boolean activo;

}