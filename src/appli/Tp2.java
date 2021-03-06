package appli;

import game.*;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.*;
import java.util.Scanner;

/**
 * Test class
 */
public class Tp2 {

        static Color currentPlayer = Color.WHITE;

        /**
         * Main class used for the test
         * @param args used for in-line arguments,take no arguments
         * @throws IllegalPosition error in case of illegal position
        //myBoard = {ChessBoard@462}*/
        public static void main(String[] args) throws IllegalPosition, IllegalMove {

                //Case[][] chess = new Case[8][8];

                //Coord myCoordinate = new Coord(6, 6);

                //Construction d’un objet de type ChessBoard
                ChessBoard myBoard = new ChessBoard();

                //Construction d'un objet de type bishop,
                //Bishop myBishop = new Bishop(myCoordinate, Color.WHITE, myBoard);

                //Test de la méthode d'affichage de l’échiquier.

                Rook myRook = new Rook(new Coord(1, 1), Color.WHITE, myBoard);
                Rook myRook3 = new Rook(new Coord(1, 8), Color.WHITE, myBoard);
                Rook myRook4 = new Rook(new Coord(8, 1), Color.BLACK, myBoard);
                Rook myRook5 = new Rook(new Coord(8, 8), Color.BLACK, myBoard);
                Knight myknight1 = new Knight(new Coord(1, 2), Color.WHITE, myBoard);
                Knight myknight2 = new Knight(new Coord(1, 7), Color.WHITE, myBoard);
                Knight myknight3 = new Knight(new Coord(8, 2), Color.BLACK, myBoard);
                Knight myknight4 = new Knight(new Coord(8, 7), Color.BLACK, myBoard);
                Bishop myBishop1 = new Bishop(new Coord(1, 3), Color.WHITE, myBoard);
                Bishop myBishop2 = new Bishop(new Coord(8, 3), Color.BLACK, myBoard);
                Bishop myBishop3 = new Bishop(new Coord(1, 6), Color.WHITE, myBoard);
                Bishop myBishop4 = new Bishop(new Coord(8, 6), Color.BLACK, myBoard);
                Queen myQueen1 = new Queen(new Coord(1, 4), Color.WHITE, myBoard);
                Queen myQueen2 = new Queen(new Coord(8, 4), Color.BLACK, myBoard);
                King myKing1 = new King(new Coord(1, 5), Color.WHITE, myBoard);
                King myKing2 = new King(new Coord(8, 5), Color.WHITE, myBoard);
                Pawn Pawn1 = new Pawn(new Coord(2, 1), Color.WHITE, myBoard);
                Pawn Pawn2 = new Pawn(new Coord(2, 2), Color.WHITE, myBoard);
                Pawn Pawn3 = new Pawn(new Coord(2, 3), Color.WHITE, myBoard);
                Pawn Pawn4 = new Pawn(new Coord(2, 4), Color.WHITE, myBoard);
                Pawn Pawn5 = new Pawn(new Coord(2, 5), Color.WHITE, myBoard);
                Pawn Pawn6 = new Pawn(new Coord(2,6), Color.WHITE, myBoard);
                Pawn Pawn7 = new Pawn(new Coord(2, 7), Color.WHITE, myBoard);
                Pawn Pawn8 = new Pawn(new Coord(2, 8), Color.WHITE, myBoard);
                Pawn Pawn9 = new Pawn(new Coord(7, 1), Color.BLACK, myBoard);
                Pawn Pawn10 = new Pawn(new Coord(7, 2), Color.BLACK, myBoard);
                Pawn Pawn11= new Pawn(new Coord(7, 3), Color.BLACK, myBoard);
                Pawn Pawn12= new Pawn(new Coord(7, 4), Color.BLACK, myBoard);
                Pawn Pawn13= new Pawn(new Coord(7, 5), Color.BLACK, myBoard);
                Pawn Pawn14= new Pawn(new Coord(7,6), Color.BLACK, myBoard);
                Pawn Pawn15= new Pawn(new Coord(7, 7), Color.BLACK, myBoard);
                Pawn Pawn16= new Pawn(new Coord(7, 8), Color.BLACK, myBoard);
                String move = "11 12";
                System.out.println("Player turn : \n"+ currentPlayer);
                myBoard.smartPrint();
                while (true){
                        System.out.print("Enter a string (xy xy) : ");
                        Scanner scanner = new Scanner(System. in);
                        String inputString = scanner. nextLine();

                        assistedMove(inputString, myBoard);
                        System.out.println("Player turn : \n"+ currentPlayer);

                        myBoard.smartPrint();
                }

        }

        // Revoir encpsulation cases board

        public static void assistedMove(String userInput, ChessBoard board) throws IllegalMove, IllegalPosition {
                String[] parts = userInput.split(" ");
                String[] posPieceStart = parts[0].split("");
                String[] posPieceArrived = parts[1].split("");

                Piece pieceToMove = (Piece) board.cases[Integer.parseInt(posPieceStart[0])-1][Integer.parseInt(posPieceStart[1])-1].getPiece();
                if (pieceToMove != null){
                        if (pieceToMove.getCol() == currentPlayer){
                                try {
                                        pieceToMove.move(new Coord(Integer.parseInt(posPieceArrived[0]),Integer.parseInt(posPieceArrived[1])));
                                        if (currentPlayer == Color.WHITE){
                                                currentPlayer = Color.BLACK;
                                        } else {
                                                currentPlayer = Color.WHITE;
                                        }
                                } catch (Exception e){
                                        e.printStackTrace();
                                }
                        }else {
                                if (currentPlayer == Color.WHITE){
                                        System.out.println("You are "+ currentPlayer + " not  Black" );

                                } else {
                                        System.out.println("You are "+ currentPlayer + " not  White" );
                                }
                        }
                }
        }
}
