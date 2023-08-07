import java.util.TreeMap;

public class DamageCalculator {
    private static int MIN_RANGE = 217;
    private static int MAX_RANGE = 255;

    // rangeNum should range from 217 to 255
    // crit indicates if there is a crit or not
    private static int damage(Move attack, Pokemon attacker, Pokemon defender,
                              StatModifier atkMod, StatModifier defMod, int rangeNum,
                              boolean crit, int extra_multiplier, boolean isPlayer) {
        if (rangeNum < MIN_RANGE) {
            rangeNum = MIN_RANGE;
        }
        if (rangeNum > MAX_RANGE) {
            rangeNum = MAX_RANGE;
        }
        Move modAttack = attack;

        double effectiveMult = Type.effectiveness(modAttack.getType(), defender
                .getSpecies().getType1(), defender.getSpecies().getType2());
        if (effectiveMult == 0) {
            return 0;
        }

        if (modAttack.getEffect() == MoveEffect.STATIC_DAMAGE) {
        	return modAttack.getPower();
        }
        if (modAttack.getPower() <= 0) {
            // TODO: more special cases
        	switch(modAttack) {
        	case HIDDENPOWER :
                Type type = getHP_Type(attacker);
                int power = getHP_Power(attacker);
                modAttack.setType(type);
                modAttack.setPower(power);
                modAttack.setName("Hidden Power [" + type.name() + " " + power + "]");
                break;
        	default: return 0;
        	}
        }

        // stat modifiers
        int aa_orig = attacker.getTrueAtk();
        int atk_atk = atkMod.modAtk(attacker);
        int dd_orig = defender.getTrueDef();
        int def_def = defMod.modDef(defender);
        if(modAttack == Move.EXPLOSION || modAttack == Move.SELFDESTRUCT) {
            dd_orig /= 2;
            def_def /= 2;
        }
        int as_orig = attacker.getTrueSpcAtk();
        int atk_spc = atkMod.modSpcAtk(attacker);
        int ds_orig = defender.getTrueSpcDef();
        //int dsa_orig_bug = defender.getTrueSpcAtk(); ///TODO : when is it used and why is this not implemented ?
        int atk_spc_orig_bug = defMod.modSpcAtk(defender);
        int def_spc = defMod.modSpcDef(defender, atk_spc_orig_bug);

        boolean STAB = modAttack.getType() != Type.NONE &&
        		(modAttack.getType() == attacker.getSpecies().getType1()
                || modAttack.getType() == attacker.getSpecies().getType2());
        double effectiveMult = Type.effectiveness(modAttack.getType(), defender
                .getSpecies().getType1(), defender.getSpecies().getType2());
        if (effectiveMult == 0) {
            return 0;
        }

        int effective_atk = 0, effective_def = 0;        
        boolean applyAtkModifiers = !crit || crit && (defMod.getDefStage() < atkMod.getAtkStage());
        boolean applyDefModifiers = applyAtkModifiers;
        boolean applySpcAtkModifiers = !crit || crit && (defMod.getSpcDefStage() < atkMod.getSpcAtkStage());
        boolean applySpcDefModifiers = applySpcAtkModifiers;
        
        boolean isThickClub = isPlayer && Constants.battleHeldItem == BattleHeldItem.THICKCLUB 
        		&& (attacker.getSpecies() == Species.CUBONE || attacker.getSpecies() == Species.MAROWAK);
        boolean isLightBall = isPlayer && Constants.battleHeldItem == BattleHeldItem.LIGHTBALL && attacker.getSpecies() == Species.PIKACHU;
        boolean isMetalPowder = isPlayer && Constants.battleHeldItem == BattleHeldItem.METALPOWDER && defender.getSpecies() == Species.DITTO;

        if (Type.isPhysicalType(modAttack.getType())) {
        	effective_atk = !applyAtkModifiers ? aa_orig : atk_atk;
        	if(atkMod.isBurned())
        		effective_atk /= 2;
        	if(applyAtkModifiers && isThickClub)
        		effective_atk *= 2;
        	effective_def = !applyDefModifiers ? dd_orig : (int)(def_def * (defMod.isReflect() ? 2 : 1) * (isMetalPowder ? 1.5 : 1));
        } else {
        	effective_atk = !applySpcAtkModifiers ? as_orig : atk_spc * (isLightBall ? 2 : 1) ;
        	effective_def = !applySpcDefModifiers ? ds_orig : (int)(def_spc * (defMod.isLightscreen() ? 2 : 1) * (isMetalPowder ? 1.5 : 1));
        }
                
        if (effective_atk > 255 || effective_def > 255) {
            effective_atk = Math.max(1, effective_atk >> 2);
            effective_def = Math.max(1, effective_def >> 2);
        }
        // int damage = ((Math.min((int) ((attacker.getLevel() * 0.4) + 2)
        // * (effective_atk) * attack.getPower() / 50 / (effective_def)
        // * (crit ? 2 : 1), 997) + 2));
        int damage = (attacker.getLevel() * 2 / 5 + 2) * modAttack.getPower()
                * effective_atk;
        damage = damage / effective_def / 50;
        // Held items
        if (isPlayer && Constants.battleHeldItem != null && modAttack.getType() == Constants.battleHeldItem.type) {
            damage = damage * 110 / 100;
        }
        if (crit) {
            damage *= 2;
        }
        damage = Math.min(damage, 997) + 2;
        
        // Weather
        switch(atkMod.getWeather()) {
        case RAIN :
        	if(modAttack == Move.SOLARBEAM || modAttack.getType() == Type.FIRE) {
        		damage /= 2;
        	} else if (modAttack.getType() == Type.WATER) {
        		damage = damage * 3 / 2;
        	}
        	break;
        case SUN :
        	if(modAttack.getType() == Type.WATER) {
        		damage /= 2;
        	} else if (modAttack.getType() == Type.FIRE) {
        		damage = damage * 3 / 2;
        	}
        	break;
        default :
        	break;
        }
        	
        // Type boosts
        if (attacker.isTypeBoosted(modAttack.getType())) {
            int typeboost = Math.max(damage * 1 / 8, 1);
            damage += typeboost;
        }
        // STAB
        if (STAB) {
            damage = damage * 3 / 2;
        }
        //damage *= effectiveMult;
        damage = Type.applyTypeEffectiveness(damage, modAttack.getType(), defender
                .getSpecies().getType1(), defender.getSpecies().getType2());
        damage *= extra_multiplier;
        damage = damage * rangeNum / 255;
        return Math.max(damage, 1);
    }

