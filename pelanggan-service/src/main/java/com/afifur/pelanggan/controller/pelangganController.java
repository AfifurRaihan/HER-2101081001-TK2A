/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.afifur.pelanggan.controller;

import com.afifur.pelanggan.VO.pelanggan;
import com.afifur.pelanggan.entity.penjualan;
import com.afifur.pelanggan.service.pelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/pelanggan")
public class pelangganController {
    @Autowired
    private pelangganService pelangganService;
    
    @PostMapping("/")
    public pelanggan savePelanggan(@RequestBody pelanggan pelanggan){
        return pelangganService.savePelanggan(pelanggan);
    }
    @GetMapping("/{id}")
    public pelanggan findPelangganById(@PathVariable("id")Long pelangganId){
        return pelangganService.findPelangganById(pelangganId);
    }
}
