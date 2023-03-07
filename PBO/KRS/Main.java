import java.util.*;

public class Main {
    public static void main (String[] args) {
        KRS object1 = new KRS();
        object1.tambahMataKuliah();
        System.out.println("-------------------------------------");
        object1.print();
    }
}
class KRS {
    Scanner input = new Scanner (System.in);
    public int jumlahMataKuliah = input.nextInt();
    public String bug = input.nextLine(); //untuk solve bug nextInt()
    public String[] kodeMataKuliah = new String[jumlahMataKuliah];
    public String[] mataKuliah = new String[jumlahMataKuliah];
    

    void tambahMataKuliah() {
        for (int i = 0; i < mataKuliah.length; i++) {
            kodeMataKuliah[i] = input.next();
            mataKuliah[i] = input.nextLine();
        }
    }
    void print() {
        if (jumlahMataKuliah > 5) {
            System.out.println("Error : KRS telah penuh");
            System.out.println("Daftar Mata Kuliah :");
            for (int i = 0; i < 5; i++) {
                System.out.println(kodeMataKuliah[i] + ":" + mataKuliah[i]);
            }
        } else {
            System.out.println("Daftar Mata Kuliah :");
            for (int i = 0; i < mataKuliah.length; i++) {
                System.out.println(kodeMataKuliah[i] + ":" + mataKuliah[i]);
            }
        }
    }
}
