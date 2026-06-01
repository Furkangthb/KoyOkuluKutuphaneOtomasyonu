package Model;

public class Kitap {
    private int kitapId;
    private String baslik;
    private String yazar;
    private String kategori;
    private String durum; 

    public Kitap() {}

    public Kitap(String baslik, String yazar, String kategori) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.kategori = kategori;
        this.durum = "Rafta"; 
    }

    public int getKitapId() { return kitapId; }
    public void setKitapId(int kitapId) { this.kitapId = kitapId; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public String getYazar() { return yazar; }
    public void setYazar(String yazar) { this.yazar = yazar; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getDurum() { return durum; }
    public void setDurum(String durum) { this.durum = durum; }
}