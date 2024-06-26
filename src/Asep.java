import java.awt.Graphics;

public class Asep extends Character {

    private static final String name = "Asep";

    public Asep(int x, int y, int speed, int health) {
        super(name, x, y, speed, health, new String[]{
                "src/aset/asep/Run-kanan1.png",
                "src/aset/asep/Run-kanan2.png",
                "src/aset/asep/Run-kanan3.png",
                "src/aset/asep/Run-kanan4.png",
                "src/aset/asep/Run-kanan5.png",
                "src/aset/asep/Run-kanan6.png"
        }, new String[]{
                "src/aset/asep/Run-kiri1.png",
                "src/aset/asep/Run-kiri2.png",
                "src/aset/asep/Run-kiri3.png",
                "src/aset/asep/Run-kiri4.png",
                "src/aset/asep/Run-kiri5.png",
                "src/aset/asep/Run-kiri6.png"
        }, new String[]{
//                idle
                "src/aset/asep/Idle-kanan1.png",
                "src/aset/asep/Idle-kanan2.png",
                "src/aset/asep/Idle-kanan3.png",
                "src/aset/asep/Idle-kanan4.png",
                "src/aset/asep/Idle-kanan5.png",
                "src/aset/asep/Idle-kanan6.png"
        }, new String[]{
//                idle
                "src/aset/asep/Idle-kiri1.png",
                "src/aset/asep/Idle-kiri2.png",
                "src/aset/asep/Idle-kiri3.png",
                "src/aset/asep/Idle-kiri4.png",
                "src/aset/asep/Idle-kiri5.png",
                "src/aset/asep/Idle-kiri6.png"
        }, new String[]{
//                jum
                "src/aset/asep/Jump-kanan1.png",
                "src/aset/asep/Jump-kanan2.png",
                "src/aset/asep/Jump-kanan3.png",
                "src/aset/asep/Jump-kanan1.png",
                "src/aset/asep/Jump-kanan2.png",
                "src/aset/asep/Jump-kanan3.png"
        }, new String[]{
//                jum
                "src/aset/asep/Jump-kiri1.png",
                "src/aset/asep/Jump-kiri2.png",
                "src/aset/asep/Jump-kiri3.png",
                "src/aset/asep/Jump-kiri1.png",
                "src/aset/asep/Jump-kiri2.png",
                "src/aset/asep/Jump-kiri3.png",
        }, new String[]{
                "src/aset/asep/Attack1-kanan1.png",
                "src/aset/asep/Attack1-kanan2.png",
                "src/aset/asep/Attack1-kanan3.png",
                "src/aset/asep/Attack1-kanan4.png",
                "src/aset/asep/Attack1-kanan5.png",
                "src/aset/asep/Attack1-kanan6.png"
        }, new String[]{
                "src/aset/asep/Attack1-kiri1.png",
                "src/aset/asep/Attack1-kiri2.png",
                "src/aset/asep/Attack1-kiri3.png",
                "src/aset/asep/Attack1-kiri4.png",
                "src/aset/asep/Attack1-kiri5.png",
                "src/aset/asep/Attack1-kiri6.png"
        }, new String[]{
                "src/aset/asep/Attack2-kanan1.png",
                "src/aset/asep/Attack2-kanan2.png",
                "src/aset/asep/Attack2-kanan3.png",
                "src/aset/asep/Attack2-kanan4.png",
                "src/aset/asep/Attack2-kanan5.png",
                "src/aset/asep/Attack2-kanan6.png"
        }, new String[]{
                "src/aset/asep/Attack2-kiri1.png",
                "src/aset/asep/Attack2-kiri2.png",
                "src/aset/asep/Attack2-kiri3.png",
                "src/aset/asep/Attack2-kiri4.png",
                "src/aset/asep/Attack2-kiri5.png",
                "src/aset/asep/Attack2-kiri6.png",
        });
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); // Menggunakan animasi gambar dari kelas induk
    }
    @Override
    public void tambahDamage() {
        setDamage(700);
    }
}
































