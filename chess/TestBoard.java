package chess;

import chess.board.Board;
import chess.board.Move;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import static org.junit.Assert.assertEquals;


public class TestBoard {
    public static void main(String[] args){
        Board board = Board.createStartBoard();
        System.out.println(board);
        Piece blackPawn = new Pawn(11, Color.BLACK);
        Move moveBlackPawn = new Move.MajorMove(board, blackPawn, 19);
        blackPawn.setPiecePos(19);
        assertEquals(blackPawn.getPiecePos(),19);
        Piece whitePawn = new Pawn(51, Color.WHITE);
        Move moveWhitePawn = new Move.MajorMove(board, whitePawn, 43);
        whitePawn.setPiecePos(43);
        assertEquals(whitePawn.getPiecePos(),43);


    }
}
