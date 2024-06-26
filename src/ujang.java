import java.awt.Graphics;

public class ujang extends Character {
    private static final String name = "Ujang";

    public ujang(int x, int y, int speed, int health) {
        super(name,x, y, speed, health, new String[]{
                "src/aset/ujang/Run-kanan1.png",
                "src/aset/ujang/Run-kanan2.png",
                "src/aset/ujang/Run-kanan3.png",
                "src/aset/ujang/Run-kanan4.png",
                "src/aset/ujang/Run-kanan5.png",
                "src/aset/ujang/Run-kanan6.png"
        }, new String[]{
                "src/aset/ujang/Run-kiri1.png",
                "src/aset/ujang/Run-kiri2.png",
                "src/aset/ujang/Run-kiri3.png",
                "src/aset/ujang/Run-kiri4.png",
                "src/aset/ujang/Run-kiri5.png",
                "src/aset/ujang/Run-kiri6.png"
        }, new String[]{
                "src/aset/ujang/Idle-kanan1.png",
                "src/aset/ujang/Idle-kanan2.png",
                "src/aset/ujang/Idle-kanan3.png",
                "src/aset/ujang/Idle-kanan4.png",
                "src/aset/ujang/Idle-kanan5.png",
                "src/aset/ujang/Idle-kanan6.png"
        }, new String[]{
                "src/aset/ujang/Idle-kiri1.png",
                "src/aset/ujang/Idle-kiri2.png",
                "src/aset/ujang/Idle-kiri3.png",
                "src/aset/ujang/Idle-kiri4.png",
                "src/aset/ujang/Idle-kiri5.png",
                "src/aset/ujang/Idle-kiri6.png"
        }, new String[]{
                "src/aset/ujang/Jump-kanan1.png",
                "src/aset/ujang/Jump-kanan2.png",
                "src/aset/ujang/Jump-kanan2.png",
                "src/aset/ujang/Jump-kanan3.png",
                "src/aset/ujang/Jump-kanan4.png",
                "src/aset/ujang/Jump-kanan4.png"
        }, new String[]{
                "src/aset/ujang/Jump-kiri1.png",
                "src/aset/ujang/Jump-kiri2.png",
                "src/aset/ujang/Jump-kiri2.png",
                "src/aset/ujang/Jump-kiri3.png",
                "src/aset/ujang/Jump-kiri4.png",
                "src/aset/ujang/Jump-kiri4.png"
        }, new String[]{
                "src/aset/ujang/Attack-kanan1.png",
                "src/aset/ujang/Attack-kanan2.png",
                "src/aset/ujang/Attack-kanan3.png",
                "src/aset/ujang/Attack-kanan1.png",
                "src/aset/ujang/Attack-kanan2.png",
                "src/aset/ujang/Attack-kanan3.png"
        }, new String[]{
                "src/aset/ujang/Attack-kirir1.png",
                "src/aset/ujang/Attack-kirir2.png",
                "src/aset/ujang/Attack-kirir3.png",
                "src/aset/ujang/Attack-kirir1.png",
                "src/aset/ujang/Attack-kirir2.png",
                "src/aset/ujang/Attack-kirir3.png"
        }, new String[]{
                "src/aset/ujang/Attack2-kanan1.png",
                "src/aset/ujang/Attack2-kanan2.png",
                "src/aset/ujang/Attack2-kanan3.png",
                "src/aset/ujang/Attack2-kanan1.png",
                "src/aset/ujang/Attack2-kanan2.png",
                "src/aset/ujang/Attack2-kanan3.png"
        }, new String[]{
                "src/aset/ujang/Attack2-kiri1.png",
                "src/aset/ujang/Attack2-kiri2.png",
                "src/aset/ujang/Attack2-kiri3.png",
                "src/aset/ujang/Attack2-kiri1.png",
                "src/aset/ujang/Attack2-kiri2.png",
                "src/aset/ujang/Attack2-kiri3.png"

        });
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); // Menggunakan animasi gambar dari kelas induk
    }
    @Override
    public void tambahDamage() {
        setDamage(50);
    }
}
































