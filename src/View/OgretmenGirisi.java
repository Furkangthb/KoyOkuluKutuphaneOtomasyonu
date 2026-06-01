package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Model.Kullanici;
import View.panelOgretmen.panelKitapYonetim;
import View.panelOgretmen.panelOduncİade;
import View.panelOgretmen.panelRaporlar;
import View.panelOgretmen.panelUyeKayit;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class OgretmenGirisi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Model.Kullanici aktifKullanici;

	private panelKitapYonetim kitapYonetimPanel;
	private panelUyeKayit uyeKayitPanel;
	private panelOduncİade oduncIadePanel;
	private panelRaporlar raporPanel;
	
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
					OgretmenGirisi frame = new OgretmenGirisi(testOgrenci);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OgretmenGirisi(Model.Kullanici kullanici) {
		this.aktifKullanici = kullanici;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(30, 41, 59));
		panelMenu.setPreferredSize(new Dimension(220, 0));
		contentPane.add(panelMenu, BorderLayout.WEST);

		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[] { 0 };
		gbl_panelMenu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelMenu.columnWeights = new double[] { 1.0 };
		gbl_panelMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		panelMenu.setLayout(gbl_panelMenu);

		JPanel panelKartlar = new JPanel();
		contentPane.add(panelKartlar, BorderLayout.CENTER);
		panelKartlar.setLayout(new CardLayout(0, 0));

		kitapYonetimPanel = new panelKitapYonetim();
		uyeKayitPanel = new panelUyeKayit();
		oduncIadePanel = new panelOduncİade();
		raporPanel = new panelRaporlar();

		panelKartlar.add(kitapYonetimPanel, "KitapYonetim");
		panelKartlar.add(uyeKayitPanel, "Kayit");
		panelKartlar.add(oduncIadePanel, "OduncIade");
		panelKartlar.add(raporPanel, "Raporlar");

		Insets standartBosluk = new Insets(10, 20, 10, 20);

		JButton btnKitapYonetim = new JButton("Kitap Yönetimi");
		btnKitapYonetim.setPreferredSize(new Dimension(150, 40));
		btnKitapYonetim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelKartlar.getLayout();
				cl.show(panelKartlar, "KitapYonetim");
				kitapYonetimPanel.tabloyuYenile();
			}
		});
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn1.insets = standartBosluk; gbc_btn1.gridx = 0; gbc_btn1.gridy = 0;
		panelMenu.add(btnKitapYonetim, gbc_btn1);

		JButton btnUyeKayit = new JButton("Üye Kayıt");
		btnUyeKayit.setPreferredSize(new Dimension(150, 40));
		btnUyeKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelKartlar.getLayout();
				cl.show(panelKartlar, "Kayit");
				uyeKayitPanel.uyeleriYenile();
			}
		});
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn2.insets = standartBosluk; gbc_btn2.gridx = 0; gbc_btn2.gridy = 1;
		panelMenu.add(btnUyeKayit, gbc_btn2);

		JButton btnOduncIade = new JButton("Ödünç/İade");
		btnOduncIade.setPreferredSize(new Dimension(150, 40));
		btnOduncIade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelKartlar.getLayout();
				cl.show(panelKartlar, "OduncIade");
				oduncIadePanel.oduncleriYenile();
			}
		});
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn3.insets = standartBosluk; gbc_btn3.gridx = 0; gbc_btn3.gridy = 2;
		panelMenu.add(btnOduncIade, gbc_btn3);

		JButton btnRaporlar = new JButton("Raporlar");
		btnRaporlar.setPreferredSize(new Dimension(150, 40));
		btnRaporlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panelKartlar.getLayout();
				cl.show(panelKartlar, "Raporlar");
			}
		});
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn4.insets = standartBosluk; gbc_btn4.gridx = 0; gbc_btn4.gridy = 3;
		panelMenu.add(btnRaporlar, gbc_btn4);

		JButton btnCikis = new JButton("Çıkış");
		btnCikis.setPreferredSize(new Dimension(150, 40));
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GirisEkrani().setVisible(true);
			}
		});
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn5.anchor = GridBagConstraints.SOUTH;
		gbc_btn5.insets = new Insets(10, 20, 30, 20);
		gbc_btn5.gridx = 0; gbc_btn5.gridy = 4;
		panelMenu.add(btnCikis, gbc_btn5);
	}
}