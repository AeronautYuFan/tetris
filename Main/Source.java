public class Source {
    public static int TILESIZE = 21;
    // # of rows
    public static int COLUMNS = 14;
    // # of columns
    public static int ROWS = 21;

    public static boolean[][] FILL = new boolean[ROWS - 1][COLUMNS - 2];
    
    public static int SCORE = 0;
    
    public static int CLEAREDROWS = 0;
    

    public static void setFillValue(int row, int col, boolean f) {
        FILL[row][col] = f;
    }

    public static void setFillValue(int row, boolean f) { FILL[row] = new boolean[ROWS]; }
    
    public static void restart() {
        FILL = new boolean[ROWS][COLUMNS];
        SCORE = 0;
        CLEAREDROWS = 0;
    }

    public static void addSCORE(int x) {
        SCORE += x;
    }
}
