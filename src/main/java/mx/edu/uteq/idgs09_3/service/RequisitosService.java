package mx.edu.uteq.idgs09_3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uteq.idgs09_3.model.repository.RequisitosRepo;
import mx.edu.uteq.idgs09_3.model.entity.Requisitos;

@Service
public class RequisitosService {
    @Autowired
    private RequisitosRepo repo;

    @Transactional(readOnly = true)
    public List<Requisitos> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Requisitos> findById(int id) {
        return repo.findById(id);
    }

    @Transactional
    public Requisitos save(Requisitos requisito) {
        return repo.save(requisito);
    }

    @Transactional
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
