import java.util.HashMap;


public class Move {
    private String name;
    private Type type;
    private int pp;
    private int power;
    private int accuracy;
    private int indexNum;
    //TODO: more fields for special cases (enum on special case?)
    
    private static Move[] allMoves;
    private static HashMap<String,Move> allMovesHashMap;
    
    public Move(String m_name, Type m_type, int m_pp, int m_power, int m_accuracy, int m_indexNum) {
        name = m_name;
        type = m_type;
        pp = m_pp;
        power = m_power;
        accuracy = m_accuracy;
        indexNum = m_indexNum;
    }
    
    public Move(Move baseMove, int increaseStage) {
    	name = baseMove.name+" "+increaseStage;
    	type = baseMove.type;
    	pp = baseMove.pp;
    	power = baseMove.power;
    	accuracy = baseMove.accuracy;
    	indexNum = baseMove.indexNum;
    }
    
    static {
        allMoves = new Move[Constants.numMoves + 1];
        Move m;
        for (int i = 0; i < allMoves.length; i++) {
            String m_name = Constants.move_names[i];
            Type m_type = Constants.move_types[i];
            int m_pp = Constants.pps[i];
            int m_power = Constants.base_powers[i];
            int m_accuracy = Constants.accuracies[i];
            m = new Move(m_name, m_type, m_pp, m_power, m_accuracy,i);
            allMoves[i] = m;
        }
        
        allMovesHashMap = new HashMap<String,Move>();
        for (Move m1 : allMoves) {
            allMovesHashMap.put(Constants.hashName(m1.getName()), m1);
        }
        //TODO: put in special cases
    }
    
    //returns the move object corresponding to the move with index i
    public static Move getMove(int i) {
        if(i < 0 || i >= allMoves.length)
            return null;
        return allMoves[i];
    }
    
    public static Move getMoveByName(String name) {
        name = Constants.hashName(name);
        if(!allMovesHashMap.containsKey(name))
            return null;
        return allMovesHashMap.get(name);
    }
    
    public String toString() {
        return String.format("%d %s %s PP: %d Power: %d Acc: %d", indexNum, 
                name, type, pp, power, accuracy);
    }
    
    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
    public int getPp() {
        return pp;
    }
    public int getPower() {
    	int retVal = power;
    	if(name.equalsIgnoreCase("Return")) {
    		retVal = Constants.base_powers[216];
    	}
        return retVal;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getIndexNum() {
        return indexNum;
    }
    public void setPower(int newPower) {
    	this.power = newPower;
    }
    public void setType(Type type) {
    	this.type = type;
    }
    
    //TODO: consider checking more
    public boolean isEqual(Object o) {
        return (o instanceof Move) && ((Move) o).indexNum == this.indexNum;        
    }
    
    public int hashCode() {
        return indexNum;
    }
}
