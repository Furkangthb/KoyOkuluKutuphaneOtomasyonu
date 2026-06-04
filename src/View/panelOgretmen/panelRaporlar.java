package View.panelOgretmen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import Dao.RaporDAO;

public class panelRaporlar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tableGenelRapor;
	private JTextField txtOgrenciNo;
	private JTable tableKarne;
	private DefaultTableModel karneModel;

	public panelRaporlar() {
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(248, 250, 252));

		JPanel panelUst = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10));
		panelUst.setBackground(new Color(241, 245, 249));
		panelUst.setBorder(new EmptyBorder(8, 12, 8, 12));
		add(panelUst, BorderLayout.NORTH);

		JButton btnEnCok = new JButton("En Çok Okunanlar");
		btnEnCok.setFont(new Font("Dialog", Font.BOLD, 13));
		btnEnCok.setForeground(Color.WHITE);
		btnEnCok.setBackground(new Color(37, 99, 235));
		btnEnCok.setFocusPainted(false);
		btnEnCok.setBorderPainted(false);
		btnEnCok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnCok.setPreferredSize(new Dimension(btnEnCok.getPreferredSize().width + 20, 34));
		btnEnCok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnEnCok.isEnabled()) {
					btnEnCok.setBackground(new Color(29, 78, 216));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (btnEnCok.isEnabled()) {
					btnEnCok.setBackground(new Color(37, 99, 235));
				}
			}
		});
		btnEnCok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				raporGoster(new RaporDAO().enCokOkunanKitaplar(), new String[] { "Kitap Adı", "Okunma Sayısı" });
			}
		});
		panelUst.add(btnEnCok);

		JButton btnKurdu = new JButton("Kitap Kurdu Üyeler");
		btnKurdu.setFont(new Font("Dialog", Font.BOLD, 13));
		btnKurdu.setForeground(Color.WHITE);
		btnKurdu.setBackground(new Color(37, 99, 235));
		btnKurdu.setFocusPainted(false);
		btnKurdu.setBorderPainted(false);
		btnKurdu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKurdu.setPreferredSize(new Dimension(btnKurdu.getPreferredSize().width + 20, 34));
		btnKurdu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnKurdu.isEnabled()) {
					btnKurdu.setBackground(new Color(29, 78, 216));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (btnKurdu.isEnabled()) {
					btnKurdu.setBackground(new Color(37, 99, 235));
				}
			}
		});
		btnKurdu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				raporGoster(new RaporDAO().kitapKurduUyeler(), new String[] { "Öğrenci Adı", "Okunan Kitap" });
			}
		});
		panelUst.add(btnKurdu);

		JButton btnAyin = new JButton("Ayın Kitap Kurdu");
		btnAyin.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAyin.setForeground(Color.WHITE);
		btnAyin.setBackground(new Color(245, 158, 11));
		btnAyin.setFocusPainted(false);
		btnAyin.setBorderPainted(false);
		btnAyin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAyin.setPreferredSize(new Dimension(btnAyin.getPreferredSize().width + 20, 34));
		btnAyin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnAyin.isEnabled()) {
					btnAyin.setBackground(new Color(217, 119, 6));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (btnAyin.isEnabled()) {
					btnAyin.setBackground(new Color(245, 158, 11));
				}
			}
		});
		btnAyin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kurdu = new RaporDAO().ayinKitapKurdu();
				javax.swing.JOptionPane.showMessageDialog(panelRaporlar.this, "Bu Ayın Kitap Kurdu:\n" + kurdu,
						"Ayın Kitap Kurdu", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		});
		panelUst.add(btnAyin);

		JPanel panelOrta = new JPanel(new BorderLayout(0, 0));
		panelOrta.setBackground(new Color(248, 250, 252));
		add(panelOrta, BorderLayout.CENTER);

		JPanel panelKarneBaslik = new JPanel(new BorderLayout());
		panelKarneBaslik.setBackground(new Color(248, 250, 252));

		JPanel panelBaslik = new JPanel(new BorderLayout());
		panelBaslik.setBackground(new Color(248, 250, 252));
		panelBaslik.setBorder(new EmptyBorder(16, 20, 8, 20));
		JLabel lblBaslikTxt = new JLabel("Öğrenci Karnesi");
		lblBaslikTxt.setFont(new Font("Dialog", Font.BOLD, 22));
		lblBaslikTxt.setForeground(new Color(30, 41, 59));
		panelBaslik.add(lblBaslikTxt, BorderLayout.WEST);
		panelKarneBaslik.add(panelBaslik, BorderLayout.NORTH);

		JPanel panelKarneUst = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10));
		panelKarneUst.setBackground(new Color(241, 245, 249));
		panelKarneUst.setBorder(new EmptyBorder(8, 12, 8, 12));
		panelKarneBaslik.add(panelKarneUst, BorderLayout.CENTER);
		panelOrta.add(panelKarneBaslik, BorderLayout.NORTH);

		JLabel lblKarneBaslik = new JLabel("Öğrenci No:");
		lblKarneBaslik.setFont(new Font("Dialog", Font.PLAIN, 13));
		panelKarneUst.add(lblKarneBaslik);

		txtOgrenciNo = new JTextField(10);
		txtOgrenciNo.setFont(new Font("Dialog", Font.PLAIN, 13));
		panelKarneUst.add(txtOgrenciNo);

		JButton btnKarneGetir = new JButton("Getir");
		btnKarneGetir.setFont(new Font("Dialog", Font.BOLD, 13));
		btnKarneGetir.setForeground(Color.WHITE);
		btnKarneGetir.setBackground(new Color(16, 185, 129));
		btnKarneGetir.setFocusPainted(false);
		btnKarneGetir.setBorderPainted(false);
		btnKarneGetir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKarneGetir.setPreferredSize(new Dimension(btnKarneGetir.getPreferredSize().width + 20, 34));
		btnKarneGetir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnKarneGetir.isEnabled()) {
					btnKarneGetir.setBackground(new Color(5, 150, 105));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (btnKarneGetir.isEnabled()) {
					btnKarneGetir.setBackground(new Color(16, 185, 129));
				}
			}
		});
		panelKarneUst.add(btnKarneGetir);

		JButton btnTxtExport = new JButton("TXT Aktar");
		btnTxtExport.setFont(new Font("Dialog", Font.BOLD, 13));
		btnTxtExport.setForeground(Color.WHITE);
		btnTxtExport.setBackground(new Color(100, 116, 139));
		btnTxtExport.setFocusPainted(false);
		btnTxtExport.setBorderPainted(false);
		btnTxtExport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTxtExport.setPreferredSize(new Dimension(btnTxtExport.getPreferredSize().width + 20, 34));
		btnTxtExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnTxtExport.isEnabled()) {
					btnTxtExport.setBackground(new Color(71, 85, 105));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (btnTxtExport.isEnabled()) {
					btnTxtExport.setBackground(new Color(100, 116, 139));
				}
			}
		});
		panelKarneUst.add(btnTxtExport);

		JButton btnCsvExport = new JButton("CSV Aktar");
		btnCsvExport.setFont(new Font("Dialog", Font.BOLD, 13));
		btnCsvExport.setForeground(Color.WHITE);
		btnCsvExport.setBackground(new Color(100, 116, 139));
		btnCsvExport.setFocusPainted(false);
		btnCsvExport.setBorderPainted(false);
		btnCsvExport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCsvExport.setPreferredSize(new Dimension(btnCsvExport.getPreferredSize().width + 20, 34));
		btnCsvExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnCsvExport.isEnabled()) {
					btnCsvExport.setBackground(new Color(71, 85, 105));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (btnCsvExport.isEnabled()) {
					btnCsvExport.setBackground(new Color(100, 116, 139));
				}
			}
		});
		panelKarneUst.add(btnCsvExport);

		karneModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Kitap Adı", "Yazar", "Kategori", "Alış Tarihi", "İade Tarihi" }) {
			public boolean isCellEditable(int r, int c) {
				return false;
			}
		};
		tableKarne = new JTable(karneModel);

		tableKarne.setFont(new Font("Dialog", Font.PLAIN, 12));
		tableKarne.setRowHeight(30);
		tableKarne.setShowVerticalLines(true);
		tableKarne.setGridColor(new Color(203, 213, 225));
		tableKarne.setSelectionBackground(new Color(219, 234, 254));
		tableKarne.setSelectionForeground(new Color(30, 41, 59));
		tableKarne.setBackground(Color.WHITE);
		tableKarne.setIntercellSpacing(new Dimension(0, 0));
		tableKarne.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
		tableKarne.getTableHeader().setBackground(new Color(226, 232, 240));
		tableKarne.getTableHeader().setForeground(new Color(30, 41, 59));
		tableKarne.getTableHeader().setPreferredSize(new Dimension(tableKarne.getTableHeader().getWidth(), 34));
		tableKarne.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollKarne = new JScrollPane(tableKarne);
		scrollKarne.setBorder(new EmptyBorder(0, 16, 8, 16));
		panelOrta.add(scrollKarne, BorderLayout.CENTER);

		btnKarneGetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = txtOgrenciNo.getText().trim();
				if (no.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(panelRaporlar.this, "Öğrenci No girin!", "Uyarı",
							javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				karneModel.setRowCount(0);
				java.util.List<String[]> liste = new RaporDAO().ogrenciKarnesi(no);
				if (liste.isEmpty()) {
					javax.swing.JOptionPane.showMessageDialog(panelRaporlar.this, "Bu öğrenciye ait kayıt bulunamadı.",
							"Bilgi", javax.swing.JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				for (String[] satir : liste) {
					karneModel.addRow(satir);
				}
			}
		});

		btnTxtExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disaAktar(".txt", true);
			}
		});

		btnCsvExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disaAktar(".csv", false);
			}
		});

		JPanel panelAlt = new JPanel(new BorderLayout());
		panelAlt.setBackground(new Color(248, 250, 252));
		panelAlt.setBorder(new EmptyBorder(8, 16, 16, 16));
		add(panelAlt, BorderLayout.SOUTH);

		JLabel lblRapor = new JLabel("Genel Rapor Sonuçları");
		lblRapor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRapor.setForeground(new Color(30, 41, 59));
		lblRapor.setBorder(new EmptyBorder(0, 0, 8, 0));
		panelAlt.add(lblRapor, BorderLayout.NORTH);

		JScrollPane scrollPaneGenel = new JScrollPane();
		panelAlt.add(scrollPaneGenel, BorderLayout.CENTER);

		tableGenelRapor = new JTable();
		tableGenelRapor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Bilgi", "Değer" }));

		tableGenelRapor.setFont(new Font("Dialog", Font.PLAIN, 12));
		tableGenelRapor.setRowHeight(30);
		tableGenelRapor.setShowVerticalLines(true);
		tableGenelRapor.setGridColor(new Color(203, 213, 225));
		tableGenelRapor.setSelectionBackground(new Color(219, 234, 254));
		tableGenelRapor.setSelectionForeground(new Color(30, 41, 59));
		tableGenelRapor.setBackground(Color.WHITE);
		tableGenelRapor.setIntercellSpacing(new Dimension(0, 0));
		tableGenelRapor.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
		tableGenelRapor.getTableHeader().setBackground(new Color(226, 232, 240));
		tableGenelRapor.getTableHeader().setForeground(new Color(30, 41, 59));
		tableGenelRapor.getTableHeader()
				.setPreferredSize(new Dimension(tableGenelRapor.getTableHeader().getWidth(), 34));
		tableGenelRapor.getTableHeader().setReorderingAllowed(false);

		scrollPaneGenel.setViewportView(tableGenelRapor);
		scrollPaneGenel.setPreferredSize(new Dimension(0, 160));
	}

	private void raporGoster(java.util.List<String[]> liste, String[] kolonlar) {
		DefaultTableModel m = new DefaultTableModel(kolonlar, 0);
		for (String[] satir : liste) {
			m.addRow(satir);
		}
		tableGenelRapor.setModel(m);
		tableGenelRapor.setFont(new Font("Dialog", Font.PLAIN, 12));
		tableGenelRapor.setRowHeight(30);
		tableGenelRapor.setShowVerticalLines(true);
		tableGenelRapor.setGridColor(new Color(203, 213, 225));
		tableGenelRapor.setSelectionBackground(new Color(219, 234, 254));
		tableGenelRapor.setSelectionForeground(new Color(30, 41, 59));
		tableGenelRapor.setBackground(Color.WHITE);
		tableGenelRapor.setIntercellSpacing(new Dimension(0, 0));
		tableGenelRapor.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
		tableGenelRapor.getTableHeader().setBackground(new Color(226, 232, 240));
		tableGenelRapor.getTableHeader().setForeground(new Color(30, 41, 59));
		tableGenelRapor.getTableHeader()
				.setPreferredSize(new Dimension(tableGenelRapor.getTableHeader().getWidth(), 34));
		tableGenelRapor.getTableHeader().setReorderingAllowed(false);
	}

	private void disaAktar(String uzanti, boolean txt) {
		if (karneModel.getRowCount() == 0) {
			javax.swing.JOptionPane.showMessageDialog(this, "Aktarılacak veri yok!", "Uyarı",
					javax.swing.JOptionPane.WARNING_MESSAGE);
			return;
		}

		javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
		fc.setSelectedFile(new java.io.File("karne_" + txtOgrenciNo.getText().trim() + uzanti));

		if (fc.showSaveDialog(this) != javax.swing.JFileChooser.APPROVE_OPTION) {
			return;
		}

		try (java.io.PrintWriter pw = new java.io.PrintWriter(
				new java.io.FileWriter(fc.getSelectedFile(), java.nio.charset.StandardCharsets.UTF_8))) {

			if (txt) {
				pw.println("Öğrenci Karnesi - No: " + txtOgrenciNo.getText().trim());
				pw.println("=".repeat(60));
				for (int i = 0; i < karneModel.getRowCount(); i++) {
					pw.printf("%-35s %-20s %-10s %s -> %s%n", karneModel.getValueAt(i, 0), karneModel.getValueAt(i, 1),
							karneModel.getValueAt(i, 2), karneModel.getValueAt(i, 3), karneModel.getValueAt(i, 4));
				}
			} else {
				pw.println("Kitap Adı,Yazar,Kategori,Alış Tarihi,İade Tarihi");
				for (int i = 0; i < karneModel.getRowCount(); i++) {
					pw.printf("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"%n", karneModel.getValueAt(i, 0),
							karneModel.getValueAt(i, 1), karneModel.getValueAt(i, 2), karneModel.getValueAt(i, 3),
							karneModel.getValueAt(i, 4));
				}
			}
			javax.swing.JOptionPane.showMessageDialog(this, "Dosya oluşturuldu!", "Başarılı",
					javax.swing.JOptionPane.INFORMATION_MESSAGE);
		} catch (java.io.IOException ex) {
			javax.swing.JOptionPane.showMessageDialog(this, "Hata: " + ex.getMessage(), "Hata",
					javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}
}