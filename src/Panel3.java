import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel3 extends JPanel implements KeyListener, ActionListener {
    private Character character1;
    private Character character2;
    private CharacterMovement movement1;
    private CharacterMovement movement2;
    private Image backgroundImage;
    private boolean moveLeft1, moveRight1;
    private boolean moveLeft2, moveRight2;
    private Timer timer;
    private int groundLevel = 355;
    private int jumpHeight = 150;
    private int jumpSpeed = 7;
    private int panelWidth = 733;
    private Timer gameTimer;
    private int timeRemaining;
    private Panel1 panel1;

    public Panel3(Panel1 panel1, Character character1, Character character2) {
        this.panel1 = panel1;
        setLayout(null);
        backgroundImage = new ImageIcon("src/aset/PANEL-3-BG.gif").getImage();
        this.character1 = character1;
        this.character2 = character2;
        movement1 = new CharacterMovement(character1, jumpHeight, jumpSpeed, groundLevel, panelWidth);
        movement2 = new CharacterMovement(character2, jumpHeight, jumpSpeed, groundLevel, panelWidth);

        JButton backButton = new BackButton("BACK");
        backButton.setFont(new Font("Elephant", Font.PLAIN, 8));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.setBounds(700, 60, 70, 25);
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
                setBackground(Color.BLACK);
                JDialog dialog = new JDialog(panel1, "Konfirmasi");
                CustomBGConfirm backgroundPanel = new CustomBGConfirm("src/aset/bgkonfirmWhite.jpeg");
                dialog.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
                dialog.setLayout(new BorderLayout());
                dialog.setContentPane(backgroundPanel);

                JLabel messageLabel = new JLabel("Yakin ingin keluar dari pertarungan?", SwingConstants.CENTER);
                messageLabel.setForeground(Color.WHITE);
                messageLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));

                JPanel buttonPanel = new JPanel();
                buttonPanel.setOpaque(false);
                JButton yesButton = new RoundButton("YES");
                yesButton.setPreferredSize(new Dimension(70, 30));
                JButton noButton = new RoundButton("NO");
                noButton.setPreferredSize(new Dimension(60, 30));
                yesButton.setFont(new Font("Elephant", Font.BOLD, 14));
                noButton.setFont(new Font("Elephant", Font.BOLD, 14));

                yesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                        panel1.showPanel2();
                        try {
                            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/select.wav"));
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioStream);

                            // Mengatur volume (contoh mengatur ke 50%)
                            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                            float volume = 1.0f; // Nilai antara 0.0 dan 1.0
                            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                            gainControl.setValue(dB);

                            clip.start(); // Memulai pemutaran musik
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                noButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                        Panel3.this.requestFocusInWindow();
                        try {
                            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/select.wav"));
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioStream);

                            // Mengatur volume (contoh mengatur ke 50%)
                            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                            float volume = 1.0f; // Nilai antara 0.0 dan 1.0
                            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                            gainControl.setValue(dB);

                            clip.start(); // Memulai pemutaran musik
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                buttonPanel.add(yesButton);
                buttonPanel.add(noButton);
                dialog.add(messageLabel, BorderLayout.CENTER);
                dialog.add(buttonPanel, BorderLayout.SOUTH);
                dialog.setSize(400, 150);
                dialog.setLocationRelativeTo(panel1);
                dialog.setVisible(true);
            }
        });

        add(backButton);
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(10, this);
        timer.start();

        timeRemaining = 99; // Set the countdown time in seconds
        gameTimer = new Timer(1000, new ActionListener() { // Update every second
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                if (timeRemaining <= 0) {
                    endGame("TIE");
                }
                repaint();
            }
        });
        gameTimer.start();
    }

    private void endGame(String message) {
        timer.stop();
        gameTimer.stop();

        String winnerMessage;
        Image winnerImage = null;

        // Tentukan siapa yang menang berdasarkan kesehatan
        if (character1.getCurrentHealth() > 0 && character2.getCurrentHealth() <= 0) {
            winnerMessage = character1.getName() + " Player 1 Wins ";
            winnerImage = character1.getIdleImage();
        } else if (character2.getCurrentHealth() > 0 && character1.getCurrentHealth() <= 0) {
            winnerMessage =  character2.getName() +  " Player 2 Wins ";
            winnerImage = character2.getIdleImage();
        } else {
            winnerMessage = "Tie";
        }

        // Create a panel to customize the dialog
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);
        CustomBGConfirm backgroundPanel = new CustomBGConfirm("src/aset/bgkonfirmWhite.jpeg");
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        JLabel messageLabel = new ShadowLabel(winnerMessage, Color.orange, Color.black , 3, 3);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        messageLabel.setFont(new Font("Stencil", Font.BOLD, 30)); // Mengatur font
        messageLabel.setForeground(Color.red); // Menyesuaikan warna teks agar terlihat di atas background
        messageLabel.setForeground(Color.YELLOW);
        backgroundPanel.add(messageLabel);

        // Tampilkan gambar idle dari karakter yang menang
        if (winnerImage != null) {
            JLabel imageLabel = new JLabel(new ImageIcon(winnerImage));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            backgroundPanel.add(imageLabel);
        }

        // Create a custom dialog
        JDialog dialog = new JDialog();
        dialog.setSize(500, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create OK button
        JButton okButton = new RoundButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                panel1.showPanel2(); // Pindah ke Panel2
                try {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/select.wav"));
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
        });
        buttonPanel.add(okButton);

        // Add components to the dialog
        dialog.add(backgroundPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Make the dialog visible
        dialog.setVisible(true);
    }


    private void restartGame() {
        // Your logic to restart the game
    }

    // Example usage
    private void checkGameStatus() {
        // Contoh logika permainan:
        if (character1.getCurrentHealth() <= 0) {
            endGame("Player 2 Wins");
        } else if (character2.getCurrentHealth() <= 0) {
            endGame("Player 1 Wins");
        } else if (timeRemaining <= 0) {
            endGame("Tie");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        character1.draw(g);
        drawHealthBar(g, character1, 10, 20, false); // Health bar untuk karakter 1 dari kiri ke kanan

        character2.draw(g);
        drawHealthBar(g, character2, getWidth() - 370, 20, true); // Health bar untuk karakter 2 dari kanan ke kiri

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(" " + timeRemaining, 379, 40);
    }

    private void drawHealthBar(Graphics g, Character character, int x, int y, boolean reverse) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 360, 30);

        g.setColor(Color.GREEN);
        double healthRatio = (double) character.getCurrentHealth() / character.maxHealth;
        int barWidth = (int) (360 * healthRatio);

        if (reverse) {
            g.fillRect(x + 360 - barWidth, y, barWidth, 30); // Menggambar dari kanan ke kiri
        } else {
            g.fillRect(x, y, barWidth, 30); // Menggambar dari kiri ke kanan
        }

        g.setColor(Color.BLACK);
        g.drawRect(x, y, 360, 30);
    }

    private void checkCollision(Character attacker, Character defender) {
        Rectangle attackHitbox = attacker.getHitbox();
        Rectangle defendHitbox = defender.getHitbox();
        if (attackHitbox.intersects(defendHitbox)) {
            if (attacker.getCurrentHealth() < 200) {
                attacker.tambahDamage();
            }
            defender.receiveDamage(attacker.getDamage());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            moveLeft1 = true;
        }
        if (key == KeyEvent.VK_D) {
            moveRight1 = true;
        }
        if (key == KeyEvent.VK_W) {
            movement1.startJump();
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/Jump.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (key == KeyEvent.VK_F) {
            character1.punch();
            checkCollision(character1, character2);
        }
        if (key == KeyEvent.VK_G) {
            character1.kick();
            checkCollision(character1, character2);
        }
        if (key == KeyEvent.VK_LEFT) {
            moveLeft2 = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            moveRight2 = true;
        }
        if (key == KeyEvent.VK_UP) {
            movement2.startJump();
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/Jump.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (key == KeyEvent.VK_K) {
            character2.punch();
            checkCollision(character2, character1);
        }
        if (key == KeyEvent.VK_L) {
            character2.kick();
            checkCollision(character2, character1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_A) {
            moveLeft1 = false;
        }
        if (key == KeyEvent.VK_D) {
            moveRight1 = false;
        }
        if (!moveLeft1 && !moveRight1) {
            character1.idle();
        }
        if (key == KeyEvent.VK_LEFT) {
            moveLeft2 = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            moveRight2 = false;
        }
        if (!moveLeft2 && !moveRight2) {
            character2.idle();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveLeft1) {
            movement1.moveBackward();
        }
        if (moveRight1) {
            movement1.moveForward();
        }
        movement1.updateJump();
        if (moveLeft2) {
            movement2.moveBackward();
        }
        if (moveRight2) {
            movement2.moveForward();
        }
        movement2.updateJump();
        repaint();
        checkGameStatus();
    }
}
