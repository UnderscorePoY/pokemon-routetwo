public enum Move {
    NO_MOVE("-", 0, null, 0, null, 0, 0, 0),
    POUND("Pound", 1, MoveEffect.NORMAL_HIT, 40, Type.NORMAL, 100, 35, 0),
    KARATECHOP("Karate Chop", 2, MoveEffect.NORMAL_HIT, 50, Type.FIGHTING, 100, 25, 0),
    DOUBLESLAP("DoubleSlap", 3, MoveEffect.MULTI_HIT, 15, Type.NORMAL, 85, 10, 0),
    COMETPUNCH("Comet Punch", 4, MoveEffect.MULTI_HIT, 18, Type.NORMAL, 85, 15, 0),
    MEGAPUNCH("Mega Punch", 5, MoveEffect.NORMAL_HIT, 80, Type.NORMAL, 85, 20, 0),
    PAYDAY("Pay Day", 6, MoveEffect.PAY_DAY, 40, Type.NORMAL, 100, 20, 0),
    FIREPUNCH("Fire Punch", 7, MoveEffect.BURN_HIT, 75, Type.FIRE, 100, 15, 10),
    ICEPUNCH("Ice Punch", 8, MoveEffect.FREEZE_HIT, 75, Type.ICE, 100, 15, 10),
    THUNDERPUNCH("ThunderPunch", 9, MoveEffect.PARALYZE_HIT, 75, Type.ELECTRIC, 100, 15, 10),
    SCRATCH("Scratch", 10, MoveEffect.NORMAL_HIT, 40, Type.NORMAL, 100, 35, 0),
    VICEGRIP("Vicegrip", 11, MoveEffect.NORMAL_HIT, 55, Type.NORMAL, 100, 30, 0),
    GUILLOTINE("Guillotine", 12, MoveEffect.OHKO, 0, Type.NORMAL, 30, 5, 0),
    RAZORWIND("Razor Wind", 13, MoveEffect.RAZOR_WIND, 80, Type.NORMAL, 75, 10, 0),
    SWORDSDANCE("Swords Dance", 14, MoveEffect.ATTACK_UP_2, 0, Type.NORMAL, 100, 30, 0),
    CUT("Cut", 15, MoveEffect.NORMAL_HIT, 50, Type.NORMAL, 95, 30, 0),
    GUST("Gust", 16, MoveEffect.GUST, 40, Type.FLYING, 100, 35, 0),
    WINGATTACK("Wing Attack", 17, MoveEffect.NORMAL_HIT, 60, Type.FLYING, 100, 35, 0),
    WHIRLWIND("Whirlwind", 18, MoveEffect.FORCE_SWITCH, 0, Type.NORMAL, 100, 20, 0),
    FLY("Fly", 19, MoveEffect.FLY, 70, Type.FLYING, 95, 15, 0),
    BIND("Bind", 20, MoveEffect.TRAP_TARGET, 15, Type.NORMAL, 75, 20, 0),
    SLAM("Slam", 21, MoveEffect.NORMAL_HIT, 80, Type.NORMAL, 75, 20, 0),
    VINEWHIP("Vine Whip", 22, MoveEffect.NORMAL_HIT, 35, Type.GRASS, 100, 10, 0),
    STOMP("Stomp", 23, MoveEffect.STOMP, 65, Type.NORMAL, 100, 20, 30),
    DOUBLEKICK("Double Kick", 24, MoveEffect.DOUBLE_HIT, 30, Type.FIGHTING, 100, 30, 0),
    MEGAKICK("Mega Kick", 25, MoveEffect.NORMAL_HIT, 120, Type.NORMAL, 75, 5, 0),
    JUMPKICK("Jump Kick", 26, MoveEffect.JUMP_KICK, 70, Type.FIGHTING, 95, 25, 0),
    ROLLINGKICK("Rolling Kick", 27, MoveEffect.FLINCH_HIT, 60, Type.FIGHTING, 85, 15, 30),
    SANDATTACK("Sand-Attack", 28, MoveEffect.ACCURACY_DOWN, 0, Type.GROUND, 100, 15, 0),
    HEADBUTT("Headbutt", 29, MoveEffect.FLINCH_HIT, 70, Type.NORMAL, 100, 15, 30),
    HORNATTACK("Horn Attack", 30, MoveEffect.NORMAL_HIT, 65, Type.NORMAL, 100, 25, 0),
    FURYATTACK("Fury Attack", 31, MoveEffect.MULTI_HIT, 15, Type.NORMAL, 85, 20, 0),
    HORNDRILL("Horn Drill", 32, MoveEffect.OHKO, 1, Type.NORMAL, 30, 5, 0),
    TACKLE("Tackle", 33, MoveEffect.NORMAL_HIT, 35, Type.NORMAL, 95, 35, 0),
    BODYSLAM("Body Slam", 34, MoveEffect.PARALYZE_HIT, 85, Type.NORMAL, 100, 15, 30),
    WRAP("Wrap", 35, MoveEffect.TRAP_TARGET, 15, Type.NORMAL, 85, 20, 0),
    TAKEDOWN("Take Down", 36, MoveEffect.RECOIL_HIT, 90, Type.NORMAL, 85, 20, 0),
    THRASH("Thrash", 37, MoveEffect.RAMPAGE, 90, Type.NORMAL, 100, 20, 0),
    DOUBLEEDGE("Double-Edge", 38, MoveEffect.RECOIL_HIT, 120, Type.NORMAL, 100, 15, 0),
    TAILWHIP("Tail Whip", 39, MoveEffect.DEFENSE_DOWN, 0, Type.NORMAL, 100, 30, 0),
    POISONSTING("Poison Sting", 40, MoveEffect.POISON_HIT, 15, Type.POISON, 100, 35, 30),
    TWINEEDLE("Twineedle", 41, MoveEffect.POISON_MULTI_HIT, 25, Type.BUG, 100, 20, 20),
    PINMISSILE("Pin Missile", 42, MoveEffect.MULTI_HIT, 14, Type.BUG, 85, 20, 0),
    LEER("Leer", 43, MoveEffect.DEFENSE_DOWN, 0, Type.NORMAL, 100, 30, 0),
    BITE("Bite", 44, MoveEffect.FLINCH_HIT, 60, Type.DARK, 100, 25, 30),
    GROWL("Growl", 45, MoveEffect.ATTACK_DOWN, 0, Type.NORMAL, 100, 40, 0),
    ROAR("Roar", 46, MoveEffect.FORCE_SWITCH, 0, Type.NORMAL, 100, 20, 0),
    SING("Sing", 47, MoveEffect.SLEEP, 0, Type.NORMAL, 55, 15, 0),
    SUPERSONIC("Supersonic", 48, MoveEffect.CONFUSE, 0, Type.NORMAL, 55, 20, 0),
    SONICBOOM("SonicBoom", 49, MoveEffect.STATIC_DAMAGE, 20, Type.NORMAL, 90, 20, 0),
    DISABLE("Disable", 50, MoveEffect.DISABLE, 0, Type.NORMAL, 55, 20, 0),
    ACID("Acid", 51, MoveEffect.DEFENSE_DOWN_HIT, 40, Type.POISON, 100, 30, 10),
    EMBER("Ember", 52, MoveEffect.BURN_HIT, 40, Type.FIRE, 100, 25, 10),
    FLAMETHROWER("Flamethrower", 53, MoveEffect.BURN_HIT, 95, Type.FIRE, 100, 15, 10),
    MIST("Mist", 54, MoveEffect.MIST, 0, Type.ICE, 100, 30, 0),
    WATERGUN("Water Gun", 55, MoveEffect.NORMAL_HIT, 40, Type.WATER, 100, 25, 0),
    HYDROPUMP("Hydro Pump", 56, MoveEffect.NORMAL_HIT, 120, Type.WATER, 80, 5, 0),
    SURF("Surf", 57, MoveEffect.NORMAL_HIT, 95, Type.WATER, 100, 15, 0),
    ICEBEAM("Ice Beam", 58, MoveEffect.FREEZE_HIT, 95, Type.ICE, 100, 10, 10),
    BLIZZARD("Blizzard", 59, MoveEffect.FREEZE_HIT, 120, Type.ICE, 70, 5, 10),
    PSYBEAM("Psybeam", 60, MoveEffect.CONFUSE_HIT, 65, Type.PSYCHIC, 100, 20, 10),
    BUBBLEBEAM("BubbleBeam", 61, MoveEffect.SPEED_DOWN_HIT, 65, Type.WATER, 100, 20, 10),
    AURORABEAM("Aurora Beam", 62, MoveEffect.ATTACK_DOWN_HIT, 65, Type.ICE, 100, 20, 10),
    HYPERBEAM("Hyper Beam", 63, MoveEffect.HYPER_BEAM, 150, Type.NORMAL, 90, 5, 0),
    PECK("Peck", 64, MoveEffect.NORMAL_HIT, 35, Type.FLYING, 100, 35, 0),
    DRILLPECK("Drill Peck", 65, MoveEffect.NORMAL_HIT, 80, Type.FLYING, 100, 20, 0),
    SUBMISSION("Submission", 66, MoveEffect.RECOIL_HIT, 80, Type.FIGHTING, 80, 25, 0),
    LOWKICK("Low Kick", 67, MoveEffect.FLINCH_HIT, 50, Type.FIGHTING, 90, 20, 30),
    COUNTER("Counter", 68, MoveEffect.COUNTER, 1, Type.FIGHTING, 100, 20, 0),
    SEISMICTOSS("Seismic Toss", 69, MoveEffect.LEVEL_DAMAGE, 0, Type.FIGHTING, 100, 20, 0),
    STRENGTH("Strength", 70, MoveEffect.NORMAL_HIT, 80, Type.NORMAL, 100, 15, 0),
    ABSORB("Absorb", 71, MoveEffect.LEECH_HIT, 20, Type.GRASS, 100, 20, 0),
    MEGADRAIN("Mega Drain", 72, MoveEffect.LEECH_HIT, 40, Type.GRASS, 100, 10, 0),
    LEECHSEED("Leech Seed", 73, MoveEffect.LEECH_SEED, 0, Type.GRASS, 90, 10, 0),
    GROWTH("Growth", 74, MoveEffect.SP_ATK_UP, 0, Type.NORMAL, 100, 40, 0),
    RAZORLEAF("Razor Leaf", 75, MoveEffect.NORMAL_HIT, 55, Type.GRASS, 95, 25, 0),
    SOLARBEAM("SolarBeam", 76, MoveEffect.SOLARBEAM, 120, Type.GRASS, 100, 10, 0),
    POISONPOWDER("PoisonPowder", 77, MoveEffect.POISON, 0, Type.POISON, 75, 35, 0),
    STUNSPORE("Stun Spore", 78, MoveEffect.PARALYZE, 0, Type.GRASS, 75, 30, 0),
    SLEEPPOWDER("Sleep Powder", 79, MoveEffect.SLEEP, 0, Type.GRASS, 75, 15, 0),
    PETALDANCE("Petal Dance", 80, MoveEffect.RAMPAGE, 70, Type.GRASS, 100, 20, 0),
    STRINGSHOT("String Shot", 81, MoveEffect.SPEED_DOWN, 0, Type.BUG, 95, 40, 0),
    DRAGONRAGE("Dragon Rage", 82, MoveEffect.STATIC_DAMAGE, 40, Type.DRAGON, 100, 10, 0),
    FIRESPIN("Fire Spin", 83, MoveEffect.TRAP_TARGET, 15, Type.FIRE, 70, 15, 0),
    THUNDERSHOCK("ThunderShock", 84, MoveEffect.PARALYZE_HIT, 40, Type.ELECTRIC, 100, 30, 10),
    THUNDERBOLT("Thunderbolt", 85, MoveEffect.PARALYZE_HIT, 95, Type.ELECTRIC, 100, 15, 10),
    THUNDERWAVE("Thunder Wave", 86, MoveEffect.PARALYZE, 0, Type.ELECTRIC, 100, 20, 0),
    THUNDER("Thunder", 87, MoveEffect.THUNDER, 120, Type.ELECTRIC, 70, 10, 30),
    ROCKTHROW("Rock Throw", 88, MoveEffect.NORMAL_HIT, 50, Type.ROCK, 90, 15, 0),
    EARTHQUAKE("Earthquake", 89, MoveEffect.EARTHQUAKE, 100, Type.GROUND, 100, 10, 0),
    FISSURE("Fissure", 90, MoveEffect.OHKO, 1, Type.GROUND, 30, 5, 0),
    DIG("Dig", 91, MoveEffect.FLY, 60, Type.GROUND, 100, 10, 0),
    TOXIC("Toxic", 92, MoveEffect.TOXIC, 0, Type.POISON, 85, 10, 0),
    CONFUSION("Confusion", 93, MoveEffect.CONFUSE_HIT, 50, Type.PSYCHIC, 100, 25, 10),
    PSYCHIC("Psychic", 94, MoveEffect.SP_DEF_DOWN_HIT, 90, Type.PSYCHIC, 100, 10, 10),
    HYPNOSIS("Hypnosis", 95, MoveEffect.SLEEP, 0, Type.PSYCHIC, 60, 20, 0),
    MEDITATE("Meditate", 96, MoveEffect.ATTACK_UP, 0, Type.PSYCHIC, 100, 40, 0),
    AGILITY("Agility", 97, MoveEffect.SPEED_UP_2, 0, Type.PSYCHIC, 100, 30, 0),
    QUICKATTACK("Quick Attack", 98, MoveEffect.PRIORITY_HIT, 40, Type.NORMAL, 100, 30, 0),
    RAGE("Rage", 99, MoveEffect.RAGE, 20, Type.NORMAL, 100, 20, 0),
    TELEPORT("Teleport", 100, MoveEffect.TELEPORT, 0, Type.PSYCHIC, 100, 20, 0),
    NIGHTSHADE("Night Shade", 101, MoveEffect.LEVEL_DAMAGE, 0, Type.GHOST, 100, 15, 0),
    MIMIC("Mimic", 102, MoveEffect.MIMIC, 0, Type.NORMAL, 100, 10, 0),
    SCREECH("Screech", 103, MoveEffect.DEFENSE_DOWN_2, 0, Type.NORMAL, 85, 40, 0),
    DOUBLETEAM("Double Team", 104, MoveEffect.EVASION_UP, 0, Type.NORMAL, 100, 15, 0),
    RECOVER("Recover", 105, MoveEffect.HEAL, 0, Type.NORMAL, 100, 20, 0),
    HARDEN("Harden", 106, MoveEffect.DEFENSE_UP, 0, Type.NORMAL, 100, 30, 0),
    MINIMIZE("Minimize", 107, MoveEffect.EVASION_UP, 0, Type.NORMAL, 100, 20, 0),
    SMOKESCREEN("SmokeScreen", 108, MoveEffect.ACCURACY_DOWN, 0, Type.NORMAL, 100, 20, 0),
    CONFUSERAY("Confuse Ray", 109, MoveEffect.CONFUSE, 0, Type.GHOST, 100, 10, 0),
    WITHDRAW("Withdraw", 110, MoveEffect.DEFENSE_UP, 0, Type.WATER, 100, 40, 0),
    DEFENSECURL("Defense Curl", 111, MoveEffect.DEFENSE_CURL, 0, Type.NORMAL, 100, 40, 0),
    BARRIER("Barrier", 112, MoveEffect.DEFENSE_UP_2, 0, Type.PSYCHIC, 100, 30, 0),
    LIGHTSCREEN("Light Screen", 113, MoveEffect.LIGHT_SCREEN, 0, Type.PSYCHIC, 100, 30, 0),
    HAZE("Haze", 114, MoveEffect.RESET_STATS, 0, Type.ICE, 100, 30, 0),
    REFLECT("Reflect", 115, MoveEffect.REFLECT, 0, Type.PSYCHIC, 100, 20, 0),
    FOCUSENERGY("Focus Energy", 116, MoveEffect.FOCUS_ENERGY, 0, Type.NORMAL, 100, 30, 0),
    BIDE("Bide", 117, MoveEffect.BIDE, 0, Type.NORMAL, 100, 10, 0),
    METRONOME("Metronome", 118, MoveEffect.METRONOME, 0, Type.NORMAL, 100, 10, 0),
    MIRRORMOVE("Mirror Move", 119, MoveEffect.MIRROR_MOVE, 0, Type.FLYING, 100, 20, 0),
    SELFDESTRUCT("Selfdestruct", 120, MoveEffect.SELFDESTRUCT, 200, Type.NORMAL, 100, 5, 0),
    EGGBOMB("Egg Bomb", 121, MoveEffect.NORMAL_HIT, 100, Type.NORMAL, 75, 10, 0),
    LICK("Lick", 122, MoveEffect.PARALYZE_HIT, 20, Type.GHOST, 100, 30, 30),
    SMOG("Smog", 123, MoveEffect.POISON_HIT, 20, Type.POISON, 70, 20, 40),
    SLUDGE("Sludge", 124, MoveEffect.POISON_HIT, 65, Type.POISON, 100, 20, 30),
    BONECLUB("Bone Club", 125, MoveEffect.FLINCH_HIT, 65, Type.GROUND, 85, 20, 10),
    FIREBLAST("Fire Blast", 126, MoveEffect.BURN_HIT, 120, Type.FIRE, 85, 5, 10),
    WATERFALL("Waterfall", 127, MoveEffect.NORMAL_HIT, 80, Type.WATER, 100, 15, 0),
    CLAMP("Clamp", 128, MoveEffect.TRAP_TARGET, 35, Type.WATER, 75, 10, 0),
    SWIFT("Swift", 129, MoveEffect.ALWAYS_HIT, 60, Type.NORMAL, 100, 20, 0),
    SKULLBASH("Skull Bash", 130, MoveEffect.SKULL_BASH, 100, Type.NORMAL, 100, 15, 0),
    SPIKECANNON("Spike Cannon", 131, MoveEffect.MULTI_HIT, 20, Type.NORMAL, 100, 15, 0),
    CONSTRICT("Constrict", 132, MoveEffect.SPEED_DOWN_HIT, 10, Type.NORMAL, 100, 35, 10),
    AMNESIA("Amnesia", 133, MoveEffect.SP_DEF_UP_2, 0, Type.PSYCHIC, 100, 20, 0),
    KINESIS("Kinesis", 134, MoveEffect.ACCURACY_DOWN, 0, Type.PSYCHIC, 80, 15, 0),
    SOFTBOILED("Softboiled", 135, MoveEffect.HEAL, 0, Type.NORMAL, 100, 10, 0),
    HIJUMP_KICK("Hi Jump Kick", 136, MoveEffect.JUMP_KICK, 85, Type.FIGHTING, 90, 20, 0),
    GLARE("Glare", 137, MoveEffect.PARALYZE, 0, Type.NORMAL, 75, 30, 0),
    DREAMEATER("Dream Eater", 138, MoveEffect.DREAM_EATER, 100, Type.PSYCHIC, 100, 15, 0),
    POISONGAS("Poison Gas", 139, MoveEffect.POISON, 0, Type.POISON, 55, 40, 0),
    BARRAGE("Barrage", 140, MoveEffect.MULTI_HIT, 15, Type.NORMAL, 85, 20, 0),
    LEECHLIFE("Leech Life", 141, MoveEffect.LEECH_HIT, 20, Type.BUG, 100, 15, 0),
    LOVELYKISS("Lovely Kiss", 142, MoveEffect.SLEEP, 0, Type.NORMAL, 75, 10, 0),
    SKYATTACK("Sky Attack", 143, MoveEffect.SKY_ATTACK, 140, Type.FLYING, 90, 5, 0),
    TRANSFORM("Transform", 144, MoveEffect.TRANSFORM, 0, Type.NORMAL, 100, 10, 0),
    BUBBLE("Bubble", 145, MoveEffect.SPEED_DOWN_HIT, 20, Type.WATER, 100, 30, 10),
    DIZZYPUNCH("Dizzy Punch", 146, MoveEffect.CONFUSE_HIT, 70, Type.NORMAL, 100, 10, 20),
    SPORE("Spore", 147, MoveEffect.SLEEP, 0, Type.GRASS, 100, 15, 0),
    FLASH("Flash", 148, MoveEffect.ACCURACY_DOWN, 0, Type.NORMAL, 70, 20, 0),
    PSYWAVE("Psywave", 149, MoveEffect.PSYWAVE, 1, Type.PSYCHIC, 80, 15, 0),
    SPLASH("Splash", 150, MoveEffect.SPLASH, 0, Type.NORMAL, 100, 40, 0),
    ACIDARMOR("Acid Armor", 151, MoveEffect.DEFENSE_UP_2, 0, Type.POISON, 100, 40, 0),
    CRABHAMMER("Crabhammer", 152, MoveEffect.NORMAL_HIT, 90, Type.WATER, 85, 10, 0),
    EXPLOSION("Explosion", 153, MoveEffect.SELFDESTRUCT, 250, Type.NORMAL, 100, 5, 0),
    FURYSWIPES("Fury Swipes", 154, MoveEffect.MULTI_HIT, 18, Type.NORMAL, 80, 15, 0),
    BONEMERANG("Bonemerang", 155, MoveEffect.DOUBLE_HIT, 50, Type.GROUND, 90, 10, 0),
    REST("Rest", 156, MoveEffect.HEAL, 0, Type.PSYCHIC, 100, 10, 0),
    ROCKSLIDE("Rock Slide", 157, MoveEffect.FLINCH_HIT, 75, Type.ROCK, 90, 10, 30),
    HYPERFANG("Hyper Fang", 158, MoveEffect.FLINCH_HIT, 80, Type.NORMAL, 90, 15, 10),
    SHARPEN("Sharpen", 159, MoveEffect.ATTACK_UP, 0, Type.NORMAL, 100, 30, 0),
    CONVERSION("Conversion", 160, MoveEffect.CONVERSION, 0, Type.NORMAL, 100, 30, 0),
    TRIATTACK("Tri Attack", 161, MoveEffect.TRI_ATTACK, 80, Type.NORMAL, 100, 10, 20),
    SUPERFANG("Super Fang", 162, MoveEffect.SUPER_FANG, 1, Type.NORMAL, 90, 10, 0),
    SLASH("Slash", 163, MoveEffect.NORMAL_HIT, 70, Type.NORMAL, 100, 20, 0),
    SUBSTITUTE("Substitute", 164, MoveEffect.SUBSTITUTE, 0, Type.NORMAL, 100, 10, 0),
    STRUGGLE("Struggle", 165, MoveEffect.RECOIL_HIT, 50, Type.NONE, 100, 1, 0),
    SKETCH("Sketch", 166, MoveEffect.SKETCH, 0, Type.NORMAL, 100, 1, 0),
    TRIPLEKICK("Triple Kick", 167, MoveEffect.TRIPLE_KICK, 10, Type.FIGHTING, 90, 10, 0),
    THIEF("Thief", 168, MoveEffect.THIEF, 40, Type.DARK, 100, 10, 100),
    SPIDERWEB("Spider Web", 169, MoveEffect.MEAN_LOOK, 0, Type.BUG, 100, 10, 0),
    MINDREADER("Mind Reader", 170, MoveEffect.LOCK_ON, 0, Type.NORMAL, 100, 5, 0),
    NIGHTMARE("Nightmare", 171, MoveEffect.NIGHTMARE, 0, Type.GHOST, 100, 15, 0),
    FLAMEWHEEL("Flame Wheel", 172, MoveEffect.FLAME_WHEEL, 60, Type.FIRE, 100, 25, 10),
    SNORE("Snore", 173, MoveEffect.SNORE, 40, Type.NORMAL, 100, 15, 30),
    CURSE("Curse", 174, MoveEffect.CURSE, 0, Type.GHOST, 100, 10, 0), // TODO: Type.CURSE
    FLAIL("Flail", 175, MoveEffect.REVERSAL, 1, Type.NORMAL, 100, 15, 0),
    CONVERSION2("Conversion 2", 176, MoveEffect.CONVERSION2, 0, Type.NORMAL, 100, 30, 0),
    AEROBLAST("Aeroblast", 177, MoveEffect.NORMAL_HIT, 100, Type.FLYING, 95, 5, 0),
    COTTONSPORE("Cotton Spore", 178, MoveEffect.SPEED_DOWN_2, 0, Type.GRASS, 85, 40, 0),
    REVERSAL("Reversal", 179, MoveEffect.REVERSAL, 1, Type.FIGHTING, 100, 15, 0),
    SPITE("Spite", 180, MoveEffect.SPITE, 0, Type.GHOST, 100, 10, 0),
    POWDERSNOW("Powder Snow", 181, MoveEffect.FREEZE_HIT, 40, Type.ICE, 100, 25, 10),
    PROTECT("Protect", 182, MoveEffect.PROTECT, 0, Type.NORMAL, 100, 10, 0),
    MACHPUNCH("Mach Punch", 183, MoveEffect.PRIORITY_HIT, 40, Type.FIGHTING, 100, 30, 0),
    SCARYFACE("Scary Face", 184, MoveEffect.SPEED_DOWN_2, 0, Type.NORMAL, 90, 10, 0),
    FAINTATTACK("Faint Attack", 185, MoveEffect.ALWAYS_HIT, 60, Type.DARK, 100, 20, 0),
    SWEETKISS("Sweet Kiss", 186, MoveEffect.CONFUSE, 0, Type.NORMAL, 75, 10, 0),
    BELLYDRUM("Belly Drum", 187, MoveEffect.BELLY_DRUM, 0, Type.NORMAL, 100, 10, 0),
    SLUDGEBOMB("Sludge Bomb", 188, MoveEffect.POISON_HIT, 90, Type.POISON, 100, 10, 30),
    MUDSLAP("Mud-Slap", 189, MoveEffect.ACCURACY_DOWN_HIT, 20, Type.GROUND, 100, 10, 100),
    OCTAZOOKA("Octazooka", 190, MoveEffect.ACCURACY_DOWN_HIT, 65, Type.WATER, 85, 10, 50),
    SPIKES("Spikes", 191, MoveEffect.SPIKES, 0, Type.GROUND, 100, 20, 0),
    ZAPCANNON("Zap Cannon", 192, MoveEffect.PARALYZE_HIT, 100, Type.ELECTRIC, 50, 5, 100),
    FORESIGHT("Foresight", 193, MoveEffect.FORESIGHT, 0, Type.NORMAL, 100, 40, 0),
    DESTINYBOND("Destiny Bond", 194, MoveEffect.DESTINY_BOND, 0, Type.GHOST, 100, 5, 0),
    PERISHSONG("Perish Song", 195, MoveEffect.PERISH_SONG, 0, Type.NORMAL, 100, 5, 0),
    ICYWIND("Icy Wind", 196, MoveEffect.SPEED_DOWN_HIT, 55, Type.ICE, 95, 15, 100),
    DETECT("Detect", 197, MoveEffect.PROTECT, 0, Type.FIGHTING, 100, 5, 0),
    BONERUSH("Bone Rush", 198, MoveEffect.MULTI_HIT, 25, Type.GROUND, 80, 10, 0),
    LOCKON("Lock-On", 199, MoveEffect.LOCK_ON, 0, Type.NORMAL, 100, 5, 0),
    OUTRAGE("Outrage", 200, MoveEffect.RAMPAGE, 90, Type.DRAGON, 100, 15, 0),
    SANDSTORM("Sandstorm", 201, MoveEffect.SANDSTORM, 0, Type.ROCK, 100, 10, 0),
    GIGADRAIN("Giga Drain", 202, MoveEffect.LEECH_HIT, 60, Type.GRASS, 100, 5, 0),
    ENDURE("Endure", 203, MoveEffect.ENDURE, 0, Type.NORMAL, 100, 10, 0),
    CHARM("Charm", 204, MoveEffect.ATTACK_DOWN_2, 0, Type.NORMAL, 100, 20, 0),
    ROLLOUT("Rollout", 205, MoveEffect.ROLLOUT, 30, Type.ROCK, 90, 20, 0),
    FALSESWIPE("False Swipe", 206, MoveEffect.FALSE_SWIPE, 40, Type.NORMAL, 100, 40, 0),
    SWAGGER("Swagger", 207, MoveEffect.SWAGGER, 0, Type.NORMAL, 90, 15, 100),
    MILKDRINK("Milk Drink", 208, MoveEffect.HEAL, 0, Type.NORMAL, 100, 10, 0),
    SPARK("Spark", 209, MoveEffect.PARALYZE_HIT, 65, Type.ELECTRIC, 100, 20, 30),
    FURYCUTTER("Fury Cutter", 210, MoveEffect.FURY_CUTTER, 10, Type.BUG, 95, 20, 0),
    STEELWING("Steel Wing", 211, MoveEffect.DEFENSE_UP_HIT, 70, Type.STEEL, 90, 25, 10),
    MEANLOOK("Mean Look", 212, MoveEffect.MEAN_LOOK, 0, Type.NORMAL, 100, 5, 0),
    ATTRACT("Attract", 213, MoveEffect.ATTRACT, 0, Type.NORMAL, 100, 15, 0),
    SLEEPTALK("Sleep Talk", 214, MoveEffect.SLEEP_TALK, 0, Type.NORMAL, 100, 10, 0),
    HEALBELL("Heal Bell", 215, MoveEffect.HEAL_BELL, 0, Type.NORMAL, 100, 5, 0),
    RETURN("Return", 216, MoveEffect.RETURN, 1, Type.NORMAL, 100, 20, 0),
    PRESENT("Present", 217, MoveEffect.PRESENT, 1, Type.NORMAL, 90, 15, 0),
    FRUSTRATION("Frustration", 218, MoveEffect.FRUSTRATION, 1, Type.NORMAL, 100, 20, 0),
    SAFEGUARD("Safeguard", 219, MoveEffect.SAFEGUARD, 0, Type.NORMAL, 100, 25, 0),
    PAINSPLIT("Pain Split", 220, MoveEffect.PAIN_SPLIT, 0, Type.NORMAL, 100, 20, 0),
    SACREDFIRE("Sacred Fire", 221, MoveEffect.SACRED_FIRE, 100, Type.FIRE, 95, 5, 50),
    MAGNITUDE("Magnitude", 222, MoveEffect.MAGNITUDE, 1, Type.GROUND, 100, 30, 0),
    DYNAMICPUNCH("DynamicPunch", 223, MoveEffect.CONFUSE_HIT, 100, Type.FIGHTING, 50, 5, 100),
    MEGAHORN("Megahorn", 224, MoveEffect.NORMAL_HIT, 120, Type.BUG, 85, 10, 0),
    DRAGONBREATH("DragonBreath", 225, MoveEffect.PARALYZE_HIT, 60, Type.DRAGON, 100, 20, 30),
    BATONPASS("Baton Pass", 226, MoveEffect.BATON_PASS, 0, Type.NORMAL, 100, 40, 0),
    ENCORE("Encore", 227, MoveEffect.ENCORE, 0, Type.NORMAL, 100, 5, 0),
    PURSUIT("Pursuit", 228, MoveEffect.PURSUIT, 40, Type.DARK, 100, 20, 0),
    RAPIDSPIN("Rapid Spin", 229, MoveEffect.RAPID_SPIN, 20, Type.NORMAL, 100, 40, 0),
    SWEETSCENT("Sweet Scent", 230, MoveEffect.EVASION_DOWN, 0, Type.NORMAL, 100, 20, 0),
    IRONTAIL("Iron Tail", 231, MoveEffect.DEFENSE_DOWN_HIT, 100, Type.STEEL, 75, 15, 30),
    METALCLAW("Metal Claw", 232, MoveEffect.ATTACK_UP_HIT, 50, Type.STEEL, 95, 35, 10),
    VITALTHROW("Vital Throw", 233, MoveEffect.ALWAYS_HIT, 70, Type.FIGHTING, 100, 10, 0),
    MORNINGSUN("Morning Sun", 234, MoveEffect.MORNING_SUN, 0, Type.NORMAL, 100, 5, 0),
    SYNTHESIS("Synthesis", 235, MoveEffect.SYNTHESIS, 0, Type.GRASS, 100, 5, 0),
    MOONLIGHT("Moonlight", 236, MoveEffect.MOONLIGHT, 0, Type.NORMAL, 100, 5, 0),
    HIDDENPOWER("Hidden Power", 237, MoveEffect.HIDDEN_POWER, 0, Type.NORMAL, 100, 15, 0),
    CROSSCHOP("Cross Chop", 238, MoveEffect.NORMAL_HIT, 100, Type.FIGHTING, 80, 5, 0),
    TWISTER("Twister", 239, MoveEffect.TWISTER, 40, Type.DRAGON, 100, 20, 20),
    RAINDANCE("Rain Dance", 240, MoveEffect.RAIN_DANCE, 0, Type.WATER, 90, 5, 0),
    SUNNYDAY("Sunny Day", 241, MoveEffect.SUNNY_DAY, 0, Type.FIRE, 90, 5, 0),
    CRUNCH("Crunch", 242, MoveEffect.SP_DEF_DOWN_HIT, 80, Type.DARK, 100, 15, 20),
    MIRRORCOAT("Mirror Coat", 243, MoveEffect.MIRROR_COAT, 1, Type.PSYCHIC, 100, 20, 0),
    PSYCHUP("Psych Up", 244, MoveEffect.PSYCH_UP, 0, Type.NORMAL, 100, 10, 0),
    EXTREMESPEED("ExtremeSpeed", 245, MoveEffect.PRIORITY_HIT, 80, Type.NORMAL, 100, 5, 0),
    ANCIENTPOWER("AncientPower", 246, MoveEffect.ALL_UP_HIT, 60, Type.ROCK, 100, 5, 10),
    SHADOWBALL("Shadow Ball", 247, MoveEffect.SP_DEF_DOWN_HIT, 80, Type.GHOST, 100, 15, 20),
    FUTURESIGHT("Future Sight", 248, MoveEffect.FUTURE_SIGHT, 80, Type.PSYCHIC, 90, 15, 0),
    ROCKSMASH("Rock Smash", 249, MoveEffect.DEFENSE_DOWN_HIT, 20, Type.FIGHTING, 100, 15, 50),
    WHIRLPOOL("Whirlpool", 250, MoveEffect.TRAP_TARGET, 15, Type.WATER, 70, 15, 0),
    BEATUP("Beat Up", 251, MoveEffect.BEAT_UP, 10, Type.DARK, 100, 10, 0),
    
    FLAIL200("Flail 200", 252, MoveEffect.REVERSAL, 200, Type.NORMAL, 100, 15, 0),
    FLAIL150("Flail 150", 253, MoveEffect.REVERSAL, 150, Type.NORMAL, 100, 15, 0),
    FLAIL100("Flail 100", 254, MoveEffect.REVERSAL, 100, Type.NORMAL, 100, 15, 0),
	FLAIL80("Flail 80", 255, MoveEffect.REVERSAL, 80, Type.NORMAL, 100, 15, 0),
	FLAIL40("Flail 40", 256, MoveEffect.REVERSAL, 40, Type.NORMAL, 100, 15, 0),
	FLAIL20("Flail 20", 257, MoveEffect.REVERSAL, 20, Type.NORMAL, 100, 15, 0),
    
	SELFHIT("Self hit", 258, MoveEffect.SELF_HIT, 40, Type.NONE, 100, 0, 0),
	;

    private String name;
    private int index;
    private MoveEffect effect;
    private int power;
    private Type type;
    private int accuracy;
    private int pp;
    private int effectChance;

    Move(String name, int index, MoveEffect effect, int power, Type type, int accuracy, int pp, int effectChance) {
        this.name = name;
        this.index = index;
        this.effect = effect;
        this.power = power;
        this.type = type;
        this.accuracy = accuracy;
        this.pp = pp;
        this.effectChance = effectChance;
    }

    public String getName() {
        return name;
    }

    public String getBoostedName(int i) {
        return name + " " + i;
    }

    public MoveEffect getEffect() {
        return effect;
    }

    public int getPower() {
        return power;
    }

    public Type getType() {
        return type;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPP() {
        return pp;
    }

    public int getEffectChance() {
        return effectChance;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
