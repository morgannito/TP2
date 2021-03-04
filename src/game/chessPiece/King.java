package game.chessPiece;
import game.boardException.IllegalMove;
import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalPosition;

/**
 * King chess piece
 */
public class King extends Piece {

    /**
     * King chess piece constructor
     * @param place starting and current coordinate
     * @param col piece color
     * @param board piece board
     * @throws IllegalPosition error in case of illegal position
     */
    public King(Coord place, Color col, ChessBoard board) throws IllegalPosition {
        super(place, board, col);
    }

    /**
     * Piece movement rule : can only move to adjacent case
     * @param c new coordinate position
     */
    public void move(Coord c) {
        try {
          //  if (!board.isOccupied(c)) {
                if (((c.x == place.x + 1) || (c.x == place.x - 1) || (c.x == place.x)) && ((c.y == place.y + 1) || (c.y == place.y - 1) || (c.y == place.y))) {
                    if (correctPath(this.place, c)) {
                        board.setOccupation(place, null);
                        setPlace(c);
                        board.setOccupation(c, this);
                    }
                } else {
                    throw new IllegalMove("King illegal move");
                }
        //    }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used for the human display
     * @return TODO
     */
    @Override
    public String toString(){
        return col == Color.WHITE ? " ♔ " : " ♚ ";
    }

}
