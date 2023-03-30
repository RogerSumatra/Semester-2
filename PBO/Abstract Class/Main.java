public class Main {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(3);
        PersegiPanjang persegiPanjang = new PersegiPanjang(5, 7);
        Lingkaran lingkaran = new Lingkaran(7);
        //BangunDatar bd = new BangunDatar() ;

        persegi.cetak();
        System.out.println("Rumus Persegi\n=====");
        System.out.println("Luas Persegi\t: " + persegi.luas());
        System.out.println("Keliling Persegi: " + persegi.keliling());

        persegiPanjang.cetak();
        System.out.println("Rumus Persegi Panjang\n=====");
        System.out.println("Luas Persegi Panjang\t: " + persegiPanjang.luas());
        System.out.println("Keliling Persegi Panjang: " + persegiPanjang.keliling());

        lingkaran.cetak();
        System.out.println("Rumus Lingkaran\n=====");
        System.out.println("Luas Lingkaran\t: " + lingkaran.luas());
        System.out.println("Keliling Lingkaran: " + lingkaran.keliling());
    }
}