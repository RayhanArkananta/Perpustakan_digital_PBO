public class Buku {
    private String isbn;
    private String judul;
    private String penulis;
    private int stok;

    public Buku(String isbn, String judul, String penulis, int stok) {
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.stok = Math.min(stok, 5);
    }

    public String getIsbn() { return isbn; }
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public int getStok() { return stok; }

    public void setStok(int stok) {
        this.stok = Math.min(stok, 5);
    }

    public boolean tersedia() {
        return stok > 0;
    }
}
