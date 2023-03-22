import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;

class Akun {
    Scanner input = new Scanner (System.in); //Pusing koding
    Random rand = new Random();
    private String nama;
    private float saldo;
    private String noPelanggan; //2 pertama jenis, 8 bebas
    private String PIN;
    DecimalFormat df = new DecimalFormat("Rp ###,###.00");

    public String konfirm;

    public Akun() {
        System.out.print("Masukkan nama anda: ");
        this.nama = input.nextLine();
        System.out.println("[1. Silver, 2. Gold, 3. Platinum]");
        System.out.print("Pilih jenis akun yang tersedia: ");
        boolean check = true;
        while (check) {
            int holder = input.nextInt(); input.nextLine();
            if (holder > 0 && holder < 4) {
                switch (holder) {
                    case 1:
                        this.noPelanggan = "38";
                        break;
                    case 2:
                        this.noPelanggan = "56";
                        break;
                    case 3:
                        this.noPelanggan = "74";
                        break;
                }
                for (int i = 0 ; i < 8; i++) {
                    this.noPelanggan += rand.nextInt(9);
                }
                check = false;
            } else {
                System.out.println("Tolong pilih sesuai pilihan");
            }
        }
        System.out.print("Masukkan 6 nomor PIN anda: ");
        check = true;
        while (check) {
            konfirm = input.nextLine();
            if (konfirm.length() == 6) {
                check = false;
            } else {
                System.out.println("Tolong masukkan PIN dengan benar");
            }
        }
        System.out.print("Konfirmasi PIN anda: ");
        check = true;
        while (check) {
            String holder = input.nextLine();
            if (konfirm.equals(holder)) {
                this.PIN = konfirm;
                check = false;
            } else {
                System.out.println("PIN salah");
            }
        }
        System.out.println("Masukkan deposit saldo (minimal Rp 50,000.00)");
        check = true;
        while (check) {
            float holder = input.nextFloat(); input.nextLine();
            if (holder < 50000) {
                System.out.println("Tolong deposit saldo dengan benar");
            } else {
                this.saldo += holder;
                check = false;
            }
        }
        System.out.println("\nAkun Berhasil dibuat");
        cekInformasiAkun();
    }
    //==========================INI UNTUK TESTCASE BROOOOOOOO======================================
    public Akun(String nama, String noPelanggan, String PIN, float saldo) {
        this.nama = nama;
        this.noPelanggan = noPelanggan;
        this.PIN = PIN;
        this.saldo = saldo;
        cekInformasiAkun();
    }
    //==========================================================================================
    boolean gantiNama(int index ,ArrayList<Akun> listAkun) {
        System.out.println("=========================================================");
        System.out.print("Masukkan nomor pelanggan: ");
        boolean check1 = true;
        while (check1) {
            String holderNo = input.nextLine();
            if (this.noPelanggan.equals(holderNo)) {
                System.out.println("=========================================================");
                System.out.print("Masukkan PIN anda (3 kali kesempatan): ");
                for (int i = 3; i > 0; i--) {
                    String holderPIN = input.nextLine();
                    if (holderPIN.equals(this.PIN)) {
                        System.out.print("Masukkan nama baru: ");
                        String namaBaru = input.nextLine();
                        this.nama = namaBaru;
                        System.out.println("Nama berhasil diganti");
                        return true;
                    } else if (!holderPIN.equals(this.PIN)) {
                        System.out.println("PIN salah. " + (i - 1) + " kesempatan lagi");
                        if ((i - 1) == 0) {
                            System.out.println("Akun terblokir");
                            listAkun.remove(index);
                            //Swalayan.ui();
                            return false;
                        }
                    }
                }
                check1 = false;
            } else {
                System.out.println("Nomor pelanggan salah");
            }
        }
        return false;
        
    }

    boolean isiSaldo(int index ,ArrayList<Akun> listAkun) {
        System.out.println("=========================================================");
        System.out.print("Masukkan nomor pelanggan: ");
        boolean check1 = true;
        while (check1) {
            String holderNo = input.nextLine();
            if (this.noPelanggan.equals(holderNo)) {
                System.out.println("=========================================================");
                System.out.print("Masukkan PIN anda (3 kali kesempatan): ");
                for (int i = 3; i > 0; i--) {
                    String holderPIN = input.nextLine();
                    if (holderPIN.equals(this.PIN)) {
                        System.out.println("=========================================================");
                        System.out.print("Masukkan nominal saldo: ");
                        float tambahSaldo = input.nextFloat(); input.nextLine();
                        this.saldo += tambahSaldo;
                        System.out.println("Saldo telah ditambahkan");
                        System.out.println("Saldo Akun: " + df.format(this.saldo));
                        return true;
                    } else if (!holderPIN.equals(this.PIN)) {
                        System.out.println("PIN salah. " + (i - 1) + " kesempatan lagi");
                        if ((i - 1) == 0) {
                            System.out.println("Akun terblokir");
                            listAkun.remove(index);
                            return false;
                        }
                    }
                }
                check1 = false;
            } else {
                System.out.println("Nomor pelanggan salah");
            }
        }
        return false;
    }

    

