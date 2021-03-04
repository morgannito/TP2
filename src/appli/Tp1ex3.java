package appli;

import game.Case;
import game.boardException.IllegalPosition;
import game.chessPiece.*;
import game.ChessBoard;
import game.Color;
import game.Coord;

/**
 * Test class
 */
public class Tp1ex3 {

        /**
         * Main class used for the test
         * @param args used for in-line arguments,take no arguments
         * @throws IllegalPosition error in case of illegal position
         //myBoard = {ChessBoard@462}*/
        public static void main(String[] args) throws IllegalPosition {

                //Case[][] chess = new Case[8][8];

                //Coord myCoordinate = new Coord(6, 6);

                //Construction d’un objet de type ChessBoard
                ChessBoard myBoard = new ChessBoard();

                //Construction d'un objet de type bishop,
                //Bishop myBishop = new Bishop(myCoordinate, Color.WHITE, myBoard);

                //Test de la méthode d'affichage de l’échiquier.

                Rook myRook = new Rook(new Coord(1, 1), Color.WHITE, myBoard);

                Rook myRook2 = new Rook(new Coord(1, 3), Color.BLACK, myBoard);

               // String move1 =

                myBoard.smartPrint();

                myRook.move(new Coord(1,2));

                myBoard.smartPrint();

                myRook.move(new Coord(1,4));

                myBoard.smartPrint();


                //out of range move
       //         Coord myMove2 = new Coord(-3, -3);
       //         myBishop.move(myMove2);
       //         myBoard.smartPrint();

                //illegal move
       //         Coord myMove3 = new Coord(5, 5);
       //         myBishop.move(myMove3);
       //         myBoard.smartPrint();

                //legal move
       //         Coord myMove4 = new Coord(2, 2);
       //         myBishop.move(myMove4);
       //         myBoard.smartPrint();
        }
}
