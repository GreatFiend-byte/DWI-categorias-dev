package mx.edu.uteq.idgs09_3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs09_3.model.entity.TiposRequisitos;

public interface TipoRequisitoRepo  extends JpaRepository<TiposRequisitos, Integer> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
    
}
