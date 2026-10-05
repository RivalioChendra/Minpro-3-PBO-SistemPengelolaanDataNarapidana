package controller;

import model.Narapidana;
import model.NarapidanaNarkotika;
import model.NarapidanaTerorisme;
import model.NarapidanaKorupsi;
import model.NarapidanaPembunuhan;
import model.NarapidanaPencurian;
import model.PemeriksaanRutin;
import view.NarapidanaView;
import java.util.ArrayList;

public class AdminLapas {
    private ArrayList<Narapidana> daftarNarapidana;
    private NarapidanaView view;

    public AdminLapas(NarapidanaView view) {
        this.daftarNarapidana = new ArrayList<>();
        this.view = view;
    }

    public void tambahDataAwal(Narapidana n) {
        daftarNarapidana.add(n);
    }

    // CREATE
    public void tambahNarapidana() {
        view.tampilkanSubMenuKategori();
        int kategori = view.bacaAngka("Pilih kategori (1-5)");

        if (kategori < 1 || kategori > 5) {
            view.tampilkanPesan(">> Kategori tidak valid.");
            return;
        }

        String id = view.bacaTeks("ID Narapidana");

        for (Narapidana n : daftarNarapidana) {
            if (n.getIdNapi().equalsIgnoreCase(id)) {
                view.tampilkanPesan(">> ID sudah digunakan.");
                return;
            }
        }

        String nama = view.bacaTeks("Nama");
        String kasus = view.bacaTeks("Kasus");
        int masaTahanan = view.bacaAngkaPositif("Masa Tahanan (bulan)");
        String nomorSel = view.bacaTeks("Nomor Sel");
        String blokSel = view.bacaTeks("Blok Sel");

        Narapidana napiBaru;

        switch (kategori) {
            case 1 -> {
                String jenisRehabilitasi = view.bacaTeks("Jenis Rehabilitasi");
                napiBaru = new NarapidanaNarkotika(id, nama, kasus, masaTahanan, nomorSel, blokSel, jenisRehabilitasi);
            }
            case 2 -> {
                String tingkatRisiko = view.bacaTeks("Tingkat Risiko (Rendah/Sedang/Tinggi)");
                napiBaru = new NarapidanaTerorisme(id, nama, kasus, masaTahanan, nomorSel, blokSel, tingkatRisiko);
            }
            case 3 -> {
                long uangPengganti = view.bacaAngkaPanjangPositif("Uang Pengganti (Rp)");
                napiBaru = new NarapidanaKorupsi(id, nama, kasus, masaTahanan, nomorSel, blokSel, uangPengganti);
            }
            case 4 -> {
                String kategoriPembunuhan = view.bacaTeks("Kategori (Berencana/Tidak Berencana)");
                napiBaru = new NarapidanaPembunuhan(id, nama, kasus, masaTahanan, nomorSel, blokSel, kategoriPembunuhan);
            }
            case 5 -> {
                long nilaiKerugian = view.bacaAngkaPanjangPositif("Nilai Kerugian (Rp)");
                napiBaru = new NarapidanaPencurian(id, nama, kasus, masaTahanan, nomorSel, blokSel, nilaiKerugian);
            }
            default -> {
                view.tampilkanPesan(">> Kategori tidak valid.");
                return;
            }
        }

        daftarNarapidana.add(napiBaru);
        view.tampilkanPesan(">> Data narapidana berhasil ditambahkan!");
    }

    // READ (semua)
    public void tampilkanNarapidana() {
        if (daftarNarapidana.isEmpty()) {
        view.tampilkanPesan("Belum ada data narapidana.");
        return;
        }

    for (Narapidana n : daftarNarapidana) {
        view.tampilkanNarapidana(n);

        if (n instanceof PemeriksaanRutin p) {
            view.tampilkanPesan("Pemeriksaan   : " + p.getJenisPemeriksaan());
            view.tampilkanPesan("-----------------------------------------------------------");
        }
            view.tampilkanPesan("");
            
    }
    }

    // READ
    public void tampilkanNarapidana(String kategori) {
        boolean ditemukan = false;

        for (Narapidana n : daftarNarapidana) {

            if (n.getKategori().equalsIgnoreCase(kategori)) {
                view.tampilkanNarapidana(n);
                if (n instanceof PemeriksaanRutin p) {
                    view.tampilkanPesan("Pemeriksaan  : " + p.getJenisPemeriksaan());
                }
                view.tampilkanPesan("-----------------------------------------------------------");
                view.tampilkanPesan("");
                ditemukan = true;
            }
        }

    if (!ditemukan) {
        view.tampilkanPesan(
            ">> Tidak ada narapidana dengan kategori " + kategori);
    }
    }

    // UPDATE
    public void updateNomorSel() {
        String idTarget = view.bacaTeks("Masukkan ID Narapidana");
        boolean ditemukan = false;

        for (Narapidana n : daftarNarapidana) {
            if (n.getIdNapi().equals(idTarget)) {
                String selBaru = view.bacaTeks("Nomor Sel Baru");
                n.setNomorSel(selBaru);
                view.tampilkanPesan(">> Nomor sel berhasil diperbarui!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            view.tampilkanPesan(">> ID Narapidana tidak ditemukan!");
        }
    }

    // DELETE
    public void hapusNarapidana() {
        String idTarget = view.bacaTeks("Masukkan ID Narapidana");
        boolean ditemukan = false;

        for (int i = 0; i < daftarNarapidana.size(); i++) {
            if (daftarNarapidana.get(i).getIdNapi().equals(idTarget)) {
                daftarNarapidana.remove(i);
                view.tampilkanPesan(">> Data narapidana berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            view.tampilkanPesan(">> ID Narapidana tidak ditemukan!");
        }
    }

    public void cekPemeriksaanRutin() {
        String idTarget = view.bacaTeks("Masukkan ID Narapidana");

        for (Narapidana n : daftarNarapidana) {
            if (n.getIdNapi().equals(idTarget)) {
                if (n instanceof PemeriksaanRutin p) {
                    view.tampilkanPesan("Nama         : " + n.getNama());
                    view.tampilkanPesan("Pemeriksaan  : " + p.getJenisPemeriksaan());
                } else {
                    view.tampilkanPesan(">> Narapidana kategori " + n.getKategori() + " tidak memiliki pemeriksaan rutin khusus.");
                }
                return;
            }
        }
    }
}