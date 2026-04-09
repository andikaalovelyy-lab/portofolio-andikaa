import java.awt.HeadlessException;

public class Kalkulator extends javax.swing.JFrame {

    String angka = "";
    double jumlah, bil1, bil2;
    int pilih;

    public Kalkulator() {
        initComponents();
        angka = "";
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        tampilTeks = new javax.swing.JTextField();
        angka7 = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        angka8 = new javax.swing.JButton();
        btntitik = new javax.swing.JButton();
        btnbagi = new javax.swing.JButton();
        angka9 = new javax.swing.JButton();
        angka1 = new javax.swing.JButton();
        angka2 = new javax.swing.JButton();
        angka3 = new javax.swing.JButton();
        btnkali = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        angka0 = new javax.swing.JButton();
        btnhasil = new javax.swing.JButton();
        angka4 = new javax.swing.JButton();
        angka5 = new javax.swing.JButton();
        angka6 = new javax.swing.JButton();
        btnkurang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tampilTeks.setEditable(false);

        angka7.setText("7");
        angka7.addActionListener(evt -> tambahAngka("7"));

        angka8.setText("8");
        angka8.addActionListener(evt -> tambahAngka("8"));

        angka9.setText("9");
        angka9.addActionListener(evt -> tambahAngka("9"));

        angka4.setText("4");
        angka4.addActionListener(evt -> tambahAngka("4"));

        angka5.setText("5");
        angka5.addActionListener(evt -> tambahAngka("5"));

        angka6.setText("6");
        angka6.addActionListener(evt -> tambahAngka("6"));

        angka1.setText("1");
        angka1.addActionListener(evt -> tambahAngka("1"));

        angka2.setText("2");
        angka2.addActionListener(evt -> tambahAngka("2"));

        angka3.setText("3");
        angka3.addActionListener(evt -> tambahAngka("3"));

        angka0.setText("0");
        angka0.addActionListener(evt -> tambahAngka("0"));

        btntitik.setText(".");
        btntitik.addActionListener(evt -> tambahAngka("."));

        btntambah.setText("+");
        btntambah.addActionListener(evt -> operasi(1));

        btnkurang.setText("-");
        btnkurang.addActionListener(evt -> operasi(2));

        btnkali.setText("X");
        btnkali.addActionListener(evt -> operasi(3));

        btnbagi.setText("/");
        btnbagi.addActionListener(evt -> operasi(4));

        btnhasil.setText("=");
        btnhasil.addActionListener(evt -> hasil());

        hapus.setText("C");
        hapus.addActionListener(evt -> clear());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tampilTeks)
            .addGroup(layout.createSequentialGroup()
                .addComponent(angka7).addComponent(angka8).addComponent(angka9).addComponent(btnkali))
            .addGroup(layout.createSequentialGroup()
                .addComponent(angka4).addComponent(angka5).addComponent(angka6).addComponent(btnkurang))
            .addGroup(layout.createSequentialGroup()
                .addComponent(angka1).addComponent(angka2).addComponent(angka3).addComponent(btntambah))
            .addGroup(layout.createSequentialGroup()
                .addComponent(angka0).addComponent(btntitik).addComponent(btnhasil).addComponent(btnbagi))
            .addComponent(hapus)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(tampilTeks, 50, 50, 50)
                .addGroup(layout.createParallelGroup().addComponent(angka7).addComponent(angka8).addComponent(angka9).addComponent(btnkali))
                .addGroup(layout.createParallelGroup().addComponent(angka4).addComponent(angka5).addComponent(angka6).addComponent(btnkurang))
                .addGroup(layout.createParallelGroup().addComponent(angka1).addComponent(angka2).addComponent(angka3).addComponent(btntambah))
                .addGroup(layout.createParallelGroup().addComponent(angka0).addComponent(btntitik).addComponent(btnhasil).addComponent(btnbagi))
                .addComponent(hapus)
        );

        pack();
    }

    private void tambahAngka(String input) {
        angka += input;
        tampilTeks.setText(angka);
    }

    private void operasi(int op) {
        if (angka.equals("")) return;

        bil1 = Double.parseDouble(angka);
        angka = "";
        pilih = op;
    }

    private void hasil() {
        if (angka.equals("")) return;

        bil2 = Double.parseDouble(angka);

        switch (pilih) {
            case 1:
                jumlah = bil1 + bil2;
                break;
            case 2:
                jumlah = bil1 - bil2;
                break;
            case 3:
                jumlah = bil1 * bil2;
                break;
            case 4:
                if (bil2 == 0) {
                    tampilTeks.setText("Error");
                    angka = "";
                    return;
                }
                jumlah = bil1 / bil2;
                break;
        }

        angka = Double.toString(jumlah);
        tampilTeks.setText(angka);
    }

    private void clear() {
        angka = "";
        bil1 = 0;
        bil2 = 0;
        jumlah = 0;
        tampilTeks.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Kalkulator().setVisible(true);
        });
    }

    private javax.swing.JButton angka0, angka1, angka2, angka3, angka4, angka5, angka6, angka7, angka8, angka9;
    private javax.swing.JButton btnbagi, btnhasil, btnkali, btnkurang, btntambah, btntitik, hapus;
    private javax.swing.JTextField tampilTeks;
}