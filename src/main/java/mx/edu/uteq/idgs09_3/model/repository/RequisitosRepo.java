package mx.edu.uteq.idgs09_3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs09_3.model.entity.Requisitos;

public interface RequisitosRepo extends JpaRepository<Requisitos, Integer> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
}
