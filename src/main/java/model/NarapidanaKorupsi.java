package model;

public class NarapidanaKorupsi extends Narapidana {
    private long uangPengganti;

    public NarapidanaKorupsi(String idNapi, String nama, String kasus, int masaTahanan, String nomorSel, String blokSel, long uangPengganti) {
        super(idNapi, nama, kasus, masaTahanan, nomorSel, blokSel);
        this.uangPengganti = uangPengganti;
    }

    @Override
    protected String getDetailKhusus() {
        return "Uang Pengganti: Rp" + uangPengganti;
    }

    @Override
    public String getKategori() {
        return "KORUPSI";
    }

    public long getUangPengganti() {
        return uangPengganti;
    }

    public void setUangPengganti(long uangPengganti) {
        if (uangPengganti <= 0) {
            System.out.println(">> Uang pengganti harus lebih besar dari 0.");
            return;
        }
        this.uangPengganti = uangPengganti;
    }
}