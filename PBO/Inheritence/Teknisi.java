public class Teknisi extends Pegawai {
    String bagian;

    public Teknisi() {

    }
    public Teknisi(String bagian) {
        this.bagian = bagian;
    }
    public Teknisi(String nama, double gaji, String bagian) {
        setNama(nama);
        this.gaji = gaji;
        this.bagian = bagian;
    }


    public void cetakData() {
        super.cetakData();
        System.out.println("Bagian: " + bagian);
    }
    
}
