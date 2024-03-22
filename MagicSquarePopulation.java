import java.util.ArrayList;
import java.util.List;

public class MagicSquarePopulation {
    public static List<int[][]> magicSquarePopulation(int n){
        

        int[][] magicSquare = new int[n][n];
        // int[][] shuffledMagicSquare = new int[z][z];
        //
        int x = 0;
        int y = (n+1)/n - 1;
        magicSquare[x][y] = 1;

        for (int i = 1; i <= n * n; i++) {
            if(magicSquare[(x + n - 1) % n ][(y - 1 + n) % n ] == 0 ){
                x = (x - 1 + n) % n;
                y = (y - 1 + n) % n;
            }
            else{
                x = (x + 1) % n;
            }

            magicSquare[x][y] = i;
        }

        int[][] shuffledMagicSquare = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                shuffledMagicSquare[i][j] = magicSquare[i][j];
            }
        }

        List<int[][]> result = new ArrayList<>();
        result.add(magicSquare);
        result.add(shuffledMagicSquare);

        return result;
    

    } 




}
