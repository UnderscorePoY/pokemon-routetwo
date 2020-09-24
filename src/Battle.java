import java.util.ArrayList;
import java.util.Iterator;

//represents a battle, with planned statmods
public class Battle extends GameAction {
    private Battleable opponent;
    private BattleOptions options;

    public Battle(Battleable b) {
        opponent = b;
        options = new BattleOptions();
    }

    public Battle(Battleable b, BattleOptions options) {
        opponent = b;
        this.options = options;
    }

    public BattleOptions getOptions() {
        return options;
    }

    public StatModifier getMod1() {
        return options.getMod1();
    }

    public StatModifier getMod2() {
        return options.getMod2();
    }

    public int getVerbose() {
        return options.getVerbose();
    }

    public static Battle makeBattle(int offset) {
        return new Battle(Trainer.getTrainer(offset));
    }

    public static Battle makeBattle(int offset, BattleOptions options) {
        return new Battle(Trainer.getTrainer(offset), options);
    }

    public static Battle makeBattle(Pokemon p) {
        return new Battle(p);
    }

    public static Battle makeBattle(Pokemon p, BattleOptions options) {
        return new Battle(p, options);
    }

    @Override
    public void performAction(Pokemon p) {
        doBattle(p);

        // check for special gym leader badges
        if (Trainer.getTrainer("FALKNER").equals(opponent)) {
            p.setAtkBadge(true);
            p.setTypeBoosted(Type.FLYING);
        } else if (Trainer.getTrainer("JASMINE").equals(opponent)) {
            p.setDefBadge(true);
            p.setTypeBoosted(Type.STEEL);
        } else if (Trainer.getTrainer("WHITNEY").equals(opponent)) {
            p.setSpdBadge(true);
            p.setTypeBoosted(Type.NORMAL);
        } else if (Trainer.getTrainer("PRYCE").equals(opponent)) {
            p.setSpcBadge(true);
            p.setTypeBoosted(Type.ICE);
        } else if (Trainer.getTrainer("BUGSY").equals(opponent)) {
            p.setTypeBoosted(Type.BUG);
        } else if (Trainer.getTrainer("MORTY").equals(opponent)) {
            p.setTypeBoosted(Type.GHOST);
        } else if (Trainer.getTrainer("CHUCK").equals(opponent)) {
            p.setTypeBoosted(Type.FIGHTING);
        } else if (Trainer.getTrainer("CLAIR").equals(opponent)) {
            p.setTypeBoosted(Type.DRAGON);
        } else if (Trainer.getTrainer("BROCK").equals(opponent)) {
            p.setTypeBoosted(Type.ROCK);
        } else if (Trainer.getTrainer("MISTY").equals(opponent)) {
            p.setTypeBoosted(Type.WATER);
        } else if (Trainer.getTrainer("LT.SURGE").equals(opponent)) {
            p.setTypeBoosted(Type.ELECTRIC);
        } else if (Trainer.getTrainer("ERIKA").equals(opponent)) {
            p.setTypeBoosted(Type.GRASS);
        } else if (Trainer.getTrainer("JANINE").equals(opponent)) {
            p.setTypeBoosted(Type.POISON);
        } else if (Trainer.getTrainer("SABRINA").equals(opponent)) {
            p.setTypeBoosted(Type.PSYCHIC);
        } else if (Trainer.getTrainer("BLAINE").equals(opponent)) {
            p.setTypeBoosted(Type.FIRE);
        } else if (Trainer.getTrainer("BLUE").equals(opponent)) {
            p.setTypeBoosted(Type.GROUND);
        }
    }

