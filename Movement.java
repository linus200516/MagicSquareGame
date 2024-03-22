public class Movement {
    public static boolean applyMove(int[][] square, int row, int column, String direction) {
        int n = square.length;
        // checking if the row and column input is in bounds
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return false; 
        }
    
        int temp;
        switch (direction) {
            case "U":
                if (row > 0) {
                    temp = square[row][column];
                    square[row][column] = square[row-1][column];
                    square[row-1][column] = temp;
                    return true;
                }
                break;
            case "D":
                if (row < n - 1) {
                    temp = square[row][column];
                    square[row][column] = square[row+1][column];
                    square[row+1][column] = temp;
                    return true;
                }
                break;
            case "L":
                if (column > 0) {
                    temp = square[row][column];
                    square[row][column] = square[row][column-1];
                    square[row][column-1] = temp;
                    return true;
                }
                break;
            case "R":
                if (column < n - 1) {
                    temp = square[row][column];
                    square[row][column] = square[row][column+1];
                    square[row][column+1] = temp;
                    return true;
                }
            break;
            default:
                return false;
        }
    return false;

}
}

