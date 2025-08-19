package mx.edu.uteq.idgs09_3.clients;

import mx.edu.uteq.idgs09_3.model.dto.Profesor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "idgs01", url = "https://profesores-production.up.railway.app")
public interface ProfesorClient {
    
    @GetMapping("/api/profesor/{id}")
    Profesor obtenerProfesor(@PathVariable int id);
}
