package model;

public class NarapidanaNarkotika extends Narapidana implements PemeriksaanRutin {
    private String jenisRehabilitasi;

    public NarapidanaNarkotika(String idNapi, String nama, String kasus, int masaTahanan, String nomorSel, String blokSel, String jenisRehabilitasi) {
        super(idNapi, nama, kasus, masaTahanan, nomorSel, blokSel);
        this.jenisRehabilitasi = jenisRehabilitasi;
    }

    @Override
    protected String getDetailKhusus() {
        return "Rehabilitasi  : " + jenisRehabilitasi;
    }

    @Override
    public String getKategori() {
        return "NARKOTIKA";
    }

    public String getJenisRehabilitasi() {
        return jenisRehabilitasi;
    }

    public void setJenisRehabilitasi(String jenisRehabilitasi) {
        if (jenisRehabilitasi == null || jenisRehabilitasi.isEmpty()) {
            System.out.println(">> Jenis rehabilitasi tidak boleh kosong.");
            return;
        }
        this.jenisRehabilitasi = jenisRehabilitasi;
    }

    @Override
    public String getJenisPemeriksaan() {
        return "Tes urine setiap 2 minggu";
    }
}