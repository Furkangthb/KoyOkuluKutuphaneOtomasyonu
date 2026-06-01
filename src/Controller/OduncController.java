package Controller;

import Dao.OduncDAO;
import Model.OduncIslem;
import javax.swing.JOptionPane;
import java.util.List;

public class OduncController {

	private OduncDAO dao;

	public OduncController() {
		this.dao = new OduncDAO();
	}

	public boolean oduncVer(String kitapIdStr, String ogrenciNo) {
		if (kitapIdStr.trim().isEmpty() || ogrenciNo.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Kitap ID ve Öğrenci No boş bırakılamaz!", "Uyarı",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		int kitapId;
		try {
			kitapId = Integer.parseInt(kitapIdStr.trim());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Kitap ID sayısal olmalıdır!", "Hata",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		boolean basarili = dao.oduncVer(kitapId, ogrenciNo);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Kitap başarıyla ödünç verildi!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "İşlem başarısız! Kitap zaten ödünçte veya öğrenci bulunamadı.",
					"Hata", JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public boolean iadeAl(int islemId, int kitapId) {
		boolean basarili = dao.iadeAl(islemId, kitapId);
		if (basarili) {
			JOptionPane.showMessageDialog(null, "Kitap başarıyla iade alındı!", "Başarılı",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "İade işlemi sırasında hata oluştu!", "Hata",
					JOptionPane.ERROR_MESSAGE);
		}
		return basarili;
	}

	public List<OduncIslem> aktifOduncleriGetir() {
		return dao.aktifOduncleriGetir();
	}

	public List<OduncIslem> ogrencininKitaplariniGetir(String ogrenciNo) {
		return dao.ogrencininKitaplariniGetir(ogrenciNo);
	}
}
