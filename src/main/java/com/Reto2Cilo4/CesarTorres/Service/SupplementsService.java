/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2Cilo4.CesarTorres.Service;

import com.Reto2Cilo4.CesarTorres.Model.Supplements;
import com.Reto2Cilo4.CesarTorres.Repository.SupplementsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesartbossa
 */
@Service
public class SupplementsService {
    @Autowired
    private SupplementsRepository supplementRepository;

    public List<Supplements> getAll() {
        return supplementRepository.getAll();
    }

    public Optional<Supplements> getSupplement(String reference) {
        return supplementRepository.getSupplement(reference);
    }

    public Supplements create(Supplements accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return supplementRepository.create(accesory);
        }
    }

    public Supplements update(Supplements accesory) {

        if (accesory.getReference() != null) {
            Optional<Supplements> accesoryDb = supplementRepository.getSupplement(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                supplementRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getSupplement(reference).map(accesory -> {
            supplementRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
