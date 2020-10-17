
public enum BattleHeldItem {
	// type boosting items
	BLACKBELT(Type.FIGHTING),
	BLACKGLASSES(Type.DARK),
	CHARCOAL(Type.FIRE),
	DRAGONSCALE(Type.DRAGON),
	HARDSTONE(Type.ROCK),
	MAGNET(Type.ELECTRIC),
	METALCOAT(Type.STEEL),
	MIRACLESEED(Type.GRASS),
	MYSTICWATER(Type.WATER),
	NEVERMELTICE(Type.ICE),
	PINKBOW(Type.NORMAL),
	POISONBARB(Type.POISON),
	POLKADOTBOW(Type.NORMAL),
	SHARPBEAK(Type.FLYING),
	SILVERPOWDER(Type.BUG),
	SOFTSAND(Type.GROUND),
	SPELLTAG(Type.GHOST),
	TWISTEDSPOON(Type.PSYCHIC),
	
	// species boosting items
	LIGHTBALL(Type.NONE),
	METALPOWDER(Type.NONE),
	THICKCLUB(Type.NONE);
	
	public Type type;
	
	private BattleHeldItem(Type t) {
		this.type = t;
	}
}
