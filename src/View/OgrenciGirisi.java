package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.Kullanici;
import javax.swing.JComboBox;

public class OgrenciGirisi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelKartlar;
	private javax.swing.JTable tableKatalog;
	private javax.swing.JTextField txtArama;
	private JComboBox cmbKategori;
	private Kullanici aktifOgrenci;
	private javax.swing.JTable tableKitaplarim;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            javax.swing.UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				} catch (Exception ex) {
				    ex.printStackTrace();
				}
				try {
					// Test amaçlı sahte bir öğrenci oluşturup ekranı açıyoruz
					Kullanici testOgrenci = new Kullanici(1, "102030", "Furkan Yüksel", "1234", "OGRENCI");
					OgrenciGirisi frame = new OgrenciGirisi(testOgrenci);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kurucu Metot: Ekran açılırken giriş yapan öğrenciyi parametre olarak alır
	 */
	public OgrenciGirisi(Kullanici ogrenci) {
		this.aktifOgrenci = ogrenci; // Login ekranından gelen öğrenciyi değişkene atadık

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600); // Öğretmen ekranına göre biraz daha kompakt
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// --- SOL MENÜ (SİDEBAR) ---
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(30, 41, 59)); // Koyu lacivert
		panelMenu.setPreferredSize(new Dimension(220, 0));
		contentPane.add(panelMenu, BorderLayout.WEST);

		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[] { 0 };
		gbl_panelMenu.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelMenu.columnWeights = new double[] { 1.0 };
		gbl_panelMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 }; // Çıkış butonu en alta gitsin
		panelMenu.setLayout(gbl_panelMenu);

		// Hoşgeldin Yazısı
		JLabel lblHosgeldin = new JLabel("<html>Merhaba,<br>" + aktifOgrenci.getAdSoyad() + "</html>");
		lblHosgeldin.setForeground(Color.WHITE);
		lblHosgeldin.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblHosgeldin = new GridBagConstraints();
		gbc_lblHosgeldin.insets = new Insets(20, 10, 30, 10);
		gbc_lblHosgeldin.gridx = 0;
		gbc_lblHosgeldin.gridy = 0;
		panelMenu.add(lblHosgeldin, gbc_lblHosgeldin);

		Insets standartBosluk = new Insets(10, 20, 10, 20);

		JButton btnKatalog = new JButton("Kütüphane Kataloğu");
		btnKatalog.setPreferredSize(new Dimension(150, 40));
		GridBagConstraints gbc_btnKatalog = new GridBagConstraints();
		gbc_btnKatalog.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKatalog.insets = standartBosluk;
		gbc_btnKatalog.gridx = 0;
		gbc_btnKatalog.gridy = 1;
		panelMenu.add(btnKatalog, gbc_btnKatalog);

		JButton btnKitaplarim = new JButton("Üzerimdeki Kitaplar");
		btnKitaplarim.setPreferredSize(new Dimension(150, 40));
		GridBagConstraints gbc_btnKitaplarim = new GridBagConstraints();
		gbc_btnKitaplarim.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKitaplarim.insets = standartBosluk;
		gbc_btnKitaplarim.gridx = 0;
		gbc_btnKitaplarim.gridy = 2;
		panelMenu.add(btnKitaplarim, gbc_btnKitaplarim);

		JButton btnCikis = new JButton("Çıkış Yap");
		btnCikis.setPreferredSize(new Dimension(150, 40));
		GridBagConstraints gbc_btnCikis = new GridBagConstraints();
		gbc_btnCikis.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCikis.anchor = GridBagConstraints.SOUTH;
		gbc_btnCikis.insets = new Insets(10, 20, 30, 20);
		gbc_btnCikis.gridx = 0;
		gbc_btnCikis.gridy = 4;
		panelMenu.add(btnCikis, gbc_btnCikis);

		// --- SAĞ TARAF (KARTLAR / SAYFALAR) ---
		panelKartlar = new JPanel();
		contentPane.add(panelKartlar, BorderLayout.CENTER);
		panelKartlar.setLayout(new CardLayout(0, 0));

		// 1. Sayfa: Katalog
		// 1. Sayfa: Katalog (Kütüphane Araması)
		JPanel panelKatalog = new JPanel();
		panelKatalog.setBackground(Color.WHITE);
		panelKatalog.setLayout(new BorderLayout(0, 0));
		panelKartlar.add(panelKatalog, "Katalog");

		// --- Üst Arama Çubuğu ---
		JPanel panelArama = new JPanel();
		panelArama.setBackground(new Color(240, 248, 255)); // Ferah açık mavi bir arka plan
		panelKatalog.add(panelArama, BorderLayout.NORTH);

		JLabel lblAra = new JLabel("Kitap Ara ");
		lblAra.setFont(new Font("Dialog", Font.BOLD, 14));
		panelArama.add(lblAra);

		txtArama = new javax.swing.JTextField();
		txtArama.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtArama.setColumns(30);
		panelArama.add(txtArama);

		cmbKategori = new JComboBox();
		cmbKategori = new JComboBox<>(new String[] { "Tümü", "Aşk (Romantik)", "Korku", "Gerilim", "Polisiye",
				"Bilimkurgu", "Fantastik", "Tarihi Roman", "Dram", "Mizah", "Distopya / Ütopya" });
		cmbKategori.setFont(new Font("Dialog", Font.PLAIN, 13));
		panelArama.add(cmbKategori);

		cmbKategori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrele();
			}
		});
		panelArama.add(cmbKategori);

		// Arama Motoru Mantığı (Öğrenci harf girdikçe tablo canlı filtrelenir)
		txtArama.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				filtrele();
			}
		});

		// --- Katalog Tablosu ---
		javax.swing.JScrollPane scrollPaneKatalog = new javax.swing.JScrollPane();
		panelKatalog.add(scrollPaneKatalog, BorderLayout.CENTER);

		tableKatalog = new javax.swing.JTable();
		// Tablo Modelini "Sadece Okunabilir" (Read-Only) yapıyoruz
		tableKatalog.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Kitap ID", "Kitap Adı", "Yazar", "Kategori", "Durum" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column]; // Hiçbir hücreye çift tıklayıp yazılamaz
			}
		});
		tableKatalog.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
			public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
					boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				int modelRow = table.convertRowIndexToModel(row);
				String durum = table.getModel().getValueAt(modelRow, 4) != null
						? table.getModel().getValueAt(modelRow, 4).toString()
						: "";
				if (!isSelected) {
					if (durum.equals("Ödünçte")) {
						setBackground(new Color(255, 220, 220)); // kırmızımsı
					} else {
						setBackground(Color.WHITE);
					}
				}
				return this;
			}
		});

		tableKatalog.setFont(new Font("Dialog", Font.PLAIN, 12));
		tableKatalog.setRowHeight(25); // Satırları biraz genişlettik, daha şık dursun
		scrollPaneKatalog.setViewportView(tableKatalog);

		// 2. Sayfa: Kitaplarım
		// 2. Sayfa: Kitaplarım (Ödünç Geçmişi)
		JPanel panelKitaplarim = new JPanel();
		panelKitaplarim.setBackground(Color.WHITE);
		panelKitaplarim.setLayout(new BorderLayout(0, 0));
		panelKartlar.add(panelKitaplarim, "Kitaplarim");

		// Üst Başlık
		JLabel lblKitaplarimBaslik = new JLabel(" Ödünç Aldığım Kitaplar & Geçmişim");
		lblKitaplarimBaslik.setFont(new Font("Dialog", Font.BOLD, 18));
		lblKitaplarimBaslik.setBorder(new EmptyBorder(15, 10, 15, 10));
		panelKitaplarim.add(lblKitaplarimBaslik, BorderLayout.NORTH);

		// Tablo Alanı
		javax.swing.JScrollPane scrollKitaplarim = new javax.swing.JScrollPane();
		panelKitaplarim.add(scrollKitaplarim, BorderLayout.CENTER);

		tableKitaplarim = new javax.swing.JTable();
		// Tablo sadece okunabilir
		tableKitaplarim.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "İşlem Numarası", "Kitap Adı", "Alış Tarihi", "İade Tarihi", "Durum" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableKitaplarim.setFont(new Font("Dialog", Font.PLAIN, 12));
		tableKitaplarim.setRowHeight(25);
		scrollKitaplarim.setViewportView(tableKitaplarim);
		// --- BUTON TIKLAMA (YÖNLENDİRME) OLAYLARI ---
		btnKatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelKartlar.getLayout();
				cl.show(panelKartlar, "Katalog");
			}
		});

		btnKitaplarim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelKartlar.getLayout();
				cl.show(panelKartlar, "Kitaplarim");
			}
		});

		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GirisEkrani().setVisible(true);
			}
		});
		// Ekran açılışında verileri yükle
		katalogYenile();
		kitaplarimiYenile();
	}

	private void katalogYenile() {
		javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableKatalog.getModel();
		model.setRowCount(0);

		Controller.KitapController kc = new Controller.KitapController();
		java.util.List<Model.Kitap> kitapListesi = kc.tumKitaplariGetir();

		for (Model.Kitap k : kitapListesi) {
			Object[] satir = { k.getKitapId(), k.getBaslik(), k.getYazar(), k.getKategori(), k.getDurum() };
			model.addRow(satir);
		}
	}

	private void kitaplarimiYenile() {
		javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableKitaplarim.getModel();
		model.setRowCount(0);

		Controller.OduncController oc = new Controller.OduncController();
		java.util.List<Model.OduncIslem> liste = oc.ogrencininKitaplariniGetir(aktifOgrenci.getKullaniciNo());

		for (Model.OduncIslem o : liste) {
			String durum = (o.getTeslimEdildiMi() == 1) ? "İade Edildi" : "Şu an bende (Okunuyor)";
			String iadeTarihi = (o.getIadeTarihi() == null) ? "-" : o.getIadeTarihi();

			Object[] satir = { o.getIslemId(), o.getKitapBaslik(), o.getAlisTarihi(), iadeTarihi, durum };
			model.addRow(satir);
		}
	}

	private void filtrele() {
		DefaultTableModel model = (DefaultTableModel) tableKatalog.getModel();
		javax.swing.table.TableRowSorter<DefaultTableModel> sorter = new javax.swing.table.TableRowSorter<>(model);
		tableKatalog.setRowSorter(sorter);

		String metin = txtArama.getText();
		String kategori = (String) cmbKategori.getSelectedItem();

		java.util.List<RowFilter<Object, Object>> filtreler = new java.util.ArrayList<>();

		if (!metin.trim().isEmpty())
			filtreler.add(RowFilter.regexFilter("(?i)" + metin, 1, 2));

		if (kategori != null && !kategori.equals("Tümü"))
			filtreler.add(RowFilter.regexFilter("(?i)^" + kategori + "$", 3));

		sorter.setRowFilter(filtreler.isEmpty() ? null : RowFilter.andFilter(filtreler));
	}
}