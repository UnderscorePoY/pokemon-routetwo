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
    
    public static final GameAction magnetFlag = new GameAction() {
        void performAction(Pokemon p) { Constants.magnet = !Constants.magnet; }
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
    public static final GameAction getZephyrBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.FLYING);
            p.setAtkBadge(true);
        }
    };
    public static final GameAction getHiveBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.BUG);
        }
    };
    public static final GameAction getPlainBadge = new GameAction() {
        void performAction(Pokemon p) { 
            p.setTypeBoosted(Type.NORMAL);
            p.setSpdBadge(true);
        }
    };
    public static final GameAction getFogBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.GHOST);
        }
    };
    public static final GameAction getStormBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.FIGHTING);
        }
    };
    public static final GameAction getMineralBadge = new GameAction() {
        void performAction(Pokemon p) { 
            p.setTypeBoosted(Type.STEEL);
            p.setDefBadge(true);
        }
    };
    public static final GameAction getGlacierBadge = new GameAction() {
        void performAction(Pokemon p) { 
            p.setTypeBoosted(Type.ICE);
            p.setSpcBadge(true);
        }
    };
    public static final GameAction getRisingBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.DRAGON);
        }
    };
    public static final GameAction getBoulderBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.ROCK);
        }
    };
    public static final GameAction getCascadeBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.WATER);
        }
    };
    public static final GameAction getThunderBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.ELECTRIC);
        }
    };
    public static final GameAction getRainbowBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.GRASS);
        }
    };
    public static final GameAction getSoulBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.POISON);
        }
    };
    public static final GameAction getMarshBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.PSYCHIC);
        }
    };
    public static final GameAction getVolcanoBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.FIRE);
        }
    };
    public static final GameAction getEarthBadge = new GameAction() {
        void performAction(Pokemon p) {
            p.setTypeBoosted(Type.GROUND);
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
    void performAction(Pokemon p) { Move.RETURN.setPower(power); }
}

class LearnMove extends GameAction {
    private Move move;
    LearnMove(String s) { move = Move.valueOf(s); }
    public Move getMove() { return move; }
    @Override
    void performAction(Pokemon p) { p.getMoveset().addMove(move); }
}


class UnlearnMove extends GameAction {
    private Move move;
    UnlearnMove(String s) { move = Move.valueOf(s); }
    public Move getMove() { return move; }
    @Override
    void performAction(Pokemon p) { p.getMoveset().delMove(move); }
}

class Evolve extends GameAction {
    private Species target;
    Evolve(String s) { target = Species.valueOf(s); }
    @Override
    void performAction(Pokemon p) {
        p.evolve(target);
        p.calculateStats();}
}
