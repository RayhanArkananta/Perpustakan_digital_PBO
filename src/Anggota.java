import java.util.ArrayList;
import java.util.List;

public class Anggota {
    private String nama;
    private String idAnggota;
    private List<Buku> bukuDipinjam;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
        this.bukuDipinjam = new ArrayList<>();
    }

    public String getNama() { return nama; }
    public String getIdAnggota() { return idAnggota; }
    public List<Buku> getBukuDipinjam() { return bukuDipinjam; }

    public boolean sudahMeminjam(Buku buku) {
        return bukuDipinjam.contains(buku);
    }

    public void pinjamBuku(Buku buku) {
        bukuDipinjam.add(buku);
    }

    public void kembalikanBuku(Buku buku) {
        bukuDipinjam.remove(buku);
    }
}
