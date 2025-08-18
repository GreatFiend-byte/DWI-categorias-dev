package mx.edu.uteq.idgs09_3.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.edu.uteq.idgs09_3.model.entity.TiposRequisitos;
import mx.edu.uteq.idgs09_3.service.TipoRequisitoService;

@RestController
@RequestMapping("/api/tipos-requisitos")
public class TipoRequisitoController {

    @Autowired 
    private TipoRequisitoService serv;

    @GetMapping
    public List<TiposRequisitos> buscarTodos() {
        return serv.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return serv.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TiposRequisitos tipoRequisito) {
        return ResponseEntity.ok(serv.save(tipoRequisito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody TiposRequisitos tipoRequisito) {
        Optional<TiposRequisitos> opt = serv.findById(id);
        if (opt.isPresent()) {
            TiposRequisitos tr = opt.get();
            tr.setNombre(tipoRequisito.getNombre());
            return ResponseEntity.ok(serv.save(tr));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable int id) {
        Optional<TiposRequisitos> opt = serv.findById(id);
        if (opt.isPresent()) {
            serv.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}