import java.util.ArrayList;
import java.util.List;

public class Perpustaka {
    private List<Buku> daftarBuku;
    private List<Anggota> daftarAnggota;
    private List<Transaksi> riwayatTransaksi;

    public Perpustaka(String nama) {
        this.daftarBuku = new ArrayList<>();
        this.daftarAnggota = new ArrayList<>();
        this.riwayatTransaksi = new ArrayList<>();

        daftarBuku.add(new Buku("001", "Buku A", "Penulis A", 5));
        daftarBuku.add(new Buku("002", "Buku B", "Penulis B", 5));
        daftarBuku.add(new Buku("003", "Buku C", "Penulis C", 5));
        daftarBuku.add(new Buku("004", "Buku D", "Penulis D", 5));
        daftarBuku.add(new Buku("005", "Buku E", "Penulis E", 5));
    }

    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.add(anggota);
    }

    public Anggota cariAnggota(String idAnggota) {
        for (Anggota anggota : daftarAnggota) {
            if (anggota.getIdAnggota().equals(idAnggota)) {
                return anggota;
            }
        }
        return null;
    }

    public void tampilkanDaftarBuku() {
        System.out.println("Daftar Buku:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku buku = daftarBuku.get(i);
            System.out.println((i + 1) + ". " + buku.getJudul() + " (Stok: " + buku.getStok() + ")");
        }
    }

    public Buku pilihBuku(int pilihan) {
        if (pilihan >= 1 && pilihan <= daftarBuku.size()) {
            return daftarBuku.get(pilihan - 1);
        }
        return null;
    }

    public void tambahTransaksi(Transaksi transaksi) {
        riwayatTransaksi.add(transaksi);
    }

    public void lihatRiwayatTransaksi() {
        System.out.println("Riwayat Transaksi:");
        for (Transaksi transaksi : riwayatTransaksi) {
            transaksi.tampilkanInfoTransaksi();
        }
    }
}
