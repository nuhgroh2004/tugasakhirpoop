import java.awt.Graphics;

public class Joko extends Character {
    private static final String name = "Joko";

    public Joko(int x, int y, int speed, int health) {
        super(name,x, y, speed, health, new String[]{
                "src/aset/joko/Run-kanan1.png",
                "src/aset/joko/Run-kanan2.png",
                "src/aset/joko/Run-kanan3.png",
                "src/aset/joko/Run-kanan4.png",
                "src/aset/joko/Run-kanan5.png",
                "src/aset/joko/Run-kanan6.png"
        }, new String[]{
                "src/aset/joko/Run-kiri1.png",
                "src/aset/joko/Run-kiri2.png",
                "src/aset/joko/Run-kiri3.png",
                "src/aset/joko/Run-kiri4.png",
                "src/aset/joko/Run-kiri5.png",
                "src/aset/joko/Run-kiri6.png"
        }, new String[]{
                "src/aset/joko/Idle-kanan1.png",
                "src/aset/joko/Idle-kanan2.png",
                "src/aset/joko/Idle-kanan3.png",
                "src/aset/joko/Idle-kanan4.png",
                "src/aset/joko/Idle-kanan5.png",
                "src/aset/joko/Idle-kanan6.png",
        }, new String[]{
                "src/aset/joko/Idle-kiri1.png",
                "src/aset/joko/Idle-kiri2.png",
                "src/aset/joko/Idle-kiri3.png",
                "src/aset/joko/Idle-kiri4.png",
                "src/aset/joko/Idle-kiri5.png",
                "src/aset/joko/Idle-kiri6.png",
        }, new String[]{
                "src/aset/joko/Fall-kanan1.png",
                "src/aset/joko/Fall-kanan2.png",
                "src/aset/joko/Fall-kanan3.png",
                "src/aset/joko/Fall-kanan4.png",
                "src/aset/joko/Fall-kanan5.png",
                "src/aset/joko/Fall-kanan6.png"
        }, new String[]{
                "src/aset/joko/Fall-kiri1.png",
                "src/aset/joko/Fall-kiri2.png",
                "src/aset/joko/Fall-kiri3.png",
                "src/aset/joko/Fall-kiri4.png",
                "src/aset/joko/Fall-kiri5.png",
                "src/aset/joko/Fall-kiri6.png"
        }, new String[]{
                "src/aset/joko/tinju-kanan1.png",
                "src/aset/joko/tinju-kanan2.png",
                "src/aset/joko/tinju-kanan3.png",
                "src/aset/joko/tinju-kanan4.png",
                "src/aset/joko/tinju-kanan5.png",
                "src/aset/joko/tinju-kanan6.png"
        }, new String[]{
                "src/aset/joko/tinju-kiri1.png",
                "src/aset/joko/tinju-kiri2.png",
                "src/aset/joko/tinju-kiri3.png",
                "src/aset/joko/tinju-kiri4.png",
                "src/aset/joko/tinju-kiri5.png",
                "src/aset/joko/tinju-kiri6.png"
        }, new String[]{
                "src/aset/joko/tendang-kanan1.png",
                "src/aset/joko/tendang-kanan2.png",
                "src/aset/joko/tendang-kanan3.png",
                "src/aset/joko/tendang-kanan4.png",
                "src/aset/joko/tendang-kanan5.png",
                "src/aset/joko/tendang-kanan6.png"
        }, new String[]{
                "src/aset/joko/tendang-kiri1.png",
                "src/aset/joko/tendang-kiri2.png",
                "src/aset/joko/tendang-kiri3.png",
                "src/aset/joko/tendang-kiri4.png",
                "src/aset/joko/tendang-kiri5.png",
                "src/aset/joko/tendang-kiri6.png"
        });
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); // Menggunakan animasi gambar dari kelas induk
    }
    @Override
    public void tambahDamage() {
        setDamage(80);
    }
}
































