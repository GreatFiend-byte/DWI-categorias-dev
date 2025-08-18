package mx.edu.uteq.idgs09_3.model.repository;

import mx.edu.uteq.idgs09_3.model.entity.ProfesorCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfesorCategoriaRepository extends JpaRepository<ProfesorCategoria, Integer> {
    List<ProfesorCategoria> findByProfesorId(int profesorId);
    List<ProfesorCategoria> findByCategoriaId(int categoriaId);

}