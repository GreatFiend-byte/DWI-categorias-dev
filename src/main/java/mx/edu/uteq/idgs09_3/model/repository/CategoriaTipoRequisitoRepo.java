package mx.edu.uteq.idgs09_3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs09_3.model.entity.CategoriaTipoRequisito;
import mx.edu.uteq.idgs09_3.model.entity.CategoriaTipoRequisitoId;

public interface CategoriaTipoRequisitoRepo extends JpaRepository<CategoriaTipoRequisito, CategoriaTipoRequisitoId> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
}
