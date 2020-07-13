package chess.pieces;
import chess.Color;
import chess.board.Board;
import chess.board.BoardSetup;
import chess.board.Move;
import chess.board.Move.MajorMove;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Pawn extends Piece {
    private final static int[] CANDIDATE_MOVE_COORD = {7, 8, 9, 16};

    public Pawn(int piecePos, final Color pieceColor) {
        super(piecePos, pieceColor);
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for (final int currCandOffset : CANDIDATE_MOVE_COORD) {
            int candDestCoord = this.piecePos + (this.getPieceColor().getDirection() * currCandOffset);

            if (!BoardSetup.isValidCoord(candDestCoord)) {
                continue;
            }
            if (currCandOffset == 8 && !board.getTile(candDestCoord).isTileOcuppied()) {
                legalMoves.add(new MajorMove(board, this, candDestCoord));
            } //miscarea normala un patrat inainte
            else if(currCandOffset == 16 && this.isFirstMove() && (BoardSetup.SECOND_ROW[this.piecePos] && this.getPieceColor().isBlack())
                    || (BoardSetup.SEVENTH_ROW[this.piecePos] && this.getPieceColor().isWhite()) ){
                //daca e prima miscare avem posibilitatea de a sari 2 casute deci daca e pe al doilea rand si e negru sau
                //pe al 7-lea rand si e alb
                final int behindCandDestCoord = this.piecePos + (this.pieceColor.getDirection() * 8);
                    if(!board.getTile(behindCandDestCoord).isTileOcuppied() && !board.getTile(candDestCoord).isTileOcuppied()){
                        legalMoves.add(new MajorMove(board,this, candDestCoord));
                    }
            }
            else if(currCandOffset == 7 && !((BoardSetup.EIGTHTH_COLUMN[this.piecePos] && this.pieceColor.isWhite()
                    || (BoardSetup.FIRST_COLUMN[this.piecePos] && this.pieceColor.isBlack()) ))){
                    if(board.getTile(candDestCoord).isTileOcuppied()){
                        final Piece pieceOnCand = board.getTile(candDestCoord).getPiece();
                        if(this.pieceColor != pieceOnCand.getPieceColor()){
                            legalMoves.add(new MajorMove(board,this,candDestCoord));
                            /*daca avem patratul ocupat, iar piesa de pe patratul pe care vrem sa ne mutam este de culoare
                            * opusa vom putea executa o miscare de "atac/capture"*/
                            /*aici ar mai fi exceptia in care in momentul capturii ajungem la sfarsit de tabla, acolo se aplica
                            * regula de pawn promotion */
                        }
                    }
            }
            else if (currCandOffset == 9 && !((BoardSetup.FIRST_COLUMN[this.piecePos] && this.pieceColor.isWhite()
                    || (BoardSetup.EIGTHTH_COLUMN[this.piecePos] && this.pieceColor.isBlack()) ))){
                        if(board.getTile(candDestCoord).isTileOcuppied()){
                            final Piece pieceOnCand = board.getTile(candDestCoord).getPiece();
                            if(this.pieceColor != pieceOnCand.getPieceColor()){
                                legalMoves.add(new MajorMove(board,this,candDestCoord));
                        }
                    }
                 }
        /*avem doua exceptii care trebuie tratate, daca sunt pion alb pe a2 nu pot ataca in partea stanga, ar fi in afara tablei
            dar daca sunt pion negru pe a7 pot */
        }
        return ImmutableList.copyOf(legalMoves);
    }
    public String toString(){
        return PieceType.PAWN.toString();
    }

}

