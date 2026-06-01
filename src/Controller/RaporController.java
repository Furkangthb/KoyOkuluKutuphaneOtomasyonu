package Controller;

import Dao.RaporDAO;
import java.util.List;

public class RaporController {

	private RaporDAO dao;

	public RaporController() {
		this.dao = new RaporDAO();
	}

	public List<String[]> enCokOkunanKitaplar() {
		return dao.enCokOkunanKitaplar();
	}

	public List<String[]> kitapKurduUyeler() {
		return dao.kitapKurduUyeler();
	}

	public String ayinKitapKurdu() {
		return dao.ayinKitapKurdu();
	}

	public List<String[]> ogrenciKarnesi(String ogrenciNo) {
		return dao.ogrenciKarnesi(ogrenciNo);
	}
}
