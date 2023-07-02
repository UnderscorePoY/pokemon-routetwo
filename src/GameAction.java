public abstract class GameAction {
    abstract void performAction(Pokemon p);
    
    // candies & boosters
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
    
    // battle held items
    public static final GameAction equipBlackBelt = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.BLACKBELT; }
    };
    public static final GameAction equipBlackGlasses = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.BLACKGLASSES; }
    };
    public static final GameAction equipCharcoal = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.CHARCOAL; }
    };
    public static final GameAction equipDragonScale = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.DRAGONSCALE; }
    };
    public static final GameAction equipHardStone = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.HARDSTONE; }
    };
    public static final GameAction equipMagnet = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.MAGNET; }
    };
    public static final GameAction equipMetalCoat = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.METALCOAT; }
    };
    public static final GameAction equipMiracleSeed = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.MIRACLESEED; }
    };
    public static final GameAction equipMysticWater = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.MYSTICWATER; }
    };
    public static final GameAction equipNeverMeltIce = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.NEVERMELTICE; }
    };
    public static final GameAction equipPinkBow = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.PINKBOW; }
    };
    public static final GameAction equipPoisonBarb = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.POISONBARB; }
    };
    public static final GameAction equipPolkadotBow = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.POLKADOTBOW; }
    };
    public static final GameAction equipSharpBeak = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.SHARPBEAK; }
    };
    public static final GameAction equipSilverPowder = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.SILVERPOWDER; }
    };
    public static final GameAction equipSoftSand = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.SOFTSAND; }
    };
    public static final GameAction equipSpellTag = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.SPELLTAG; }
    };
    public static final GameAction equipTwisterSpoon = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.TWISTEDSPOON; }
    };
    public static final GameAction equipLightBall = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.LIGHTBALL; }
    };
    public static final GameAction equipMetalPowder = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.METALPOWDER; }
    };
    public static final GameAction equipThickClub = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.THICKCLUB; }
    };
    public static final GameAction equipLuckyEgg = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = BattleHeldItem.LUCKYEGG; }
    };
    public static final GameAction unequip = new GameAction() {
        void performAction(Pokemon p) { Constants.battleHeldItem = null; }
    };
    
    // battle tower
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
    
    public static final GameAction setAmuletCoin = new GameAction() {
        void performAction(Pokemon p) {
        	Settings.hasAmuletCoin = true;
        }
    };
    public static final GameAction unsetAmuletCoin = new GameAction() {
        void performAction(Pokemon p) {
        	Settings.hasAmuletCoin = false;
        }
    };
	
    public static final GameAction infectPokerus = new GameAction() {
        void performAction(Pokemon p) {
        	Settings.hasPokerus = true;
        }
    };

    public static final GameAction setBoostedExp = new GameAction() {
        void performAction(Pokemon p) {
        	Settings.hasBoostedExp = true;
        }
    };

    public static final GameAction unsetBoostedExp = new GameAction() {
        void performAction(Pokemon p) {
        	Settings.hasBoostedExp = false;
        }
    };
    
    public static final GameAction addMoney = new GameAction() {
    	void performAction(Pokemon p) {
    		
    	}
    };
    
    //not really a game action, but it's a nice hack?
    public static final GameAction printMoney = new GameAction() {
        void performAction(Pokemon p) { 
            Main.appendln(String.format("MONEY: %,d", Settings.money));
        }
    };
    public static final GameAction printAllStats = new GameAction() {
        void performAction(Pokemon p) { 
            Main.appendln(p.statsWithBoost());
            //Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d", p.getLevel(),
            //        p.expToNextLevel(), p.expForLevel()));
        }
    };
    public static final GameAction printAllStatsNoBoost = new GameAction() {
        void performAction(Pokemon p) { 
            Main.appendln(p.statsWithoutBoost());
            //Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d", p.getLevel(),
            //        p.expToNextLevel(), p.expForLevel()));
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
    private int MIN_RETURN_POWER = 1;
    private int MAX_RETURN_POWER = 102;
    ChangeReturnPower(int newPower) { power = Math.min(MAX_RETURN_POWER, Math.max(MIN_RETURN_POWER, newPower)); }
    @Override
    void performAction(Pokemon p) { Move.RETURN.setPower(power); }
}

class LearnMove extends GameAction {
    private Move move;
    LearnMove(String s) { move = Move.valueOf(s); }
    public Move getMove() { return move; }
    @Override
    void performAction(Pokemon p) { 
    	if(this.getMove() == Move.FLAIL) {  // TO-DO : hacky
    		p.getMoveset().addMove(Move.FLAIL200);
    		p.getMoveset().addMove(Move.FLAIL150);
    		p.getMoveset().addMove(Move.FLAIL100);
    		p.getMoveset().addMove(Move.FLAIL80);
    		p.getMoveset().addMove(Move.FLAIL40);
    		p.getMoveset().addMove(Move.FLAIL20);
    		p.getMoveset().delMove(Move.FLAIL);
    	} else {
    		p.getMoveset().addMove(move);
    	}
    }
}


class UnlearnMove extends GameAction {
    private Move move;
    UnlearnMove(String s) { move = Move.valueOf(s); }
    public Move getMove() { return move; }
    @Override
    void performAction(Pokemon p) { 
    	if(this.getMove() == Move.FLAIL) {  // TO-DO : hacky
			p.getMoveset().delMove(Move.FLAIL200);
			p.getMoveset().delMove(Move.FLAIL150);
			p.getMoveset().delMove(Move.FLAIL100);
			p.getMoveset().delMove(Move.FLAIL80);
			p.getMoveset().delMove(Move.FLAIL40);
			p.getMoveset().delMove(Move.FLAIL20);
		} else {
			p.getMoveset().delMove(move);
		}
    }
}

class Evolve extends GameAction {
    private Species target;
    Evolve(String s) { target = Species.valueOf(s); }
    @Override
    void performAction(Pokemon p) {
        p.evolve(target);
        p.calculateStats();}
}

class AddMoney extends GameAction {
	private int money;
	AddMoney(int m) {money = m;}
	@Override
	void performAction(Pokemon p) {
		Settings.money += money;
	}
}
