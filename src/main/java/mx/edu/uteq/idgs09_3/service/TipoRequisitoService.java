package mx.edu.uteq.idgs09_3.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uteq.idgs09_3.model.repository.TipoRequisitoRepo;
import mx.edu.uteq.idgs09_3.model.entity.TiposRequisitos;

@Service
public class TipoRequisitoService {
    @Autowired
    private TipoRequisitoRepo repo;

    @Transactional(readOnly = true)
    public List<TiposRequisitos> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TiposRequisitos> findById(int id) {
        return repo.findById(id);
    }

    @Transactional
    public TiposRequisitos save(TiposRequisitos pe) {
        return repo.save(pe);
    }

    @Transactional
    public void deleteById(int id) {
        repo.deleteById(id);
    }

}