import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
public class Block extends JPanel{
    private Point origin;
    private Color realColor;
    public Block() {
        origin = new Point(6, 0);
        realColor = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
    }

    public Block(Point o, Color c) {
        origin = o;
        realColor = c;
    }

    public int getOriginX() { return origin.x; }

    public int getOriginY() { return origin.y; }

    public Point getPoint() { return origin; }

    public boolean checkPoint(int x, int y) {
        return (origin.x == x && origin.y == y);
    }

    public void setPoint(Point p) {
        origin = p;
    }

    public void setOriginX(int x) { origin.x = x; }

    public void setOriginY(int y) { origin.y = y; }

    public Color getRealColor() { return realColor; }

    public void setRealColor(Color c) { realColor = c; }

    public void drawBlock(Graphics g){
        g.setColor(realColor);
        g.fillRect(origin.x*Source.TILESIZE, origin.y*Source.TILESIZE,Source.TILESIZE-1, Source.TILESIZE-1);
    }

    public void moveDown(){
        origin.y++;
        repaint();
    }

    public void moveHorizontal(int x){
        origin.x+= x;
        repaint();
    }



}
