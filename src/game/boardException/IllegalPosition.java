package game.boardException;

/**
 * Called when the user try to move out of the board dimension
 */
public class IllegalPosition extends Exception{
    public IllegalPosition(String message) {
        super(message);
    }
}
