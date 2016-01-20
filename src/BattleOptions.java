
public class BattleOptions {
    private int participants = 1;
    private Integer[] sxps = null;
    private boolean printSRsOnLvl = false;
    private boolean printSRsBoostOnLvl = false;
    private StatModifier mod1;
    private StatModifier mod2;
    private int verbose = BattleOptions.NONE;
    //verbose options
    public static final int NONE = 0;
    public static final int SOME = 1;
    public static final int ALL = 2;
    public static final int EVERYTHING = 3;
    
    public BattleOptions() {
        setMod1(new StatModifier());
        setMod2(new StatModifier());
    }

    public boolean isPrintSRsBoostOnLvl() {
        return printSRsBoostOnLvl;
    }

    public void setPrintSRsBoostOnLvl(boolean printSRsBoostOnLvl) {
        this.printSRsBoostOnLvl = printSRsBoostOnLvl;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
    
    public void setSxps(Integer[] sxps) {
    	int len = sxps.length;
    	this.sxps = new Integer[len];
    	System.arraycopy(sxps, 0, this.sxps, 0, len);
    }
    
    public Integer[] getSxps() {
    	return sxps;
    }

    public boolean isPrintSRsOnLvl() {
        return printSRsOnLvl;
    }

    public void setPrintSRsOnLvl(boolean printSRsOnLvl) {
        this.printSRsOnLvl = printSRsOnLvl;
    }

    public StatModifier getMod1() {
        return mod1;
    }

    public void setMod1(StatModifier mod1) {
        this.mod1 = mod1;
    }

    public StatModifier getMod2() {
        return mod2;
    }

    public void setMod2(StatModifier mod2) {
        this.mod2 = mod2;
    }

    public int getVerbose() {
        return verbose;
    }

    public void setVerbose(int verbose) {
        this.verbose = verbose;
    }
    
}
