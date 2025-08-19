package mx.edu.uteq.idgs09_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import mx.edu.uteq.idgs09_3.model.entity.Categorias;
import mx.edu.uteq.idgs09_3.model.entity.ProfesorCategoria;
import mx.edu.uteq.idgs09_3.service.ProfesorCategoriaService;
import mx.edu.uteq.idgs09_3.model.dto.AsignacionRequest;

import java.util.List;
import java.util.Optional;
import mx.edu.uteq.idgs09_3.service.CategoriaService;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping()
    public List<Categorias> buscarTodos(@RequestParam boolean soloActivo) {
        return service.buscar(soloActivo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> crear(@Validated @RequestBody Categorias c) {
        Categorias entity = service.crear(c);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Categorias entity) {
        Optional<Categorias> optional = service.editar(id, entity);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (service.borrar(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @Autowired
    private ProfesorCategoriaService profesorCategoriaService;

    @PostMapping("/asignar-profesor")
    public ResponseEntity<?> asignarCategoriaAProfesor(
            @RequestBody AsignacionRequest request) {

        try {
            ProfesorCategoria relacion = profesorCategoriaService.asignarCategoria(request.getProfesorId(), request.getCategoriaId());
            return ResponseEntity.ok(relacion);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/profesor/{categoriaId}")
    public ResponseEntity<List<ProfesorCategoria>> obtenerCategoriasDeProfesor(
            @PathVariable int categoriaId) {

        List<ProfesorCategoria> profesores = profesorCategoriaService.obtenerProfesorCategorias(categoriaId);
        return ResponseEntity.ok(profesores);
    }

    @DeleteMapping("/desasignar-profesor/{id}")
    public ResponseEntity<?> desasignarCategoriaDeProfesor(@PathVariable int id) {
        profesorCategoriaService.desasignarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
