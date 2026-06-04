package VeriTabani;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBHelper {

	public static void tablolariOlustur() {

		String sqlKullanicilar = "CREATE TABLE IF NOT EXISTS Kullanicilar (\n"
				+ "    Kullanici_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" + "    Ad TEXT NOT NULL,\n"
				+ "    Soyad TEXT NOT NULL,\n" + "    OgrenciNo TEXT UNIQUE,\n" + "    Sifre TEXT NOT NULL,\n"
				+ "    Rol TEXT NOT NULL,\n" //
				+ "    Tema_Rengi TEXT DEFAULT '#1e293b'\n" + ");";

		String sqlKitaplar = "CREATE TABLE IF NOT EXISTS Kitaplar (\n"
				+ "    Kitap_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" + "    Baslik TEXT NOT NULL,\n"
				+ "    Yazar TEXT NOT NULL,\n" + "    Kategori TEXT NOT NULL,\n" + "    Durum TEXT DEFAULT 'Rafta'\n"
				+ ");";

		String sqlIslemler = "CREATE TABLE IF NOT EXISTS Islemler (\n"
				+ "    Islem_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" + "    Kitap_ID INTEGER,\n"
				+ "    Kullanici_ID INTEGER,\n" + "    Alis_Tarihi TEXT NOT NULL,\n" + "    Iade_Tarihi TEXT,\n"
				+ "    Teslim_Edildi_Mi INTEGER DEFAULT 0,\n"
				+ "    FOREIGN KEY(Kitap_ID) REFERENCES Kitaplar(Kitap_ID),\n"
				+ "    FOREIGN KEY(Kullanici_ID) REFERENCES Kullanicilar(Kullanici_ID)\n" + ");";

		try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {

			stmt.execute("PRAGMA foreign_keys = ON;");

			stmt.execute(sqlKullanicilar);
			stmt.execute(sqlKitaplar);
			stmt.execute(sqlIslemler);

			System.out.println("Tüm tablolar başarıyla oluşturuldu veya zaten mevcut.");

		} catch (Exception e) {
			System.out.println("Tablo oluşturma hatası: " + e.getMessage());
		}
	}

	public static void testKullanicilariniEkle() {
		String ogretmenEkle = "INSERT OR IGNORE INTO Kullanicilar (Ad, Soyad, OgrenciNo, Sifre, Rol) "
				+ "VALUES ('Sibel', 'Birtane Akar', 'admin', 'admin123', 'OGRETMEN');";
		String ogretmenEkle2 = "INSERT OR IGNORE INTO Kullanicilar (Ad, Soyad, OgrenciNo, Sifre, Rol) "
				+ "VALUES ('1', '1', '1', '1', 'OGRETMEN');";
		String ogrenciEkle = "INSERT OR IGNORE INTO Kullanicilar (Ad, Soyad, OgrenciNo, Sifre, Rol) "
				+ "VALUES ('Furkan', 'Yüksel', '102030', '1234', 'OGRENCI');";

		try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {

			stmt.execute(ogretmenEkle);
			stmt.execute(ogrenciEkle);
			stmt.execute(ogretmenEkle2);
			System.out.println("Test kullanıcıları (Öğretmen ve Öğrenci) başarıyla eklendi!");

		} catch (Exception e) {
			System.out.println("Kullanıcı ekleme hatası: " + e.getMessage());
		}
	}

	public static void testKitaplariniEkle() {
		String sqlKontrol = "SELECT COUNT(*) FROM Kitaplar";

		String sqlKitaplar = "INSERT INTO Kitaplar (Baslik, Yazar, Kategori) VALUES "
				// Aşk (Romantik)
				+ "('Aşk ve Gurur', 'Jane Austen', 'Aşk (Romantik)'),"
				+ "('Uğultulu Tepeler', 'Emily Brontë', 'Aşk (Romantik)'),"
				+ "('Anna Karenina', 'Lev Tolstoy', 'Aşk (Romantik)'),"
				+ "('Kolera Günlerinde Aşk', 'Gabriel García Márquez', 'Aşk (Romantik)'),"
				+ "('Masumiyet Müzesi', 'Orhan Pamuk', 'Aşk (Romantik)'),"

				// Korku
				+ "('O (It)', 'Stephen King', 'Korku')," + "('Dracula', 'Bram Stoker', 'Korku'),"
				+ "('Frankenstein', 'Mary Shelley', 'Korku')," + "('Hayvan Mezarlığı', 'Stephen King', 'Korku'),"
				+ "('Deliliğin Dağlarında', 'H.P. Lovecraft', 'Korku'),"

				// Gerilim
				+ "('Da Vinci Şifresi', 'Dan Brown', 'Gerilim')," + "('Trendeki Kız', 'Paula Hawkins', 'Gerilim'),"
				+ "('Sessiz Hasta', 'Alex Michaelides', 'Gerilim')," + "('Kayıp Kız', 'Gillian Flynn', 'Gerilim'),"
				+ "('Psikopat', 'Wulf Dorn', 'Gerilim'),"

				// Polisiye
				+ "('On Küçük Zenci', 'Agatha Christie', 'Polisiye'),"
				+ "('Doğu Ekspresinde Cinayet', 'Agatha Christie', 'Polisiye'),"
				+ "('Akıl Oyunlarının Gölgesinde', 'Arthur Conan Doyle', 'Polisiye'),"
				+ "('Ejderha Dövmeli Kız', 'Stieg Larsson', 'Polisiye')," + "('Kavim', 'Ahmet Ümit', 'Polisiye'),"

				// Bilimkurgu
				+ "('Dune', 'Frank Herbert', 'Bilimkurgu')," + "('Vakıf', 'Isaac Asimov', 'Bilimkurgu'),"
				+ "('Marslı', 'Andy Weir', 'Bilimkurgu'),"
				+ "('Karanlığın Sol Eli', 'Ursula K. Le Guin', 'Bilimkurgu'),"
				+ "('Cesur Yeni Dünya', 'Aldous Huxley', 'Bilimkurgu'),"

				// Fantastik
				+ "('Yüzüklerin Efendisi', 'J.R.R. Tolkien', 'Fantastik'),"
				+ "('Harry Potter ve Felsefe Taşı', 'J.K. Rowling', 'Fantastik'),"
				+ "('Taht Oyunları', 'George R.R. Martin', 'Fantastik'),"
				+ "('Rüzgarın Adı', 'Patrick Rothfuss', 'Fantastik')," + "('Hobbit', 'J.R.R. Tolkien', 'Fantastik'),"

				// Tarihi Roman
				+ "('Sefiller', 'Victor Hugo', 'Tarihi Roman'),"
				+ "('İki Şehrin Hikayesi', 'Charles Dickens', 'Tarihi Roman'),"
				+ "('Devlet Ana', 'Kemal Tahir', 'Tarihi Roman')," + "('Semerkant', 'Amin Maalouf', 'Tarihi Roman'),"
				+ "('Savaş ve Barış', 'Lev Tolstoy', 'Tarihi Roman'),"

				// Dram
				+ "('Uçurtma Avcısı', 'Khaled Hosseini', 'Dram')," + "('Bülbülü Öldürmek', 'Harper Lee', 'Dram'),"
				+ "('Gazap Üzümleri', 'John Steinbeck', 'Dram'),"
				+ "('Şeker Portakalı', 'José Mauro de Vasconcelos', 'Dram')," + "('Serenad', 'Zülfü Livaneli', 'Dram'),"

				// Mizah
				+ "('Otostopçunun Galaksi Rehberi', 'Douglas Adams', 'Mizah')," + "('Don Kişot', 'Cervantes', 'Mizah'),"
				+ "('Yaşar Ne Yaşar Ne Yaşamaz', 'Aziz Nesin', 'Mizah')," + "('Zübük', 'Aziz Nesin', 'Mizah'),"
				+ "('Deliler Boşandı', 'Aziz Nesin', 'Mizah'),"

				// Distopya / Ütopya
				+ "('1984', 'George Orwell', 'Distopya / Ütopya'),"
				+ "('Hayvan Çiftliği', 'George Orwell', 'Distopya / Ütopya'),"
				+ "('Fahrenheit 451', 'Ray Bradbury', 'Distopya / Ütopya'),"
				+ "('Damızlık Kızın Öyküsü', 'Margaret Atwood', 'Distopya / Ütopya'),"
				+ "('Biz', 'Yevgeni Zamyatin', 'Distopya / Ütopya');";

		try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {

			boolean tabloBos = false;

			try (ResultSet rs = stmt.executeQuery(sqlKontrol)) {
				if (rs.next() && rs.getInt(1) == 0) {
					tabloBos = true;
				}
			}
			if (tabloBos) {
				stmt.execute(sqlKitaplar);
				System.out.println("Örnek 50 kitap başarıyla kataloğa eklendi!");
			} else {
				System.out.println("Katalogda zaten kitaplar var, örnek veriler tekrar eklenmedi.");
			}

		} catch (Exception e) {
			System.out.println("Kitap ekleme hatası: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		tablolariOlustur();
		testKullanicilariniEkle();
		testKitaplariniEkle();
	}
}