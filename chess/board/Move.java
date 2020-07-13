package chess.board;

import chess.pieces.Piece;

public abstract class Move {
    final Board board;
    final Piece movedPiece;
    final int destinationCoord;

   public Move(final Board board, final Piece movedPiece, final int destinationCoord) {
        this.board=board;
        this.movedPiece=movedPiece;
        this.destinationCoord=destinationCoord;
    }

    public static final class MajorMove extends Move {

        public MajorMove(final Board board, final Piece movedPiece, final int destinationCoord) {
            super(board, movedPiece, destinationCoord);
        }
    }
    public static final class Capture extends Move{
        final Piece capturedPiece;

        public Capture(final Board board, final Piece movedPiece, final int destinationCoord, final Piece capturedPiece) {
            super(board, movedPiece, destinationCoord);
            this.capturedPiece=capturedPiece;
        }
    }

}
