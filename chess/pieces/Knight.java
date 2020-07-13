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

public class Knight extends Piece{

    private final static int[] CANDIDATE_MOVE_COORD = {-17, -15, -10, -6, 6, 10, 15, 17};
    public Knight(final int piecePos, final Color pieceColor) {
        super(piecePos, pieceColor);
    }

    @Override
    public Collection<Move> calcLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for(final int currentCandOffset : CANDIDATE_MOVE_COORD){

            final int candDestCoord = this.piecePos+currentCandOffset;

            if(BoardSetup.isValidCoord(candDestCoord)){
                if(isFirstColumnExclusion(this.piecePos,currentCandOffset) ||
                        isSecondColumnExclusion(this.piecePos, currentCandOffset) ||
                        isSeventhColumnExclusion(this.piecePos, currentCandOffset) ||
                        isEightthColumnExclusion(this.piecePos, currentCandOffset))
                {
                    continue;
                }

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
                }
            }

        }
        return ImmutableList.copyOf(legalMoves);
    }
    public String toString(){
        return PieceType.KNIGHT.toString();
    }

    private static boolean isFirstColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.FIRST_COLUMN[currPos] && (candOffset == -17 || candOffset == -10
        || candOffset == 6 || candOffset == 15);
    }
    private static boolean isSecondColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.SECOND_COLUMN[currPos] && (candOffset == -10 || candOffset == 6);
    }
    private static boolean isSeventhColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.SEVENTH_COLUMN[currPos] && (candOffset == -6 || candOffset == 10);
    }
    private static boolean isEightthColumnExclusion(final int currPos, final int candOffset){
        return BoardSetup.EIGTHTH_COLUMN[currPos] && (candOffset == -15 || candOffset == -6 || candOffset == 10
        || candOffset == 17);
    }


}
