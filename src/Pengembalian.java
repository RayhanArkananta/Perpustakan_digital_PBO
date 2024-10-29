public class Pengembalian extends Transaksi {
    public Pengembalian(Anggota anggota, Buku buku) {
        super(anggota, buku);
    }

    @Override
    public void lakukanTransaksi() {
        if (anggota.sudahMeminjam(buku)) {
            buku.setStok(buku.getStok() + 1);
            anggota.kembalikanBuku(buku);
            System.out.println(anggota.getNama() + " mengembalikan buku " + buku.getJudul());
        } else {
            System.out.println(anggota.getNama() + " belum meminjam buku " + buku.getJudul() + ".");
        }
    }

    @Override
    public void tampilkanInfoTransaksi() {
        System.out.println("Pengembalian Buku: " + buku.getJudul() + " oleh " + anggota.getNama());
    }
}
