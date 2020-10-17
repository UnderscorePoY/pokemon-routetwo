//the in-battle stat modifiers to a pokemon (caused by e.g. x attack)
public class StatModifier {
    // private static final int XACCON = 100;
    // int from -6 to +6 that represents the stage
    private int atk = 0;
    private int def = 0;
    private int spd = 0;
    private int spcAtk = 0;
    private int spcDef = 0;
    private int accuracy = 0;
    private int evasion = 0;
    private boolean usedxacc = false;
    private int atkBB = 0;
    private int defBB = 0;
    private int spdBB = 0;
    private int spcBB = 0;
    private boolean lightscreen = false;
    private boolean reflect = false;

    public StatModifier() {}

    public StatModifier(int atk, int def, int spd, int spcAtk, int spcDef) {
        this.atk = atk;
        this.def = def;
        this.spcAtk = spcAtk;
        this.spcDef = spcDef;
        this.spd = spd;
    }

    public StatModifier(int atk, int def, int spd, int spcAtk, int spcDef, boolean xacc) {
        this(atk, def, spd, spcAtk, spcDef, 0, 0, xacc);
    }

    // public StatModifier(int atk, int def, int spd, int spc, int accuracy, int
    // evasion) {
    // this(atk,def,spd,spc);
    // this.accuracy = accuracy;
    // this.evasion = evasion;
    // }
    public StatModifier(int atk, int def, int spd, int spcAtk, int spcDef,
            int accuracy, int evasion, boolean xacc) {
        this(atk, def, spd, spcAtk, spcDef);
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.usedxacc = xacc;
    }

    // used to keep the stage between -6 and +6
    private static int bound(int stage) {
        if (stage < -6)
            return -6;
        else if (stage > 6)
            return 6;
        else
            return stage;
    }

    // in gen 1, accuracy/evasion stages are done the same as other stats
    private static double accuracyEvasionMultiplier(int stage) {
        return normalStatMultiplier(stage);
    }

    //multiplier for atk,def,spc,spd
    private static double normalStatMultiplier(int stage) {
        return ((double) multipliers[stage + 6]) / divisors[stage + 6];
    }

    private static int[] multipliers = new int[] {  25,  28, 33,   40,  50,  66, 1, 15, 2, 25, 3, 35, 4 };
    private static int[] divisors    = new int[] { 100, 100, 100, 100, 100, 100, 1, 10, 1, 10, 1, 10, 1 };

    private static int modifyStat(int original, int stage) {
        return original * multipliers[stage + 6] / divisors[stage + 6];
    }

    public void setBadgeBoosts(int atkBB, int defBB, int spdBB, int spcBB) {
        this.atkBB = atkBB;
        this.defBB = defBB;
        this.spdBB = spdBB;
        this.spcBB = spcBB;
    }

    public int getAtkBB() {
        return atkBB;
    }

    public int getDefBB() {
        return defBB;
    }

    public int getSpdBB() {
        return spdBB;
    }

    public int getSpcBB() {
        return spcBB;
    }

    public int getAccuracyStage() {
        return accuracy;
    }

    public void setAccuracyStage(int accuracy) {
        this.accuracy = bound(accuracy);
    }

    public int getEvasionStage() {
        return evasion;
    }

    public void setEvasionStage(int evasion) {
        this.evasion = bound(evasion);
    }
    
    public void setLightscreen(int lightscreen) {
    	this.lightscreen = (lightscreen != 0);
    }
    public void setReflect(int reflect) {
    	this.reflect = (reflect != 0);
    }
    public boolean isLightscreen() { return lightscreen; }
    public boolean isReflect() { return reflect; }
    

    public int getAtkStage() {
        return atk;
    }

    public void setAtkStage(int atk) {
        this.atk = bound(atk);
    }

    public int getDefStage() {
        return def;
    }

    public void setDefStage(int def) {
        this.def = bound(def);
    }

    public int getSpcAtkStage() {
        return spcAtk;
    }

    public void setSpcAtkStage(int spc) {
        this.spcAtk = bound(spc);
    }

    public int getSpcDefStage() {
        return spcDef;
    }

    public void setSpcDefStage(int spc) {
        this.spcDef = bound(spc);
    }

    public int getSpdStage() {
        return spd;
    }

    public void setSpdStage(int spd) {
        this.spd = bound(spd);
    }

    public boolean getUsedXAcc() {
        return usedxacc;
    }

    public void useXAcc() {
        this.usedxacc = true;
    }

    public void unuseXAcc() {
        this.usedxacc = false;
    }

    public void incrementAccuracyStage() {
        incrementAccuracyStage(1);
    }

    public void incrementEvasionStage() {
        incrementEvasionStage(1);
    }

    public void incrementAtkStage() {
        incrementAtkStage(1);
    }

    public void incrementDefStage() {
        incrementDefStage(1);
    }

    public void incrementSpcAtkStage() {
        incrementSpcAtkStage(1);
    }

    public void incrementSpcDefStage() {
        incrementSpcDefStage(1);
    }

