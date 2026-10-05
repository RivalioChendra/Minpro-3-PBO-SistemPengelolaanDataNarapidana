package model;

public class NarapidanaPencurian extends Narapidana {
    private long nilaiKerugian;

    public NarapidanaPencurian(String idNapi, String nama, String kasus, int masaTahanan, String nomorSel, String blokSel, long nilaiKerugian) {
        super(idNapi, nama, kasus, masaTahanan, nomorSel, blokSel);
        this.nilaiKerugian = nilaiKerugian;
    }

    @Override
    protected String getDetailKhusus() {
        return "Nilai Kerugian: Rp" + nilaiKerugian;
    }

    @Override
    public String getKategori() {
        return "PENCURIAN";
    }

    public long getNilaiKerugian() {
        return nilaiKerugian;
    }

    public void setNilaiKerugian(long nilaiKerugian) {
        if (nilaiKerugian <= 0) {
            System.out.println(">> Nilai kerugian harus lebih besar dari 0.");
            return;
        }
        this.nilaiKerugian = nilaiKerugian;
    }
}