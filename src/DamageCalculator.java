//calculates damage (durr)
import java.util.TreeMap;

public class DamageCalculator {
	private static int MIN_RANGE = 217;
	private static int MAX_RANGE = 255;

	// rangeNum should range from 217 to 255
	// crit indicates if there is a crit or not
	private static int damage(Move attack, Pokemon attacker, Pokemon defender,
			StatModifier atkMod, StatModifier defMod, int rangeNum,
			boolean crit, int extra_multiplier) {
		if (rangeNum < MIN_RANGE) {
			rangeNum = MIN_RANGE;
		}
		if (rangeNum > MAX_RANGE) {
			rangeNum = MAX_RANGE;
		}

		if (attack.getPower() <= 0) {
			// TODO: special cases
			return 0;
		}
		// stat modifiers
		int aa_orig = attacker.getTrueAtk();
		int atk_atk = atkMod.modAtk(attacker);
		int dd_orig = defender.getTrueDef();
		int def_def = defMod.modDef(defender);
		int as_orig = attacker.getTrueSpcAtk();
		int atk_spc = atkMod.modSpcAtk(attacker);
		int ds_orig = defender.getTrueSpcDef();
		int dsa_orig_bug = defender.getTrueSpcAtk();
		int atk_spc_orig_bug = defMod.modSpcAtk(defender);
		int def_spc = defMod.modSpcDef(defender, atk_spc_orig_bug);

		boolean STAB = attack.getType() == attacker.getSpecies().getType1()
				|| attack.getType() == attacker.getSpecies().getType2();
		double effectiveMult = Type.effectiveness(attack.getType(), defender
				.getSpecies().getType1(), defender.getSpecies().getType2());
		if (effectiveMult == 0) {
			return 0;
		}

		int effective_atk = 0, effective_def = 0;
		if (Type.isPhysicalType(attack.getType())) {
			effective_atk = crit ? ((atkMod.getAtkStage() >= 0) ? atk_atk
					: aa_orig) : atk_atk;
			effective_def = crit ? ((defMod.getDefStage() <= 0) ? def_def
					: dd_orig) : def_def;

		} else {
			effective_atk = crit ? ((atkMod.getSpcAtkStage() >= 0) ? atk_spc
					: as_orig) : atk_spc;
			effective_def = crit ? ((defMod.getSpcDefStage() <= 0) ? def_spc
					: ds_orig) : def_spc;
		}
		if (effective_atk > 255 || effective_def > 255) {
			effective_atk = Math.max(1, effective_atk >> 2);
			effective_def = Math.max(1, effective_def >> 2);
		}
		// int damage = ((Math.min((int) ((attacker.getLevel() * 0.4) + 2)
		// * (effective_atk) * attack.getPower() / 50 / (effective_def)
		// * (crit ? 2 : 1), 997) + 2));
		int damage = (attacker.getLevel() * 2 / 5 + 2) * attack.getPower()
				* effective_atk;
		damage = damage / effective_def / 50;
		if (Constants.pinkBow && attack.getType() == Type.NORMAL) {
			damage = damage * 110 / 100;
		}
		if (Constants.charcoal && attack.getType() == Type.FIRE) {
			damage = damage * 110 / 100;
		}
		if (crit) {
			damage *= 2;
		}
		damage = Math.min(damage, 997) + 2;
		if (attacker.isTypeBoosted(attack.getType())) {
			int typeboost = Math.max(damage * 1 / 8, 1);
			damage += typeboost;
		}
		if (STAB) {
			damage = damage * 3 / 2;
		}
		damage *= effectiveMult;
		damage *= extra_multiplier;
		damage = damage * rangeNum / 255;
		return Math.max(damage, 1);
	}

	public static int minDamage(Move attack, Pokemon attacker,
			Pokemon defender, StatModifier atkMod, StatModifier defMod,
			int extra_multiplier) {
		return damage(attack, attacker, defender, atkMod, defMod, MIN_RANGE,
				false, extra_multiplier);
	}

	public static int maxDamage(Move attack, Pokemon attacker,
			Pokemon defender, StatModifier atkMod, StatModifier defMod,
			int extra_multiplier) {
		return damage(attack, attacker, defender, atkMod, defMod, MAX_RANGE,
				false, extra_multiplier);
	}

	public static int minCritDamage(Move attack, Pokemon attacker,
			Pokemon defender, StatModifier atkMod, StatModifier defMod,
			int extra_multiplier) {
		return damage(attack, attacker, defender, atkMod, defMod, MIN_RANGE,
				true, extra_multiplier);
	}

	public static int maxCritDamage(Move attack, Pokemon attacker,
			Pokemon defender, StatModifier atkMod, StatModifier defMod,
			int extra_multiplier) {
		return damage(attack, attacker, defender, atkMod, defMod, MAX_RANGE,
				true, extra_multiplier);
	}

