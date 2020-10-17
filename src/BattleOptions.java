public class BattleOptions {
    private int participants = 1;
    private Integer[] sxps = null;
    private Integer[] xatks = null;
    private Integer[] xdefs = null;
    private Integer[] xspds = null;
    private Integer[] xspcs = null;
    private Integer[] ydefs = null;
    private Integer[] order = null;
    private Integer[] xlightscreen = null;
    private Integer[] xreflect = null;
    private Integer[] ylightscreen = null;
    private Integer[] yreflect = null;
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

    public void setXatks(Integer[] xatks) {
        int len = xatks.length;
        this.xatks = new Integer[len];
        System.arraycopy(xatks, 0, this.xatks, 0, len);
    }
    
    public Integer[] getXatks() {
        return xatks;
    }
    
    public void setXdefs(Integer[] xdefs) {
        int len = xdefs.length;
        this.xdefs = new Integer[len];
        System.arraycopy(xdefs, 0, this.xdefs, 0, len);
    }
    
    public Integer[] getXdefs() {
        return xdefs;
    }
    
    public void setXspds(Integer[] xspds) {
        int len = xspds.length;
        this.xspds = new Integer[len];
        System.arraycopy(xspds, 0, this.xspds, 0, len);
    }
    
    public Integer[] getXspds() {
        return xspds;
    }
    
    public void setXspcs(Integer[] xspcs) {
        int len = xspcs.length;
        this.xspcs = new Integer[len];
        System.arraycopy(xspcs, 0, this.xspcs, 0, len);
    }
    
    public Integer[] getXspcs() {
        return xspcs;
    }
    
    public void setYdefs(Integer[] ydefs) {
        int len = ydefs.length;
        this.ydefs = new Integer[len];
        System.arraycopy(ydefs, 0, this.ydefs, 0, len);
    }
    
    public Integer[] getYdefs() {
        return ydefs;
    }

    public void setOrder(Integer[] order) {
        int len = order.length;
        this.order = new Integer[len];
        System.arraycopy(order, 0, this.order, 0, len);
    }

    public Integer[] getOrder() { return order; }

    public void setXlightscreen(Integer[] lightscreen) { 
    	int len = lightscreen.length;
    	this.xlightscreen = new Integer[len];
    	System.arraycopy(lightscreen, 0, this.xlightscreen, 0, len);
    }
    public void setYlightscreen(Integer[] lightscreen) {
    	int len = lightscreen.length;
    	this.ylightscreen = new Integer[len];
    	System.arraycopy(lightscreen, 0, this.ylightscreen, 0, len);
    }
    public Integer[] getXlightscreen() { return xlightscreen; }
    public Integer[] getYlightscreen() { return ylightscreen; }
    
    public void setXreflect(Integer[] reflect) {
    	int len = reflect.length;
    	this.xreflect = new Integer[len];
    	System.arraycopy(reflect, 0, this.xreflect, 0, len);
    }
    public void setYreflect(Integer[] reflect) {
    	int len = reflect.length;
    	this.yreflect = new Integer[len];
    	System.arraycopy(reflect, 0, this.yreflect, 0, len);
    }
    public Integer[] getXreflect() { return xreflect; }
    public Integer[] getYreflect() { return yreflect; }

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
