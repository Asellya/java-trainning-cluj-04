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

public class Bishop extends Piece {

    private final static int[] CANDIDATE_MOVE_VECTOR_COORD = {-9, -7, 7, 9};

    public Bishop(int piecePos, Color pieceColor) {
        super(piecePos, pieceColor);
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {
        final List<Move> legalMoves= new ArrayList<>();
        for(final int candCoordOffset : CANDIDATE_MOVE_VECTOR_COORD){
            int candDestCoord = this.piecePos;
            while(BoardSetup.isValidCoord(candDestCoord)){
                if(isFirstColumnExclusion(candDestCoord,candCoordOffset) || isEightColumnExclusion(candDestCoord,candCoordOffset)){
                    break;
                }

                candDestCoord += candCoordOffset;
                if(BoardSetup.isValidCoord(candDestCoord)){
                    final Tile candDestTile = board.getTile(candDestCoord);
                    if (!candDestTile.isTileOcuppied()){ //daca nu e ocupat putem muta pe patratul respectiv
                        legalMoves.add(new MajorMove(board,this,candDestCoord));
                    }
                    else{
                        final Piece pieceAtDest = candDestTile.getPiece();
                        final Color pieceColor = pieceAtDest.getPieceColor();

                        if (this.pieceColor != pieceColor){ //daca e ocupat de catre o piesa din tabara opusa putem "ataca"
                            legalMoves.add(new Capture(board,this,candDestCoord,pieceAtDest));
                        }
                        break;
                    }

                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }
    public String toString(){
        return PieceType.BISHOP.toString();
    }
    private static boolean isFirstColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.FIRST_COLUMN[currPos] && (candOffset == -9 || candOffset == 7);
    }
    private static boolean isEightColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.EIGTHTH_COLUMN[currPos] && (candOffset == -7 || candOffset == 9);
    }
}