    private static Type getHP_Type(Pokemon attacker) {
        IVs ivs = attacker.getIVs();
        int atkDV = ivs.getAtkIV();
        int defDV = ivs.getDefIV();
        int hpType = 4*(atkDV%4) + (defDV%4);
        if(hpType==15) {
            hpType += 1;
        }
        if(hpType==7) {
            hpType = 15;
        }
        if(hpType<7) {
            hpType += 1;
        }
        return Type.values()[hpType];
    }

    private static int getHP_Power(Pokemon attacker) {
        IVs ivs = attacker.getIVs();
        int atkDV = (ivs.getAtkIV() >>> 3) << 3;
        int defDV = (ivs.getDefIV() >>> 3) << 2;
        int spdDV = (ivs.getSpdIV() >>> 3) << 1;
        int spcDV = (ivs.getSpcIV() >>> 3) << 0;
        return 31+(5*(spcDV+spdDV+defDV+atkDV)+(ivs.getSpcIV()%4))/2;
    }

    public static int minDamage(Move attack, Pokemon attacker,
                                Pokemon defender, StatModifier atkMod, StatModifier defMod,
                                int extra_multiplier, boolean isPlayer) {
        return damage(attack, attacker, defender, atkMod, defMod, MIN_RANGE,
                false, extra_multiplier, isPlayer);
    }

    public static int maxDamage(Move attack, Pokemon attacker,
                                Pokemon defender, StatModifier atkMod, StatModifier defMod,
                                int extra_multiplier, boolean isPlayer) {
        return damage(attack, attacker, defender, atkMod, defMod, MAX_RANGE,
                false, extra_multiplier, isPlayer);
    }

    public static int minCritDamage(Move attack, Pokemon attacker,
                                    Pokemon defender, StatModifier atkMod, StatModifier defMod,
                                    int extra_multiplier, boolean isPlayer) {
        return damage(attack, attacker, defender, atkMod, defMod, MIN_RANGE,
                true, extra_multiplier, isPlayer);
    }

    public static int maxCritDamage(Move attack, Pokemon attacker,
                                    Pokemon defender, StatModifier atkMod, StatModifier defMod,
                                    int extra_multiplier, boolean isPlayer) {
        return damage(attack, attacker, defender, atkMod, defMod, MAX_RANGE,
                true, extra_multiplier, isPlayer);
    }

