package mx.edu.uteq.idgs09_3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uteq.idgs09_3.model.repository.CategoriaTipoRequisitoRepo;
import mx.edu.uteq.idgs09_3.model.entity.CategoriaTipoRequisito;
import mx.edu.uteq.idgs09_3.model.entity.CategoriaTipoRequisitoId;

@Service
public class CategoriaTipoRequisitoService {
    @Autowired
    private CategoriaTipoRequisitoRepo repo;

    @Transactional(readOnly = true)
    public List<CategoriaTipoRequisito> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<CategoriaTipoRequisito> findById(CategoriaTipoRequisitoId id) {
        return repo.findById(id);
    }

    @Transactional
    public CategoriaTipoRequisito save(CategoriaTipoRequisito relacion) {
        return repo.save(relacion);
    }

    @Transactional
    public void deleteById(CategoriaTipoRequisitoId id) {
        repo.deleteById(id);
    }
}
