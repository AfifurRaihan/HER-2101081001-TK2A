/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.afifur.perpustakaanclient.controller;

import com.mycompany.afifur.perpustakaanclient.FormPeminjaman;
import com.mycompany.afifur.perpustakaanclient.model.Peminjaman;
import com.mycompany.afifur.perpustakaanclient.service.PeminjamanService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PeminjamanController {

    private final PeminjamanService peminjamanService;
    private final FormPeminjaman formPeminjaman;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        this.formPeminjaman = formPeminjaman;
        peminjamanService = new PeminjamanService();
    }

    public void bersihForm() {
        formPeminjaman.getTxtPeminjamanId().setText("");
        formPeminjaman.getTxtBukuId().setText("");
        formPeminjaman.getTxtAnggotaId().setText("");
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }

    public void getPeminjamanId() {
        Long id = Long.parseLong(formPeminjaman.getTxtPeminjamanId().getText());
        Peminjaman peminjaman = peminjamanService.getPeminjaman(id);
        if (peminjaman != null) {
            formPeminjaman.getTxtBukuId().setText(peminjaman.getBukuId().toString());
            formPeminjaman.getTxtAnggotaId().setText(peminjaman.getAnggotaId().toString());
            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglPinjam());
            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglKembali());
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Data Tidak Ditemukan");
        }
    }

    public void savePeminjaman() {
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtAnggotaId().getText()));
        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtBukuId().getText()));
        peminjaman.setTglPinjam(formPeminjaman.getTxtTglPinjam().getText());
        peminjaman.setTglKembali(formPeminjaman.getTxtTglKembali().getText());
        peminjaman = peminjamanService.savePeminjaman(peminjaman);
        if (peminjaman != null) {
            formPeminjaman.getTxtPeminjamanId().setText(peminjaman.getPeminjamanId().toString());
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Data Gagal");
        }
    }

    public void updatePeminjaman() {
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setPeminjamanId(Long.parseLong(formPeminjaman.getTxtPeminjamanId().getText()));
        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtAnggotaId().getText()));
        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtBukuId().getText()));
        peminjaman.setTglPinjam(formPeminjaman.getTxtTglPinjam().getText());
        peminjaman.setTglKembali(formPeminjaman.getTxtTglKembali().getText());
        peminjaman = peminjamanService.updatePeminjaman(peminjaman);
        if (peminjaman != null) {
            formPeminjaman.getTxtPeminjamanId().setText(peminjaman.getPeminjamanId().toString());
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Gagal");
        }
    }

    public void deletePeminjaman() {
        Long id = Long.parseLong(formPeminjaman.getTxtPeminjamanId().getText());
        peminjamanService.deletePeminjaman(id);
        JOptionPane.showMessageDialog(formPeminjaman, "Delete Data Berhasil");
    }

    public void viewTable() {
        DefaultTableModel tabelModel = (DefaultTableModel) formPeminjaman.getTabelPeminjaman().getModel();
        tabelModel.setRowCount(0);
        List<Peminjaman> peminjamanList = peminjamanService.getAllPeminjaman();
        for (Peminjaman peminjaman : peminjamanList) {
            Object[] row = {
                peminjaman.getPeminjamanId(),
                peminjaman.getAnggotaId(),
                peminjaman.getBukuId(),
                peminjaman.getTglPinjam(),
                peminjaman.getTglKembali()
            };
            tabelModel.addRow(row);
        }
    }
}
