package appli;

import game.ChessBoard;
import game.Color;
import game.Coord;
import game.Piece;
import game.boardException.IllegalMove;
import game.boardException.IllegalPosition;
import game.chessPiece.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tp2
 */
public class Tp2 {

    static Color currentPlayer = Color.WHITE;
    static ArrayList<String> deplacement = new ArrayList<>();

    /**
     * Main class used for the test
     *
     * @param args used for in-line arguments,take no arguments
     * @throws IllegalPosition error in case of illegal position
     *
     */
    public static void main(String[] args) throws IllegalPosition, IOException, ClassNotFoundException {
        //Construction d’un objet de type ChessBoard
        ChessBoard myBoard = new ChessBoard();
        initBoard(myBoard);
        System.out.print("- Entrez play pour jouer une nouvelle parti ça ecrasera les anciennes sauvegardes\n" +
                "- Entrez replay pour revoir la dernière partie\n" +
                "- Entrez load pour jouer la dernière partie\n");

        Scanner scannerstart = new Scanner(System.in);
        String inputStringstart = scannerstart.nextLine();

        if (inputStringstart.equals("play")){
            startGame(myBoard);
        } if (inputStringstart.equals("replay")){
            System.out.println("Revoir les movement du fichier texte");
            replayTxt(myBoard);
        }if (inputStringstart.equals("load")){
            System.out.println("Continue la partie");
            myBoard= load();
            startGame(myBoard);
        }
    }


    public static void save(ChessBoard board){
        try {
            FileOutputStream fileOut = new FileOutputStream("./save/saveOne.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(board);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in "+fileOut);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ChessBoard load() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("./save/saveOne.ser");
        ObjectInputStream oi = new ObjectInputStream(fi);
        return (ChessBoard) oi.readObject();
    }

    public static void saveTxt(String posi) {
        try {
            deplacement.add(posi);
            File myFile = new File("./save/NouvellePartie.txt");
            FileWriter fw = new FileWriter(myFile);
            if (myFile.createNewFile()) {
                System.out.println("Le fichier est créé.");
                try {
                    fw.write(posi);
                    System.out.println("Le texte a été écrit avec succès");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Le fichier existe déjà.");
                for (String str : deplacement) {
                    fw.write(str + System.lineSeparator());
                    System.out.println("Ecriture de : " + str + System.lineSeparator());
                }
                System.out.println("Le texte a été écrit avec succès");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Revoir encpsulation cases board
    public static void assistedMove(String userInput, ChessBoard board) throws IllegalMove, IllegalPosition {
        String[] parts = userInput.split(" ");
        String[] posPieceStart = parts[0].split("");
        String[] posPieceArrived = parts[1].split("");

        Piece pieceToMove = (Piece) board.getPiece(Integer.parseInt(posPieceStart[0])-1,Integer.parseInt(posPieceStart[1])-1);
         if (pieceToMove != null) {
            if (pieceToMove.getCol() == currentPlayer) {
                    pieceToMove.move(new Coord(Integer.parseInt(posPieceArrived[0]), Integer.parseInt(posPieceArrived[1])));
                    if (currentPlayer == Color.WHITE) {
                        currentPlayer = Color.BLACK;
                    } else {
                        currentPlayer = Color.WHITE;
                    }
            } else {
                if (currentPlayer == Color.WHITE) {
                    System.out.println("You are " + currentPlayer + " not  Black");

                } else {
                    System.out.println("You are " + currentPlayer + " not  White");
                }
            }
        }
    }

    public static void startGame(ChessBoard myBoard) throws IOException, ClassNotFoundException {
        while (true) {
            myBoard.smartPrint();
            System.out.println("Player turn : \n" + currentPlayer);
            System.out.println("Input s for save");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            if (inputString.equals("s")){
                save(myBoard);
            } else {
                try{
                    assistedMove(inputString, myBoard);
                    saveTxt(inputString);
                }catch (IllegalMove | IllegalPosition move ){
                    System.out.println("erreur mouvemevent non sauvegarder" + move);
                }
            }
        }
    }

    public static void initBoard(ChessBoard myBoard)throws IllegalPosition{
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
        Pawn Pawn6 = new Pawn(new Coord(2, 6), Color.WHITE, myBoard);
        Pawn Pawn7 = new Pawn(new Coord(2, 7), Color.WHITE, myBoard);
        Pawn Pawn8 = new Pawn(new Coord(2, 8), Color.WHITE, myBoard);
        Pawn Pawn9 = new Pawn(new Coord(7, 1), Color.BLACK, myBoard);
        Pawn Pawn10 = new Pawn(new Coord(7, 2), Color.BLACK, myBoard);
        Pawn Pawn11 = new Pawn(new Coord(7, 3), Color.BLACK, myBoard);
        Pawn Pawn12 = new Pawn(new Coord(7, 4), Color.BLACK, myBoard);
        Pawn Pawn13 = new Pawn(new Coord(7, 5), Color.BLACK, myBoard);
        Pawn Pawn14 = new Pawn(new Coord(7, 6), Color.BLACK, myBoard);
        Pawn Pawn15 = new Pawn(new Coord(7, 7), Color.BLACK, myBoard);
        Pawn Pawn16 = new Pawn(new Coord(7, 8), Color.BLACK, myBoard);
    }


    public static void replayTxt(ChessBoard board) {
            File myFile = new File("./save/NouvellePartie.txt");
            try {
                InputStream game = new FileInputStream(myFile);
                InputStreamReader gameReader = new InputStreamReader(game);
                BufferedReader reader = new BufferedReader(gameReader);
                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    System.out.println(ligne);
                    assistedMove(ligne,board);
                    board.smartPrint();
                }
                reader.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
    }
}

