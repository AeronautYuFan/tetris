import java.awt.*;

public class Piece {
    private int type;
    private int rotation;

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
        rotation = 0;

        if (type == 2) {
            blockSpots = new Point[]{new Point(5, 0), new Point(6, 0), new Point(7, 0), new Point(6, 1)};
        }
        else if (type == 3) {
            blockSpots = new Point[]{new Point(5, 1), new Point(5, 0), new Point(6, 0), new Point(7, 0)};
        }
        else if (type == 4) {
            blockSpots = new Point[]{new Point(5, 0), new Point(5, 1), new Point(6, 1), new Point(7, 1)};
        }
        else if (type == 5) {
            blockSpots = new Point[]{new Point(6, 0), new Point(6, 1), new Point(7, 1), new Point(7, 0)};
        }
        else if (type == 6) {
            blockSpots = new Point[]{new Point(5, 0), new Point(6, 0), new Point(6, 1), new Point(7, 1)};
        }
        else if (type == 7) {
            blockSpots = new Point[]{new Point(5, 1), new Point(6, 1), new Point(6, 0), new Point(7, 0)};
        }

        else
            blockSpots = new Point[]{new Point(5, 0), new Point(6, 0), new Point(7, 0), new Point(8, 0)};

        pieceColor = new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));

        makeBlocks();
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

    public Block getBlock1() { return block1; }
    public Block getBlock2() { return block2; }
    public Block getBlock3() { return block3; }
    public Block getBlock4() { return block4; }

    public Color getPieceColor() { return pieceColor; }

    public void moveLeftRight(int x) {
        block1.moveHorizontal(x);
        block2.moveHorizontal(x);
        block3.moveHorizontal(x);
        block4.moveHorizontal(x);
    }

    public void moveDown() {
        block1.moveDown();
        block2.moveDown();
        block3.moveDown();
        block4.moveDown();
    }

    public int getRotation(){
        return rotation;
    }

    public void setRotation(int r){
        rotation = r;
    }

    public void rotate(){
        //Rotations for Piece 2
        if(type == 2 && rotation == 0){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block4.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
        }
        if(type == 2 && rotation == 1){
            block1.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block4.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
        }
        if(type == 2 && rotation == 2){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block4.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
        }
        if(type == 2 && rotation == 3){
            block1.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block4.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
        }
        //Rotations for Piece 3
        if(type == 3 && rotation == 0){
            block1.setOriginXY(block3.getOriginX() - 1, block3.getOriginY() - 1);
            block2.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
        }
        if(type == 3 && rotation == 1){
            block1.setOriginXY(block3.getOriginX() + 1, block3.getOriginY() - 1);
            block2.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
            block4.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
        }
        if(type == 3 && rotation == 2){
            block1.setOriginXY(block3.getOriginX() + 1, block3.getOriginY() + 1);
            block2.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
        }
        if(type == 3 && rotation == 3){
            block1.setOriginXY(block3.getOriginX() - 1, block3.getOriginY() + 1);
            block2.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
            block4.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
        }
        //Rotations for Piece 4
        if(type == 4 && rotation == 0){
            block1.setOriginXY(block3.getOriginX() + 1, block3.getOriginY() - 1);
            block2.setOriginXY(block1.getOriginX() - 1, block1.getOriginY());
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
        }
        if(type == 4 && rotation == 1){
            block1.setOriginXY(block3.getOriginX() + 1, block3.getOriginY() + 1);
            block2.setOriginXY(block1.getOriginX(), block1.getOriginY() - 1);
            block4.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
        }
        if(type == 4 && rotation == 2){
            block1.setOriginXY(block3.getOriginX() - 1, block3.getOriginY() + 1);
            block2.setOriginXY(block1.getOriginX() + 1, block1.getOriginY());
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
        }
        if(type == 4 && rotation == 3){
            block1.setOriginXY(block3.getOriginX() - 1, block3.getOriginY() - 1);
            block2.setOriginXY(block1.getOriginX(), block1.getOriginY() + 1);
            block4.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
        }
        //Rotation for Piece 5
        if(type == 5 && rotation == 0){
            block1.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block4.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
        }
        if(type == 5 && rotation == 1){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block3.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
        }
        if(type == 5 && rotation == 2){
            block1.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block4.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
        }
        if(type == 5 && rotation == 3){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block3.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
        }
        //Rotation for Piece 6
        if(type == 6 && rotation == 0){
            block1.setOriginXY(block3.getOriginX() + 1, block3.getOriginY() - 1);
            block2.setOriginXY(block1.getOriginX(), block1.getOriginY() + 1);
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
        }
        if(type == 6 && rotation == 1){
            block1.setOriginXY(block3.getOriginX() + 1, block3.getOriginY() + 1);
            block2.setOriginXY(block1.getOriginX() - 1, block1.getOriginY());
            block4.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
        }
        if(type == 6 && rotation == 2){
            block1.setOriginXY(block3.getOriginX() - 1, block3.getOriginY() + 1);
            block2.setOriginXY(block1.getOriginX(), block1.getOriginY() - 1);
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
        }
        if(type == 6 && rotation == 3){
            block1.setOriginXY(block3.getOriginX() - 1, block3.getOriginY() - 1);
            block2.setOriginXY(block1.getOriginX() + 1, block1.getOriginY());
            block4.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
        }
        //Rotation for Piece 7
        if(type == 7 && rotation == 0){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block3.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
        }
        if(type == 7 && rotation == 1){
            block1.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block4.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
        }
        if(type == 7 && rotation == 2){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block3.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
        }
        if(type == 7 && rotation == 3){
            block1.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block4.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
        }
        //Rotation for Piece 1
        if(type == 1 && rotation == 0){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() + 1);
        }
        if(type == 1 && rotation == 1){
            block1.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block4.setOriginXY(block3.getOriginX() - 1, block3.getOriginY());
        }
        if(type == 1 && rotation == 2){
            block1.setOriginXY(block2.getOriginX(), block2.getOriginY() + 1);
            block3.setOriginXY(block2.getOriginX(), block2.getOriginY() - 1);
            block4.setOriginXY(block3.getOriginX(), block3.getOriginY() - 1);
        }
        if(type == 1 && rotation == 3){
            block1.setOriginXY(block2.getOriginX() - 1, block2.getOriginY());
            block3.setOriginXY(block2.getOriginX() + 1, block2.getOriginY());
            block4.setOriginXY(block3.getOriginX() + 1, block3.getOriginY());
        }

        if(rotation == 3)
            rotation = -1;
        rotation++;
    }
}