	// printout of move damages between the two pokemon
	// assumes you are p1
	public static String summary(Pokemon p1, Pokemon p2, BattleOptions options) {
		StringBuilder sb = new StringBuilder();
		String endl = Constants.endl;
		StatModifier mod1 = options.getMod1();
		StatModifier mod2 = options.getMod2();

		sb.append(p1.levelName() + " vs " + p2.levelName());
		// TODO: Don't show exp for tower pokes (minor thing since exp isn't added anyway)
//		if(!Constants.battleTower) {
			sb.append("          >>> EXP GIVEN: " + p2.expGiven(options.getParticipants()));
//		}
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

		sb.append(summary_help(p1, p2, mod1, mod2));

		sb.append(endl);

		if(options.getVerbose() == BattleOptions.EVERYTHING) {
			for(Move move : p1.getMoveset())
	    	{
				if (move.getIndexNum() == 205 || move.getIndexNum() == 210) {
					for (int i = 1; i <= 5; i++) {
						Move m2 = new Move(move, i);
						damage_help(sb, m2, p1, p2, mod1, mod2, 1 << (i - 1));					
					}
	      		} else if (move.getIndexNum() == 99) {
					for (int i = 1; i <= 8; i++) {
						Move m2 = new Move(move, i);
						damage_help(sb, m2, p1, p2, mod1, mod2, i);
					}
				} else if(move.getIndexNum() == 222) {
					for (int i=4; i<=10; i++) {
						Move m2 = new Move(move, i);
						if(i==10) { i++; }
						m2.setPower(i*20-70);
						damage_help(sb, m2, p1, p2, mod1, mod2, 1);
					}
				} else {
					damage_help(sb, move, p1, p2, mod1, mod2, 1);
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
		sb.append(summary_help(p2, p1, mod2, mod1));

		if(options.getVerbose() == BattleOptions.EVERYTHING) {
	        sb.append(endl);
	        for(Move move : p2.getMoveset())
	    	{
				if (move.getIndexNum() == 205 || move.getIndexNum() == 210) {
					for (int i = 1; i <= 5; i++) {
						Move m2 = new Move(move, i);
						damage_help(sb, m2, p2, p1, mod2, mod1, 1 << (i - 1));					
					}
	      		} else if (move.getIndexNum() == 99) {
					for (int i = 1; i <= 8; i++) {
						Move m2 = new Move(move, i);
						damage_help(sb, m2, p2, p1, mod2, mod1, i);
					}
				} else if(move.getIndexNum() == 222) {
					for (int i=4; i<=10; i++) {
						Move m2 = new Move(move, i);
						if(i==10) { i++; }
						m2.setPower(i*20-70);
						damage_help(sb, m2, p2, p1, mod2, mod1, 1);
					}
				} else {
					damage_help(sb, move, p2, p1, mod2, mod1, 1);
				}
	    	}		
		}
		return sb.toString();
	}

    private static void damage_help(StringBuilder sb, Move move, Pokemon p1, Pokemon p2, StatModifier mod1, StatModifier mod2, int extra_modifier) {
		String endl = Constants.endl;
    	int minDmg = Math.min(p2.getHP(), minDamage(move, p1, p2, mod1, mod2, extra_modifier));
   		if(minDmg > 0)
   		{
       		int minCritDmg = Math.min(p2.getHP(), minCritDamage(move, p1, p2, mod1, mod2, extra_modifier));
        	TreeMap<Integer,Double> dmgMap = detailedDamage(move, p1, p2, mod1, mod2, false, extra_modifier);
        	TreeMap<Integer,Double> critMap = detailedDamage(move, p1, p2, mod1, mod2, true, extra_modifier);
        	sb.append(move.getName());
        	sb.append(endl);
        	sb.append("          NON-CRITS");
        	for(Integer i : dmgMap.keySet())
        	{
        		if((i - minDmg) % 7 == 0)
        		{
        			sb.append(endl);
        			if(i.intValue() == p2.getHP() && minDmg != p2.getHP())
        			{
        				sb.append(endl);
        			}
        			sb.append("            ");
        		}
        		else if(i.intValue() == p2.getHP() && minDmg != p2.getHP())
        		{
        			sb.append(endl);
        			sb.append(endl);
        			sb.append("            ");		        			
        		}
        		
        		sb.append(String.format("%3d: %6.02f%%     ", i, dmgMap.get(i)));
        	}
        	sb.append(endl);
        	sb.append(endl);
        	sb.append("          CRITS");
        	for(Integer i : critMap.keySet())
        	{
        		if((i - minCritDmg) % 7 == 0)
        		{
        			sb.append(endl);
        			if(i.intValue() == p2.getHP() && minCritDmg != p2.getHP())
        			{
        				sb.append(endl);
        			}
        			sb.append("            ");
        		}
        		else if(i.intValue() == p2.getHP() && minCritDmg != p2.getHP())
        		{
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
	private static String summary_help(Pokemon p1, Pokemon p2,
			StatModifier mod1, StatModifier mod2) {
		StringBuilder sb = new StringBuilder();
		String endl = Constants.endl;

		int enemyHP = p2.getHP();

		for (Move m : p1.getMoveset()) {
			if (m.getIndexNum() == 205 || m.getIndexNum() == 210) {
				for (int i = 1; i <= 5; i++) {
					Move m2 = new Move(m, i);
					printMoveDamage(sb, m2, p1, p2, mod1, mod2, endl, enemyHP,
							1 << (i - 1));
				}
			} else if (m.getIndexNum() == 99) {
				for (int i = 1; i <= 8; i++) {
					Move m2 = new Move(m, i);
					printMoveDamage(sb, m2, p1, p2, mod1, mod2, endl, enemyHP,
							i);
				}
			} else if(m.getIndexNum() == 222) {
				for (int i=4; i<=10; i++) {
					Move m2 = new Move(m, i);
					if(i==10) { i++; }
					m2.setPower(i*20-70);
					printMoveDamage(sb, m2, p1, p2, mod1, mod2, endl, enemyHP, 1);
				}
			} else {
				printMoveDamage(sb, m, p1, p2, mod1, mod2, endl, enemyHP, 1);
			}

		}

		return sb.toString();
	}

	public static void printMoveDamage(StringBuilder sb, Move m, Pokemon p1,
			Pokemon p2, StatModifier mod1, StatModifier mod2, String endl,
			int enemyHP, int extra_multiplier) {
		sb.append(m.getName() + "\t");
		// calculate damage of this move, and its percentages on opposing
		// pokemon
		int minDmg = minDamage(m, p1, p2, mod1, mod2, extra_multiplier);
		int maxDmg = maxDamage(m, p1, p2, mod1, mod2, extra_multiplier);

		// don't spam if the move doesn't do damage
		// TODO: better test of damaging move, to be done when fixes are made
		if (maxDmg == 0) {
			sb.append(endl);
			return;
		}
		double minPct = 100.0 * minDmg / enemyHP;
		double maxPct = 100.0 * maxDmg / enemyHP;
		sb.append(String.format("%d-%d %.02f-%.02f", minDmg, maxDmg, minPct,
				maxPct));
		sb.append("%\t(crit: ");
		// do it again, for crits
		int critMinDmg = minCritDamage(m, p1, p2, mod1, mod2, extra_multiplier);
		int critMaxDmg = maxCritDamage(m, p1, p2, mod1, mod2, extra_multiplier);

		double critMinPct = 100.0 * critMinDmg / enemyHP;
		double critMaxPct = 100.0 * critMaxDmg / enemyHP;
		sb.append(String.format("%d-%d %.02f-%.02f", critMinDmg, critMaxDmg,
				critMinPct, critMaxPct));
		sb.append("%)" + endl);

		int oppHP = p2.getHP();
		// test if noncrits can kill in 1shot
		if (maxDmg >= oppHP && minDmg < oppHP) {
			double oneShotPct = oneShotPercentage(m, p1, p2, mod1, mod2, false,
					extra_multiplier);
			sb.append(String.format("\t(One shot prob.: %.02f%%)", oneShotPct)
					+ endl);
		}
		// test if crits can kill in 1shot
		if (critMaxDmg >= oppHP && critMinDmg < oppHP) {
			double oneShotPct = oneShotPercentage(m, p1, p2, mod1, mod2, true,
					extra_multiplier);
			sb.append(String.format("\t(Crit one shot prob.: %.02f%%)",
					oneShotPct) + endl);
		}
	}

	// used for the less verbose option
	public static String shortSummary(Pokemon p1, Pokemon p2,
			BattleOptions options) {
		StringBuilder sb = new StringBuilder();
		String endl = Constants.endl;

		StatModifier mod1 = options.getMod1();
		StatModifier mod2 = options.getMod2();

		sb.append(p1.levelName() + " vs " + p2.levelName() + endl);
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

		sb.append(summary_help(p1, p2, mod1, mod2) + endl);
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
			boolean crit, int extra_multiplier) {
		// iterate until damage is big enough
		int rangeNum = MIN_RANGE;
		while (damage(attack, attacker, defender, atkMod, defMod, rangeNum,
				crit, extra_multiplier) < defender.getHP()) {
			rangeNum++;
		}
		return 100.0 * (MAX_RANGE - rangeNum + 1) / (MAX_RANGE - MIN_RANGE + 1);
	}
	
    private static TreeMap<Integer,Double> detailedDamage(Move attack, Pokemon attacker, Pokemon defender,
            StatModifier atkMod, StatModifier defMod, boolean crit, int extra_multiplier)
    {
       	TreeMap<Integer,Double> dmgMap = new TreeMap<Integer,Double>();
        for(int i=MIN_RANGE; i<=MAX_RANGE; i++)
        {
        	int dmg = Math.min(defender.getHP(), damage(attack, attacker, defender, atkMod, defMod, i, crit, extra_multiplier));
        	if(dmgMap.containsKey(dmg))
        	{
        		dmgMap.put(dmg,100.0/((double)(MAX_RANGE-MIN_RANGE+1))+dmgMap.get(dmg));
        	}
        	else
        	{
        		dmgMap.put(dmg,100.0/((double)(MAX_RANGE-MIN_RANGE+1)));
        	}
        }
     	return dmgMap;
    }
}