    // printout of move damages between the two pokemon
    // assumes you are p1
    public static String summary(Pokemon p1, Pokemon p2, BattleOptions options) {
        StringBuilder sb = new StringBuilder();
        String endl = Constants.endl;
        StatModifier mod1 = options.getMod1();
        StatModifier mod2 = options.getMod2();

        sb.append(p1.levelName() + " vs " + p2.levelName());
        // Don't show exp for tower pokes (minor thing since exp isn't added anyway)
        if(!p2.isTowerPoke()) {
            sb.append("          >>> EXP GIVEN: " + p2.expGiven(options.getParticipants()));
        }
        sb.append(endl);
        // sb.append(String.format("EXP to next level: %d EXP gained: %d",
        // p1.expToNextLevel(), p2.expGiven()) + endl);
        sb.append(String.format("%s (%s) ", p1.pokeName(), p1.statsStr()));
        if (mod1.hasMods() || mod1.hasBBs()) {
            sb.append(String.format("%s -> (%s) ", mod1.summary(),
                    mod1.modStatsStr(p1))
                    + endl);
        } else {
            sb.append(endl);
        }

        sb.append(summary_help(p1, p2, mod1, mod2, Constants.isPlayer, options.isDvDmgRanges(), options.isSplitForCrits()));

        sb.append(endl);

        if(options.getVerbose() == BattleOptions.EVERYTHING || options.getVerbose() == BattleOptions.ALL) {
            for(Move move : p1.getMoveset()) {
                if (move == Move.FURYCUTTER) {
                    for (int i = 1; i <= 5; i++) {
                        damage_help(sb, move, p1, p2, mod1, mod2, i, Constants.isPlayer);
                    }
                } else if (move == Move.ROLLOUT) {
                	for (int i = 1; i <= 6; i++) {
                        damage_help(sb, move, p1, p2, mod1, mod2, i, Constants.isPlayer);
                    }
                } else if (move == Move.RAGE) {
                    for (int i = 1; i <= 8; i++) {
                        damage_help(sb, move, p1, p2, mod1, mod2, i, Constants.isPlayer);
                    }
                } else if(move == Move.MAGNITUDE) {
                    for (int i=4; i<=10; i++) {
                        if(i==10) { i++; }
                        move.setPower(i*20-70);
                        damage_help(sb, move, p1, p2, mod1, mod2, 1, Constants.isPlayer);
                        move.setPower(1);
                    }
                } else {
                    damage_help(sb, move, p1, p2, mod1, mod2, 1, Constants.isPlayer);
                }
            }

            if (mod2.hasMods()) {
                sb.append(String.format("%s (%s) %s -> (%s): ", p2.pokeName(),
                        p2.statsStr(), mod2.summary(), mod2.modStatsStr(p2))
                        + endl);
            } else {
                sb.append(String.format("%s (%s): ", p2.pokeName(), p2.statsStr())
                        + endl);
            }
        }
        sb.append(summary_help(p2, p1, mod2, mod1, Constants.isEnemy, options.isDvDmgRanges(), options.isSplitForCrits()));

        if(options.getVerbose() == BattleOptions.EVERYTHING) {
            sb.append(endl);
            for(Move move : p2.getMoveset()) {
                if (move == Move.FURYCUTTER) {
                    for (int i = 1; i <= 5; i++) {
                        damage_help(sb, move, p2, p1, mod2, mod1, i, Constants.isEnemy);
                    }
                } else if (move == Move.ROLLOUT) {
                    for (int i = 1; i <= 6; i++) {
                        damage_help(sb, move, p2, p1, mod2, mod1, i, Constants.isEnemy);
                    }
            	} else if (move == Move.RAGE) {
                    for (int i = 1; i <= 8; i++) {
                        damage_help(sb, move, p2, p1, mod2, mod1, i, Constants.isEnemy);
                    }
                } else if(move == Move.MAGNITUDE) {
                    for (int i=4; i<=10; i++) {
                        if(i==10) { i++; }
                        move.setPower(i*20-70);
                        damage_help(sb, move, p2, p1, mod2, mod1, 1, Constants.isEnemy);
                        move.setPower(1);
                    }
                } else {
                    damage_help(sb, move, p2, p1, mod2, mod1, 1, Constants.isEnemy);
                }
            }
        }
        return sb.toString();
    }

    private static void damage_help(StringBuilder sb, Move move, Pokemon p1, Pokemon p2, StatModifier mod1, StatModifier mod2, int _extra_modifier, boolean isPlayer) {
        int extra_modifier = (move == Move.FURYCUTTER || move == Move.ROLLOUT) ? 1 << (_extra_modifier - 1) : _extra_modifier;
        String endl = Constants.endl;
        int minDmg = Math.min(p2.getHP(), minDamage(move, p1, p2, mod1, mod2, extra_modifier, Constants.isPlayer));
        if(minDmg > 0) {
            int minCritDmg = Math.min(p2.getHP(), minCritDamage(move, p1, p2, mod1, mod2, extra_modifier, Constants.isPlayer));
            TreeMap<Integer,Double> dmgMap = detailedDamage(move, p1, p2, mod1, mod2, false, extra_modifier, isPlayer);
            TreeMap<Integer,Double> critMap = detailedDamage(move, p1, p2, mod1, mod2, true, extra_modifier, isPlayer);
            if(move == Move.RAGE || move == Move.FURYCUTTER || move == Move.ROLLOUT) {
                sb.append(move.getBoostedName(_extra_modifier));
            } else {
                sb.append(move.getName());
            }
            sb.append(endl);
            sb.append("          NON-CRITS");
            for(Integer i : dmgMap.keySet()) {
                if((i - minDmg) % 7 == 0) {
                    sb.append(endl);
                    if(i.intValue() == p2.getHP() && minDmg != p2.getHP()) {
                        sb.append(endl);
                    }
                    sb.append("            ");
                }
                else if(i.intValue() == p2.getHP() && minDmg != p2.getHP()) {
                    sb.append(endl);
                    sb.append(endl);
                    sb.append("            ");
                }
                sb.append(String.format("%3d: %6.02f%%     ", i, dmgMap.get(i)));
            }
            sb.append(endl);
            sb.append(endl);
            sb.append("          CRITS");
            for(Integer i : critMap.keySet()) {
                if((i - minCritDmg) % 7 == 0) {
                    sb.append(endl);
                    if(i.intValue() == p2.getHP() && minCritDmg != p2.getHP()) {
                        sb.append(endl);
                    }
                    sb.append("            ");
                }
                else if(i.intValue() == p2.getHP() && minCritDmg != p2.getHP()) {
                    sb.append(endl);
                    sb.append(endl);
                    sb.append("            ");
                }
                sb.append(String.format("%3d: %6.02f%%     ", i, critMap.get(i)));
            }
            sb.append(endl);
            sb.append(endl);
        }

    }
        
