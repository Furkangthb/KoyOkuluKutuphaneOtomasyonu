package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Model.Kullanici;
import View.panelOgretmen.panelKitapYonetim;
import View.panelOgretmen.panelOduncİade;
import View.panelOgretmen.panelRaporlar;
import View.panelOgretmen.panelUyeKayit;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class OgretmenGirisi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Model.Kullanici aktifKullanici;
    private JPanel panelKartlar;

    private panelKitapYonetim kitapYonetimPanel;
    private panelUyeKayit uyeKayitPanel;
    private panelOduncİade oduncIadePanel;
    private panelRaporlar raporPanel;

    private JButton btnKitapYonetim;
    private JButton btnUyeKayit;
    private JButton btnOduncIade;
    private JButton btnRaporlar;

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
                    Kullanici testOgretmen = new Kullanici(1, "admin", "Furkan Yüksel", "admin123", "OGRETMEN");
                    OgretmenGirisi frame = new OgretmenGirisi(testOgretmen);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public OgretmenGirisi(Model.Kullanici kullanici) {
        this.aktifKullanici = kullanici;
        setTitle("Kütüphane — Öğretmen Paneli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1240, 680);
        setLocationRelativeTo(null); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(248, 250, 252)); 
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(30, 41, 59)); 
        panelMenu.setPreferredSize(new Dimension(240, 0));
        contentPane.add(panelMenu, BorderLayout.WEST);

        GridBagLayout gbl_panelMenu = new GridBagLayout();
        gbl_panelMenu.columnWidths = new int[] { 0 };
        gbl_panelMenu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panelMenu.columnWeights = new double[] { 1.0 };
        gbl_panelMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
        panelMenu.setLayout(gbl_panelMenu);

     
        JLabel lblBaslik = new JLabel("Yönetim Paneli");
        lblBaslik.setForeground(Color.WHITE);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 14));
        GridBagConstraints gbcBaslik = new GridBagConstraints();
        gbcBaslik.anchor = GridBagConstraints.WEST;
        gbcBaslik.insets = new Insets(24, 16, 4, 16);
        gbcBaslik.gridx = 0;
        gbcBaslik.gridy = 0;
        panelMenu.add(lblBaslik, gbcBaslik);

        JLabel lblKullanici = new JLabel("<html>" + aktifKullanici.getAdSoyad() + "</html>");
        lblKullanici.setForeground(new Color(148, 163, 184)); 
        lblKullanici.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        GridBagConstraints gbcKullanici = new GridBagConstraints();
        gbcKullanici.anchor = GridBagConstraints.WEST;
        gbcKullanici.insets = new Insets(0, 16, 12, 16);
        gbcKullanici.gridx = 0;
        gbcKullanici.gridy = 1;
        panelMenu.add(lblKullanici, gbcKullanici);

        JSeparator ayirici = new JSeparator();
        ayirici.setForeground(new Color(255, 255, 255, 80));
        GridBagConstraints gbcSep = new GridBagConstraints();
        gbcSep.fill = GridBagConstraints.HORIZONTAL;
        gbcSep.insets = new Insets(0, 16, 12, 16);
        gbcSep.gridx = 0;
        gbcSep.gridy = 2;
        panelMenu.add(ayirici, gbcSep);

        Insets menuBosluk = new Insets(4, 12, 4, 12);

        
        btnKitapYonetim = new JButton("  Kitap Yönetimi");
        menuButonuStilUygula(btnKitapYonetim);
        btnKitapYonetim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuSec(btnKitapYonetim);
                CardLayout cl = (CardLayout) panelKartlar.getLayout();
                cl.show(panelKartlar, "KitapYonetim");
                kitapYonetimPanel.tabloyuYenile();
            }
        });
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.insets = menuBosluk;
        gbc1.gridx = 0;
        gbc1.gridy = 3;
        panelMenu.add(btnKitapYonetim, gbc1);

        btnUyeKayit = new JButton("  Üye Kayıt");
        menuButonuStilUygula(btnUyeKayit);
        btnUyeKayit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuSec(btnUyeKayit);
                CardLayout cl = (CardLayout) panelKartlar.getLayout();
                cl.show(panelKartlar, "Kayit");
                uyeKayitPanel.uyeleriYenile();
            }
        });
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.insets = menuBosluk;
        gbc2.gridx = 0;
        gbc2.gridy = 4;
        panelMenu.add(btnUyeKayit, gbc2);

        btnOduncIade = new JButton("  Ödünç / İade");
        menuButonuStilUygula(btnOduncIade);
        btnOduncIade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuSec(btnOduncIade);
                CardLayout cl = (CardLayout) panelKartlar.getLayout();
                cl.show(panelKartlar, "OduncIade");
                oduncIadePanel.oduncleriYenile();
            }
        });
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        gbc3.insets = menuBosluk;
        gbc3.gridx = 0;
        gbc3.gridy = 5;
        panelMenu.add(btnOduncIade, gbc3);

        btnRaporlar = new JButton("  Raporlar");
        menuButonuStilUygula(btnRaporlar);
        btnRaporlar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuSec(btnRaporlar);
                CardLayout cl = (CardLayout) panelKartlar.getLayout();
                cl.show(panelKartlar, "Raporlar");
            }
        });
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.fill = GridBagConstraints.HORIZONTAL;
        gbc4.insets = menuBosluk;
        gbc4.gridx = 0;
        gbc4.gridy = 6;
        panelMenu.add(btnRaporlar, gbc4);

        JPanel bosAlan = new JPanel();
        bosAlan.setOpaque(false);
        GridBagConstraints gbcBos = new GridBagConstraints();
        gbcBos.gridx = 0;
        gbcBos.gridy = 7;
        gbcBos.weighty = 1.0;
        gbcBos.fill = GridBagConstraints.VERTICAL;
        panelMenu.add(bosAlan, gbcBos);

        JButton btnCikis = new JButton("  Çıkış");
        menuButonuStilUygula(btnCikis);
        btnCikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GirisEkrani().setVisible(true);
            }
        });
        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.fill = GridBagConstraints.HORIZONTAL;
        gbc5.anchor = GridBagConstraints.SOUTH;
        gbc5.insets = new Insets(10, 12, 28, 12);
        gbc5.gridx = 0;
        gbc5.gridy = 8;
        panelMenu.add(btnCikis, gbc5);

        panelKartlar = new JPanel();
        panelKartlar.setBackground(new Color(248, 250, 252));
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

        menuSec(btnKitapYonetim);
    }

    private void menuButonuStilUygula(JButton btn) {
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setForeground(new Color(226, 232, 240));
        btn.setBackground(new Color(30, 41, 59)); 
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(170, 42));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorder(new EmptyBorder(10, 18, 10, 18));
        
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.getFont().isPlain()) { 
                    btn.setBackground(new Color(45, 60, 85)); 
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btn.getFont().isPlain()) { 
                    btn.setBackground(new Color(30, 41, 59));
                }
            }
        });
    }

    private void menuSec(JButton aktif) {
        butonPasifYap(btnKitapYonetim);
        butonPasifYap(btnUyeKayit);
        butonPasifYap(btnOduncIade);
        butonPasifYap(btnRaporlar);
        
        butonAktifYap(aktif);
    }

    private void butonAktifYap(JButton btn) {
        btn.setBackground(new Color(37, 99, 235)); 
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    private void butonPasifYap(JButton btn) {
        btn.setBackground(new Color(30, 41, 59)); 
        btn.setForeground(new Color(226, 232, 240));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }
}