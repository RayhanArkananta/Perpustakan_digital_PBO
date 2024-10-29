public class Peminjaman extends Transaksi {
    public Peminjaman(Anggota anggota, Buku buku) {
        super(anggota, buku);
    }

    @Override
    public void lakukanTransaksi() {
        if (!anggota.sudahMeminjam(buku)) {
            if (buku.tersedia()) {
                buku.setStok(buku.getStok() - 1);
                anggota.pinjamBuku(buku);
                System.out.println(anggota.getNama() + " meminjam buku " + buku.getJudul());
            } else {
                System.out.println("Buku " + buku.getJudul() + " tidak tersedia.");
            }
        } else {
            System.out.println(anggota.getNama() + " sudah meminjam buku " + buku.getJudul() + " sebelumnya.");
        }
    }

    @Override
    public void tampilkanInfoTransaksi() {
        System.out.println("Peminjaman Buku: " + buku.getJudul() + " oleh " + anggota.getNama());
    }
}
