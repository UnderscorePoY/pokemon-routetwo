public class IVs {
    private int atk;
    private int def;
    private int spc;
    private int spd;
    private int hp; //calculated based off of previous 4
    
    public IVs() {
        atk = 9;
        def = 8;
        spc = 8;
        spd = 8;
        hp = calculateHP();
    }
    
    public IVs(int newAtk, int newDef, int newSpd, int newSpc) {
        atk = newAtk;
        def = newDef;
        spc = newSpc;
        spd = newSpd;
        hp = calculateHP();
    }
    
    private int calculateHP() {
        return ((atk & 1) << 3) + ((def & 1) << 2) + ((spd & 1) << 1) + (spc & 1);
    }
    
    public int getHPIV() {
        return hp;
    }
    public int getAtkIV() {
        return atk;
    }
    public int getDefIV() {
        return def;
    }
    public int getSpcIV() {
        return spc;
    }
    public int getSpdIV() {
        return spd;
    }
}
