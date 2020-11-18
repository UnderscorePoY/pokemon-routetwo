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
        if(spA >=  0 && spA <= 205
        || spA >=433 && spA <= 660)
        	return false;
        			
        return true;
    }

}
