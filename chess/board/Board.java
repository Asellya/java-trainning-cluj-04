package chess.board;

import chess.Color;
import chess.pieces.*;
import com.google.common.collect.ImmutableList;

import java.util.*;

public class Board {
    private final List<Tile> gameBoard;

    private final Collection<Piece> whitePieces;
    private final Collection<Piece> blackPieces;

    private Board(Builder builder) {
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = calcActivePiceces(this.gameBoard, Color.WHITE);
        this.blackPieces = calcActivePiceces(this.gameBoard, Color.BLACK);

        final Collection<Move> whiteStartLegalMoves = calcLegalMoves(this.whitePieces);
        final Collection<Move> blackStartLegalMoves = calcLegalMoves(this.blackPieces);
    }

    public String toString(){
        final StringBuilder builder = new StringBuilder();
        for(int i=0; i<BoardSetup.NUM_TILES; i++){
            final String tileText = this.gameBoard.get(i).toString();
            builder.append(String.format("%3s", tileText));
            if( (i+1) % BoardSetup.NUM_TILES_PER_ROW == 0){
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    private Collection<Move> calcLegalMoves(final Collection<Piece> pieces) {
        final List<Move> legalMoves = new ArrayList<>();
        for(final Piece piece : pieces){
            legalMoves.addAll(piece.calcLegalMoves(this));

        }
        return ImmutableList.copyOf(legalMoves);
    }


    private static Collection<Piece> calcActivePiceces(final List<Tile> gameBoard, final Color color) {
        final List<Piece> activePieces = new ArrayList<>();
        for(final Tile tile : gameBoard){
            if(tile.isTileOcuppied()){
                final Piece piece = tile.getPiece();
                if(piece.getPieceColor() == color){
                    activePieces.add(piece);
                }
            }
        }
        return ImmutableList.copyOf(activePieces);
    }

    public Tile getTile(final int tileCoord) {
        return gameBoard.get(tileCoord);
    }

    public static List<Tile> createGameBoard(final Builder builder) {
        final Tile[] tiles = new Tile[BoardSetup.NUM_TILES];
        for (int i = 0; i < BoardSetup.NUM_TILES; i++) {
            tiles[i] = Tile.createTile(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }


    public static Board createStartBoard(){
        final Builder builder = new Builder();
        //BLACK
        builder.setPiece(new Rook(0,Color.BLACK));
        builder.setPiece(new Knight(1,Color.BLACK));
        builder.setPiece(new Bishop(2,Color.BLACK));
        builder.setPiece(new Queen(3,Color.BLACK));
        builder.setPiece(new King(4,Color.BLACK));
        builder.setPiece(new Bishop(5,Color.BLACK));
        builder.setPiece(new Knight(6,Color.BLACK));
        builder.setPiece(new Rook(7,Color.BLACK));
        builder.setPiece(new Pawn(8,Color.BLACK));
        builder.setPiece(new Pawn(9,Color.BLACK));
        builder.setPiece(new Pawn(10,Color.BLACK));
        builder.setPiece(new Pawn(11,Color.BLACK));
        builder.setPiece(new Pawn(12,Color.BLACK));
        builder.setPiece(new Pawn(13,Color.BLACK));
        builder.setPiece(new Pawn(14,Color.BLACK));
        builder.setPiece(new Pawn(15,Color.BLACK));

        //WHITE
        builder.setPiece(new Pawn(48,Color.WHITE));
        builder.setPiece(new Pawn(49,Color.WHITE));
        builder.setPiece(new Pawn(50,Color.WHITE));
        builder.setPiece(new Pawn(51,Color.WHITE));
        builder.setPiece(new Pawn(52,Color.WHITE));
        builder.setPiece(new Pawn(53,Color.WHITE));
        builder.setPiece(new Pawn(54,Color.WHITE));
        builder.setPiece(new Pawn(55,Color.WHITE));
        builder.setPiece(new Rook(56,Color.WHITE));
        builder.setPiece(new Knight(57,Color.WHITE));
        builder.setPiece(new Bishop(58,Color.WHITE));
        builder.setPiece(new Queen(59,Color.WHITE));
        builder.setPiece(new King(60,Color.WHITE));
        builder.setPiece(new Bishop(61,Color.WHITE));
        builder.setPiece(new Knight(62,Color.WHITE));
        builder.setPiece(new Rook(63,Color.WHITE));
        //alb muta primul
        builder.setMove(Color.WHITE);
        return builder.build();
    }
    public static class Builder{

        Map<Integer, Piece> boardConfig;
        Color nextMove;

        public Builder(){
            this.boardConfig = new HashMap<>();
        }
        public Builder setPiece(final Piece piece){
            this.boardConfig.put(piece.getPiecePos(), piece);
            return this;
        }
        public Builder setMove(final Color nextMove){
            this.nextMove = nextMove;
            return this;
        }

        public Board build(){
            return new Board(this);
        }
    }

}
