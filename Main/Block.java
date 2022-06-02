import java.awt;

class Block implements Yes {
    private int xLoc;
    private int yLoc;
    
    public Block(int x) {
        xLoc = x;
        yLoc = 0;
    }
    
    public void setY(int y) {
        yLoc = y;
    }

    public int getX() {
        return xLoc;
    }

    public int getY() {
        return yLoc;
    }

    public void timedMoveDown() {
        this.moveDown();
    }

    public void moveDown() {
        yLoc++;
    }

    public boolean moveLeft() {
       if (this.isGrounded == false) {
        if(xLoc > 0) {
            xLoc--;
            return true;
        }
       }
        return false;
    }

    public boolean moveRight() {
       if (this.isGrounded == false) {
        if(xLoc < 12) {
            xLoc++;
            return true;
        }
       }
        return false;
    }

    public boolean isGrounded() {
        // TO DO
        return false;
        // TO DO
    }

    public void removeBlock() {
        // TO DO
    }


}
