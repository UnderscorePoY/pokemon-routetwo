public class Constants {
    static final String hashName(String s) {
        return s.toUpperCase().replaceAll("\\W", "");
    }
    static final String endl = System.lineSeparator();

    static final boolean isPlayer = true;
    static final boolean isEnemy = false;
    
    static BattleHeldItem battleHeldItem = null;
    public static boolean battleTower = false;

    static public boolean givesSpDefBadgeBoost(int spA) {
        int aVal = (spA - 999)/256;
        return (aVal % 2) == 0;
    }

}
