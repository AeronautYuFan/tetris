public class Score {
    private int score;
    private int completedRows;
    public void nScore(){
        score+=12;
    }
    public void rowFilled (){
        completedRows++;
        nScore();
    }

    public int getScore() {
        return score;
    }

    public int getCompletedRows() {
        return completedRows;
    }

    public void setScore(int s) {
        score = s;
    }

    public void setCompletedRows(int r) {
        completedRows = r;
    }

}
