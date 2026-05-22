package com.duoc.vrk.services;

import com.duoc.vrk.model.Prenda;
import com.duoc.vrk.repository.PrendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService {

    @Autowired
    private PrendaRepository PrendaRepository;

    public List<Prenda> getPrendas() {
        return PrendaRepository.findAll();
    }

    public Prenda savePrenda(Prenda prenda) {
        return PrendaRepository.save(prenda);
    }

    public Prenda getPrendaId(int id) {
        return PrendaRepository.findById(id).orElse(null);
    }

    public Prenda updatePrenda(Prenda prenda) {
        if (!PrendaRepository.existsById(prenda.getId())) {
            return null;
        }
        return PrendaRepository.save(prenda);
    }

    public void deletePrenda(int id) {
        PrendaRepository.deleteById(id);
    }
}