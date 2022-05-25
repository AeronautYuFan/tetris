import java.awt;

class Block implements Yes {
    private int xLoc;
    private int yLoc;

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
        if(xLoc > 0) {
            xLoc--;
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if(xLoc < 12) {
            xLoc++;
            return true;
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
