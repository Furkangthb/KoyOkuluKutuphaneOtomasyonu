package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Controller.KullaniciController;

public class GirisEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOgrenciNo;
	private JPasswordField SifreOgrenci;
	private JTextField textFieldKullaniciAdi;
	private JPasswordField passwordFieldKullanici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			javax.swing.UIManager.put("control", new Color(248, 250, 252));
			javax.swing.UIManager.put("nimbusBase", new Color(30, 41, 59));
			javax.swing.UIManager.put("nimbusSelectionBackground", new Color(37, 99, 235));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					GirisEkrani frame = new GirisEkrani();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GirisEkrani() {
		VeriTabani.DBHelper.tablolariOlustur();
		VeriTabani.DBHelper.testKullanicilariniEkle();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 191, 188));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panelOgrenci = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = new ImageIcon("images/acikKitap.png").getImage();
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panel.add(panelOgrenci, "OGRENCI");
		panelOgrenci.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelSol = new JPanel();
		panelSol.setOpaque(false);
		panelOgrenci.add(panelSol);
		GridBagLayout gbl_panelSol = new GridBagLayout();

		panelSol.setLayout(gbl_panelSol);

		JLabel lblOgrenciBaslik = new JLabel("Kütüphaneye Hoş Geldiniz");
		lblOgrenciBaslik.setFont(new Font("Z003", Font.BOLD, 28));
		GridBagConstraints gbc_lblOgrenciBaslik = new GridBagConstraints();
		gbc_lblOgrenciBaslik.anchor = GridBagConstraints.SOUTH;
		gbc_lblOgrenciBaslik.weighty = 1.0;
		gbc_lblOgrenciBaslik.weightx = 1.0;
		gbc_lblOgrenciBaslik.insets = new Insets(0, 50, 20, 0);
		gbc_lblOgrenciBaslik.gridx = 0;
		gbc_lblOgrenciBaslik.gridy = 0;
		panelSol.add(lblOgrenciBaslik, gbc_lblOgrenciBaslik);

		JButton btnOgretmenGiris = new JButton("Öğretmen Girişi");
		btnOgretmenGiris.setForeground(new Color(0, 0, 0));
		btnOgretmenGiris.setFont(new Font("Z003", Font.BOLD, 16));
		btnOgretmenGiris.setBackground(new Color(192, 191, 188));
		btnOgretmenGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "OGRETMEN");
			}
		});
		GridBagConstraints gbc_btnOgretmenGiris = new GridBagConstraints();
		gbc_btnOgretmenGiris.insets = new Insets(0, 50, 0, 0);
		gbc_btnOgretmenGiris.weighty = 1.0;
		gbc_btnOgretmenGiris.weightx = 1.0;
		gbc_btnOgretmenGiris.anchor = GridBagConstraints.NORTH;
		gbc_btnOgretmenGiris.gridx = 0;
		gbc_btnOgretmenGiris.gridy = 1;
		panelSol.add(btnOgretmenGiris, gbc_btnOgretmenGiris);

		JPanel panelSag = new JPanel();
		panelSag.setBackground(new Color(255, 255, 255));
		panelSag.setOpaque(false);
		panelOgrenci.add(panelSag);
		GridBagLayout gbl_panelSag = new GridBagLayout();
		gbl_panelSag.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelSag.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelSag.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelSag.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelSag.setLayout(gbl_panelSag);

		JLabel lblOgrenciGirisi = new JLabel("Öğrenci Girişi");
		lblOgrenciGirisi.setFont(new Font("Z003", Font.BOLD, 28));
		GridBagConstraints gbc_lblOgrenciGirisi = new GridBagConstraints();
		gbc_lblOgrenciGirisi.gridwidth = 2;
		gbc_lblOgrenciGirisi.weighty = 1.0;
		gbc_lblOgrenciGirisi.weightx = 1.0;
		gbc_lblOgrenciGirisi.anchor = GridBagConstraints.SOUTH;
		gbc_lblOgrenciGirisi.insets = new Insets(0, 0, 20, 0);
		gbc_lblOgrenciGirisi.gridx = 0;
		gbc_lblOgrenciGirisi.gridy = 0;
		panelSag.add(lblOgrenciGirisi, gbc_lblOgrenciGirisi);

		JLabel lblNewLabel_2 = new JLabel("Öğrenci No:");
		lblNewLabel_2.setFont(new Font("Z003", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.insets = new Insets(5, 20, 5, 5);
		gbc_lblNewLabel_2.gridy = 1;
		panelSag.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textOgrenciNo = new JTextField();
		GridBagConstraints gbc_textOgrenciNo = new GridBagConstraints();
		gbc_textOgrenciNo.weightx = 1.0;
		gbc_textOgrenciNo.insets = new Insets(5, 5, 5, 40);
		gbc_textOgrenciNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOgrenciNo.gridx = 1;
		gbc_textOgrenciNo.gridy = 1;
		panelSag.add(textOgrenciNo, gbc_textOgrenciNo);
		textOgrenciNo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Şifre:");
		lblNewLabel_3.setFont(new Font("Z003", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(5, 20, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panelSag.add(lblNewLabel_3, gbc_lblNewLabel_3);

		SifreOgrenci = new JPasswordField();
		GridBagConstraints gbc_sifreOgrenci = new GridBagConstraints();
		gbc_sifreOgrenci.weightx = 1.0;
		gbc_sifreOgrenci.insets = new Insets(5, 5, 5, 40);
		gbc_sifreOgrenci.fill = GridBagConstraints.HORIZONTAL;
		gbc_sifreOgrenci.gridx = 1;
		gbc_sifreOgrenci.gridy = 2;
		panelSag.add(SifreOgrenci, gbc_sifreOgrenci);

		JButton btnOgrenciGirisYap = new JButton("Giriş Yap");
		btnOgrenciGirisYap.setFocusPainted(false);
		btnOgrenciGirisYap.setBorderPainted(false);
		btnOgrenciGirisYap.setFont(new Font("Z003", Font.BOLD, 16));
		btnOgrenciGirisYap.setForeground(new Color(0, 0, 0));
		btnOgrenciGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciController kc = new KullaniciController(GirisEkrani.this);
				kc.ogrenciGirisKontrol(textOgrenciNo.getText(), new String(SifreOgrenci.getPassword()));
			}
		});
		btnOgrenciGirisYap.setBackground(new Color(154, 153, 150));
		GridBagConstraints gbc_btnOgrenciGirisYap = new GridBagConstraints();
		gbc_btnOgrenciGirisYap.gridwidth = 2;
		gbc_btnOgrenciGirisYap.insets = new Insets(20, 40, 0, 40);
		gbc_btnOgrenciGirisYap.weighty = 1.0;
		gbc_btnOgrenciGirisYap.weightx = 1.0;
		gbc_btnOgrenciGirisYap.anchor = GridBagConstraints.NORTH;
		gbc_btnOgrenciGirisYap.gridx = 0;
		gbc_btnOgrenciGirisYap.gridy = 3;
		panelSag.add(btnOgrenciGirisYap, gbc_btnOgrenciGirisYap);

		JPanel panelOgretmen = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = new ImageIcon("images/kapaliKitap.png").getImage();

				int imgW = img.getWidth(this);
				int imgH = img.getHeight(this);

				if (imgW > 0 && imgH > 0) {
					double oran = Math.min((double) getWidth() / imgW, (double) getHeight() / imgH);

					int yeniGenislik = (int) (imgW * oran);
					int yeniYukseklik = (int) (imgH * oran);

					int x = (getWidth() - yeniGenislik) / 2;
					int y = (getHeight() - yeniYukseklik) / 2;

					g.drawImage(img, x, y, yeniGenislik, yeniYukseklik, this);
				}
			}
		};
		panel.add(panelOgretmen, "OGRETMEN");
		panelOgretmen.setLayout(new GridBagLayout());

		JPanel panelOgretmenIc = new JPanel();
		panelOgretmenIc.setBackground(new Color(30,41,59));
		panelOgretmenIc.setPreferredSize(new Dimension(320, 280));
		panelOgretmenIc.setOpaque(false);
		GridBagConstraints gbc_panelOgretmenIc = new GridBagConstraints();
		gbc_panelOgretmenIc.insets = new Insets(0, 20, 0, 20);
		gbc_panelOgretmenIc.anchor = GridBagConstraints.NORTH;
		panelOgretmen.add(panelOgretmenIc, gbc_panelOgretmenIc);
		GridBagLayout gbl_panelOgretmenIc = new GridBagLayout();
		gbl_panelOgretmenIc.columnWidths = new int[] { 0, 0, 0 };
		gbl_panelOgretmenIc.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelOgretmenIc.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelOgretmenIc.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelOgretmenIc.setLayout(gbl_panelOgretmenIc);

		JLabel lblYonetimGirisi = new JLabel("Yönetim Girişi");
		lblYonetimGirisi.setForeground(new Color(245, 194, 17));
		lblYonetimGirisi.setFont(new Font("Z003", Font.PLAIN, 28));
		GridBagConstraints gbc_lblYonetimGirisi = new GridBagConstraints();
		gbc_lblYonetimGirisi.weighty = 1.0;
		gbc_lblYonetimGirisi.weightx = 1.0;
		gbc_lblYonetimGirisi.gridwidth = 2;
		gbc_lblYonetimGirisi.anchor = GridBagConstraints.SOUTH;
		gbc_lblYonetimGirisi.insets = new Insets(0, 0, 30, 0);
		gbc_lblYonetimGirisi.gridx = 0;
		gbc_lblYonetimGirisi.gridy = 0;
		panelOgretmenIc.add(lblYonetimGirisi, gbc_lblYonetimGirisi);

		JLabel lblKullaniciAdi = new JLabel("Kullanıcı Adı:");
		lblKullaniciAdi.setFont(new Font("Z003", Font.PLAIN, 20));
		lblKullaniciAdi.setForeground(new Color(245, 194, 17));
		GridBagConstraints gbc_lblKullaniciAdi = new GridBagConstraints();
		gbc_lblKullaniciAdi.anchor = GridBagConstraints.EAST;
		gbc_lblKullaniciAdi.insets = new Insets(5, 10, 5, 10);
		gbc_lblKullaniciAdi.gridx = 0;
		gbc_lblKullaniciAdi.gridy = 1;
		panelOgretmenIc.add(lblKullaniciAdi, gbc_lblKullaniciAdi);

		textFieldKullaniciAdi = new JTextField();
		GridBagConstraints gbc_textFieldKullaniciAdi = new GridBagConstraints();
		gbc_textFieldKullaniciAdi.weightx = 1.0;
		gbc_textFieldKullaniciAdi.insets = new Insets(5, 0, 5, 20);
		gbc_textFieldKullaniciAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldKullaniciAdi.gridx = 1;
		gbc_textFieldKullaniciAdi.gridy = 1;
		panelOgretmenIc.add(textFieldKullaniciAdi, gbc_textFieldKullaniciAdi);
		textFieldKullaniciAdi.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Şifre:");
		lblNewLabel_6.setFont(new Font("Z003", Font.PLAIN, 20));
		lblNewLabel_6.setForeground(new Color(245, 194, 17));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(5, 10, 5, 10);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 2;
		panelOgretmenIc.add(lblNewLabel_6, gbc_lblNewLabel_6);

		passwordFieldKullanici = new JPasswordField();
		GridBagConstraints gbc_passwordFieldKullanici = new GridBagConstraints();
		gbc_passwordFieldKullanici.weightx = 1.0;
		gbc_passwordFieldKullanici.insets = new Insets(5, 0, 5, 20);
		gbc_passwordFieldKullanici.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldKullanici.gridx = 1;
		gbc_passwordFieldKullanici.gridy = 2;
		panelOgretmenIc.add(passwordFieldKullanici, gbc_passwordFieldKullanici);

		JButton btnKullaniciGirisYap = new JButton("Giriş Yap");
		btnKullaniciGirisYap.setFont(new Font("Z003", Font.PLAIN, 20));
		btnKullaniciGirisYap.setBackground(new Color(192, 191, 188));
		btnKullaniciGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KullaniciController kc = new KullaniciController(GirisEkrani.this);
				kc.ogretmenGirisKontrol(textFieldKullaniciAdi.getText(),
						new String(passwordFieldKullanici.getPassword()));
			}
		});
		GridBagConstraints gbc_btnKullaniciGirisYap = new GridBagConstraints();
		gbc_btnKullaniciGirisYap.insets = new Insets(25, 20, 5, 20);
		gbc_btnKullaniciGirisYap.weighty = 1.0;
		gbc_btnKullaniciGirisYap.weightx = 1.0;
		gbc_btnKullaniciGirisYap.gridwidth = 2;
		gbc_btnKullaniciGirisYap.gridx = 0;
		gbc_btnKullaniciGirisYap.gridy = 3;
		panelOgretmenIc.add(btnKullaniciGirisYap, gbc_btnKullaniciGirisYap);

		JButton btnOgrenciGirisi = new JButton("Öğrenci Girişi");
		btnOgrenciGirisi.setFont(new Font("Z003", Font.PLAIN, 18));
		btnOgrenciGirisi.setBackground(new Color(192, 191, 188));
		
		btnOgrenciGirisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "OGRENCI");
			}
		});

		GridBagConstraints gbc_btnOgrenciGirisi = new GridBagConstraints();
		gbc_btnOgrenciGirisi.gridwidth = 2;
		gbc_btnOgrenciGirisi.insets = new Insets(0, 0, 5, 5);
		gbc_btnOgrenciGirisi.gridx = 0;
		gbc_btnOgrenciGirisi.gridy = 4;
		panelOgretmenIc.add(btnOgrenciGirisi, gbc_btnOgrenciGirisi);

	}

}