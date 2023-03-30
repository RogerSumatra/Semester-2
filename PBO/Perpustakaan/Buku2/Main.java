import java.text.DecimalFormat;
import java.util.*;

public class Main {

    static int banyakKategori, pilihanKategori, banyakBuku, i, j, jumlahKata, terjual;
    static String judul, penulis, sinopsis, tampungSinopsis;
    static double harga;
    static int[] indexKategori;
    static int[][] persen;

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
        persen = new int[banyakKategori][]; //nampung input persen
        indexKategori = new int[banyakKategori]; //nampung pilihan kategori
        for (i = 0; i < banyakKategori; i++) {
            boolean check1 = true;
            System.out.println("pilihan Kategori: " + Arrays.toString(cetakJenisBuku(Buku.pilihanJenisBuku)));
            System.out.print("Jenis ke " + (i + 1) + " apa bro? (masukkan nomor kategori): ");
            while (check1) { //ulang bila input tidak ada di index kategori
                indexKategori[i] = input.nextInt(); input.nextLine();
                if (indexKategori[i] > 0 && indexKategori[i] < 8) {
                    check1 = false;
                } else {
                    System.out.print("Tolong masukkan sesuai nomor pilihan: ");
                    check1 = true;
                }
            }
            System.out.print("Buku " + Buku.pilihanJenisBuku[indexKategori[i] - 1] + " ada berapa bro?: ");
            banyakBuku = input.nextInt(); input.nextLine();
            kumpulanBuku[i] = new Buku[banyakBuku];
            persen[i] = new int[banyakBuku];
            for (j = 0; j < banyakBuku; j++) {
                System.out.print("Judul buku " + (j + 1) + " apa bro?: ");
                judul = input.nextLine();
                System.out.print("Penulis buku " + (j + 1) + " siapa saja bro?: ");
                penulis = input.nextLine();
                //tambah sinopsis
                System.out.println("Buku " + (j + 1) + " sinopsisnya apa bro? (minimal 20 kata): ");
                boolean check2 = true;
                while (check2) { //ulang bila kata kurang dari 20
                    tampungSinopsis = input.nextLine().toLowerCase();
                    jumlahKata = Buku.jumlahKata(tampungSinopsis);
                    if (jumlahKata > 20) {
                        check2 = false;
                    } else {
                        System.out.println("Masukkan minimal 20 kata lah bro");
                        check2 = true;
                    }
                }
                sinopsis = Buku.fixSinopsis(tampungSinopsis);
                 //tambah harga
                System.out.print("Harganya berapa bro?: ");
                harga = input.nextDouble(); input.nextLine();
                //terjual
                System.out.print("Bukunya terjual berapa bro?: ");
                terjual = input.nextInt(); input.nextLine();
                //untung
                System.out.print("Mau ambil untung berapa persen bro?: ");
                persen[i][j] = input.nextInt(); input.nextLine();
                
               
                kumpulanBuku[i][j] = new Buku(judul, penulis, sinopsis, jumlahKata, harga, terjual);
            }


        }
        System.out.println("");
        Buku.print(banyakKategori, indexKategori, kumpulanBuku, persen);
    }
}

class Buku {
    String judul;
    String penulis;
    final static String[] pilihanJenisBuku = {"Teknologi", "Filsafat", "Sejarah", "Agama", "Psikologi", "Politik", "Fiksi"};
    String sinopsis;
    int jumlahKata;
    double harga;
    int terjual;
    static DecimalFormat df = new DecimalFormat("###,###.00");

    public Buku(String judul, String penulis, String sinopsis, int jumlahKata, double harga, int terjual) {
        this.judul = judul;
        this.penulis = penulis;
        this.sinopsis = sinopsis;
        this.jumlahKata = jumlahKata;
        this.harga = harga;
        this.terjual = terjual;
    }
    public static String fixSinopsis(String sinopsis) {
        String []holder = sinopsis.split("(?<=[.!?:])\\s");
        String space = " ";
        String kalimat = "";
        for (int i = 0; i < holder.length; i++) {
            holder[i] = holder[i].trim();
        }
        for (int i = 0; i < holder.length; i++) {
            String kapital = holder[i].substring(0, 1).toUpperCase();
            kalimat += kapital + holder[i].substring(1) + space;
        }
        return kalimat;
    }
    public static int jumlahKata(String sinopsis) {
        String[] holderKata = sinopsis.split(" ");
        return holderKata.length;    
    }
    public String jumlahRoyalti(int terjual, double harga) {
        double royalti = (harga * terjual) / 10;
        return df.format(royalti);
    }
    public String jumlahRoyalti(int terjual, double harga, int persen) {
        double royalti = (harga * terjual * persen) / 100;
        return df.format(royalti);
    }
    public static void print(int banyakKategori, int[] indexKategori, Buku[][] kumpulanBuku, int[][] persen) {
        for (int i = 0; i < banyakKategori; i++) {
            System.out.println("Kategori " + pilihanJenisBuku[indexKategori[i] - 1] + ": ");
            for (int j = 0; j < kumpulanBuku[i].length; j++) {
                Buku komponen = kumpulanBuku[i][j];
                System.out.printf("%d. Judul Buku\t: %s\n", j + 1, komponen.judul);
                System.out.printf("%2s Penulis\t: %s\n","" , komponen.penulis);
                System.out.printf("%2s Sinopsis\t: %s\n","" , komponen.sinopsis);
                System.out.printf("%2s Jumlah kata\t: %d kata\n","" , komponen.jumlahKata);
                System.out.printf("%2s Harga\t: Rp.%s\n","" , df.format(komponen.harga));
                System.out.printf("%2s Terjual\t: %s cetak\n","" , komponen.terjual);
                System.out.printf("%2s Royalti 10%%\t: Rp.%s\n","" , komponen.jumlahRoyalti(komponen.terjual, komponen.harga));
                System.out.printf("%2s Royalti %d%%\t: Rp.%s\n","" , persen[i][j], komponen.jumlahRoyalti(komponen.terjual, komponen.harga, persen[i][j]));
                System.out.println("");
            }
            System.out.println("");
        }
    }
}