    private void doBattle(Pokemon p) {
        int lastLvl = p.getLevel();

        // TODO: automatically determine whether or not to print
        if (opponent instanceof Pokemon) {
            if(getVerbose() == BattleOptions.ALL || getVerbose() == BattleOptions.EVERYTHING)
                printBattle(p, (Pokemon) opponent);
            else if (getVerbose() == BattleOptions.SOME)
                printShortBattle(p, (Pokemon) opponent);

            // TODO: Fix this hack
            if(!((Pokemon) opponent).isTowerPoke()) {
                opponent.battle(p, options);
                if (p.getLevel() > lastLvl) {
                    lastLvl = p.getLevel();
                    if (options.isPrintSRsOnLvl()) {
                        Main.appendln(p.statRanges(false));
                    }
                    if (options.isPrintSRsBoostOnLvl()) {
                        Main.appendln(p.statRanges(true));
                    }
                }
                if(getVerbose() == BattleOptions.EVERYTHING) {
                    Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d", p.getLevel(),
                        p.expToNextLevel(), p.expForLevel()));
                }
            }
        } else { // is a Trainer
            Trainer t = (Trainer) opponent;
            int sxpIdx = 0;
            int sxp = 1;
            Integer[] sxps = options.getSxps();
            Integer[] xatks = options.getXatks();
            Integer[] xdefs = options.getXdefs();
            Integer[] xspds = options.getXspds();
            Integer[] xspcs = options.getXspcs();
            Integer[] ydefs = options.getYdefs();
            Integer[] order = options.getOrder();
            Iterable<Pokemon> trainerPokes = null;
            if(order == null) {
                trainerPokes = t;
            } else {
                ArrayList<Pokemon> origPokes = new ArrayList<>();
                t.forEach(origPokes::add);
                ArrayList<Pokemon> modPokes = new ArrayList<>();
                for(int i=0; i<order.length; i++) {
                    modPokes.add(origPokes.get(order[i]-1));
                }
                trainerPokes = modPokes;
                t.changePokes(modPokes);
            }
            if(getVerbose() == BattleOptions.ALL || getVerbose() == BattleOptions.SOME || getVerbose() == BattleOptions.EVERYTHING) {
                Main.appendln(t.toString());
            }
            for (Pokemon opps : trainerPokes) {
                if(sxps != null) {
                    sxp = sxps[sxpIdx];
                    if(sxp != 0) {
                        options.setParticipants(sxp);
                    }
                }
                if(xatks != null) {
                    int xatk = xatks[sxpIdx];
                    StatModifier mod1 = options.getMod1();
                    mod1.setAtkStage(xatk);
                    options.setMod1(mod1);
                }
                if(xdefs != null) {
                    int xdef = xdefs[sxpIdx];
                    StatModifier mod1 = options.getMod1();
                    mod1.setDefStage(xdef);
                    options.setMod1(mod1);
                }
                if(xspds != null) {
                    int xspd = xspds[sxpIdx];
                    StatModifier mod1 = options.getMod1();
                    mod1.setSpdStage(xspd);
                    options.setMod1(mod1);
                }
                if(xspcs != null) {
                    int xspc = xspcs[sxpIdx];
                    StatModifier mod1 = options.getMod1();
                    mod1.setSpcAtkStage(xspc);
                    options.setMod1(mod1);
                }
                if(ydefs != null) {
                    int ydef = ydefs[sxpIdx];
                    StatModifier mod2 = options.getMod2();
                    mod2.setDefStage(ydef);
                    options.setMod2(mod2);
                }
                if(sxp != 0) {
                    if(getVerbose() == BattleOptions.ALL || getVerbose() == BattleOptions.EVERYTHING)
                        printBattle(p, (Pokemon) opps);
                    else if (getVerbose() == BattleOptions.SOME)
                        printShortBattle(p, (Pokemon) opps);
                    if (getVerbose() != BattleOptions.NONE) {
                        if (options.getMod1().modSpdWithIV(p, 0) <= options.getMod2().modSpd(opps)
                                && options.getMod1().modSpdWithIV(p, 15) >= options.getMod2().modSpd(opps)) {
                            int tieDV = 16, outspeedDV = 16;
                            int oppSpd = options.getMod2().modSpd(opps);
                            for (int sDV = 0; sDV < 16; sDV++) {
                                int mySpd = options.getMod1().modSpdWithIV(p, sDV);
                                if (mySpd == oppSpd && sDV < tieDV) {
                                    tieDV = sDV;
                                }
                                if (mySpd > oppSpd && sDV < outspeedDV) {
                                    outspeedDV = sDV;
                                    break;
                                }
                            }
                            Main.append("(Speed DV required");
                            if (tieDV != 16 && outspeedDV != 16 && (tieDV != outspeedDV)) {
                                Main.append(" to outspeed: " + outspeedDV + ", to speedtie: " + tieDV);
                            } else if (outspeedDV != 16) {
                                Main.append(" to outspeed: " + outspeedDV);
                            } else {
                                Main.append(" to speedtie: " + tieDV);
                            }
                            Main.appendln(")");
                            Main.appendln("");
                        }
                    }
                    opps.battle(p, options);
                    // test if you leveled up on this pokemon
                    if (p.getLevel() > lastLvl) {
                        lastLvl = p.getLevel();
                        if (options.isPrintSRsOnLvl()) {
                            Main.appendln(p.statRanges(false));
                        }
                        if (options.isPrintSRsBoostOnLvl()) {
                            Main.appendln(p.statRanges(true));
                        }
                    }
                    if(getVerbose() == BattleOptions.EVERYTHING) {
                        Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d",
                                p.getLevel(), p.expToNextLevel(), p.expForLevel()));
                    }
                }
                sxpIdx++;
            }
        }
        if(getVerbose() == BattleOptions.ALL || getVerbose() == BattleOptions.SOME) {
            Main.appendln(String.format("LVL: %d EXP NEEDED: %d/%d", p.getLevel(),
                    p.expToNextLevel(), p.expForLevel()));
        }
    }

    // does not actually do the battle, just prints summary
    public void printBattle(Pokemon us, Pokemon them) {
        Main.appendln(DamageCalculator.summary(us, them, options));
    }

    // does not actually do the battle, just prints short summary
    public void printShortBattle(Pokemon us, Pokemon them) {
        Main.appendln(DamageCalculator.shortSummary(us, them, options));
    }
}

class Encounter extends Battle {
    Encounter(Species s, int lvl, BattleOptions options) {
        super(new Pokemon(s, lvl), options);
    }

    Encounter(String s, int lvl) {
        this(Species.valueOf(s), lvl, new BattleOptions());
    }

    Encounter(String s, int lvl, BattleOptions options) {
        this(Species.valueOf(s), lvl, options);
    }
}

class TrainerPoke extends Battle {
    TrainerPoke(Species s, int lvl, BattleOptions options) {
        super(new Pokemon(s, lvl), options);
    }

    TrainerPoke(String s, int lvl) {
        this(Species.valueOf(s), lvl, new BattleOptions());
    }

    TrainerPoke(String s, int lvl, BattleOptions options) {
        this(Species.valueOf(s), lvl, options);
    }
}
