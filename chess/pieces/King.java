package chess.pieces;

import chess.Color;
import chess.board.Board;
import chess.board.BoardSetup;
import chess.board.Move;
import chess.board.Tile;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static chess.board.Move.*;

public class King extends Piece{

    private final static int[] CANDIDATE_MOVE_COORD = {-9, -8, -7, -1, 1, 7, 8, 9};


    public King(int piecePos, Color pieceColor) {
        super(piecePos, pieceColor);
    }

    @Override
    public Collection<Move> calcLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();


        for(final int currCandOffset : CANDIDATE_MOVE_COORD){
            final int candDestCoord = this.piecePos + currCandOffset;

            if(isFirstColumnExclusion(this.piecePos,currCandOffset) || isEightColumnExclusion(this.piecePos,currCandOffset) ){
                continue;
            }

            if(BoardSetup.isValidCoord(candDestCoord)){
                final Tile candDestTile = board.getTile(candDestCoord);
                if (!candDestTile.isTileOcuppied()){
                    legalMoves.add(new MajorMove(board,this,candDestCoord));
                }
                else{
                    final Piece pieceAtDest = candDestTile.getPiece();
                    final Color pieceColor = pieceAtDest.getPieceColor();

                    if (this.pieceColor != pieceColor){
                        legalMoves.add(new Capture(board,this,candDestCoord,pieceAtDest));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }
    public String toString(){
        return PieceType.KING.toString();
    }

    private static boolean isFirstColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.FIRST_COLUMN[currPos] && (candOffset == -9 || candOffset == -1
                || candOffset == 7);
    }
    private static boolean isEightColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.EIGTHTH_COLUMN[currPos] && (candOffset == -7 || candOffset == 1 || candOffset == 9 );
    }
}
