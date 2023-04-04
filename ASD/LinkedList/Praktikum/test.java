package Praktikum;

import java.util.*;

class Mobil {
    int nomorMesin;
    String namaMobil;

    public Mobil(String namaMobil, int nomorMesin) {
        this.namaMobil = namaMobil;
        this.nomorMesin = nomorMesin;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        Mobil[] arrayMobil = new Mobil[2];
        arrayMobil[0] = new Mobil("lol" ,400);

        //for (int i = 0; i > arrayMobil.length; i++) {
            //arrayMobil[i] = new Mobil(input.nextInt());
        //}
        //System.out.println(arrayMobil[0].nomorMesin);
        Mobil temp = arrayMobil[0];
        System.out.println(temp.namaMobil);



    }
}