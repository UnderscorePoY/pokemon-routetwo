import java.util.ArrayList;
import java.util.List;

public enum Type {
    NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE, DRAGON, STEEL, DARK, NONE;
    // returns the type effectiveness multiplier.
    // defType2 should be Type.NONE if the defending pokemon has only one type
    public static double effectiveness(Type atkType, Type defType1,
            Type defType2) {
        return effectiveness(atkType, defType1)
                * effectiveness(atkType, defType2);
    }

    private static double effectiveness(Type atkType, Type defType) {
        if (defType == NONE || atkType == NONE) { 
            return 1;
        } else {
            int val = typeTable[typeIndex(atkType)][typeIndex(defType)];
            return (val == 5) ? 0.5 : val; // i am coding master
        }

    }

    // returns index associated with this type (in the order written)
    // Type.NONE will return -1
    public static int typeIndex(Type t) {
        switch (t) {
        case NORMAL:
            return 0;
        case FIGHTING:
            return 1;
        case FLYING:
            return 2;
        case POISON:
            return 3;
        case GROUND:
            return 4;
        case ROCK:
            return 5;
        case BUG:
            return 6;
        case GHOST:
            return 7;
        case FIRE:
            return 8;
        case WATER:
            return 9;
        case GRASS:
            return 10;
        case ELECTRIC:
            return 11;
        case PSYCHIC:
            return 12;
        case ICE:
            return 13;
        case DRAGON:
            return 14;
        case STEEL:
            return 15;
        case DARK:
            return 16;
        default: // NONE
            return -1;
        }
    }

    // typeTable[i][j] is type i's effectiveness against type j, with 5
    // representing 0.5
    private static final int[][] typeTable = {
            { 1, 1, 1, 1, 1, 5, 1, 0, 1, 1, 1, 1, 1, 1, 1, 5, 1 },
            //{ 2, 1, 5, 5, 1, 2, 5, 1, 1, 1, 1, 1, 5, 2, 1, 2, 2 }, //2 - Foresight with Fighting
            { 2, 1, 5, 5, 1, 2, 5, 0, 1, 1, 1, 1, 5, 2, 1, 2, 2 }, //2 - Normal
            { 1, 2, 1, 1, 1, 5, 2, 1, 1, 1, 2, 5, 1, 1, 1, 5, 1 },
            { 1, 1, 1, 5, 5, 5, 1, 5, 1, 1, 2, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 0, 2, 1, 2, 5, 1, 2, 1, 5, 2, 1, 1, 1, 2, 1 },
            { 1, 5, 2, 1, 5, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 5, 1 },
            { 1, 5, 5, 5, 1, 1, 1, 5, 5, 1, 2, 1, 2, 1, 1, 5, 2 },
            { 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5 },
            { 1, 1, 1, 1, 1, 5, 2, 1, 5, 5, 2, 1, 1, 2, 5, 2, 1 },
            { 1, 1, 1, 1, 2, 2, 1, 1, 2, 5, 5, 1, 1, 1, 5, 1, 1 },
            { 1, 1, 5, 5, 2, 2, 5, 1, 5, 2, 5, 1, 1, 1, 5, 5, 1 },
            { 1, 1, 2, 1, 0, 1, 1, 1, 1, 2, 5, 5, 1, 1, 5, 1, 1 },
            { 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 5, 0 },
            { 1, 1, 2, 1, 2, 1, 1, 1, 5, 5, 2, 1, 1, 5, 2, 5, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 5, 1 },
            { 1, 1, 1, 1, 1, 2, 1, 1, 5, 5, 1, 5, 1, 2, 1, 5, 1 },
            { 1, 5, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5 }, };

    public static boolean isPhysicalType(Type t) {
        return (typeIndex(t) >= typeIndex(Type.NORMAL) && typeIndex(t) <= typeIndex(Type.GHOST))
                || t == Type.STEEL || t == Type.NONE;
    }
    
    
    private static List<TypeEffectiveness> effectList = new ArrayList<TypeEffectiveness>();
    private static final int NO_EFFECT = 0;
    private static final int NOT_VERY_EFFECTIVE = 5;
    private static final int SUPER_EFFECTIVE = 20;
    
