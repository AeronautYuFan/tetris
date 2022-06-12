public class Source {
    public static int TILESIZE = 21;
    // # of rows
    public static int COLUMNS = 14;
    // # of columns
    public static int ROWS = 21;

    public static boolean[][] FILL = new boolean[COLUMNS - 2][ROWS - 1];
    
    public static int SCORE = 0;
    
    public static int CLEAREDROWS = 0;
    

    public static void setFillValue(int col, int row, boolean f) { FILL[col][row] = f; }

    public static void setFillValue(int realRow, boolean f) {
        for(int c = 0; c < COLUMNS - 2; c++) {
            FILL[c][realRow] = f;
        }
    }
    
    public static void restart() {
        FILL = new boolean[COLUMNS - 2][ROWS - 1];
        SCORE = 0;
        CLEAREDROWS = 0;
    }

    public static void addSCORE(int x) {
        SCORE += x;
    }
}
