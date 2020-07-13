package chess.board;
import chess.pieces.*;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

//avem 64 de patratele
public abstract class Tile {

    protected final int tileCoord;
    private static final Map<Integer,EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer,EmptyTile> emptyTileMap = new HashMap<>();
        for(int i = 0; i< BoardSetup.NUM_TILES; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoord, final Piece piece){
        return piece != null ? new OccupiedTile(tileCoord,piece) : EMPTY_TILES_CACHE.get(tileCoord);
    }

    private Tile(final int tileCoord){
        this.tileCoord = tileCoord;
    }
    public abstract boolean isTileOcuppied();
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile{
        private EmptyTile(final int coord){
            super(coord);
        }
        public String toString(){
            return "-";
        }
        public boolean isTileOcuppied(){ //implicit patratul e gol
            return false;
        }
        public Piece getPiece(){
            return null; //implicit daca avem un patrat gol va returna null
        }
    }
    public static final class OccupiedTile extends Tile{

        private final Piece piece;

        private OccupiedTile(int tileCoord, Piece piece){
            super(tileCoord);
            this.piece=piece;
        }
        public String toString(){
            return getPiece().getPieceColor().isBlack() ? getPiece().toString().toLowerCase() :
                   getPiece().toString();
        }
        public boolean isTileOcuppied(){
            return true;
        }
        public Piece getPiece(){
            return this.piece;
        }
    }
}