    // String summary of all of p1's moves used on p2
    // (would be faster if i didn't return intermediate strings)
    private static String summary_help(Pokemon p1, Pokemon p2, StatModifier mod1, StatModifier mod2, boolean isPlayer, boolean varyDVs, boolean splitForCrits) {
        StringBuilder sb = new StringBuilder();
        String endl = Constants.endl;

        int enemyHP = p2.getHP();

        for (Move m : p1.getMoveset()) {
            if (m == Move.FURYCUTTER) {
                for (int i = 1; i <= 5; i++) {
                    printMoveDamage(sb, m, p1, p2, mod1, mod2, endl, enemyHP, i, isPlayer, varyDVs, splitForCrits);
                }
            } else if (m == Move.ROLLOUT) {
                for (int i = 1; i <= 6; i++) {
                    printMoveDamage(sb, m, p1, p2, mod1, mod2, endl, enemyHP, i, isPlayer, varyDVs, splitForCrits);
                }
        	} else if (m == Move.RAGE) {
                for (int i = 1; i <= 8; i++) {
                    printMoveDamage(sb, m, p1, p2, mod1, mod2, endl, enemyHP, i, isPlayer, varyDVs, splitForCrits);
                }
            } else if(m == Move.MAGNITUDE) {
                for (int i=4; i<=10; i++) {
                    if(i==10) { i++; }
                    m.setPower(i*20-70);
                    printMoveDamage(sb, m, p1, p2, mod1, mod2, endl, enemyHP, 1, isPlayer, varyDVs, splitForCrits);
                    m.setPower(1);
                }
            } else {
                printMoveDamage(sb, m, p1, p2, mod1, mod2, endl, enemyHP, 1, isPlayer, varyDVs, splitForCrits);
            }
        }
        for(Move m : p2.getMoveset()) {
        	if(m.getEffect() == MoveEffect.CONFUSE || m.getEffect() == MoveEffect.CONFUSE_HIT) {
        		printMoveDamage(sb, Move.SELFHIT, p1, p1, mod1, mod1, endl, p1.getHP(), 1, isPlayer, varyDVs, splitForCrits);
        		break;
        	}
        }
        
        return sb.toString();
    }

    public static void printMoveDamage(StringBuilder sb, Move m, Pokemon p1,
                                       Pokemon p2, StatModifier mod1, StatModifier mod2, String endl,
                                       int enemyHP, int _extra_multiplier, boolean isPlayer, boolean varyDVs, boolean splitForCrits) {
        int extra_multiplier =
                (m == Move.FURYCUTTER || m == Move.ROLLOUT) ? 1 << (_extra_multiplier - 1) : _extra_multiplier;
        if(m == Move.RAGE || m == Move.FURYCUTTER || m == Move.ROLLOUT) {
            sb.append(m.getBoostedName(_extra_multiplier));
        } else if (mod1.getWeather() != Weather.NONE) {
	        switch(mod1.getWeather()) {
	        case RAIN :
	        	if(m == Move.SOLARBEAM || m.getType() == Type.FIRE) {
	        		sb.append(m.getName()+" -RAIN");
	        	} else if (m.getType() == Type.WATER) {
	        		sb.append(m.getName()+" +RAIN");
	        	} else {
	            	sb.append(m.getName());
	        	}
	        	break;
	        case SUN :
	        	if(m.getType() == Type.WATER) {
	        		sb.append(m.getName()+" -SUN");
	        	} else if (m.getType() == Type.FIRE) {
	        		sb.append(m.getName()+" +SUN");
	        	} else {
	            	sb.append(m.getName());
	        	}
	        	break;
	        default :
	        	sb.append(m.getName());
	        	break;
	        } 
        } else {
        	sb.append(m.getName());
        }
        
        sb.append("\t");
        
        if(varyDVs){
        	if(isPlayer && m == Move.SELFHIT) {
    	    	sb.append(endl);
    	    	
        		int oldAtkIV = p1.getIVs().getAtkIV();
        		int oldDefIV = p1.getIVs().getDefIV();
        		int oldSpdIV = p1.getIVs().getSpdIV();
        		int oldSpcIV = p1.getIVs().getSpcIV();
        		for(int atkDV = 0; atkDV <= 15; atkDV++) {
            		String dvStr = String.format("%d", atkDV);
            		sb.append(String.format(" Atk DV:%s ", dvStr));
            		
        			p1.setIVs(new IVs(atkDV, oldDefIV, oldSpdIV, oldSpcIV));
        			printMoveDamageVaryDV(sb, m, p1, p1, mod1, mod1, endl, enemyHP, extra_multiplier, false, false);
        		}
    			p1.setIVs(new IVs(oldAtkIV, oldDefIV, oldSpdIV, oldSpcIV));
        	} else {
        		printMoveDamageVaryDV(sb, m, p1, p2, mod1, mod2, endl, enemyHP, extra_multiplier, isPlayer, splitForCrits);
        	}
        	
        } else { // don't vary DVs
        	printMoveDamageCore(sb, m, p1, p2, mod1, mod2, endl, enemyHP, extra_multiplier, isPlayer);
        }
    }
    