    boolean tarikSaldo(int index ,ArrayList<Akun> listAkun) {
        System.out.println("=========================================================");
        System.out.print("Masukkan nomor pelanggan: ");
        boolean check1 = true;
        while (check1) {
            String holderNo = input.nextLine();
            if (this.noPelanggan.equals(holderNo)) {
                System.out.println("=========================================================");
                System.out.print("Masukkan PIN anda (3 kali kesempatan): ");
                for (int i = 3; i > 0; i--) {
                    String holderPIN = input.nextLine();
                    if (holderPIN.equals(this.PIN)) {
                        System.out.println("=========================================================");
                        System.out.print("Masukkan nominal saldo yang ingin ditarik: ");
                        boolean check = true;
                        while (check) {
                            float tarikSaldo = input.nextFloat(); input.nextLine();
                            if (this.saldo < tarikSaldo) {
                                System.out.println("Saldo tidak cukup untuk melakukan penarikan");
                            } else {
                                this.saldo -= tarikSaldo;
                                System.out.println("Penarikan saldo berhasil");
                                System.out.println("Sisa saldo anda\t: " + df.format(this.saldo));
                                check = false;
                            }
                        }
                        return true;
                    } else if (!holderPIN.equals(this.PIN)) {
                        System.out.println("PIN salah. " + (i - 1) + " kesempatan lagi");
                        if ((i - 1) == 0) {
                            System.out.println("Akun terblokir");
                            listAkun.remove(index);
                            return false;
                        }
                    }
                }
                check1 = false;
            } else {
                System.out.println("Nomor pelanggan salah");
            }
        }
        return false;
        
    }
    String getNama() {
        return this.nama;
    }
    String getNoPelanggan() {
        return this.noPelanggan;
    }
    float getSaldo() {
        return this.saldo;
    }
    float setSaldo(float saldo) {
        return this.saldo = saldo;
    }
    String getPIN() {
        return this.PIN;
    }

    void cekInformasiAkun() {
        System.out.println("=========================================================");
        System.out.println("Nama\t\t: " + getNama());
        System.out.println("No Pelanggan\t: " + getNoPelanggan());
        switch(getNoPelanggan().substring(0, 2)) {
            case "38":
                System.out.println("Jenis Akun\t: Silver");
                break;
            case "56":
                System.out.println("Jenis Akun\t: Gold");
                break;
            case "74":
                System.out.println("Jenis Akun\t: Platinum");
                break;
        }
        System.out.println("Saldo\t\t: " + df.format(getSaldo()));
    }    
}
//=====================================================================================================
//=====================================================================================================
class Handphone {
    String merk;
    float harga;

    public Handphone(String merk, float harga) {
        this.merk = merk;
        this.harga = harga;
    }
}
//=====================================================================================================
//=====================================================================================================
public class Swalayan {
    static Scanner input = new Scanner(System.in);
    static ArrayList <Akun> listAkun = new ArrayList<Akun>();
    static ArrayList <Handphone> listHandphones = new ArrayList<Handphone>();
    static DecimalFormat df = new DecimalFormat("Rp ###,###.00");

    static void ui() {
        System.out.println("=========================================================");
        System.out.println("Selamat datang di Pasar Swalayan");
        System.out.println("1. Buat Akun\n2. Masuk Akun\n9. Exit");
        System.out.print("Masukkan pilihan anda : ");
        int inputPilihan = input.nextInt(); input.nextLine();
        switch (inputPilihan) {
            case 1:
                buatAkun();
                ui();
                break;
            case 2:
                masukAkun();
                ui();
                break;
            case 9:
            System.out.println("Closing....");
                break;
            default:
                System.out.println("Tolong masukkan input dengan benar");
                ui();
        }
    }

