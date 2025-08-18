package mx.edu.uteq.idgs09_3.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.edu.uteq.idgs09_3.model.entity.Requisitos;
import mx.edu.uteq.idgs09_3.service.RequisitosService;

@RestController
@RequestMapping("/api/requisitos")
public class RequisitosController {

    @Autowired 
    private RequisitosService serv;

    @GetMapping
    public List<Requisitos> buscarTodos() {
        return serv.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return serv.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Requisitos requisito) {
        return ResponseEntity.ok(serv.save(requisito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Requisitos requisito) {
        Optional<Requisitos> opt = serv.findById(id);
        if (opt.isPresent()) {
            Requisitos r = opt.get();
            r.setNombre(requisito.getNombre());
            r.setTipoRequisito(requisito.getTipoRequisito());
            return ResponseEntity.ok(serv.save(r));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable int id) {
        Optional<Requisitos> opt = serv.findById(id);
        if (opt.isPresent()) {
            serv.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
