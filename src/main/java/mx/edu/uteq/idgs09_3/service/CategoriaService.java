package mx.edu.uteq.idgs09_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uteq.idgs09_3.model.entity.Categorias;
import mx.edu.uteq.idgs09_3.model.repository.CategoriaRepo;
import mx.edu.uteq.idgs09_3.model.repository.TipoRequisitoRepo;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepo repo;
    @Autowired
    private TipoRequisitoRepo trRepo;

    @Transactional(readOnly = true)
    public List<Categorias> buscar(boolean soloActivos) {
        if (soloActivos) {
            return repo.findByActivoTrue();
        }
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Categorias> buscarPorId(int id) {
        return repo.findById(id);
    }

    @Transactional
    public Categorias crear(Categorias categoria) {
        return repo.save(categoria);
    }

    @Transactional
    public Optional<Categorias> editar(int id, Categorias categoria) {
        Optional<Categorias> opt = repo.findById(id);
        if (opt.isPresent()) {
            Categorias d = opt.get();
            d.setNombre(categoria.getNombre());
            d.setCategoriaPadre(categoria.getCategoriaPadre());
            d.setCategoria_federal(categoria.getCategoria_federal());
            d.setCategoria_estatal(categoria.getCategoria_estatal());
            d.setActivo(categoria.isActivo());
             // Actualizar otros campos según sea necesario
            return Optional.of(repo.save(d));
        }
        return opt;
    }

    @Transactional
    public boolean borrar(int id) {
        Optional<Categorias> opt = repo.findById(id);
        if (opt.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
