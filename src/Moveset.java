import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//represents a list of moves (doesn't care if there are > 4 moves)
public class Moveset implements Iterable<Move>{
    private ArrayList<Move> moves = new ArrayList<Move>();;
    //private int numMoves;
    //private Move[] moves;
    
    public Moveset() {
    }
    
    public Moveset(List<Move> newMoves) {
        if (newMoves == null)
            return;          
        moves = new ArrayList<Move>(newMoves);
    }
    
    //returns the 4 most recently learned moves for a pokemon of this level
    public static Moveset defaultMoveset(Species species, int level, boolean isGS){
        ArrayList<Move> distinctMoves = new ArrayList<Move>();
        HashSet<Move> movesSet = new HashSet<Move>();
        Learnset l = Learnset.getLearnset(species.getDexNum(), isGS);
        if (l == null) {
            return new Moveset();
        }
        LevelMove[] lms = l.getLevelMoves();
        for(int i =  0; i < lms.length; i++) {
            Move m = lms[i].getMove();
            if (!movesSet.contains(m) && lms[i].getLevel() <= level) {
            	movesSet.add(m);
	            distinctMoves.add(m);
            }
        }
        
        if (distinctMoves.size() <= 4)
            return new Moveset(distinctMoves);
        else {
            int n = distinctMoves.size();
            return new Moveset(distinctMoves.subList(n-4, n));
        }
            
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(Move m : moves) {
            sb.append(m.getName() + ", ");
        }
        
        return sb.toString();
    }

    @Override
    public Iterator<Move> iterator() {
        return moves.iterator();
    }
    
    public void addMove(Move m) {
        if (!moves.contains(m))
            moves.add(m);
    }
    
    public void addMove(String s) {
        addMove(Move.valueOf(s));
    }
    
    public void addMove(int i) {
        addMove(Move.values()[i]);
    }
    
    public boolean delMove(Move m) {
        return moves.remove(m);
    }
    
    public void delMove(String s) {
        delMove(Move.valueOf(s));
    }
    
}
