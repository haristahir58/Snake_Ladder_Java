import java.util.Random;
import java.util.Scanner;

public class Snake_and_ladder {

    public static int[] make_board() {
        int size = 30, count = 1;
        int[] my_board = new int[size];
        for (int i = 0; i < size ; i++, count++) {
            my_board[i] = count;
        }
        return my_board;
    }


    // Utility functions snake and ladder
    public static boolean got_snake(int[] snake_array, int moved) {
        for (int head : snake_array) {
            if (head == moved)
                return true;
        }
        return false;
    }

    public static boolean got_ladder(int[] ladder_array, int moved) {
        for (int ladder : ladder_array) {
            if (ladder == moved)
                return true;
        }
        return false;
    }


    public static void print_board(int[] board, int move) {
        String board_copy = "";
        int count = 0;
        for (int position : board) {
            count++;
            if (move != position) {
                board_copy += Integer.toString(position);

            } else if (move == position) {
                board_copy += "X";
                if (count < 5)
                    board_copy += " ";
            }

            if (count <= 10)
                board_copy += "    ";
            else
                board_copy += "   ";

            if (count % 5 == 0)
                board_copy += "\n";
        }
        System.out.println(board_copy);
    }



    public static int make_move(int[] board, int _move) {
        Random random = new Random();
        int original;
        int random_move = random.nextInt(6) + 1;
        System.out.println("\nDice Roll is "+ random_move + "\n");

        if (_move + random_move <= board.length) {
            // Defining snake and ladder positions
            int[] snakes = {8, 14, 22, 29};
            int[] ladders = {4, 12, 19};

            _move += random_move;
            original = _move;

            if (got_snake(snakes, _move)) {
                switch (_move) {
                    case 8:
                        _move = 2; break;
                    case 14:
                        _move = 10; break;
                    case 22:
                        _move = 5; break;
                    case 29:
                        _move = 18; break;
                }
                System.out.println("Got Snake, back to " + _move + " position from " + original + ".\n");
            }
            else if (got_ladder(ladders, _move)) {
                switch (_move){
                    case 4:
                        _move = 9; break;
                    case 12:
                        _move = 24; break;
                    case 19:
                        _move = 27; break;
                }
                System.out.println("Got Ladder, Forward to " + _move + " position from " + original +".\n");
            }
        }
        print_board(board, _move);
        return _move;
    }


    public static void main (String[]ages){
        int move = 0;
        //making board
        int[] my_board = make_board();
        Scanner input = new Scanner(System.in);

        //Initializing moves
        while(move < my_board[my_board.length-1]) {
            System.out.println("\nPress Enter to make move");
            String temp = input.nextLine();

            move = make_move(my_board, move);

        }
        System.out.println("\n\t------Congratulations, You Won--------");
    }
}