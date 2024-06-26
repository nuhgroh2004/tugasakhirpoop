import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;

public abstract class Character implements CharacterActions {
    // Atribut yang sudah ada
    protected int x, y, speed, health, maxHealth;
    protected Image[] walkRightImages;
    protected Image[] walkLeftImages;
    protected Image[] idleRightImages;
    protected Image[] idleLeftImages;
    protected Image[] jumpRightImages;
    protected Image[] jumpLeftImages;
    protected Image[] punchRightImages;
    protected Image[] punchLeftImages;
    protected Image[] kickRightImages;
    protected Image[] kickLeftImages;
    protected int currentFrame;
    protected int frameDelay;
    protected int frameCounter;
    protected String currentAction;
    protected boolean facingRight;
    protected Rectangle hitbox;
    protected int currentHealth;
    private String name;
    private int damage; // Tambahkan atribut damage

    public Character(String name, int x, int y, int speed, int health, String[] walkRightPaths, String[] walkLeftPaths, String[] idleRightPaths, String[] idleLeftPaths, String[] jumpRightPaths, String[] jumpLeftPaths, String[] punchRightPaths, String[] punchLeftPaths, String[] kickRightPaths, String[] kickLeftPaths) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.walkRightImages = loadImages(walkRightPaths);
        this.walkLeftImages = loadImages(walkLeftPaths);
        this.idleRightImages = loadImages(idleRightPaths);
        this.idleLeftImages = loadImages(idleLeftPaths);
        this.jumpRightImages = loadImages(jumpRightPaths);
        this.jumpLeftImages = loadImages(jumpLeftPaths);
        this.punchRightImages = loadImages(punchRightPaths);
        this.punchLeftImages = loadImages(punchLeftPaths);
        this.kickRightImages = loadImages(kickRightPaths);
        this.kickLeftImages = loadImages(kickLeftPaths);
        this.currentFrame = 0;
        this.frameDelay = 10;
        this.frameCounter = 0;
        this.currentAction = "idle";
        this.facingRight = true;
        this.hitbox = new Rectangle(x, y + 50, 10, 50);
        this.maxHealth = 800;
        this.currentHealth = maxHealth;
        this.damage = 10; // Inisialisasi damage
    }

    public String getName() {
        return name;
    }

    private Image[] loadImages(String[] paths) {
        Image[] images = new Image[paths.length];
        for (int i = 0; i < paths.length; i++) {
            images[i] = new ImageIcon(paths[i]).getImage();
        }
        return images;
    }

    public void draw(Graphics g) {
        Image[] images = getCurrentImages();
        g.drawImage(images[currentFrame], x, y, null);
        updateAnimationFrame(images.length);
    }

    private Image[] getCurrentImages() {
        Image[] images = null;
        switch (currentAction) {
            case "walkRight":
                images = walkRightImages;
                break;
            case "walkLeft":
                images = walkLeftImages;
                break;
            case "jump":
                images = facingRight ? jumpRightImages : jumpLeftImages;
                break;
            case "punching":
                images = facingRight ? punchRightImages : punchLeftImages;
                break;
            case "kicking":
                images = facingRight ? kickRightImages : kickLeftImages;
                break;
            default:
                images = facingRight ? idleRightImages : idleLeftImages;
                break;
        }
        return images;
    }

    private void updateAnimationFrame(int totalFrames) {
        frameCounter++;
        if (frameCounter >= frameDelay) {
            frameCounter = 0;
            currentFrame = (currentFrame + 1) % totalFrames;
        }
    }

    @Override
    public void moveForward() {
        x += speed;
        currentAction = "walkRight";
        facingRight = true;
    }

    @Override
    public void moveBackward() {
        x -= speed;
        currentAction = "walkLeft";
        facingRight = false;
    }

    @Override
    public void moveUp() {
        y -= speed;
        currentAction = facingRight ? "walkRight" : "walkLeft";
    }


    public void punch() {
        currentAction = "punching";
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/pedang.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = 0.1f; // Nilai antara 0.0 dan 1.0
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void kick() {
        currentAction = "kicking";
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(this.getClass().getResource("music/pedang.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = 0.1f; // Nilai antara 0.0 dan 1.0
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void jump() {
        currentAction = "jump";
    }

    public void idle() {
        currentAction = "idle";
    }

    public Rectangle getHitbox() {
        Image[] images = getCurrentImages();
        return new Rectangle(x, y, images[currentFrame].getWidth(null), images[currentFrame].getHeight(null));
    }

    public int getWidth() {
        return getCurrentImages()[currentFrame].getWidth(null);
    }

    public int getHeight() {
        return getCurrentImages()[currentFrame].getHeight(null);
    }

    public void receiveDamage(int damage) {
        if (currentHealth < 200) {
            tambahDamage();
        }
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getIdleImage() {
        return facingRight ? idleRightImages[0] : idleLeftImages[0];
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    // Tambahkan metode abstrak tambahDamage
    public abstract void tambahDamage();
}



































