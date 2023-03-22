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

        System.out.println("\nAkun Berhasil dibuat");
        cekInformasiAkun();
    }

    public Akun(String nama, String noPelanggan, String PIN) {
        this.nama = nama;
        this.noPelanggan = noPelanggan;
        this.PIN = PIN;
        cekInformasiAkun();
    }

    void gantiNama() {
        System.out.println("=========================================================");
        System.out.print("Masukkan nama baru: ");
        String namaBaru = input.nextLine();
        this.nama = namaBaru;
        System.out.println("Nama berhasil diganti");
    }

    void isiSaldo() {
        System.out.println("=========================================================");
        System.out.print("Masukkan nominal saldo: ");
        float tambahSaldo = input.nextFloat();
        this.saldo += tambahSaldo;
        System.out.println("Saldo telah ditambahkan");
    }

    void tarikSaldo() {
        System.out.println("=========================================================");
        System.out.print("Masukkan nominal saldo yang ingin ditarik: ");
        boolean check = true;
        while (check) {
            float tarikSaldo = input.nextFloat();
            if (getSaldo() < tarikSaldo) {
                System.out.println("Saldo tidak cukup untuk melakukan penarikan");
            } else {
                this.saldo -= tarikSaldo;
                System.out.println("Penarikan saldo berhasil");
                System.out.println("Sisa saldo anda\t: " + df.format(this.saldo));
                check = false;
            }
        }
        
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
    DecimalFormat df = new DecimalFormat("Rp. ###.###.00");

    static void ui() {
        System.out.println("=========================================================");
        System.out.println("Selamat datang di Swalayan");
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

    static void tampilanAkun(Akun akun) {
        System.out.println("=========================================================");
        System.out.println("Selamat datang " + akun.getNama() + "\n");
        System.out.println("1. Cek Akun\n2. Ganti nama\n3. Isi saldo\n4. Tarik saldo\n5. Pembelian\n9. Exit");
        System.out.print("Masukkan pilihan anda : ");
        int inputPilihan = input.nextInt(); input.nextLine();
        switch(inputPilihan) {
            case 1:
                akun.cekInformasiAkun();
                tampilanAkun(akun);
                break;
            case 2:
                akun.gantiNama();
                tampilanAkun(akun);
                break;
            case 3:
                akun.isiSaldo();
                tampilanAkun(akun);
                break;
            case 4:
                akun.tarikSaldo();
                tampilanAkun(akun);
            case 5:
                pembelian(akun);
                tampilanAkun(akun);
                break;
            case 9:
                break;
            default:
                System.out.println("Tolong masukkan input dengan benar");
                tampilanAkun(akun);
                break;
        }
    }

    static void pembelian(Akun akun) {
        System.out.println("=========================================================\nHandpohne yang tersedia: ");
        System.out.println("   Nama\t\t\t     Harga");
        for (int i = 0; i < listHandphones.size(); i++) {
            Handphone holderHandphone = listHandphones.get(i);
            System.out.printf("%d. %-25s %f\n",i + 1 ,holderHandphone.merk, holderHandphone.harga);
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
                        Handphone holderHandphone1 = listHandphones.get(0);
                        if (akun.getSaldo() > holderHandphone1.harga) {
                            if ((akun.getSaldo() - holderHandphone1.harga) < 10000.0) {
                                System.out.println("Transaksi gagal, saldo pasca transaksi minimal Rp. 10.000");
                            } else {
                                akun.setSaldo(akun.getSaldo() - holderHandphone1.harga);
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo: " + akun.getSaldo());
                            }
                            
                        } else {
                            System.out.println("Transaksi gagal. Saldo tidak cukup");
                        }
                        break;
                    case 1:
                        Handphone holderHandphone2 = listHandphones.get(1);
                        if (akun.getSaldo() > holderHandphone2.harga) {
                            if ((akun.getSaldo() - holderHandphone2.harga) < 10000.0) {
                                System.out.println("Transaksi gagal, saldo pasca transaksi minimal Rp. 10.000");
                            } else {
                                akun.setSaldo(akun.getSaldo() - holderHandphone2.harga);
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo: " + akun.getSaldo());
                            }
                            
                        } else {
                            System.out.println("Transaksi gagal. Saldo tidak cukup");
                        }
                        break;
                    case 2:
                        Handphone holderHandphone3 = listHandphones.get(2);
                        if (akun.getSaldo() > holderHandphone3.harga) {
                            if ((akun.getSaldo() - holderHandphone3.harga) < 10000.0) {
                                System.out.println("Transaksi gagal, saldo pasca transaksi minimal Rp. 10.000");
                            } else {
                                akun.setSaldo(akun.getSaldo() - holderHandphone3.harga);
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo: " + akun.getSaldo());
                            }
                            
                        } else {
                            System.out.println("Transaksi gagal. Saldo tidak cukup");
                        }
                        break;
                    case 3:
                        Handphone holderHandphone4 = listHandphones.get(3);
                        if (akun.getSaldo() > holderHandphone4.harga) {
                            if ((akun.getSaldo() - holderHandphone4.harga) < 10000.0) {
                                System.out.println("Transaksi gagal, saldo pasca transaksi minimal Rp. 10.000");
                            } else {
                                akun.setSaldo(akun.getSaldo() - holderHandphone4.harga);
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo: " + akun.getSaldo());
                            }
                            
                        } else {
                            System.out.println("Transaksi gagal. Saldo tidak cukup");
                        }
                        break;
                    case 4:
                        Handphone holderHandphone5 = listHandphones.get(4);
                        if (akun.getSaldo() > holderHandphone5.harga) {
                            if ((akun.getSaldo() - holderHandphone5.harga) < 10000.0) {
                                System.out.println("Transaksi gagal, saldo pasca transaksi minimal Rp. 10.000");
                            } else {
                                akun.setSaldo(akun.getSaldo() - holderHandphone5.harga);
                                System.out.println("Transaksi berhasil");
                                System.out.println("Sisa saldo: " + akun.getSaldo());
                            }
                            
                        } else {
                            System.out.println("Transaksi gagal. Saldo tidak cukup");
                        }
                        break;
                    case 9:
                        tampilanAkun(akun);
                        break;
                    default:
                        System.out.println("Tolong masukkan input dengan benar");
                        break;
                        
                }
                check = false;
            } else {
                System.out.println("Tolong masukkan input dengan benar.");
            }
        }
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
                    if (validatePIN(i, holderAkun.getPIN())) {
                        tampilanAkun(holderAkun);
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


    // static boolean validateNoPelanggan(int index, String noPelanggan) {
    //     System.out.println("=========================================================");
    //     return false;
    // }

    static boolean validatePIN(int index, String PIN) {
        System.out.println("=========================================================");
        System.out.print("Masukkan PIN anda (3 kali kesempatan): ");
        for (int i = 3; i > 0;i--) {
            String holderPass = input.nextLine();
            if (holderPass.equals(PIN)) {
                return true;
            } else if (!holderPass.equals(PIN)) {
                System.out.println("PIN salah. " + (i - 1) + " kesempatan lagi");
                if ((i - 1) == 0) {
                    System.out.println("Akun terblokir");
                    listAkun.remove(index);
                    break;
                }
                
            }
        }
        return false;

    }
    public static void main (String[] args){
        listAkun.add(new Akun("Javed", "3809809630", "123456"));
        listAkun.add(new Akun("Ujang", "5655509630", "123456"));
        listAkun.add(new Akun("Supardi", "7442396390", "123456"));

        Akun tesHarga = listAkun.get(0);
        tesHarga.setSaldo(5000000);

        listHandphones.add(new Handphone("Samsul Universe", 1500000)); //1.500.000
        listHandphones.add(new Handphone("Blueberry Bold 9900", 2500000)); //2.500.000
        listHandphones.add(new Handphone("Konia 8210 ", 500000)); //500.000
        listHandphones.add(new Handphone("Siomay MI 8 Big ", 5000000)); //5.000.000
        listHandphones.add(new Handphone("Ipul Newbie Min", 12000000)); //12.000.000


        ui();
    }
}
