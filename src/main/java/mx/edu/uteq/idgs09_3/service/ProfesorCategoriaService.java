package mx.edu.uteq.idgs09_3.service;

import mx.edu.uteq.idgs09_3.clients.ProfesorClient;
import mx.edu.uteq.idgs09_3.model.dto.Profesor;
import mx.edu.uteq.idgs09_3.model.entity.Categorias;
import mx.edu.uteq.idgs09_3.model.entity.ProfesorCategoria;
import mx.edu.uteq.idgs09_3.model.repository.ProfesorCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesorCategoriaService {

    @Autowired
    private ProfesorCategoriaRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProfesorClient profesorClient;

    @Transactional
    public ProfesorCategoria asignarCategoria(int profesorId, int categoriaId) {
        // Verificar que el profesor existe
        Profesor profesor = profesorClient.obtenerProfesor(profesorId);
        if (profesor == null) {
            throw new RuntimeException("Profesor no encontrado");
        }

        Categorias categoria = categoriaService.buscarPorId(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        ProfesorCategoria relacion = new ProfesorCategoria();
        relacion.setProfesorId(profesorId);
        relacion.setCategoria(categoria);
        return repository.save(relacion);
    }

    @Transactional(readOnly = true)
    public List<ProfesorCategoria> obtenerCategoriasPorProfesor(int profesorId) {
        return repository.findByProfesorId(profesorId);
    }

    @Transactional(readOnly = true)
    public List<ProfesorCategoria> obtenerProfesorCategorias(int categoriaId) {
        return repository.findByCategoriaId(categoriaId);
    }

    @Transactional
    public void desasignarCategoria(int id) {
        repository.deleteById(id);
    }
}