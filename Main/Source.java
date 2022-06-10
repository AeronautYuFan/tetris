public class Source {
    public static int TILESIZE = 21;
    // # of rows
    public static int COLUMNS = 14;
    // # of columns
    public static int ROWS = 21;

    public static boolean[][] FILL = new boolean[ROWS][COLUMNS];

    public static void setFillValue(int row, int col, boolean f) {
        FILL[row][col] = f;
    }
}
