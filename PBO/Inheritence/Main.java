public class Main {

    public static void hitungPajak(Pegawai peg) {
        System.out.println(peg instanceof Manajer);
        System.out.println(peg instanceof Pegawai);
        if (peg instanceof Manajer) {
            System.out.println("Pajak Manajer " + (peg.gaji) * 0.001);
        } else if (peg instanceof Teknisi) {
            System.out.println("Pajak Teknisi " + (peg.gaji) * 0.004);
        }
    }
    public static void main(String[] args){
    Pegawai oegawai = new Manajer("BBB", 5000, "lol");
    hitungPajak(oegawai);
    Pegawai pegawai = new Pegawai();
    pegawai.setNama("Budi");
    pegawai.gaji = 1000000;        
    pegawai.cetakData();
    Manajer manajer = new Manajer("Santoso", 20000, "Kedokteran");
    manajer.cetakData();

    System.out.println();
    Pegawai staff[] = new Pegawai[4];
    staff[0] = new Manajer("Prayitno", 30000, "Hukum");
    staff[1] = new Pegawai("Aku Siapa?", 4000);
    staff[2] = new Pegawai("Masbro", 1000);
    staff[3] = new Manajer("Kamu Nanya?", 60000, "Pertanyaan");
    for (int i = 0; i < staff.length; i++) {
        staff[i].cetakData();
        System.out.println();
    }
    }
    
}
