/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2Cilo4.CesarTorres.Repository;

import com.Reto2Cilo4.CesarTorres.Interface.InterfaceSupplements;
import com.Reto2Cilo4.CesarTorres.Model.Supplements;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cesartbossa
 */
@Repository
public class SupplementsRepository {
    @Autowired
    private InterfaceSupplements repository;

    public List<Supplements> getAll() {
        return repository.findAll();
    }

    public Optional<Supplements> getSupplement(String reference) {
        return repository.findById(reference);
    }
    public Supplements create(Supplements supplement) {
        return repository.save(supplement);
    }

    public void update(Supplements supplement) {
        repository.save(supplement);
    }
    
    public void delete(Supplements supplement) {
        repository.delete(supplement);
    }
}
