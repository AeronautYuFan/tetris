public class Score {
    private int points;
    private int completedRows;
    
    public Score() {
        points = 0;
        completedRows = 0;
    }
    

    public int getPoints() {
        return points;
    }

    public int getCompletedRows() {
        return completedRows;
    }

    public void setPoints(int s) {
        points = s;
    }

    public void setCompletedRows(int r) {
        completedRows = r;
    }

}
