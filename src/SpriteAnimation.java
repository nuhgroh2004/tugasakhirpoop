import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SpriteAnimation extends JPanel implements ActionListener, KeyListener {

    private BufferedImage spriteSheet1;
    private BufferedImage spriteSheet2;
    private BufferedImage[] sprites1;
    private BufferedImage[] sprites2;
    private BufferedImage background;
    private int currentFrame1 = 0;
    private int currentFrame2 = 0;
    private Timer timer;
    private int x1 = 100; // Initial x position of character 1
    private int y1 = 300; // Initial y position of character 1
    private int x2 = 500; // Initial x position of character 2
    private int y2 = 300; // Initial y position of character 2

    public SpriteAnimation() {
        try {
            // Load the sprite sheets and background image
            spriteSheet1 = ImageIO.read(new File("src/Asset/Char_3_No_Armor.png"));
            spriteSheet2 = ImageIO.read(new File("src/Asset/Char_3_No_Armor.png"));

            // Assuming the sprite sheet has 8 columns and 10 rows
            int rows = 10;
            int cols = 8;
            int width1 = spriteSheet1.getWidth() / cols;
            int height1 = spriteSheet1.getHeight() / rows;
            int width2 = spriteSheet2.getWidth() / cols;
            int height2 = spriteSheet2.getHeight() / rows;

            // Extract individual sprites for both characters
            sprites1 = new BufferedImage[cols * rows];
            sprites2 = new BufferedImage[cols * rows];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    sprites1[(row * cols) + col] = spriteSheet1.getSubimage(
                            col * width1, row * height1, width1, height1);
                    sprites2[(row * cols) + col] = spriteSheet2.getSubimage(
                            col * width2, row * height2, width2, height2);
                }
            }

            // Set up the timer for animation
            timer = new Timer(100, this); // Change 100 to control the speed
            timer.start();

            // Add key listener
            setFocusable(true);
            addKeyListener(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
        }
        if (sprites1 != null) {
            g.drawImage(sprites1[currentFrame1], x1, y1, null);
        }
        if (sprites2 != null) {
            g.drawImage(sprites2[currentFrame2], x2, y2, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame1 = (currentFrame1 + 1) % sprites1.length;
        currentFrame2 = (currentFrame2 + 1) % sprites2.length;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int speed = 5;

        if (key == KeyEvent.VK_LEFT) {
            x1 -= speed;
        }
        if (key == KeyEvent.VK_RIGHT) {
            x1 += speed;
        }
        if (key == KeyEvent.VK_A) {
            x2 -= speed;
        }
        if (key == KeyEvent.VK_D) {
            x2 += speed;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }
}