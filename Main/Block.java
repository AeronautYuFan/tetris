import java.awt.*;

public class Block {
    private Point origin;

    private Color realColor;

    public Block(int x, int y) {
        origin = new Point(x, y);
    }

    public int getOriginX() { return origin.x; }

    public int getOriginY() { return origin.y; }

    public void setOriginX(int x) { origin.x = x; }

    public void setOriginY(int y) { origin.y = y; }

    public Color getColor() { return realColor; }

    public void setColor(Color c) { realColor = c; }

    public void drawPiece(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(origin.x*Source.TILESIZE, origin.y*Source.TILESIZE,Source.TILESIZE-1, Source.TILESIZE-1);
    }
    



}