	static {
		effectList.add(new TypeEffectiveness(Type.NORMAL  , Type.ROCK    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.NORMAL  , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.FIRE    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.WATER   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.GRASS   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.ICE     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.BUG     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.ROCK    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.DRAGON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIRE    , Type.STEEL   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.WATER   , Type.FIRE    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.WATER   , Type.WATER   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.WATER   , Type.GRASS   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.WATER   , Type.GROUND  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.WATER   ,  Type.ROCK   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.WATER   , Type.DRAGON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ELECTRIC, Type.WATER   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ELECTRIC, Type.ELECTRIC, NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ELECTRIC, Type.GRASS   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ELECTRIC, Type.GROUND  , NO_EFFECT));
		effectList.add(new TypeEffectiveness(Type.ELECTRIC, Type.FLYING  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ELECTRIC, Type.DRAGON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.FIRE    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.WATER   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.GRASS   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.POISON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.GROUND  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.FLYING  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.BUG     , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.ROCK    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.DRAGON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GRASS   , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.WATER   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.GRASS   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.ICE     , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.GROUND  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.FLYING  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.DRAGON  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ICE     , Type.FIRE    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.NORMAL  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.ICE     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.POISON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.FLYING  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.PSYCHIC , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.BUG     , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.ROCK    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.DARK    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FIGHTING, Type.STEEL   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.POISON  , Type.GRASS   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.POISON  , Type.POISON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.POISON  , Type.GROUND  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.POISON  , Type.ROCK    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.POISON  , Type.GHOST   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.POISON  , Type.STEEL   , NO_EFFECT));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.FIRE    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.ELECTRIC, SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.GRASS   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.POISON  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.FLYING  , NO_EFFECT));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.BUG     , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.ROCK    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GROUND  , Type.STEEL   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FLYING  , Type.ELECTRIC, NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FLYING  , Type.GRASS   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FLYING  , Type.FIGHTING, SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FLYING  , Type.BUG     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FLYING  , Type.ROCK    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.FLYING  , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.PSYCHIC , Type.FIGHTING, SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.PSYCHIC , Type.POISON  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.PSYCHIC , Type.PSYCHIC , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.PSYCHIC , Type.DARK    , NO_EFFECT));
		effectList.add(new TypeEffectiveness(Type.PSYCHIC , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.FIRE    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.GRASS   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.FIGHTING, NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.POISON  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.FLYING  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.PSYCHIC , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.GHOST   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.DARK    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.BUG     , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.FIRE    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.ICE     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.FIGHTING, NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.GROUND  , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.FLYING  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.BUG     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.ROCK    , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GHOST   , Type.NORMAL  , NO_EFFECT));
		effectList.add(new TypeEffectiveness(Type.GHOST   , Type.PSYCHIC , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GHOST   , Type.DARK    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GHOST   , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.GHOST   , Type.GHOST   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DRAGON  , Type.DRAGON  , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DRAGON  , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DARK    , Type.FIGHTING, NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DARK    , Type.PSYCHIC , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DARK    , Type.GHOST   , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DARK    , Type.DARK    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.DARK    , Type.STEEL   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.STEEL   , Type.FIRE    , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.STEEL   , Type.WATER   , NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.STEEL   , Type.ELECTRIC, NOT_VERY_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.STEEL   , Type.ICE     , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.STEEL   , Type.ROCK    , SUPER_EFFECTIVE));
		effectList.add(new TypeEffectiveness(Type.STEEL   , Type.STEEL   , NOT_VERY_EFFECTIVE));
	}
    
    public static int applyTypeEffectiveness(int damage, Type atkType,
			Type defType1, Type defType2) {
		for (TypeEffectiveness t : effectList) {
			if (t.atkType == atkType
					&& (t.defType == defType1 || t.defType == defType2)) {
				damage = damage * t.multiplier / 10;
			}
		}
		return damage;
	}


	private static class TypeEffectiveness {
		Type atkType;
		Type defType;
		int multiplier;

		TypeEffectiveness(Type atkType, Type defType, int multiplier) {
			this.atkType = atkType;
			this.defType = defType;
			this.multiplier = multiplier;
		}
	}

}
