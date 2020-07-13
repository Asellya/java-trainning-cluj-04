package chess.pieces;

import chess.Color;
import chess.board.Board;
import chess.board.Move;

import java.util.Collection;

public abstract class Piece {
    //toate piesele au o pozitie, un patrat pe care il ocupa

    protected int piecePos;
    protected final Color pieceColor;
    protected final boolean isFirstMove;
    protected PieceType pieceType;

    Piece( int piecePos, final Color pieceColor){
        this.pieceColor=pieceColor;
        this.piecePos=piecePos;
        this.isFirstMove=false;
    }

    public int getPiecePos(){
        return this.piecePos;
    }
    public void setPiecePos(int piecePos){
        this.piecePos=piecePos;
    }

    public Color getPieceColor(){
        return this.pieceColor;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }

    public abstract Collection<Move> calcLegalMoves(final Board board);

    public enum PieceType{
        PAWN("P"),
        KNIGHT("K"),
        BISHOP("B"),
        ROOK("R"),
        QUEEN("Q"),
        KING("K");

        private String pieceName;
        PieceType(final String pieceName){
            this.pieceName = pieceName;

        }
        public String toString(){
            return this.pieceName;
        }


    }

}
