package view;

import model.Narapidana;
import java.util.Scanner;

public class NarapidanaView {
    private Scanner scanner;

    public NarapidanaView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void tampilkanMenu() {
        System.out.println("\n==========================================");
        System.out.println("      SISTEM PENGELOLAAN DATA NARAPIDANA");
        System.out.println("==========================================");
        System.out.println("1. Tampilkan Narapidana");
        System.out.println("2. Tambah Narapidana");
        System.out.println("3. Update Nomor Sel");
        System.out.println("4. Hapus Narapidana");
        System.out.println("5. Tampilkan Berdasarkan Kategori");
        System.out.println("6. Keluar");
    }

    public void tampilkanSubMenuKategori() {
        System.out.println("Pilih kategori kejahatan:");
        System.out.println("1. Narkotika");
        System.out.println("2. Terorisme");
        System.out.println("3. Korupsi");
        System.out.println("4. Pembunuhan");
        System.out.println("5. Pencurian");
    }

    public int bacaAngka(String label) {
        System.out.print(label + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println(">> Input harus berupa angka, coba lagi.");
            scanner.nextLine(); 
            System.out.print(label + ": ");
        }
        int nilai = scanner.nextInt();
        scanner.nextLine();
        return nilai;
    }

    // Input wajib lebih besar dari 0
    public int bacaAngkaPositif(String label) {
        int nilai = bacaAngka(label);
        while (nilai <= 0) {
            System.out.println(">> Angka harus lebih besar dari 0, coba lagi.");
            nilai = bacaAngka(label);
        }
        return nilai;
    }

    // Input wajib angka
    public long bacaAngkaPanjang(String label) {
        System.out.print(label + ": ");
        while (!scanner.hasNextLong()) {
            System.out.println(">> Input harus berupa angka, coba lagi.");
            scanner.nextLine();
            System.out.print(label + ": ");
        }
        long nilai = scanner.nextLong();
        scanner.nextLine();
        return nilai;
    }

    // Input harus lebih dari 0
    public long bacaAngkaPanjangPositif(String label) {
        long nilai = bacaAngkaPanjang(label);
        while (nilai <= 0) {
            System.out.println(">> Angka harus lebih besar dari 0, coba lagi.");
            nilai = bacaAngkaPanjang(label);
        }
        return nilai;
    }

    // Input tidak boleh kosong
    public String bacaTeks(String label) {
        System.out.print(label + ": ");
        String nilai = scanner.nextLine();
        while (nilai.isEmpty()) {
            System.out.println(">> " + label + " tidak boleh kosong, coba lagi.");
            System.out.print(label + ": ");
            nilai = scanner.nextLine();
        }
        return nilai;
    }

    public void tampilkanNarapidana(Narapidana n) {
        System.out.println(n.getInfo());
        System.out.println("-----------------------------------------------------------");
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}