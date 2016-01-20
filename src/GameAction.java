
public abstract class GameAction {
    abstract void performAction(Pokemon p);
    
    public static final GameAction eatRareCandy = new GameAction() {
        void performAction(Pokemon p) { p.eatRareCandy(); }
    };
    public static final GameAction eatHPUp = new GameAction() {
        void performAction(Pokemon p) { p.eatHPUp(); }
    };
    public static final GameAction eatIron = new GameAction() {
        void performAction(Pokemon p) { p.eatIron(); }
    };
    public static final GameAction eatProtein = new GameAction() {
        void performAction(Pokemon p) { p.eatProtein(); }
    };
    public static final GameAction eatCalcium = new GameAction() {
        void performAction(Pokemon p) { p.eatCalcium(); }
    };
    public static final GameAction eatCarbos = new GameAction() {
        void performAction(Pokemon p) { p.eatCarbos(); }
    };
    
    public static final GameAction pinkBowFlag = new GameAction() {
        void performAction(Pokemon p) { Constants.pinkBow = true; }
    };
    
    public static final GameAction charcoalFlag = new GameAction() {
    	void performAction(Pokemon p) { Constants.charcoal = !Constants.charcoal; }
    };
    
    public static final GameAction battleTowerFlag = new GameAction() {
    	void performAction(Pokemon p) {
    		p.setAtkBadge(false);
    		p.setDefBadge(false);
    		p.setSpcBadge(false);
    		p.setSpdBadge(false);
    		p.unboostType(Type.FLYING);
    		p.unboostType(Type.BUG);
    		p.unboostType(Type.NORMAL);
    		p.unboostType(Type.GHOST);
    		p.unboostType(Type.ICE);
    		p.unboostType(Type.FIGHTING);
    		p.unboostType(Type.STEEL);
    		p.unboostType(Type.DRAGON);
    	}
    };
    
    //badges
    public static final GameAction getBoulderBadge = new GameAction() {
        void performAction(Pokemon p) { p.setAtkBadge(true); }
    };
    public static final GameAction getSoulBadge = new GameAction() {
        void performAction(Pokemon p) { p.setSpdBadge(true); } //gen 1 is buggy as fuck
    };
    public static final GameAction getVolcanoBadge = new GameAction() {
        void performAction(Pokemon p) { p.setSpcBadge(true); }
    };
    public static final GameAction getThunderBadge = new GameAction() {
        void performAction(Pokemon p) { 
        	p.setTypeBoosted(Type.ICE);
        	p.setDefBadge(true); 
        }
    };
    
    //not really a game action, but it's a nice hack?
    public static final GameAction printAllStats = new GameAction() {
        void performAction(Pokemon p) { 
        	Main.appendln(p.statsWithBoost()); 
        	Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d", p.getLevel(),
                    p.expToNextLevel(), p.expForLevel()));
        }
    };
    public static final GameAction printAllStatsNoBoost = new GameAction() {
        void performAction(Pokemon p) { 
        	Main.appendln(p.statsWithoutBoost()); 
        	Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d", p.getLevel(),
                    p.expToNextLevel(), p.expForLevel()));
        }
    };
    public static final GameAction printStatRanges = new GameAction() {
        void performAction(Pokemon p) { Main.appendln(p.statRanges(true)); }
    };
    public static final GameAction printStatRangesNoBoost = new GameAction() {
        void performAction(Pokemon p) { Main.appendln(p.statRanges(false)); }
    };

}

class ChangeReturnPower extends GameAction {
	private int power;
	ChangeReturnPower(int newPower) { power = newPower; }
	@Override
	void performAction(Pokemon p) { Constants.base_powers[216] = power; }
}

class LearnMove extends GameAction {
    private Move move;
    LearnMove(Move m) { move = m; }
    LearnMove(String s) { move = Move.getMoveByName(s); }
    public Move getMove() { return move; }
    @Override
    void performAction(Pokemon p) { p.getMoveset().addMove(move); }
}


class UnlearnMove extends GameAction {
    private Move move;
    UnlearnMove(Move m) { move = m; }
    UnlearnMove(String s) { move = Move.getMoveByName(s); }
    public Move getMove() { return move; }
    @Override
    void performAction(Pokemon p) { p.getMoveset().delMove(move); }
}

class Evolve extends GameAction {
    private Species target;
    Evolve(Species s) { target = s; }
    Evolve(String s) { target = PokemonNames.getSpeciesFromName(s); }
    @Override
    void performAction(Pokemon p) {
        p.evolve(target);
        p.calculateStats();}
}
