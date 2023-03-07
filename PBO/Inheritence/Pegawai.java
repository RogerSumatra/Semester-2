public class Pegawai {
    private String nama;
    public double gaji;

    public String getNama() {
        return this.nama;
    }

    public Pegawai() {
        
    }

    public Pegawai(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    protected void cetakData() {
        System.out.println("Nama: " + nama);
        System.out.println("Gaji: " + gaji);
    }
}