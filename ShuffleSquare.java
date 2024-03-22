import java.util.Random;
public class ShuffleSquare {
    public static void shuffledMagicSquare(int[][] magicSquare){
        Random shuffle = new Random();
        int n = magicSquare.length;


        for(int i = 0; i < n * n; i++){
            int x = shuffle.nextInt(n);
            int y = shuffle.nextInt(n);

            int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int[] moving = move[shuffle.nextInt(move.length)];
            int newX = x + moving[0];
            int newY = y + moving[1];

            if(newX >= 0 && newX < n && newY >= 0 && newY < n){
                int temp = magicSquare[x][y];
                magicSquare[x][y] = magicSquare[newX][newY];
                magicSquare[newX][newY] = temp;
            }


        }
        


    }
}
