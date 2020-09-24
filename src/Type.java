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
            { 2, 1, 5, 5, 1, 2, 5, 0, 1, 1, 1, 1, 5, 2, 1, 2, 2 },
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
                || t == Type.STEEL;
    }

}
