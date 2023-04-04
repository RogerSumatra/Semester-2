package Praktikum;

import java.util.*;

class KTM {
    public String nama, nim, jurusan, univ;

    public KTM(String nama, String nim, String jurusan, String univ) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.univ = univ;
    }

    @Override
    public String toString() {
      return "";
    }

    // public void split(String[] arrayKTM, int number) {
    //     String[] komponen = arrayKTM[number - 1].split(" ");
    //     System.out.println(Arrays.toString(komponen));
    // }
}

public class holder {

    public static String nama, nim, jurusan, univ, kalimat;
    public static int temp;
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int banyakKTM = input.nextInt(); input.nextLine();
        KTM[] arrayKTM = new KTM[banyakKTM];
        String nomorKTM = input.nextLine();
        String[] splittedKTM = nomorKTM.split(" ");
        for (int i = 0; i < arrayKTM.length; i++) {
            nama = input.next();
            nim = input.next();
            jurusan = input.next();
            univ = input.next();
            arrayKTM[i] = new KTM(nama, nim, jurusan, univ);
        }
        System.out.println(arrayKTM[1]);
        for (int i = 0; i < splittedKTM.length; i++) {
            temp = Integer.parseInt(splittedKTM[i]);
            KTM kalimat = arrayKTM[temp - 1];
            System.out.println(kalimat);
            //String[] komponen = kalimat.split(" ");
            //System.out.println(Arrays.toString(komponen));
            
        }
        
    }
}