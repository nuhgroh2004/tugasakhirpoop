import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel2 extends JPanel {
    private JButton backButton;
    private JButton AGUS;
    private JButton ASEP;
    private JButton JOKO;
    private JButton UJANG;
    private Panel1 panel1;
    private String player1;
    private String player2;
    private boolean isPlayer1Selected = false;
    private JLabel characterLabel;
    private Character character1;
    private Character character2;

    public Panel2(Panel1 panel1) {
        this.panel1 = panel1;
        setLayout(null); // Menggunakan null layout untuk absolute positioning
        characterLabel = new JLabel();
        characterLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 12));
        characterLabel.setBounds(600, 250, 150, 20);
        add(characterLabel);
        // Mengatur gambar latar belakang
        ImageIcon backgroundIcon = new ImageIcon("src/aset/PILIH_KARAKTER_BG.gif");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());

        AGUS = new CharacterButton("ASEP JS");
        AGUS.setFont(new Font("Berlin Sans FB", Font.BOLD, 12));
        AGUS.setBounds(84, 280, 130, 40);
        AGUS.addActionListener(new CharacterSelectionHandler("ASEP"));

        UJANG = new CharacterButton("AGUS PHP");
        UJANG.setFont(new Font("Berlin Sans FB", Font.BOLD, 12));
        UJANG.setBounds(247, 280, 130, 40);
        UJANG.addActionListener(new CharacterSelectionHandler("AGUS"));

        ASEP = new CharacterButton("UJANG CSS");
        ASEP.setFont(new Font("Berlin Sans FB", Font.BOLD, 12));
        ASEP.setBounds(413, 280, 130, 40);
        ASEP.addActionListener(new CharacterSelectionHandler("UJANG"));

        JOKO = new CharacterButton("JOKO JAVA");
        JOKO.setFont(new Font("Berlin Sans FB", Font.BOLD, 12));
        JOKO.setBounds(575, 280, 130, 40);
        JOKO.addActionListener(new CharacterSelectionHandler("JOKO"));
        // Tombol kembali
        backButton = new BackButton("BACK");
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Elephant", Font.PLAIN, 10));
        backButton.setBounds(35, 500, 70, 30); // Atur posisi dan ukuran tombol (kiri bawah)
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/select.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                resetSelection();
                panel1.showMainPanel();
            }
        });
        // Tambahkan komponen
        add(AGUS);
        add(UJANG);
        add(ASEP);
        add(JOKO);
        add(backButton); // Tambahkan tombol "Kembali"
        add(backgroundLabel); // Tambahkan latar belakang di posisi terakhir untuk memastikan berada di belakang komponen lainnya
    }
    private class CharacterSelectionHandler implements ActionListener {
        private String character;
        public CharacterSelectionHandler(String character) {
            this.character = character;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isPlayer1Selected) {
                player1 = character;
                character1 = createCharacter(player1, 100, 355); // Posisi awal karakter 1
                isPlayer1Selected = true;
                try {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/selectedCharacter.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    // Mengatur volume (contoh mengatur ke 50%)
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float volume = 0.15f; // Nilai antara 0.0 dan 1.0
                    float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                    gainControl.setValue(dB);

                    clip.start(); // Memulai pemutaran musik
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (isPlayer1Selected && player2 == null) {
                player2 = character;
                character2 = createCharacter(player2, 500, 355); // Posisi awal karakter 2
                panel1.showPanel3(character1, character2);
                try {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/selectedCharacter.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioStream);

                    // Mengatur volume (contoh mengatur ke 50%)
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float volume = 0.15f; // Nilai antara 0.0 dan 1.0
                    float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                    gainControl.setValue(dB);

                    clip.start(); // Memulai pemutaran musik
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    private Character createCharacter(String characterType, int x, int y) {
        switch (characterType) {
            case "AGUS":
                return new Agus(x, y, 5, 100);
            case "ASEP":
                return new Asep(x, y, 5, 100);
            case "UJANG":
                return new ujang(x, y, 5, 100);
            case "JOKO":
                return new Joko(x, y, 5, 100);
            default:
                throw new IllegalArgumentException("Karakter tidak dikenal: " + characterType);
        }
    }
    public void resetPanel() {
        resetSelection();
    }
    public void resetSelection() {
        player1 = null;
        player2 = null;
        isPlayer1Selected = false;
        characterLabel.setText("");
    }
}
