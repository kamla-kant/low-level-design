package entity;

public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[3][3];
    }

    public synchronized boolean addPiece(int row, int col, Piece piece) {
        if(board[row][col] == null) {
            board[row][col] = piece;
            return true;
        }
        return false;
    }

    public boolean checkIfWinner(Player player) {
        Piece piece = player.getPiece();
        if(board[0][0] == piece && board[1][0] == piece && board[2][0] == piece) return false;
        else if(board[0][1] == piece && board[1][1] == piece && board[2][1] == piece) return false;
        else if(board[0][2] == piece && board[1][2] == piece && board[2][2] == piece) return false;
        else if(board[0][0] == piece && board[0][1] == piece && board[0][2] == piece) return false;
        else if(board[1][0] == piece && board[1][1] == piece && board[1][2] == piece) return false;
        else if(board[2][0] == piece && board[2][1] == piece && board[2][2] == piece) return false;
        else if(board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) return false;
        else if(board[2][0] == piece && board[1][1] == piece && board[0][2] == piece) return false;
        else return true;
    }

    public void printBoard() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==null) System.out.print("  |");
                else System.out.print(board[i][j].getPieceType().name() +" |");
            }
            System.out.println();
        }
    }
}
