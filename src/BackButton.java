import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

class BackButton extends JButton {
    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 20;
    private int shadowSize = 5;
    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    public Color getColorOver() {
        return colorOver;
    }
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    public Color getColorClick() {
        return colorClick;
    }
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }
    public Color getBorderColor() {
        return borderColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public BackButton(String text) {
        super(text);
        //Init color
        colorOver = new Color(45, 36, 37);
//        colorClick = new Color(252, 248, 249);
        borderColor = new Color(0, 0, 0);
        setColor(getBorderColor());
        setContentAreaFilled(false);
        setBorderPainted(false); // Disable border painting
        setFocusPainted(false); // Disable focus border painting
        //add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorOver);
                over=true;
            }
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(over){
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
                over=false;
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Paint Border
//        g2.setColor(new Color(0,0,0,50));
        g2.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, radius, radius);
        g2.setColor(getBackground());
        //Border set 2 pix
        g2.fillRoundRect(2,2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(g);
        g2.dispose();
    }
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
    @Override
    public boolean contains(int x, int y) {
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 50);
        return shape.contains(x, y);
    }
}