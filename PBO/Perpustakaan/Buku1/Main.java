import java.util.*;

public class Main {

    static int banyakKategori, pilihanKategori, banyakBuku, i, j;
    static String judul, penulis;
    static int[] indexKategori;

    static String[] cetakJenisBuku(String[] jenisBuku) { //untuk interface
        String[] result = new String[jenisBuku.length];
        for (int i = 1; i < jenisBuku.length + 1; i++) {
            result[i - 1] = Integer.toString(i) + ". " + jenisBuku[i - 1];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Kategori yang tersedia: " + Arrays.toString(cetakJenisBuku(Buku.pilihanJenisBuku)));
        System.out.print("Mau berapa jenis buku bro?: ");
        banyakKategori = input.nextInt(); input.nextLine();
        Buku[][] kumpulanBuku = new Buku[banyakKategori][]; //nampung objek buku [kategori][banyak jenis buku]
        indexKategori = new int[banyakKategori];
        for (i = 0; i < banyakKategori; i++) {
            boolean check = true;
            System.out.println("pilihan Kategori: " + Arrays.toString(cetakJenisBuku(Buku.pilihanJenisBuku)));
            System.out.print("Jenis ke " + (i + 1) + " apa bro? (masukkan nomor kategori): ");
            while (check) {
                indexKategori[i] = input.nextInt(); input.nextLine();
                if (indexKategori[i] > 0 && indexKategori[i] < 8) {
                    check = false;
                } else {
                    System.out.print("Tolong masukkan sesuai nomor pilihan: ");
                    check = true;
                }
            }
            System.out.print("Buku " + Buku.pilihanJenisBuku[indexKategori[i] - 1] + " ada berapa bro?: ");
            banyakBuku = input.nextInt(); input.nextLine();
            kumpulanBuku[i] = new Buku[banyakBuku];
            for (j = 0; j < banyakBuku; j++) {
                System.out.print("Judul buku " + (j + 1) + " apa bro?: ");
                judul = input.nextLine();
                System.out.print("Penulis buku " + (j + 1) + " siapa saja bro?: ");
                penulis = input.nextLine();
                kumpulanBuku[i][j] = new Buku(judul, penulis);
            }


        }
        System.out.println("");
        Buku.print(banyakKategori, indexKategori, kumpulanBuku);
    }
}

class Buku {
    String judul;
    String penulis;
    final static String[] pilihanJenisBuku = {"Teknologi", "Filsafat", "Sejarah", "Agama", "Psikologi", "Politik", "Fiksi"};

    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }
    public static void print(int banyakKategori, int[] indexKategori, Buku[][] kumpulanBuku) {
        for (int i = 0; i < banyakKategori; i++) {
            System.out.println("Kategori " + pilihanJenisBuku[indexKategori[i] - 1] + ": ");
            for (int j = 0; j < kumpulanBuku[i].length; j++) {
                Buku komponen = kumpulanBuku[i][j];
                System.out.printf("Buku %s, penulis %s\n", komponen.judul, komponen.penulis);
            }
            System.out.println("");
        }
    }
}