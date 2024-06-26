import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;

public class Panel1 extends JFrame {
    private static Panel2 panel2;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;
    private Clip clip;
    private static Clip clipFight;

    public Panel1() {
        // Mengatur judul jendela
        setTitle("Fighting Game");
        // Mengatur ukuran jendela
        setSize(800, 600);
        // Mengatur tindakan default ketika jendela ditutup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Menonaktifkan pengaturan ukuran jendela oleh pengguna
        setResizable(false);
        // Menyusun komponen di tengah layar
        setLocationRelativeTo(null);
        // Mengatur CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        // Memuat gambar latar belakang
        ImageIcon backgroundIcon = new ImageIcon("src/aset/MENU_BG.jpg");
        Image backgroundImage = backgroundIcon.getImage();
        // Membuat panel utama dengan gambar latar belakang
        JPanel menuPanel = new BackgroundPanel1(backgroundImage);
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        // Membuat label judul
        JLabel titleLabel = new ShadowLabel("Fighting Samurai", Color.YELLOW, Color.red, 2, 2);
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(new Font("Stencil", Font.BOLD, 48));
        menuPanel.add(titleLabel, gbc);
        // Membuat tombol mulai
        JButton startButton = new RoundButton("Start game");
        startButton.setForeground(Color.white);
        startButton.setFont(new Font("Elephant", Font.PLAIN, 20));
        startButton.addActionListener(e -> startGame());
        // Membuat tombol keluar
        JButton exitButton = new RoundButton("Exit");
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Elephant", Font.PLAIN, 18));
        exitButton.addActionListener(e -> System.exit(0));
        // Menambahkan tombol ke panel utama
        menuPanel.add(startButton, gbc);
        menuPanel.add(exitButton, gbc);
        // Menambahkan panel utama ke CardLayout
        mainPanel.add(menuPanel, "MenuPanel");
        add(mainPanel);

        // Tambahkan Panel2
        panel2 = new Panel2(this);
        mainPanel.add(panel2, "Panel2");
        // Memuat musik dari file audio
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/menu.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // Memulai pemutaran musik
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Mengulang musik secara terus menerus
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void stopMenuMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
    private static void stopFightSound() {
        if (clipFight != null && clipFight.isRunning()) {
            clipFight.stop();
        }
    }


    public void startGame() {
        cardLayout.show(mainPanel, "Panel2");
        stopFightSound();
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/select.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void showMainPanel() {
        stopFightSound();
        cardLayout.show(mainPanel, "MenuPanel");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/select.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void showPanel2() {
        stopFightSound();
        panel2.resetSelection();
        cardLayout.show(mainPanel, "Panel2");

    }
    public void showPanel3(Character character1, Character character2) {
        // Hapus Panel2 dari mainPanel
//        mainPanel.remove(panel2);
//        mainPanel.revalidate(); // Perbarui tampilan panel
//        mainPanel.repaint(); // Gambar ulang panel
        stopMenuMusic(); // Hentikan musik sebelum beralih ke Panel3
        try {
            AudioInputStream audioStreamFight = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/Backsound-fighter.wav"));
            clipFight = AudioSystem.getClip();
            clipFight.open(audioStreamFight);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = 0.02f; // Nilai antara 0.0 dan 1.0
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clipFight.start(); // Memulai pemutaran musik
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Panel3 panel3 = new Panel3(this, character1, character2);
        mainPanel.add(panel3, "Panel3");
        cardLayout.show(mainPanel, "Panel3");
        // Meminta fokus pada Panel3 setelah ditampilkan
        panel3.requestFocusInWindow();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Panel1 panel1 = new Panel1();
                panel1.setVisible(true);
            }
        });
    }
}
