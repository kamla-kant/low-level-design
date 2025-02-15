import entity.Board;
import entity.Piece;
import entity.PieceType;
import entity.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private Board board;
    Deque<Player> players = new LinkedList<>();;
    private int count;
    Game() {
        board = new Board();
        count=0;
        players.add(new Player("Player 1", new Piece(PieceType.X)));
        players.add(new Player("Player 2", new Piece(PieceType.O)));
    }

    public void startGame() {
        boolean noWinner = true;
        Scanner inptScanner = new Scanner(System.in);
        while(noWinner) {
            board.printBoard();
            Player playingPlayer = players.removeFirst();
            System.out.print(playingPlayer.getName() +" enter row, col: ");
            String s = inptScanner.nextLine();
            String[] values = s.split(",");
            int inptRow = Integer.valueOf(values[0]);
            int inptCol = Integer.valueOf(values[1]);
            boolean insert = board.addPiece(inptRow, inptCol, playingPlayer.getPiece());
            if(!insert) {
                System.out.println("Invalid input, try again...");
                players.addFirst(playingPlayer);
                continue;
            }
            noWinner = board.checkIfWinner(playingPlayer);
            if(!noWinner) {
                board.printBoard();
                System.out.println(playingPlayer.getName() +" won!!");
                break;
            }
            players.addLast(playingPlayer);
            count++;
            if(count >= 9) {
                board.printBoard();
                System.out.println("Match draw !!");
                break;
            }
        }
        inptScanner.close();
    }


}
