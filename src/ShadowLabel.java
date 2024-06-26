import javax.swing.*;
import java.awt.*;

class ShadowLabel extends JLabel {
    private Color shadowColor;
    private int shadowOffsetX;
    private int shadowOffsetY;

    public ShadowLabel(String text, Color foreground, Color shadowColor, int shadowOffsetX, int shadowOffsetY) {
        super(text);
        setForeground(foreground);
        this.shadowColor = shadowColor;
        this.shadowOffsetX = shadowOffsetX;
        this.shadowOffsetY = shadowOffsetY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow
        g2.setColor(shadowColor);
        g2.drawString(getText(), getInsets().left + shadowOffsetX, getInsets().top + g2.getFontMetrics().getAscent() + shadowOffsetY);

        // Draw text
        g2.setColor(getForeground());
        g2.drawString(getText(), getInsets().left, getInsets().top + g2.getFontMetrics().getAscent());

        g2.dispose();
    }
}
