package game;

import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;

public interface Movable {
    Coord pos = new Coord(0,0);

    void move(Coord c) throws IllegalPosition, IllegalMove;

    Coord getPos();
    void setPos(Coord pos);
}
