package model;

public abstract class Narapidana {
    private final String idNapi;
    private final String nama;
    private final String kasus;
    private final int masaTahanan;

    private String nomorSel;
    private String blokSel;

    // Constructor
    public Narapidana(String idNapi, String nama, String kasus, int masaTahanan, String nomorSel, String blokSel) {
        this.idNapi = idNapi;
        this.nama = nama;
        this.kasus = kasus;
        this.masaTahanan = masaTahanan;
        this.nomorSel = nomorSel;
        this.blokSel = blokSel;
    }

    // Getter & Setter
    public String getIdNapi() {
        return idNapi;
    }

    public String getNama() {
        return nama;
    }

    public String getKasus() {
        return kasus;
    }

    public int getMasaTahanan() {
        return masaTahanan;
    }

    public String getNomorSel() {
        return nomorSel;
    }

    public void setNomorSel(String nomorSel) {
        //nomor sel tidak boleh kosong
        if (nomorSel == null || nomorSel.isEmpty()) {
            System.out.println(">> Nomor sel tidak boleh kosong.");
            return;
        }
        this.nomorSel = nomorSel;
    }

    public String getBlokSel() {
        return blokSel;
    }

    public void setBlokSel(String blokSel) {
        //blok sel tidak boleh kosong
        if (blokSel == null || blokSel.isEmpty()) {
            System.out.println(">> Blok sel tidak boleh kosong.");
            return;
        }
        this.blokSel = blokSel;
    }

    protected abstract String getDetailKhusus();

    public abstract String getKategori();

    public String getInfo() {
        return "ID Narapidana : " + idNapi + "\n"
                + "Nama          : " + nama + "\n"
                + "Kasus         : " + kasus + "\n"
                + "Masa Tahanan  : " + masaTahanan + " bulan\n"
                + "Sel           : " + nomorSel + " (" + blokSel + ")\n"
                + getDetailKhusus() + "\n"
                + "Kategori      : " + getKategori();
    }
}