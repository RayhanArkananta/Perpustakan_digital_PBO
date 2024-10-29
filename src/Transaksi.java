public abstract class Transaksi {
    protected Anggota anggota;
    protected Buku buku;

    public Transaksi(Anggota anggota, Buku buku) {
        this.anggota = anggota;
        this.buku = buku;
    }

    public abstract void lakukanTransaksi();
    public abstract void tampilkanInfoTransaksi();
}
