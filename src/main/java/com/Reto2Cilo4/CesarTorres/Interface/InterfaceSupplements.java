/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto2Cilo4.CesarTorres.Interface;

import com.Reto2Cilo4.CesarTorres.Model.Supplements;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cesartbossa
 */
public interface InterfaceSupplements extends MongoRepository<Supplements, String>{
    
}
