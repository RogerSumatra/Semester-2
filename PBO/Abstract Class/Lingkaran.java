public class Lingkaran extends BangunDatar {
    public double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    public double keliling() {
        return Math.PI * 2 * jariJari;
    }
    
}
