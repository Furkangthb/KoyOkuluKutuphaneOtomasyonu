package Model;

public class OduncIslem {
	private int islemId;
	private int kitapId;
	private int kullaniciId;
	private String alisTarihi;
	private String iadeTarihi;
	private int teslimEdildiMi; 

	private String kitapBaslik;
	private String uyeAdSoyad;
	private String ogrenciNo;

	public OduncIslem() {
	}

	public int getIslemId() {
		return islemId;
	}

	public void setIslemId(int islemId) {
		this.islemId = islemId;
	}

	public int getKitapId() {
		return kitapId;
	}

	public void setKitapId(int kitapId) {
		this.kitapId = kitapId;
	}

	public int getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public String getAlisTarihi() {
		return alisTarihi;
	}

	public void setAlisTarihi(String alisTarihi) {
		this.alisTarihi = alisTarihi;
	}

	public String getIadeTarihi() {
		return iadeTarihi;
	}

	public void setIadeTarihi(String iadeTarihi) {
		this.iadeTarihi = iadeTarihi;
	}

	public int getTeslimEdildiMi() {
		return teslimEdildiMi;
	}

	public void setTeslimEdildiMi(int teslimEdildiMi) {
		this.teslimEdildiMi = teslimEdildiMi;
	}

	public String getKitapBaslik() {
		return kitapBaslik;
	}

	public void setKitapBaslik(String kitapBaslik) {
		this.kitapBaslik = kitapBaslik;
	}

	public String getUyeAdSoyad() {
		return uyeAdSoyad;
	}

	public void setUyeAdSoyad(String uyeAdSoyad) {
		this.uyeAdSoyad = uyeAdSoyad;
	}

	public String getOgrenciNo() {
		return ogrenciNo;
	}

	public void setOgrenciNo(String ogrenciNo) {
		this.ogrenciNo = ogrenciNo;
	}
}