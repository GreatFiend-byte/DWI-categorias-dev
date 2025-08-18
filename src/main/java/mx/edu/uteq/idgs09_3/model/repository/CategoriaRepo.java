//package mx.edu.uteq.idgs03.model.repository;
package mx.edu.uteq.idgs09_3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.edu.uteq.idgs09_3.model.entity.Categorias;
import java.util.List;

public interface CategoriaRepo  extends JpaRepository<Categorias, Integer> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations

    @Query("SELECT c FROM Categorias c LEFT JOIN FETCH c.categoriaPadre")
    List<Categorias> findAllWithParent();
    
    @Query("SELECT c FROM Categorias c WHERE c.activo = true")
    List<Categorias> findByActivoTrue();
    
}
