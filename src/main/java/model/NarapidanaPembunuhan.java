package model;

public class NarapidanaPembunuhan extends Narapidana implements PemeriksaanRutin {
    private String kategoriPembunuhan;

    public NarapidanaPembunuhan(String idNapi, String nama, String kasus, int masaTahanan, String nomorSel, String blokSel, String kategoriPembunuhan) {
        super(idNapi, nama, kasus, masaTahanan, nomorSel, blokSel);
        this.kategoriPembunuhan = kategoriPembunuhan;
    }

    @Override
    protected String getDetailKhusus() {
        return "Kategori Kasus: " + kategoriPembunuhan;
    }

    @Override
    public String getKategori() {
        return "PEMBUNUHAN";
    }

    public String getKategoriPembunuhan() {
        return kategoriPembunuhan;
    }

    public void setKategoriPembunuhan(String kategoriPembunuhan) {
        if (kategoriPembunuhan == null || kategoriPembunuhan.isEmpty()) {
            System.out.println(">> Kategori pembunuhan tidak boleh kosong.");
            return;
        }
        this.kategoriPembunuhan = kategoriPembunuhan;
    }

    @Override
    public String getJenisPemeriksaan() {
        return "Evaluasi psikologis setiap 3 bulan";
    }
}