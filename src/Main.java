import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perpustaka perpustakaan = new Perpustaka("Perpustakaan Digital");
        Scanner scanner = new Scanner(System.in);
        Anggota anggotaAktif = null;

        while (true) {
            System.out.println("=== Selamat Datang di Sistem Perpustakaan Digital ===");

            while (anggotaAktif == null) {
                System.out.println("1. Login");
                System.out.println("2. Daftar Anggota Baru");
                System.out.print("Pilih opsi: ");
                int opsiLogin = scanner.nextInt();
                scanner.nextLine();

                if (opsiLogin == 1) {
                    System.out.print("Masukkan ID Anggota: ");
                    String idAnggota = scanner.nextLine();
                    anggotaAktif = perpustakaan.cariAnggota(idAnggota);

                    if (anggotaAktif != null) {
                        System.out.println("Login berhasil. Selamat datang, " + anggotaAktif.getNama() + "!");
                    } else {
                        System.out.println("ID Anggota tidak ditemukan. Silakan daftar terlebih dahulu.");
                    }

                } else if (opsiLogin == 2) {
                    System.out.print("Masukkan Nama Anda: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan ID Anggota: ");
                    String idAnggota = scanner.nextLine();

                    if (perpustakaan.cariAnggota(idAnggota) == null) {
                        anggotaAktif = new Anggota(nama, idAnggota);
                        perpustakaan.tambahAnggota(anggotaAktif);
                        System.out.println("Pendaftaran berhasil. Anda telah login sebagai anggota.");
                    } else {
                        System.out.println("ID Anggota sudah terdaftar. Silakan gunakan ID yang lain.");
                    }
                } else {
                    System.out.println("Opsi tidak valid.");
                }
            }

            while (true) {
                System.out.println("\n=== Menu Perpustakaan ===");
                System.out.println("1. Lakukan Peminjaman");
                System.out.println("2. Lakukan Pengembalian");
                System.out.println("3. Lihat Riwayat Transaksi");
                System.out.println("4. Keluar");
                System.out.print("Pilih opsi: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        perpustakaan.tampilkanDaftarBuku();
                        System.out.print("Pilih nomor buku yang ingin dipinjam: ");
                        int pilihanBukuPinjam = scanner.nextInt();
                        scanner.nextLine();

                        Buku bukuPinjam = perpustakaan.pilihBuku(pilihanBukuPinjam);
                        if (bukuPinjam != null) {
                            Transaksi peminjaman = new Peminjaman(anggotaAktif, bukuPinjam);
                            peminjaman.lakukanTransaksi();
                            perpustakaan.tambahTransaksi(peminjaman);
                        } else {
                            System.out.println("Buku tidak ditemukan.");
                        }
                        break;

                    case 2:
                        perpustakaan.tampilkanDaftarBuku();
                        System.out.print("Pilih nomor buku yang ingin dikembalikan: ");
                        int pilihanBukuKembali = scanner.nextInt();
                        scanner.nextLine();

                        Buku bukuKembali = perpustakaan.pilihBuku(pilihanBukuKembali);
                        if (bukuKembali != null) {
                            Transaksi pengembalian = new Pengembalian(anggotaAktif, bukuKembali);
                            pengembalian.lakukanTransaksi();
                            perpustakaan.tambahTransaksi(pengembalian);
                        } else {
                            System.out.println("Buku tidak ditemukan.");
                        }
                        break;

                    case 3:
                        perpustakaan.lihatRiwayatTransaksi();
                        break;

                    case 4:
                        System.out.println("Keluar dari Sistem.");
                        anggotaAktif = null;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

                if (anggotaAktif == null) {
                    break;
                }
            }
        }
    }
}
