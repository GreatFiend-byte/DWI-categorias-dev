package mx.edu.uteq.idgs09_3.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.edu.uteq.idgs09_3.model.entity.CategoriaTipoRequisito;
import mx.edu.uteq.idgs09_3.model.entity.CategoriaTipoRequisitoId;
import mx.edu.uteq.idgs09_3.service.CategoriaTipoRequisitoService;

@RestController
@RequestMapping("/api/categoria-tipo-requisito")
public class CategoriaTipoRequisitoController {

    @Autowired
    private CategoriaTipoRequisitoService serv;

    @GetMapping
    public List<CategoriaTipoRequisito> buscarTodos() {
        return serv.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CategoriaTipoRequisito relacion) {
        return ResponseEntity.ok(serv.save(relacion));
    }

    @DeleteMapping("/{categoriaId}/{tipoRequisitoId}")
    public ResponseEntity<?> borrar(
            @PathVariable int categoriaId,
            @PathVariable int tipoRequisitoId) {

        CategoriaTipoRequisitoId id = new CategoriaTipoRequisitoId(categoriaId, tipoRequisitoId);
        Optional<CategoriaTipoRequisito> opt = serv.findById(id);
        if (opt.isPresent()) {
            serv.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
