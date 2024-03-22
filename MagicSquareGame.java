import java.util.List;
import java.util.Scanner;

public class MagicSquareGame {
    private int[][] magicSquare;
    private int[][] shuffledMagicSquare;
    private int moveCount = 0;
    private Scanner scanner = new Scanner(System.in);

    
    public MagicSquareGame(int n) {
        //making both magic square and shuffled square
        List<int[][]> squares = MagicSquarePopulation.magicSquarePopulation(n);
        magicSquare = squares.get(0);
        shuffledMagicSquare = squares.get(1);
        ShuffleSquare.shuffledMagicSquare(shuffledMagicSquare);
    }



    public static void main(String[] args) {
        //get size of square 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an odd number to make the magic square:");
        int n = scanner.nextInt();
        scanner.nextLine(); 
    
        //error check
        while (n % 2 == 0) {
            System.out.println("This number is not odd, try again:");
            n = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character after retrying
        }
        //initiate game 
        MagicSquareGame game = new MagicSquareGame(n);
        game.startGame();
    }







    public void startGame() {
        System.out.println("Here is the shuffled square :D :");
        SquareUtils.printArray(shuffledMagicSquare);

        while (!SquareUtils.isMagicSquare(shuffledMagicSquare)) {
            System.out.println("Please enter your move (row first, column second, and direction last e.g. 3 2 U) ");
            String inputLine = scanner.nextLine(); // Read the whole line of input

            // spliting the input into 3 different sections
            String[] parts = inputLine.split(" ");
            if (parts.length != 3) {
                //checks no more than 3 inputs are there 
                System.out.println("Please follow the format mentioned before: row column direction");
                continue; 
            }

            try {
                //udjusting to the index of the array, and standardizing letter
                int row = Integer.parseInt(parts[0]) - 1; 
                int column = Integer.parseInt(parts[1]) - 1; 
                String direction = parts[2].toUpperCase(); 

                if (Movement.applyMove(shuffledMagicSquare, row, column, direction)) {
                    moveCount++;
                    System.out.println("Nice move keep going:");
                    SquareUtils.printArray(shuffledMagicSquare);
                } else {
                    //out of bounds 
                    System.out.println("your move is invalid, please try again");
                    SquareUtils.printArray(shuffledMagicSquare);
                }
            } catch (NumberFormatException e) {
                //didn't input 2 num and 1 letter 
                System.out.println("you can not input that, please try again");
                SquareUtils.printArray(shuffledMagicSquare);
            }
        }

        System.out.println("Well done, you have corrected the magic square in " + moveCount + " moves. :D");
    }

}