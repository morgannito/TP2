package game.chessPiece;

import game.boardException.IllegalMove;
import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalPosition;

import static java.lang.Math.abs;

/**
 * Bishop chess piece
 */
public class Bishop extends Piece {

    /**
     * Bishop chess piece constructor
     * @param place starting and current coordinate
     * @param col piece color
     * @param board piece board
     * @throws IllegalPosition error in case of illegal position
     */
    public Bishop(Coord place, Color col, ChessBoard board) throws IllegalPosition {
        super(place, board, col);
    }

    /**
     * Piece movement rule : diagonal move only
     * @param c new coordinate position
     */
    public void move(Coord c){
        try {
          //  if (!board.isOccupied(c)){
                if(abs(place.x - c.x) == abs(place.y - c.y)) {
                    if (correctPath(this.place, c)) {
                        board.setOccupation(place, null);
                        setPlace(c);
                        board.setOccupation(c, this);
                    }
                } else {
                    throw new IllegalMove("Bishop illegal move");
                }
         //   }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return col == Color.WHITE ? " ♗ " : " ♝ ";
    }

}
