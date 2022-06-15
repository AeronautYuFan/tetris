import java.awt.*;

public class Piece {
    private int type;

    private Point[] blockSpots;

    private Color pieceColor;

    private Block block1;
    private Block block2;
    private Block block3;
    private Block block4;

    /*
    line = 1
    T = 2
    L = 3
    backwards L = 4
    square = 5
    swiggle = 6
    back swiggle = 7
    */
    public Piece(int pieceType) {
        type = pieceType;

        //if (t == 2) {
        //    blockSpots = new Point[]{new Point(5, 0), new Point(6, 0), new Point(7, 0), new Point(6, 1)};
        //}
        if (type == 3) {
            blockSpots = new Point[]{new Point(5, 0), new Point(5, 1), new Point(6, 1), new Point(7, 1)};
        }
        if (type == 4) {
            blockSpots = new Point[]{new Point(5, 1), new Point(5, 0), new Point(6, 0), new Point(7, 0)};
        }
        if (type == 5) {
            blockSpots = new Point[]{new Point(6, 0), new Point(6, 1), new Point(7, 1), new Point(7, 0)};
        }
        if (type == 6) {
            blockSpots = new Point[]{new Point(5, 0), new Point(6, 0), new Point(6, 1), new Point(7, 1)};
        }
        if (type == 7) {
            blockSpots = new Point[]{new Point(5, 1), new Point(6, 1), new Point(6, 0), new Point(7, 0)};
        }

        else blockSpots = new Point[]{new Point(5, 0), new Point(6, 0), new Point(7, 0), new Point(8, 0)};

        pieceColor = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
    }

    public void makeBlocks() {
        block1 = new Block(blockSpots[0], pieceColor);
        block2 = new Block(blockSpots[1], pieceColor);
        block3 = new Block(blockSpots[2], pieceColor);
        block4 = new Block(blockSpots[3], pieceColor);
    }

    public void drawPiece(Graphics g) {
        block1.drawBlock(g);
        block2.drawBlock(g);
        block3.drawBlock(g);
        block4.drawBlock(g);
    }


}