    public static void printMoveDamageVaryDV(StringBuilder sb, Move m, Pokemon p1,
            Pokemon p2, StatModifier mod1, StatModifier mod2, String endl,
            int enemyHP, int extra_multiplier, boolean isPlayer, boolean splitForCrits) {
    	sb.append(endl);
    	
    	Pokemon player = isPlayer ? p1 : p2;
    	int oldAtkIV = player.getIVs().getAtkIV();
    	int oldDefIV = player.getIVs().getDefIV();
    	int oldSpdIV = player.getIVs().getSpdIV();
    	int oldSpcIV = player.getIVs().getSpcIV();
    	
    	if(isPlayer)
    		player.setIVs(new IVs(0, oldDefIV, oldSpdIV, 0));
    	else
    		player.setIVs(new IVs(oldAtkIV, 0, oldSpdIV, 0));
    	
    	int lowDv = 0;
    	int lowDmg = splitForCrits ? maxCritDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer):
    			                     maxDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer);
    	int highDmg = lowDmg;
    	for(int highDv = 0; highDv <= 15; highDv++) {
    		while(highDv <= 15 && 
    				(isPlayer ? 
    						lowDmg >= (highDmg = splitForCrits ? 
    								maxCritDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer):
    								maxDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer)):
    				        lowDmg <= (highDmg = splitForCrits ? 
    				        		maxCritDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer):
			                        maxDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer)))
    			 ) { // if player, damage increase ; if enemy, damage decrease
        		highDv++;
            	if(isPlayer)
            		player.setIVs(new IVs(highDv, oldDefIV, oldSpdIV, highDv));
            	else
            		player.setIVs(new IVs(oldAtkIV, highDv, oldSpdIV, highDv));
    		}
    		highDv--;
        	if(isPlayer)
        		player.setIVs(new IVs(highDv, oldDefIV, oldSpdIV, highDv));
        	else
        		player.setIVs(new IVs(oldAtkIV, highDv, oldSpdIV, highDv));
            String dvStr = highDv == lowDv ? String.format("%d", lowDv) : String.format("%d-%d", lowDv, highDv);
            String typeStr = !Type.isPhysicalType(m.getType()) ? "Spc" : (isPlayer ?  "Atk" : "Def");
            			
    		sb.append(String.format("  %s DV:%s ", typeStr, dvStr));
    		printMoveDamageCore(sb, m, p1, p2, mod1, mod2, endl, enemyHP, extra_multiplier, isPlayer);
    		lowDv = highDv+1;
    		lowDmg = highDmg;
    	}
    	player.setIVs(new IVs(oldAtkIV, oldDefIV, oldSpdIV, oldSpcIV));
    }
    
    public static void printMoveDamageCore(StringBuilder sb, Move m, Pokemon p1,
            Pokemon p2, StatModifier mod1, StatModifier mod2, String endl,
            int enemyHP, int extra_multiplier, boolean isPlayer) {
    	// calculate damage of this move, and its percentages on opposing
        // pokemon
        int minDmg = minDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer);
        int maxDmg = maxDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer);

        // don't spam if the move doesn't do damage
        // TODO: better test of damaging move, to be done when fixes are made
        if (maxDmg == 0) {
            sb.append(endl);
            return;
        }
        
        double minPct = 100.0 * minDmg / enemyHP;
        double maxPct = 100.0 * maxDmg / enemyHP;
        
        //Deal with confusion
        if(m == Move.SELFHIT) {
        	sb.append(String.format("%d%s",  maxDmg, endl));
        	return;
        }
        
        sb.append(String.format("%d-%d %.02f-%.02f", minDmg, maxDmg, minPct,
                maxPct));
        sb.append("%\t(crit: ");
        // do it again, for crits
        int critMinDmg = minCritDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer);
        int critMaxDmg = maxCritDamage(m, p1, p2, mod1, mod2, extra_multiplier, isPlayer);

        double critMinPct = 100.0 * critMinDmg / enemyHP;
        double critMaxPct = 100.0 * critMaxDmg / enemyHP;
        sb.append(String.format("%d-%d %.02f-%.02f", critMinDmg, critMaxDmg,
                critMinPct, critMaxPct));
        sb.append("%)" + endl);

        int oppHP = p2.getHP();
        
     // normal rolls
        sb.append("\tNormal rolls: ");
        int lastDam = -1;
        int lastDamCount = -1;
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            int dam = damage(m, p1, p2, mod1, mod2, i, false, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
            if (dam > oppHP) {
                dam = oppHP;
            }
            if (dam != lastDam) {
                if (lastDamCount != -1) {
                    sb.append(lastDam + "x" + lastDamCount + ", ");
                }
                lastDam = dam;
                lastDamCount = 1;
            } else {
                lastDamCount++;
            }
        }
        sb.append(lastDam + "x" + lastDamCount + endl);

        // crit rolls
        sb.append("\tCrit rolls: ");
        lastDam = -1;
        lastDamCount = -1;
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            int dam = damage(m, p1, p2, mod1, mod2, i, true, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
            if (dam > oppHP) {
                dam = oppHP;
            }
            if (dam != lastDam) {
                if (lastDamCount != -1) {
                    sb.append(lastDam + "x" + lastDamCount + ", ");
                }
                lastDam = dam;
                lastDamCount = 1;
            } else {
                lastDamCount++;
            }
        }
        sb.append(lastDam + "x" + lastDamCount + endl);

        int realminDmg = Math.min(minDmg, critMinDmg);
        int realmaxDmg = Math.max(maxDmg, critMaxDmg);

        if (Settings.includeCrits) {

            double critChance = 1 / 16.0;
            if (m == Move.AEROBLAST  || 
            	m == Move.CRABHAMMER ||
            	m == Move.CROSSCHOP  ||
            	m == Move.KARATECHOP ||
            	m == Move.RAZORLEAF  ||
            	m == Move.RAZORWIND  ||
            	m == Move.SLASH ){
                critChance *= 4;
            }

            for (int hits = 1; hits <= 8; hits++) {
                if (realminDmg * hits < oppHP && realmaxDmg * hits >= oppHP) {
                    double totalKillPct = 0;
                    for (int crits = 0; crits <= hits; crits++) {
                        double nShotPct = nShotPercentage(m, p1, p2, mod1, mod2, hits - crits, crits, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
                        totalKillPct += nShotPct * choose(hits, crits) * Math.pow(critChance, crits)
                                * Math.pow(1 - critChance, hits - crits);
                    }
                    if (totalKillPct >= 0.1 && totalKillPct <= 99.999) {
                        sb.append(String.format("\t(Overall %d-hit Kill%%: %.04f%%)", hits, totalKillPct) + endl);
                    }
                }
            }
        } else {

            // test if noncrits can kill in 1shot
            if (maxDmg >= oppHP && minDmg < oppHP) {
                double oneShotPct = oneShotPercentage(m, p1, p2, mod1, mod2, false, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
                sb.append(String.format("\t(One shot prob.: %.02f%%)", oneShotPct) + endl);
            }
            // test if crits can kill in 1shot
            if (critMaxDmg >= oppHP && critMinDmg < oppHP) {
                double oneShotPct = oneShotPercentage(m, p1, p2, mod1, mod2, true, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
                sb.append(String.format("\t(Crit one shot prob.: %.02f%%)", oneShotPct) + endl);
            }

            // n-shot
            int minDmgWork = minDmg;
            int maxDmgWork = maxDmg;
            int hits = 1;
            while (minDmgWork < oppHP && hits < 5) {
                hits++;
                minDmgWork += minDmg;
                maxDmgWork += maxDmg;
                if (maxDmgWork >= oppHP && minDmgWork < oppHP) {
                    System.out.println("working out a " + hits + "-shot");
                    double nShotPct = nShotPercentage(m, p1, p2, mod1, mod2, hits, 0, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
                    sb.append(String.format("\t(%d shot prob.: %.04f%%)", hits, nShotPct) + endl);
                }
            }

            // n-crit-shot
            minDmgWork = critMinDmg;
            maxDmgWork = critMaxDmg;
            hits = 1;
            while (minDmgWork < oppHP && hits < 5) {
                hits++;
                minDmgWork += critMinDmg;
                maxDmgWork += critMaxDmg;
                if (maxDmgWork >= oppHP && minDmgWork < oppHP) {
                    System.out.println("working out a " + hits + "-crit-shot");
                    double nShotPct = nShotPercentage(m, p1, p2, mod1, mod2, 0, hits, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
                    sb.append(String.format("\t(%d crits death prob.: %.04f%%)", hits, nShotPct) + endl); 
                }
            }

            // mixed a-noncrit and b-crit shot
            for (int non = 1; non <= 5 && realminDmg * (non + 1) < oppHP; non++) {
                for (int crit = 1; non + crit <= 5 && realminDmg * (non + crit) < oppHP; crit++) {
                    int sumMin = critMinDmg * crit + minDmg * non;
                    int sumMax = critMaxDmg * crit + maxDmg * non;
                    if (sumMin < oppHP && sumMax >= oppHP) {
                        System.out.printf("working out %d non-crits + %d crits\n", non, crit);
                        double nShotPct = nShotPercentage(m, p1, p2, mod1, mod2, non, crit, extra_multiplier, isPlayer); /// TODO : Rage, Rollout etc.
                        sb.append(String.format("\t(%d non-crit%s + %d crit%s death prob.: %.04f%%)", non,
                                non > 1 ? "s" : "", crit, crit > 1 ? "s" : "", nShotPct)
                                + endl);
                    }
                }
            }
        }

        // guaranteed n-shot
        if (Settings.showGuarantees) {
            int guarantee = (int) Math.ceil(((double) oppHP) / realminDmg);
            sb.append(String.format("\t(guaranteed %d-shot)", guarantee) + endl);
        }
        
        /*
        // test if noncrits can kill in 1shot
        if (maxDmg >= oppHP && minDmg < oppHP) {
            double oneShotPct = oneShotPercentage(m, p1, p2, mod1, mod2, false,
                    extra_multiplier, isPlayer);
            sb.append(String.format("\t(One shot prob.: %.02f%%)", oneShotPct)
                    + endl);
        }
        // test if crits can kill in 1shot
        if (critMaxDmg >= oppHP && critMinDmg < oppHP) {
            double oneShotPct = oneShotPercentage(m, p1, p2, mod1, mod2, true,
                    extra_multiplier, isPlayer);
            sb.append(String.format("\t(Crit one shot prob.: %.02f%%)",
                    oneShotPct) + endl);
        }
        */
    }
    
    
    
    
    
    public static long choose(long total, long choose) {
        if (total < choose)
            return 0;
        if (choose == 0 || choose == total)
            return 1;
        if (choose == 1 || choose == total - 1)
            return total;
        return choose(total - 1, choose - 1) + choose(total - 1, choose);
    }

    // used for the less verbose option
    public static String shortSummary(Pokemon p1, Pokemon p2, BattleOptions options, boolean isPlayer) {
        StringBuilder sb = new StringBuilder();
        String endl = Constants.endl;

        StatModifier mod1 = options.getMod1();
        StatModifier mod2 = options.getMod2();

        sb.append(p1.levelName() + " vs " + p2.levelName());
        // Don't show exp for tower pokes (minor thing since exp isn't added anyway)
        if(!p2.isTowerPoke()) {
            sb.append("          >>> EXP GIVEN: " + p2.expGiven(options.getParticipants()));
        }
        sb.append(endl);
        // sb.append(String.format("EXP to next level: %d EXP gained: %d",
        // p1.expToNextLevel(), p2.expGiven()) + endl);
        sb.append(String.format("%s (%s) ", p1.pokeName(), p1.statsStr()));
        if (mod1.hasMods() || mod1.hasBBs()) {
            sb.append(String.format("%s -> (%s) ", mod1.summary(),
                    mod1.modStatsStr(p1))
                    + endl);
        } else {
            sb.append(endl);
        }

        sb.append(summary_help(p1, p2, mod1, mod2, isPlayer, options.isDvDmgRanges(), options.isSplitForCrits()) + endl);
        if (mod2.hasMods()) {
            sb.append(String.format("%s (%s) %s -> (%s): ", p2.pokeName(),
                    p2.statsStr(), mod2.summary(), mod2.modStatsStr(p2)));
        } else {
            sb.append(String.format("%s (%s): ", p2.pokeName(), p2.statsStr()));
        }

        sb.append(" " + p2.getMoveset().toString() + endl);
        return sb.toString();
    }

    private static double oneShotPercentage(Move attack, Pokemon attacker,
                                            Pokemon defender, StatModifier atkMod, StatModifier defMod,
                                            boolean crit, int extra_multiplier, boolean isPlayer) {
        // iterate until damage is big enough
        int rangeNum = MIN_RANGE;
        while (damage(attack, attacker, defender, atkMod, defMod, rangeNum,
                crit, extra_multiplier, isPlayer) < defender.getHP()) {
            rangeNum++;
        }
        return 100.0 * (MAX_RANGE - rangeNum + 1) / (MAX_RANGE - MIN_RANGE + 1);
    }

    private static TreeMap<Integer,Double> detailedDamage(Move attack, Pokemon attacker, Pokemon defender,
                                                          StatModifier atkMod, StatModifier defMod, boolean crit,
                                                          int extra_multiplier, boolean isPlayer) {
        TreeMap<Integer,Double> dmgMap = new TreeMap<Integer,Double>();
        for(int i=MIN_RANGE; i<=MAX_RANGE; i++) {
            int dmg = Math.min(defender.getHP(), damage(attack, attacker, defender, atkMod, defMod, i, crit, extra_multiplier, isPlayer));
            if(dmgMap.containsKey(dmg)) {
                dmgMap.put(dmg,100.0/((double)(MAX_RANGE-MIN_RANGE+1))+dmgMap.get(dmg));
            } else {
                dmgMap.put(dmg,100.0/((double)(MAX_RANGE-MIN_RANGE+1)));
            }
        }
        return dmgMap;
    }
    
    private static double nShotPercentage(Move attack, Pokemon attacker, Pokemon defender, StatModifier atkMod,
            StatModifier defMod, int numHitsNonCrit, int numHitsCrit, int extra_multiplier, boolean isPlayer) {
        int rawHitDamageNC = damage(attack, attacker, defender, atkMod, defMod, MAX_RANGE, false, extra_multiplier, isPlayer);  /// TODO : Rage, Rollout etc.
        int minDamageNC = rawHitDamageNC * MIN_RANGE / 255;
        int[] probsNC = new int[rawHitDamageNC - minDamageNC + 1];
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            int dmg = rawHitDamageNC * i / 255;
            probsNC[dmg - minDamageNC]++;
        }
        int rawHitDamageCR = damage(attack, attacker, defender, atkMod, defMod, MAX_RANGE, true, extra_multiplier, isPlayer);  /// TODO : Rage, Rollout etc.
        int minDamageCR = rawHitDamageCR * MIN_RANGE / 255;
        int[] probsCR = new int[rawHitDamageCR - minDamageCR + 1];
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            int dmg = rawHitDamageCR * i / 255;
            probsCR[dmg - minDamageCR]++;
        }
        double chances = 0;
        int rawHP = defender.getHP();
        if (numHitsNonCrit > 0) {
            for (int i = minDamageNC; i <= rawHitDamageNC; i++) {
                chances += nShotPctInner(minDamageNC, rawHitDamageNC, minDamageCR, rawHitDamageCR, rawHP, 0, i,
                        numHitsNonCrit, numHitsCrit, probsNC, probsCR);
            }
        } else {
            for (int i = minDamageCR; i <= rawHitDamageCR; i++) {
                chances += nShotPctInner(minDamageNC, rawHitDamageNC, minDamageCR, rawHitDamageCR, rawHP, 0, i,
                        numHitsNonCrit, numHitsCrit, probsNC, probsCR);
            }
        }
        return 100.0 * chances / Math.pow(MAX_RANGE - MIN_RANGE + 1, numHitsNonCrit + numHitsCrit);
    }

    private static double nShotPctInner(int minDamageNC, int maxDamageNC, int minDamageCR, int maxDamageCR, int hp,
            int stackedDmg, int rolledDamage, int hitsLeftNonCrit, int hitsLeftCrit, int[] probsNC, int[] probsCR) {
        boolean wasCritical = false;
        if (hitsLeftNonCrit > 0) {
            hitsLeftNonCrit--;
        } else {
            hitsLeftCrit--;
            wasCritical = true;
        }
        stackedDmg += rolledDamage;
        if (stackedDmg >= hp || (stackedDmg + hitsLeftNonCrit * minDamageNC + hitsLeftCrit * minDamageCR) >= hp) {
            return Math.pow(MAX_RANGE - MIN_RANGE + 1, hitsLeftNonCrit + hitsLeftCrit)
                    * (wasCritical ? probsCR[rolledDamage - minDamageCR] : probsNC[rolledDamage - minDamageNC]);
        } else if (hitsLeftNonCrit == 0 && hitsLeftCrit == 0) {
            return 0;
        } else if (stackedDmg + hitsLeftNonCrit * maxDamageNC + hitsLeftCrit * maxDamageCR < hp) {
            return 0;
        } else {
            double chances = 0;
            if (hitsLeftNonCrit > 0) {
                for (int i = minDamageNC; i <= maxDamageNC; i++) {
                    chances += nShotPctInner(minDamageNC, maxDamageNC, minDamageCR, maxDamageCR, hp, stackedDmg, i,
                            hitsLeftNonCrit, hitsLeftCrit, probsNC, probsCR);
                }
            } else {
                for (int i = minDamageCR; i <= maxDamageCR; i++) {
                    chances += nShotPctInner(minDamageNC, maxDamageNC, minDamageCR, maxDamageCR, hp, stackedDmg, i,
                            hitsLeftNonCrit, hitsLeftCrit, probsNC, probsCR);
                }
            }
            return chances * (wasCritical ? probsCR[rolledDamage - minDamageCR] : probsNC[rolledDamage - minDamageNC]);
        }
    }
}
