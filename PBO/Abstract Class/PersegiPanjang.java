public class PersegiPanjang extends BangunDatar {
    public double panjang;
    public double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double luas() {
        return panjang * lebar;
    }
    public double keliling() {
        return (2 * panjang) + (2 * lebar);
    }
}
