package game.chessPiece;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalPosition;

import static java.lang.Math.abs;

/**
 * Queen chess piece
 */
public class Queen extends Piece {

    /**
     * Queen chess piece constructor
     * @param place starting and current coordinate
     * @param col piece color
     * @param board piece board
     * @throws IllegalPosition error in case of illegal position
     */
    public Queen(Coord place, Color col, ChessBoard board) throws IllegalPosition {
        super(place, board, col);
    }

    /**
     * Piece movement rule : move like a rook or bishop
     * @param c new coordinate position
     */
    /*
    public void move(Coord c) {
        try {
        //    if (!board.isOccupied(c)){
                if (((c.x != place.x)&&(c.y == place.y))||((c.x == place.x)&&(c.y != place.y ))||abs(place.x - c.x) == abs(place.y - c.y)){
                    if (correctPath(this.place, c)) {
                        board.setOccupation(place, null);
                        setPlace(c);
                        board.setOccupation(c, this);
                    }
                } else {
                    throw new IllegalMove("Queen illegal move");
                }
        //    }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected boolean isValidMove(Coord c) {
        try {
            if (((c.x != place.x)&&(c.y == place.y))||((c.x == place.x)&&(c.y != place.y ))||abs(place.x - c.x) == abs(place.y - c.y)){
                if (correctPath(place,c))
                    return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String toString(){
        return col == Color.WHITE ? " ♕ " : " ♛ ";
    }

}
