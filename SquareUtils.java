public class SquareUtils {


    public static boolean isMagicSquare(int[][] square) {
        int n = square.length;
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        int magicSum = n * (n * n + 1) / 2;
    
        for (int i = 0; i < n; i++) {
            sumDiag1 += square[i][i]; 
            sumDiag2 += square[i][n - 1 - i]; 
            int sumRow = 0, sumCol = 0;
            for (int j = 0; j < n; j++) {
                sumRow += square[i][j]; 
                sumCol += square[j][i]; 
            }
           
            if (sumRow != magicSum || sumCol != magicSum) return false;
        }
        return sumDiag1 == magicSum && sumDiag2 == magicSum;
    }


    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();   
    }

}


}