    static void tampilanAkun(int indexAkun, Akun akun) {
        System.out.println("=========================================================");
        System.out.println("Selamat datang " + akun.getNama() + "\n");
        System.out.println("1. Cek Akun\n2. Ganti nama\n3. Isi saldo\n4. Tarik saldo\n5. Pembelian\n9. Exit");
        System.out.print("Masukkan pilihan anda : ");
        int inputPilihan = input.nextInt(); input.nextLine();
        switch(inputPilihan) {
            case 1:
                akun.cekInformasiAkun();
                tampilanAkun(indexAkun, akun);
                break;
            case 2:
                if (akun.gantiNama(indexAkun, listAkun)) {
                    tampilanAkun(indexAkun, akun);
                }
                break;
            case 3:
                if (akun.isiSaldo(indexAkun, listAkun)) {
                    tampilanAkun(indexAkun, akun);
                }
                break;
            case 4:
                if (akun.tarikSaldo(indexAkun, listAkun)) {
                    tampilanAkun(indexAkun, akun);
                }
                break;
            case 5:
                if (pembelian(akun, indexAkun)) {
                    tampilanAkun(indexAkun, akun);
                }
                break;
            case 9:
                break;
            default:
                System.out.println("Tolong masukkan input dengan benar");
                tampilanAkun(indexAkun, akun);
                break;
        }
    }

    static boolean pembelian(Akun akun, int indexAkun) {
        System.out.println("=========================================================\nHandphone yang tersedia: ");
        System.out.println("   Nama\t\t\t     Harga");
        for (int i = 0; i < listHandphones.size(); i++) {
            Handphone holderHandphone = listHandphones.get(i);
            System.out.printf("%d. %-25s %s\n",i + 1 ,holderHandphone.merk, df.format(holderHandphone.harga));
        }
        System.out.println("9. Exit");
        System.out.print("\nMasukkan pilihan anda : ");
        boolean check = true;
        int inputPilihan;
        while (check) {
            inputPilihan = input.nextInt(); input.nextLine();
            if ((inputPilihan > 0 && inputPilihan <= listHandphones.size() + 1) || inputPilihan == 9) {
                switch(inputPilihan - 1) {
                    case 0:
                        if (pembayaran(akun, indexAkun, 0)) {
                            return true;
                        }
                        return false;
                    case 1:
                        if (pembayaran(akun, indexAkun, 1)) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (pembayaran(akun, indexAkun, 2)) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (pembayaran(akun, indexAkun, 3)) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (pembayaran(akun, indexAkun, 4)) {
                            return true;
                        }
                        return false;
                    case 9:
                        return true;
                       
                }
                check = false;
            } else {
                System.out.println("Tolong masukkan input dengan benar.");
            }
        }
        return false;
    }

