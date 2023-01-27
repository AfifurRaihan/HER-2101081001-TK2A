/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.afifur.pelanggan.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ASUS
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class penjualan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pelanggan;
    private Long namaPelanggan;
    private int harga;
    private int jumlah;
    private double diskonPersen;
    private double PPNPersenTotal;
}
