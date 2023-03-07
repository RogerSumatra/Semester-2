public class Manajer extends Pegawai {
    String departemen;

    public Manajer() {
        
    }
    public Manajer(String departemen) {
        this.departemen = departemen;
    }
    public Manajer(String nama, double gaji, String departemen) {
        setNama(nama);
        this.gaji = gaji;
        this.departemen = departemen;
    }
    

    void isiGaji() {
        super.gaji = gaji;
    }
    public void cetakData() {
        super.cetakData();
        System.out.println("Departemen: " + departemen);
    }
}