    static boolean pembayaran(Akun akun, int indexAkun, int indexPhone) {
        Handphone holderHandphone = listHandphones.get(indexPhone);
        if (akun.getSaldo() > holderHandphone.harga) {
            if ((akun.getSaldo() - holderHandphone.harga) < 10000.0) {
                System.out.println("Transaksi gagal, saldo pasca transaksi minimal Rp. 10.000");
            } else {
                String jenisAkun = akun.getNoPelanggan().substring(0, 2);
                switch (jenisAkun) {
                    case "38":
                        if (holderHandphone.harga > 1000000.0) {
                            if (validate(akun ,indexAkun)) {
                                float potongan = (holderHandphone.harga * 5) / 100;
                                akun.setSaldo(akun.getSaldo() - (holderHandphone.harga - potongan));
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo\t: " + df.format(akun.getSaldo()));
                                System.out.println("Cashback\t: " + df.format(potongan));
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            if (validate(akun, indexAkun)) {
                                akun.setSaldo(akun.getSaldo() - (holderHandphone.harga));
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo\t: " + df.format(akun.getSaldo()));
                                return true;
                            } else {
                                return false;
                            }
                        }
                    case "56":
                        if (holderHandphone.harga > 1000000.0) {
                            if (validate(akun, indexAkun)) {
                                float potongan = (holderHandphone.harga * 7) / 100;
                                akun.setSaldo(akun.getSaldo() - (holderHandphone.harga - potongan));
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo\t: " + df.format(akun.getSaldo()));
                                System.out.println("Cashback\t: " + df.format(potongan));
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            if (validate(akun ,indexAkun)) {
                                float potongan = (holderHandphone.harga * 2) / 100;
                                akun.setSaldo(akun.getSaldo() - (holderHandphone.harga - potongan));
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo\t: " + df.format(akun.getSaldo()));
                                System.out.println("Cashback\t: " + df.format(potongan));
                                return true;
                            } else {
                                return false;
                            }
                        }
                        //break;
                    case "74":
                        if (holderHandphone.harga > 1000000.0) {
                            if (validate(akun, indexAkun)) {
                                float potongan = (holderHandphone.harga * 10) / 100;
                                akun.setSaldo(akun.getSaldo() - (holderHandphone.harga - potongan));
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo\t: " + df.format(akun.getSaldo()));
                                System.out.println("Cashback\t: " + df.format(potongan));
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            if (validate(akun ,indexAkun)) {
                                float potongan = (holderHandphone.harga * 5) / 100;
                                akun.setSaldo(akun.getSaldo() - (holderHandphone.harga - potongan));
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo\t: " + df.format(akun.getSaldo()));
                                System.out.println("Cashback\t: " + df.format(potongan));;
                                return true;
                            } else {
                                return false;
                            }
                            
                        }
                }
            }
               
        } else {
            System.out.println("Transaksi gagal. Saldo tidak cukup");
            pembelian(akun, indexAkun);
        }
        return false;
    }

    static void buatAkun() {
        System.out.println("=========================================================");
        Akun addAkun = new Akun();
        listAkun.add(addAkun);
    }

    static void masukAkun() {
        System.out.println("=========================================================");
        System.out.print("Masukkan nomor pelanggan anda: ");
        boolean check = true;
        while (check) {
            String holderNo = input.nextLine();
            for (int i = 0; i < listAkun.size(); i++) {
                 Akun holderAkun = listAkun.get(i);
                if (holderAkun.getNoPelanggan().equals(holderNo)) {
                    if (validatePIN(i, holderAkun)) {
                        tampilanAkun(i ,holderAkun);
                        check = false;
                        break;
                    } else {
                        ui();
                        check = false;
                        break;
                    }
                    
                } else if (i == listAkun.size() - 1) {
                    System.out.println("Nomor pelanggan tidak ditemukan");
                }
                
            }
        }
    }
    static boolean validate(Akun akun ,int index) {
        System.out.println("=========================================================");
        System.out.print("Masukkan nomor pelanggan: ");
        boolean check = true;
        while (check) {
            String holderNo = input.nextLine();
            if (holderNo.equals(akun.getNoPelanggan())) {
                check = false;
            } else {
                System.out.println("Nomor pelanggan salah");
            }
        }
        System.out.print("Masukkan PIN anda (3 kali kesempatan): ");
        for (int i = 3; i > 0;i--) {
            String holderPIN = input.nextLine();
            if (holderPIN.equals(akun.getPIN())) {
                return true;
            } else if (!holderPIN.equals(akun.getPIN())) {
                System.out.println("PIN salah. " + (i - 1) + " kesempatan lagi");
                if ((i - 1) == 0) {
                    System.out.println("Akun terblokir");
                    listAkun.remove(index);
                    return false;
                }
                
            }
        }
        return false;
    }

    static boolean validatePIN(int indexAkun, Akun akun) {
        System.out.println("=========================================================");
        System.out.print("Masukkan PIN anda (3 kali kesempatan): ");
        for (int i = 3; i > 0;i--) {
            String holderPass = input.nextLine();
            if (holderPass.equals(akun.getPIN())) {
                return true;
            } else if (!holderPass.equals(akun.getPIN())) {
                System.out.println("PIN salah. " + (i - 1) + " kesempatan lagi");
                if ((i - 1) == 0) {
                    System.out.println("Akun terblokir");
                    listAkun.remove(indexAkun);
                    break;
                }
                
            }
        }
        return false;
    }
    public static void main (String[] args){
        listAkun.add(new Akun("Javed", "3809809630", "123456", 5000000));
        listAkun.add(new Akun("Ujang", "5655509630", "135791", 1000000));
        listAkun.add(new Akun("Supardi", "7442396390", "246824", 2000000));

        listHandphones.add(new Handphone("Samsul Universe", 1500000)); //1.500.000
        listHandphones.add(new Handphone("Blueberry Bold 9900", 2500000)); //2.500.000
        listHandphones.add(new Handphone("Konia 8210 ", 500000)); //500.000
        listHandphones.add(new Handphone("Siomay MI 8 Big ", 5000000)); //5.000.000
        listHandphones.add(new Handphone("Ipul Newbie Min", 12000000)); //12.000.000

        ui();
    }
}