    public void incrementSpdStage() {
        incrementSpdStage(1);
    }

    public void incrementAccuracyStage(int i) {
        setAccuracyStage(getAccuracyStage() + i);
    }

    public void incrementEvasionStage(int i) {
        setEvasionStage(getEvasionStage() + i);
    }

    public void incrementAtkStage(int i) {
        setAtkStage(getAtkStage() + i);
    }

    public void incrementDefStage(int i) {
        setDefStage(getDefStage() + i);
    }

    public void incrementSpcAtkStage(int i) {
        setSpcAtkStage(getSpcAtkStage() + i);
    }

    public void incrementSpcDefStage(int i) {
        setSpcDefStage(getSpcDefStage() + i);
    }

    public void incrementSpdStage(int i) {
        setSpdStage(getSpdStage() + i);
    }

    public double getAccuracyMultiplier() {
        return accuracyEvasionMultiplier(accuracy);
    }

    public double getEvasionMultiplier() {
        return accuracyEvasionMultiplier(evasion);
    }

    public double getAtkMultiplier() {
        return normalStatMultiplier(atk);
    }

    public double getDefMultiplier() {
        return normalStatMultiplier(def);
    }

    public double getSpcAtkMultiplier() {
        return normalStatMultiplier(spcAtk);
    }

    public double getSpcDefMultiplier() {
        return normalStatMultiplier(spcDef);
    }

    public double getSpdMultiplier() {
        return normalStatMultiplier(spd);
    }

    public String summary() {
        if (hasMods()) {
            if (hasBBs()) {
                return String.format("+[%s/%s/%s/%s/%s]%s%s%s +<%s/%s/%s/%s>",
                		atk, def, spd, spcAtk, spcDef, 
                        (usedxacc ? " +X ACC" : ""), (isLightscreen() ? " +LIGHTSCREEN" : ""), (isReflect() ? " +REFLECT" : ""),
                        atkBB, defBB, spdBB, spcBB);
            } else {
                return String.format("+[%s/%s/%s/%s/%s]%s%s%s", 
                		atk, def, spd, spcAtk, spcDef, 
                		(usedxacc ? " +X ACC" : ""), (isLightscreen() ? " +LIGHTSCREEN" : ""), (isReflect() ? " +REFLECT" : ""));
            }
        } else {
            if (hasBBs()) {
                return String.format("+<%s/%s/%s/%s>", atkBB, defBB, spdBB,
                        spcBB);
            } else {
                return "";
            }
        }

    }

    public int modAtk(Pokemon p) {
        int a = Math.max(modifyStat(p.getTrueAtk(), atk), 1);
        if (p.isAtkBadge()) {
            for (int i = 1; i <= atkBB + 1; i++) {
                a = 9 * a / 8;
            }
        }
        return a;
    }

    public int modDef(Pokemon p) {
        int a = Math.max(modifyStat(p.getTrueDef(), def), 1);
        if (p.isDefBadge()) {
            for (int i = 1; i <= defBB + 1; i++) {
                a = 9 * a / 8;
            }
        }
        return a;
    }

    public int modSpcAtk(Pokemon p) {
        int a = Math.max(modifyStat(p.getTrueSpcAtk(), spcAtk), 1);
        if (p.isSpcBadge()) {
            for (int i = 1; i <= spcBB + 1; i++) {
                a = 9 * a / 8;
            }
        }
        return a;
    }

    public int modSpcDef(Pokemon p, int spA) {
        int a = Math.max(modifyStat(p.getTrueSpcDef(), spcDef), 1);
        if (p.isSpcBadge() && Constants.givesSpDefBadgeBoost(spA)) {
            for (int i = 1; i <= spcBB + 1; i++) {
                a = 9 * a / 8;
            }
        }
        return a;
    }

    public int modSpd(Pokemon p) {
        int a = Math.max(modifyStat(p.getTrueSpd(), spd), 1);
        if (p.isSpdBadge()) {
            for (int i = 1; i <= spdBB + 1; i++) {
                a = 9 * a / 8;
            }
        }
        return a;
    }

    public int modSpdWithIV(Pokemon p, int iv) {
        int a = Math.max(modifyStat(p.getSpdWithIV(iv), spd), 1);
        if (p.isSpdBadge()) {
            for (int i = 1; i <= spdBB + 1; i++) {
                a = 9 * a / 8;
            }
        }
        return a;
    }

    public boolean hasMods() {
        return atk != 0 || def != 0 || spcAtk != 0 || spcDef != 0 || spd != 0 || accuracy != 0
                || evasion != 0 || usedxacc || isLightscreen() || isReflect();
    }

    public boolean hasBBs() {
        return atkBB != 0 || defBB != 0 || spcBB != 0 || spdBB != 0;
    }

    public String modStatsStr(Pokemon p) {
        return String.format("%s/%s/%s/%s/%s/%s", p.getHP(), modAtk(p), modDef(p),
                modSpd(p), modSpcAtk(p), modSpcDef(p, modSpcAtk(p)));
    }

}
