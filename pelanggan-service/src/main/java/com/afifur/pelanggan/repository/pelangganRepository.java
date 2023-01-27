/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.afifur.pelanggan.repository;

import com.afifur.pelanggan.entity.pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface pelangganRepository extends JpaRepository<pelanggan, Long>{

    public pelanggan findByPeminjamanId(Long pelangganId);

    

    
    
}
