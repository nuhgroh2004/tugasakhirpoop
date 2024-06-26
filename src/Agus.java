import java.awt.Graphics;

public class Agus extends Character {

    private static final String name = "Agus";


    public Agus(int x, int y, int speed, int health) {
        super(name, x, y, speed, health, new String[]{
                "src/aset/agus/Run-kanan1.png",
                "src/aset/agus/Run-kanan2.png",
                "src/aset/agus/Run-kanan3.png",
                "src/aset/agus/Run-kanan4.png",
                "src/aset/agus/Run-kanan5.png",
                "src/aset/agus/Run-kanan6.png"
        }, new String[]{
                "src/aset/agus/Run-kiri1.png",
                "src/aset/agus/Run-kiri2.png",
                "src/aset/agus/Run-kiri3.png",
                "src/aset/agus/Run-kiri4.png",
                "src/aset/agus/Run-kiri5.png",
                "src/aset/agus/Run-kiri6.png"
        }, new String[]{
                "src/aset/agus/Idle-kanan1.png",
                "src/aset/agus/Idle-kanan2.png",
                "src/aset/agus/Idle-kanan3.png",
                "src/aset/agus/Idle-kanan4.png",
                "src/aset/agus/Idle-kanan5.png",
                "src/aset/agus/Idle-kanan6.png"
        }, new String[]{
                "src/aset/agus/Idle-kiri1.png",
                "src/aset/agus/Idle-kiri2.png",
                "src/aset/agus/Idle-kiri3.png",
                "src/aset/agus/Idle-kiri4.png",
                "src/aset/agus/Idle-kiri5.png",
                "src/aset/agus/Idle-kiri6.png"
        }, new String[]{
                "src/aset/agus/Fall-kanan1.png",
                "src/aset/agus/Fall-kanan2.png",
                "src/aset/agus/Fall-kanan1.png",
                "src/aset/agus/Fall-kanan2.png",
                "src/aset/agus/Fall-kanan1.png",
                "src/aset/agus/Fall-kanan2.png"
        }, new String[]{
                "src/aset/agus/Fall-kiri1.png",
                "src/aset/agus/Fall-kiri2.png",
                "src/aset/agus/Fall-kiri1.png",
                "src/aset/agus/Fall-kiri2.png",
                "src/aset/agus/Fall-kiri1.png",
                "src/aset/agus/Fall-kiri2.png"
        }, new String[]{
                "src/aset/agus/Attack1-kanan1.png",
                "src/aset/agus/Attack1-kanan2.png",
                "src/aset/agus/Attack1-kanan3.png",
                "src/aset/agus/Attack1-kanan4.png",
                "src/aset/agus/Attack1-kanan5.png",
                "src/aset/agus/Attack1-kanan6.png"
        }, new String[]{
                "src/aset/agus/Attack1-kiri1.png",
                "src/aset/agus/Attack1-kiri2.png",
                "src/aset/agus/Attack1-kiri3.png",
                "src/aset/agus/Attack1-kiri4.png",
                "src/aset/agus/Attack1-kiri5.png",
                "src/aset/agus/Attack1-kiri6.png"
        }, new String[]{
                "src/aset/agus/Attack2-kanan1.png",
                "src/aset/agus/Attack2-kanan2.png",
                "src/aset/agus/Attack2-kanan3.png",
                "src/aset/agus/Attack2-kanan4.png",
                "src/aset/agus/Attack2-kanan5.png",
                "src/aset/agus/Attack2-kanan6.png"
        }, new String[]{
                "src/aset/agus/Attack2-kiri1.png",
                "src/aset/agus/Attack2-kiri2.png",
                "src/aset/agus/Attack2-kiri3.png",
                "src/aset/agus/Attack2-kiri4.png",
                "src/aset/agus/Attack2-kiri5.png",
                "src/aset/agus/Attack2-kiri6.png"
        });
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g); // Menggunakan animasi gambar dari kelas induk
    }
    @Override
    public void tambahDamage() {
        setDamage(100);
    }
}
































