package com.mycompany.lapas;

import controller.AdminLapas;
import model.NarapidanaNarkotika;
import model.NarapidanaTerorisme;
import model.NarapidanaKorupsi;
import model.NarapidanaPembunuhan;
import model.NarapidanaPencurian;
import view.NarapidanaView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NarapidanaView view = new NarapidanaView(scanner);
        AdminLapas admin = new AdminLapas(view);

        admin.tambahDataAwal(new NarapidanaNarkotika(
                "N001", "Galeh Pramudi", "Kepemilikan Sabu 5 Gram", 48,
                "A1", "Blok B", "Rehabilitasi Medis"));

        admin.tambahDataAwal(new NarapidanaTerorisme(
                "N002", "Rian Saputra", "Percobaan Pengeboman", 180,
                "C1", "Blok A", "Tinggi"));

        admin.tambahDataAwal(new NarapidanaKorupsi(
                "N003", "Glen Allen", "Korupsi Dana Desa", 50,
                "B1", "Blok B", 150000000));

        admin.tambahDataAwal(new NarapidanaPembunuhan(
                "N004", "Doni Hartono", "Pembunuhan Berencana dalam Sengketa Warisan", 145,
                "D1", "Blok A", "Berencana"));

        admin.tambahDataAwal(new NarapidanaPencurian(
                "N005", "Suki", "Pencurian Kendaraan Bermotor", 18,
                "A2", "Blok C", 15000000));

        boolean berjalan = true;

        while (berjalan) {
            view.tampilkanMenu();
            int pilihan = view.bacaAngka("Pilih menu (1-6)");
            view.tampilkanPesan("");

            switch (pilihan) {
                case 1 -> admin.tampilkanNarapidana();
                case 2 -> admin.tambahNarapidana();
                case 3 -> admin.updateNomorSel();
                case 4 -> admin.hapusNarapidana();
                case 5 -> {
                    String kategori = view.bacaTeks(
                            "Kategori (Narkotika/Terorisme/Korupsi/Pembunuhan/Pencurian)");
                    admin.tampilkanNarapidana(kategori);
                }
                case 6 -> {
                    view.tampilkanPesan("\nKeluar dari program...");
                    berjalan = false;
                }

                default -> view.tampilkanPesan(">> Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}