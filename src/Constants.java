public class Constants {
    static final String hashName(String s) {
        return s.toUpperCase().replaceAll("\\W", "");
    }

    static final String endl = System.lineSeparator();

    static boolean pinkBow = false;
    static boolean charcoal = false;
    static boolean magnet = false;
    public static boolean battleTower = false;

    static public boolean givesSpDefBadgeBoost(int spA) {
        int aVal = (spA - 999)/256;
        return (aVal % 2) == 0;
    }

}
