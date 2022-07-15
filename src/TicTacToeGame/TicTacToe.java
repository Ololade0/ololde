package TicTacToeGame;

import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playersPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},

                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement (1-9)");
            int position = scanner.nextInt();

            System.out.println(position);


            placePiece(gameBoard, position, "player");
            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            placePiece(gameBoard, cpuPosition, "CPU");


            printGameBoard(gameBoard);
          String result =  checkWinner();
            System.out.println(result);

        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard, int position, String user){
       char symbol = 'X';
        if(Objects.equals(user, "player")) {
            symbol = 'X';
            playersPositions.add(position)   ;
        }
        else if(Objects.equals(user, "CPU")){
            symbol = '0';
            cpuPositions.add(position);

        }

        switch(position)

        {
            case 1:
                gameBoard[0][0] = 'X';
                break;

            case 2:
                gameBoard[0][2] = 'X';
                break;

            case 3:
                gameBoard[0][4] = 'X';
                break;
            case 4:
                gameBoard[2][0] = 'X';
                break;

            case 5:
                gameBoard[2][2] = 'X';
                break;

            case 6:
                gameBoard[2][4] = 'X';
                break;
            case 7:
                gameBoard[4][0] = 'X';
                break;

            case 8:
                gameBoard[4][2] = 'X';
                break;

            case 9:
                gameBoard[4][4] = 'X';
                break;

            default:
                break;
        }

    }

    public static String checkWinner(){
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        for(List l : winning){
            if(playersPositions.containsAll(l)){
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "Cpu wins! Sorry :(";

            } else if (playersPositions.size() + cpuPositions.size() == 9) {
                return "CAT!";
                
            }
        }
        return "";
    }
    }
