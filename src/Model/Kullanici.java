package Model;

public class Kullanici {
    private int id;
    private String kullaniciNo; 
    private String adSoyad;
    private String sifre;
    private String rol; 

    public Kullanici() {}

    public Kullanici(int id, String kullaniciNo, String adSoyad, String sifre, String rol) {
        this.id = id;
        this.kullaniciNo = kullaniciNo;
        this.adSoyad = adSoyad;
        this.sifre = sifre;
        this.rol = rol;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKullaniciNo() { return kullaniciNo; }
    public void setKullaniciNo(String kullaniciNo) { this.kullaniciNo = kullaniciNo; }

    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }

    public String getSifre() { return sifre; }
    public void setSifre(String sifre) { this.sifre = sifre; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}