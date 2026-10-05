package model;

public class NarapidanaTerorisme extends Narapidana implements PemeriksaanRutin {
    private String tingkatRisiko;

    public NarapidanaTerorisme(String idNapi, String nama, String kasus, int masaTahanan, String nomorSel, String blokSel, String tingkatRisiko) {
        super(idNapi, nama, kasus, masaTahanan, nomorSel, blokSel);
        this.tingkatRisiko = tingkatRisiko;
    }

    @Override
    protected String getDetailKhusus() {
        return "Tingkat Risiko: " + tingkatRisiko;
    }

    @Override
    public String getKategori() {
        return "TERORISME";
    }

    public String getTingkatRisiko() {
        return tingkatRisiko;
    }

    public void setTingkatRisiko(String tingkatRisiko) {
        if (tingkatRisiko == null || tingkatRisiko.isEmpty()) {
            System.out.println(">> Tingkat risiko tidak boleh kosong.");
            return;
        }
        this.tingkatRisiko = tingkatRisiko;
    }

    @Override
    public String getJenisPemeriksaan() {
        if (tingkatRisiko.equalsIgnoreCase("Tinggi")) {
            return "Pemeriksaan sel dan komunikasi setiap hari";
        }
        return "Pemeriksaan sel dan komunikasi setiap minggu";
    }
}