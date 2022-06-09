import java.awt.*;
import javax.swing.JPanel;
public class Block extends JPanel {
    private Point origin;

    private Color realColor;

    public Block(int x, int y) {
        origin = new Point(x, y);
        realColor = Color.RED;
        Source.setFillValue(y, x, true);

    }

    public int getOriginX() { return origin.x; }

    public int getOriginY() { return origin.y; }

    public void setOriginX(int x) { origin.x = x; }

    public void setOriginY(int y) { origin.y = y; }

    public Color getRealColor() { return realColor; }

    public void setRealColor(Color c) { realColor = c; }
    

}
