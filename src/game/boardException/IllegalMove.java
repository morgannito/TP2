package game.boardException;

/**
 * Called when the user try to move a piece in an forbidden way
 */
public class IllegalMove extends Exception{
    public IllegalMove(String message) {
        super(message);
    }
}
