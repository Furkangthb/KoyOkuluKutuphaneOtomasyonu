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
        butonStiliUygula(btnEnCok, new Color(37, 99, 235), new Color(29, 78, 216)); 
        btnEnCok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                raporGoster(new RaporDAO().enCokOkunanKitaplar(), new String[] { "Kitap Adı", "Okunma Sayısı" });
            }
        });
        panelUst.add(btnEnCok);

        JButton btnKurdu = new JButton("Kitap Kurdu Üyeler");
        butonStiliUygula(btnKurdu, new Color(37, 99, 235), new Color(29, 78, 216)); 
        btnKurdu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                raporGoster(new RaporDAO().kitapKurduUyeler(), new String[] { "Öğrenci Adı", "Okunan Kitap" });
            }
        });
        panelUst.add(btnKurdu);

        JButton btnAyin = new JButton("Ayın Kitap Kurdu");
        butonStiliUygula(btnAyin, new Color(245, 158, 11), new Color(217, 119, 6));
        btnAyin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kurdu = new RaporDAO().ayinKitapKurdu();
                javax.swing.JOptionPane.showMessageDialog(panelRaporlar.this, 
                        "Bu Ayın Kitap Kurdu:\n" + kurdu,
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
        lblBaslikTxt.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblBaslikTxt.setForeground(new Color(30, 41, 59));
        panelBaslik.add(lblBaslikTxt, BorderLayout.WEST);
        panelKarneBaslik.add(panelBaslik, BorderLayout.NORTH);

        JPanel panelKarneUst = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10));
        panelKarneUst.setBackground(new Color(241, 245, 249));
        panelKarneUst.setBorder(new EmptyBorder(8, 12, 8, 12));
        panelKarneBaslik.add(panelKarneUst, BorderLayout.CENTER);
        panelOrta.add(panelKarneBaslik, BorderLayout.NORTH);

        JLabel lblKarneBaslik = new JLabel("Öğrenci No:");
        lblKarneBaslik.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        panelKarneUst.add(lblKarneBaslik);

        txtOgrenciNo = new JTextField(10);
        txtOgrenciNo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        panelKarneUst.add(txtOgrenciNo);

        JButton btnKarneGetir = new JButton("Getir");
        butonStiliUygula(btnKarneGetir, new Color(16, 185, 129), new Color(5, 150, 105)); 
        panelKarneUst.add(btnKarneGetir);

        JButton btnTxtExport = new JButton("TXT Aktar");
        butonStiliUygula(btnTxtExport, new Color(100, 116, 139), new Color(71, 85, 105)); 
        panelKarneUst.add(btnTxtExport);

        JButton btnCsvExport = new JButton("CSV Aktar");
        butonStiliUygula(btnCsvExport, new Color(100, 116, 139), new Color(71, 85, 105)); 
        panelKarneUst.add(btnCsvExport);

        karneModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Kitap Adı", "Yazar", "Kategori", "Alış Tarihi", "İade Tarihi" }) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };
        tableKarne = new JTable(karneModel);
        tabloStiliUygula(tableKarne);
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
                    javax.swing.JOptionPane.showMessageDialog(panelRaporlar.this,
                            "Bu öğrenciye ait kayıt bulunamadı.", "Bilgi",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
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
        lblRapor.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblRapor.setForeground(new Color(30, 41, 59));
        lblRapor.setBorder(new EmptyBorder(0, 0, 8, 0));
        panelAlt.add(lblRapor, BorderLayout.NORTH);

        JScrollPane scrollPaneGenel = new JScrollPane();
        panelAlt.add(scrollPaneGenel, BorderLayout.CENTER);

        tableGenelRapor = new JTable();
        tableGenelRapor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Bilgi", "Değer" }));
        tabloStiliUygula(tableGenelRapor);
        scrollPaneGenel.setViewportView(tableGenelRapor);
        scrollPaneGenel.setPreferredSize(new Dimension(0, 160));
    }


    private void raporGoster(java.util.List<String[]> liste, String[] kolonlar) {
        DefaultTableModel m = new DefaultTableModel(kolonlar, 0);
        for (String[] satir : liste) {
            m.addRow(satir);
        }
        tableGenelRapor.setModel(m);
        tabloStiliUygula(tableGenelRapor);
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
                    pw.printf("%-35s %-20s %-10s %s -> %s%n",
                            karneModel.getValueAt(i, 0), karneModel.getValueAt(i, 1),
                            karneModel.getValueAt(i, 2), karneModel.getValueAt(i, 3),
                            karneModel.getValueAt(i, 4));
                }
            } else {
                pw.println("Kitap Adı,Yazar,Kategori,Alış Tarihi,İade Tarihi");
                for (int i = 0; i < karneModel.getRowCount(); i++) {
                    pw.printf("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"%n",
                            karneModel.getValueAt(i, 0), karneModel.getValueAt(i, 1),
                            karneModel.getValueAt(i, 2), karneModel.getValueAt(i, 3),
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

    private void butonStiliUygula(JButton btn, Color normal, Color hover) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setForeground(Color.WHITE);
        btn.setBackground(normal);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(btn.getPreferredSize().width + 20, 34));
        
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(hover);
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(normal);
                }
            }
        });
    }

    private void tabloStiliUygula(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.setShowVerticalLines(true);
        table.setGridColor(new Color(203, 213, 225));
        table.setSelectionBackground(new Color(219, 234, 254));
        table.setSelectionForeground(new Color(30, 41, 59));
        table.setBackground(Color.WHITE);
        table.setIntercellSpacing(new Dimension(0, 0));
        
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(226, 232, 240)); 
        table.getTableHeader().setForeground(new Color(30, 41, 59)); 
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 34));
        table.getTableHeader().setReorderingAllowed(false);
    }
}