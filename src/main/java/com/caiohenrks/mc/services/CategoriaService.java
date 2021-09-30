package com.caiohenrks.mc.services;

import com.caiohenrks.mc.domain.Categoria;
import com.caiohenrks.mc.repositories.CategoriaRepository;
import com.caiohenrks.mc.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }
}
