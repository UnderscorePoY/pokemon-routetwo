public enum Species {
    BULBASAUR("Bulbasaur", 1, Type.GRASS, Type.POISON, 45, 49, 49, 65, 65, 45, 64, ExpCurve.MEDIUM_SLOW),
    IVYSAUR("Ivysaur", 2, Type.GRASS, Type.POISON, 60, 62, 63, 80, 80, 60, 141, ExpCurve.MEDIUM_SLOW),
    VENUSAUR("Venusaur", 3, Type.GRASS, Type.POISON, 80, 82, 83, 100, 100, 80, 208, ExpCurve.MEDIUM_SLOW),
    CHARMANDER("Charmander", 4, Type.FIRE, Type.NONE, 39, 52, 43, 60, 50, 65, 65, ExpCurve.MEDIUM_SLOW),
    CHARMELEON("Charmeleon", 5, Type.FIRE, Type.NONE, 58, 64, 58, 80, 65, 80, 142, ExpCurve.MEDIUM_SLOW),
    CHARIZARD("Charizard", 6, Type.FIRE, Type.FLYING, 78, 84, 78, 109, 85, 100, 209, ExpCurve.MEDIUM_SLOW),
    SQUIRTLE("Squirtle", 7, Type.WATER, Type.NONE, 44, 48, 65, 50, 64, 43, 66, ExpCurve.MEDIUM_SLOW),
    WARTORTLE("Wartortle", 8, Type.WATER, Type.NONE, 59, 63, 80, 65, 80, 58, 143, ExpCurve.MEDIUM_SLOW),
    BLASTOISE("Blastoise", 9, Type.WATER, Type.NONE, 79, 83, 100, 85, 105, 78, 210, ExpCurve.MEDIUM_SLOW),
    CATERPIE("Caterpie", 10, Type.BUG, Type.NONE, 45, 30, 35, 20, 20, 45, 53, ExpCurve.MEDIUM_FAST),
    METAPOD("Metapod", 11, Type.BUG, Type.NONE, 50, 20, 55, 25, 25, 30, 72, ExpCurve.MEDIUM_FAST),
    BUTTERFREE("Butterfree", 12, Type.BUG, Type.FLYING, 60, 45, 50, 80, 80, 70, 160, ExpCurve.MEDIUM_FAST),
    WEEDLE("Weedle", 13, Type.BUG, Type.POISON, 40, 35, 30, 20, 20, 50, 52, ExpCurve.MEDIUM_FAST),
    KAKUNA("Kakuna", 14, Type.BUG, Type.POISON, 45, 25, 50, 25, 25, 35, 71, ExpCurve.MEDIUM_FAST),
    BEEDRILL("Beedrill", 15, Type.BUG, Type.POISON, 65, 80, 40, 45, 80, 75, 159, ExpCurve.MEDIUM_FAST),
    PIDGEY("Pidgey", 16, Type.NORMAL, Type.FLYING, 40, 45, 40, 35, 35, 56, 55, ExpCurve.MEDIUM_SLOW),
    PIDGEOTTO("Pidgeotto", 17, Type.NORMAL, Type.FLYING, 63, 60, 55, 50, 50, 71, 113, ExpCurve.MEDIUM_SLOW),
    PIDGEOT("Pidgeot", 18, Type.NORMAL, Type.FLYING, 83, 80, 75, 70, 70, 91, 172, ExpCurve.MEDIUM_SLOW),
    RATTATA("Rattata", 19, Type.NORMAL, Type.NONE, 30, 56, 35, 25, 35, 72, 57, ExpCurve.MEDIUM_FAST),
    RATICATE("Raticate", 20, Type.NORMAL, Type.NONE, 55, 81, 60, 50, 70, 97, 116, ExpCurve.MEDIUM_FAST),
    SPEAROW("Spearow", 21, Type.NORMAL, Type.FLYING, 40, 60, 30, 31, 31, 70, 58, ExpCurve.MEDIUM_FAST),
    FEAROW("Fearow", 22, Type.NORMAL, Type.FLYING, 65, 90, 65, 61, 61, 100, 162, ExpCurve.MEDIUM_FAST),
    EKANS("Ekans", 23, Type.POISON, Type.NONE, 35, 60, 44, 40, 54, 55, 62, ExpCurve.MEDIUM_FAST),
    ARBOK("Arbok", 24, Type.POISON, Type.NONE, 60, 85, 69, 65, 79, 80, 147, ExpCurve.MEDIUM_FAST),
    PIKACHU("Pikachu", 25, Type.ELECTRIC, Type.NONE, 35, 55, 30, 50, 40, 90, 82, ExpCurve.MEDIUM_FAST),
    RAICHU("Raichu", 26, Type.ELECTRIC, Type.NONE, 60, 90, 55, 90, 80, 100, 122, ExpCurve.MEDIUM_FAST),
    SANDSHREW("Sandshrew", 27, Type.GROUND, Type.NONE, 50, 75, 85, 20, 30, 40, 93, ExpCurve.MEDIUM_FAST),
    SANDSLASH("Sandslash", 28, Type.GROUND, Type.NONE, 75, 100, 110, 45, 55, 65, 163, ExpCurve.MEDIUM_FAST),
    NIDORANF("NidoranF", 29, Type.POISON, Type.NONE, 55, 47, 52, 40, 40, 41, 59, ExpCurve.MEDIUM_SLOW),
    NIDORINA("Nidorina", 30, Type.POISON, Type.NONE, 70, 62, 67, 55, 55, 56, 117, ExpCurve.MEDIUM_SLOW),
    NIDOQUEEN("Nidoqueen", 31, Type.POISON, Type.GROUND, 90, 82, 87, 75, 85, 76, 194, ExpCurve.MEDIUM_SLOW),
    NIDORANM("NidoranM", 32, Type.POISON, Type.NONE, 46, 57, 40, 40, 40, 50, 60, ExpCurve.MEDIUM_SLOW),
    NIDORINO("Nidorino", 33, Type.POISON, Type.NONE, 61, 72, 57, 55, 55, 65, 118, ExpCurve.MEDIUM_SLOW),
    NIDOKING("Nidoking", 34, Type.POISON, Type.GROUND, 81, 92, 77, 85, 75, 85, 195, ExpCurve.MEDIUM_SLOW),
    CLEFAIRY("Clefairy", 35, Type.NORMAL, Type.NONE, 70, 45, 48, 60, 65, 35, 68, ExpCurve.FAST),
    CLEFABLE("Clefable", 36, Type.NORMAL, Type.NONE, 95, 70, 73, 85, 90, 60, 129, ExpCurve.FAST),
    VULPIX("Vulpix", 37, Type.FIRE, Type.NONE, 38, 41, 40, 50, 65, 65, 63, ExpCurve.MEDIUM_FAST),
    NINETALES("Ninetales", 38, Type.FIRE, Type.NONE, 73, 76, 75, 81, 100, 100, 178, ExpCurve.MEDIUM_FAST),
    JIGGLYPUFF("Jigglypuff", 39, Type.NORMAL, Type.NONE, 115, 45, 20, 45, 25, 20, 76, ExpCurve.FAST),
    WIGGLYTUFF("Wigglytuff", 40, Type.NORMAL, Type.NONE, 140, 70, 45, 75, 50, 45, 109, ExpCurve.FAST),
    ZUBAT("Zubat", 41, Type.POISON, Type.FLYING, 40, 45, 35, 30, 40, 55, 54, ExpCurve.MEDIUM_FAST),
    GOLBAT("Golbat", 42, Type.POISON, Type.FLYING, 75, 80, 70, 65, 75, 90, 171, ExpCurve.MEDIUM_FAST),
    ODDISH("Oddish", 43, Type.GRASS, Type.POISON, 45, 50, 55, 75, 65, 30, 78, ExpCurve.MEDIUM_SLOW),
    GLOOM("Gloom", 44, Type.GRASS, Type.POISON, 60, 65, 70, 85, 75, 40, 132, ExpCurve.MEDIUM_SLOW),
    VILEPLUME("Vileplume", 45, Type.GRASS, Type.POISON, 75, 80, 85, 100, 90, 50, 184, ExpCurve.MEDIUM_SLOW),
    PARAS("Paras", 46, Type.BUG, Type.GRASS, 35, 70, 55, 45, 55, 25, 70, ExpCurve.MEDIUM_FAST),
    PARASECT("Parasect", 47, Type.BUG, Type.GRASS, 60, 95, 80, 60, 80, 30, 128, ExpCurve.MEDIUM_FAST),
    VENONAT("Venonat", 48, Type.BUG, Type.POISON, 60, 55, 50, 40, 55, 45, 75, ExpCurve.MEDIUM_FAST),
    VENOMOTH("Venomoth", 49, Type.BUG, Type.POISON, 70, 65, 60, 90, 75, 90, 138, ExpCurve.MEDIUM_FAST),
    DIGLETT("Diglett", 50, Type.GROUND, Type.NONE, 10, 55, 25, 35, 45, 95, 81, ExpCurve.MEDIUM_FAST),
    DUGTRIO("Dugtrio", 51, Type.GROUND, Type.NONE, 35, 80, 50, 50, 70, 120, 153, ExpCurve.MEDIUM_FAST),
    MEOWTH("Meowth", 52, Type.NORMAL, Type.NONE, 40, 45, 35, 40, 40, 90, 69, ExpCurve.MEDIUM_FAST),
    PERSIAN("Persian", 53, Type.NORMAL, Type.NONE, 65, 70, 60, 65, 65, 115, 148, ExpCurve.MEDIUM_FAST),
    PSYDUCK("Psyduck", 54, Type.WATER, Type.NONE, 50, 52, 48, 65, 50, 55, 80, ExpCurve.MEDIUM_FAST),
    GOLDUCK("Golduck", 55, Type.WATER, Type.NONE, 80, 82, 78, 95, 80, 85, 174, ExpCurve.MEDIUM_FAST),
    MANKEY("Mankey", 56, Type.FIGHTING, Type.NONE, 40, 80, 35, 35, 45, 70, 74, ExpCurve.MEDIUM_FAST),
    PRIMEAPE("Primeape", 57, Type.FIGHTING, Type.NONE, 65, 105, 60, 60, 70, 95, 149, ExpCurve.MEDIUM_FAST),
    GROWLITHE("Growlithe", 58, Type.FIRE, Type.NONE, 55, 70, 45, 70, 50, 60, 91, ExpCurve.SLOW),
    ARCANINE("Arcanine", 59, Type.FIRE, Type.NONE, 90, 110, 80, 100, 80, 95, 213, ExpCurve.SLOW),
    POLIWAG("Poliwag", 60, Type.WATER, Type.NONE, 40, 50, 40, 40, 40, 90, 77, ExpCurve.MEDIUM_SLOW),
    POLIWHIRL("Poliwhirl", 61, Type.WATER, Type.NONE, 65, 65, 65, 50, 50, 90, 131, ExpCurve.MEDIUM_SLOW),
    POLIWRATH("Poliwrath", 62, Type.WATER, Type.FIGHTING, 90, 85, 95, 70, 90, 70, 185, ExpCurve.MEDIUM_SLOW),
    ABRA("Abra", 63, Type.PSYCHIC, Type.NONE, 25, 20, 15, 105, 55, 90, 73, ExpCurve.MEDIUM_SLOW),
    KADABRA("Kadabra", 64, Type.PSYCHIC, Type.NONE, 40, 35, 30, 120, 70, 105, 145, ExpCurve.MEDIUM_SLOW),
    ALAKAZAM("Alakazam", 65, Type.PSYCHIC, Type.NONE, 55, 50, 45, 135, 85, 120, 186, ExpCurve.MEDIUM_SLOW),
    MACHOP("Machop", 66, Type.FIGHTING, Type.NONE, 70, 80, 50, 35, 35, 35, 88, ExpCurve.MEDIUM_SLOW),
    MACHOKE("Machoke", 67, Type.FIGHTING, Type.NONE, 80, 100, 70, 50, 60, 45, 146, ExpCurve.MEDIUM_SLOW),
    MACHAMP("Machamp", 68, Type.FIGHTING, Type.NONE, 90, 130, 80, 65, 85, 55, 193, ExpCurve.MEDIUM_SLOW),
    BELLSPROUT("Bellsprout", 69, Type.GRASS, Type.POISON, 50, 75, 35, 70, 30, 40, 84, ExpCurve.MEDIUM_SLOW),
    WEEPINBELL("Weepinbell", 70, Type.GRASS, Type.POISON, 65, 90, 50, 85, 45, 55, 151, ExpCurve.MEDIUM_SLOW),
    VICTREEBEL("Victreebel", 71, Type.GRASS, Type.POISON, 80, 105, 65, 100, 60, 70, 191, ExpCurve.MEDIUM_SLOW),
    TENTACOOL("Tentacool", 72, Type.WATER, Type.POISON, 40, 40, 35, 50, 100, 70, 105, ExpCurve.SLOW),
    TENTACRUEL("Tentacruel", 73, Type.WATER, Type.POISON, 80, 70, 65, 80, 120, 100, 205, ExpCurve.SLOW),
    GEODUDE("Geodude", 74, Type.ROCK, Type.GROUND, 40, 80, 100, 30, 30, 20, 86, ExpCurve.MEDIUM_SLOW),
    GRAVELER("Graveler", 75, Type.ROCK, Type.GROUND, 55, 95, 115, 45, 45, 35, 134, ExpCurve.MEDIUM_SLOW),
    GOLEM("Golem", 76, Type.ROCK, Type.GROUND, 80, 110, 130, 55, 65, 45, 177, ExpCurve.MEDIUM_SLOW),
    PONYTA("Ponyta", 77, Type.FIRE, Type.NONE, 50, 85, 55, 65, 65, 90, 152, ExpCurve.MEDIUM_FAST),
    RAPIDASH("Rapidash", 78, Type.FIRE, Type.NONE, 65, 100, 70, 80, 80, 105, 192, ExpCurve.MEDIUM_FAST),
    SLOWPOKE("Slowpoke", 79, Type.WATER, Type.PSYCHIC, 90, 65, 65, 40, 40, 15, 99, ExpCurve.MEDIUM_FAST),
    SLOWBRO("Slowbro", 80, Type.WATER, Type.PSYCHIC, 95, 75, 110, 100, 80, 30, 164, ExpCurve.MEDIUM_FAST),
    MAGNEMITE("Magnemite", 81, Type.ELECTRIC, Type.STEEL, 25, 35, 70, 95, 55, 45, 89, ExpCurve.MEDIUM_FAST),
    MAGNETON("Magneton", 82, Type.ELECTRIC, Type.STEEL, 50, 60, 95, 120, 70, 70, 161, ExpCurve.MEDIUM_FAST),
    FARFETCHD("Farfetch'd", 83, Type.NORMAL, Type.FLYING, 52, 65, 55, 58, 62, 60, 94, ExpCurve.MEDIUM_FAST),
    DODUO("Doduo", 84, Type.NORMAL, Type.FLYING, 35, 85, 45, 35, 35, 75, 96, ExpCurve.MEDIUM_FAST),
    DODRIO("Dodrio", 85, Type.NORMAL, Type.FLYING, 60, 110, 70, 60, 60, 100, 158, ExpCurve.MEDIUM_FAST),
    SEEL("Seel", 86, Type.WATER, Type.NONE, 65, 45, 55, 45, 70, 45, 100, ExpCurve.MEDIUM_FAST),
    DEWGONG("Dewgong", 87, Type.WATER, Type.ICE, 90, 70, 80, 70, 95, 70, 176, ExpCurve.MEDIUM_FAST),
    GRIMER("Grimer", 88, Type.POISON, Type.NONE, 80, 80, 50, 40, 50, 25, 90, ExpCurve.MEDIUM_FAST),
    MUK("Muk", 89, Type.POISON, Type.NONE, 105, 105, 75, 65, 100, 50, 157, ExpCurve.MEDIUM_FAST),
    SHELLDER("Shellder", 90, Type.WATER, Type.NONE, 30, 65, 100, 45, 25, 40, 97, ExpCurve.SLOW),
    CLOYSTER("Cloyster", 91, Type.WATER, Type.ICE, 50, 95, 180, 85, 45, 70, 203, ExpCurve.SLOW),
    GASTLY("Gastly", 92, Type.GHOST, Type.POISON, 30, 35, 30, 100, 35, 80, 95, ExpCurve.MEDIUM_SLOW),
    HAUNTER("Haunter", 93, Type.GHOST, Type.POISON, 45, 50, 45, 115, 55, 95, 126, ExpCurve.MEDIUM_SLOW),
    GENGAR("Gengar", 94, Type.GHOST, Type.POISON, 60, 65, 60, 130, 75, 110, 190, ExpCurve.MEDIUM_SLOW),
    ONIX("Onix", 95, Type.ROCK, Type.GROUND, 35, 45, 160, 30, 45, 70, 108, ExpCurve.MEDIUM_FAST),
    DROWZEE("Drowzee", 96, Type.PSYCHIC, Type.NONE, 60, 48, 45, 43, 90, 42, 102, ExpCurve.MEDIUM_FAST),
    HYPNO("Hypno", 97, Type.PSYCHIC, Type.NONE, 85, 73, 70, 73, 115, 67, 165, ExpCurve.MEDIUM_FAST),
    KRABBY("Krabby", 98, Type.WATER, Type.NONE, 30, 105, 90, 25, 25, 50, 115, ExpCurve.MEDIUM_FAST),
    KINGLER("Kingler", 99, Type.WATER, Type.NONE, 55, 130, 115, 50, 50, 75, 206, ExpCurve.MEDIUM_FAST),
    VOLTORB("Voltorb", 100, Type.ELECTRIC, Type.NONE, 40, 30, 50, 55, 55, 100, 103, ExpCurve.MEDIUM_FAST),
    ELECTRODE("Electrode", 101, Type.ELECTRIC, Type.NONE, 60, 50, 70, 80, 80, 140, 150, ExpCurve.MEDIUM_FAST),
    EXEGGCUTE("Exeggcute", 102, Type.GRASS, Type.PSYCHIC, 60, 40, 80, 60, 45, 40, 98, ExpCurve.SLOW),
    EXEGGUTOR("Exeggutor", 103, Type.GRASS, Type.PSYCHIC, 95, 95, 85, 125, 65, 55, 212, ExpCurve.SLOW),
    CUBONE("Cubone", 104, Type.GROUND, Type.NONE, 50, 50, 95, 40, 50, 35, 87, ExpCurve.MEDIUM_FAST),
    MAROWAK("Marowak", 105, Type.GROUND, Type.NONE, 60, 80, 110, 50, 80, 45, 124, ExpCurve.MEDIUM_FAST),
    HITMONLEE("Hitmonlee", 106, Type.FIGHTING, Type.NONE, 50, 120, 53, 35, 110, 87, 139, ExpCurve.MEDIUM_FAST),
    HITMONCHAN("Hitmonchan", 107, Type.FIGHTING, Type.NONE, 50, 105, 79, 35, 110, 76, 140, ExpCurve.MEDIUM_FAST),
    LICKITUNG("Lickitung", 108, Type.NORMAL, Type.NONE, 90, 55, 75, 60, 75, 30, 127, ExpCurve.MEDIUM_FAST),
    KOFFING("Koffing", 109, Type.POISON, Type.NONE, 40, 65, 95, 60, 45, 35, 114, ExpCurve.MEDIUM_FAST),
    WEEZING("Weezing", 110, Type.POISON, Type.NONE, 65, 90, 120, 85, 70, 60, 173, ExpCurve.MEDIUM_FAST),
    RHYHORN("Rhyhorn", 111, Type.GROUND, Type.ROCK, 80, 85, 95, 30, 30, 25, 135, ExpCurve.SLOW),
    RHYDON("Rhydon", 112, Type.GROUND, Type.ROCK, 105, 130, 120, 45, 45, 40, 204, ExpCurve.SLOW),
    CHANSEY("Chansey", 113, Type.NORMAL, Type.NONE, 250, 5, 5, 35, 105, 50, 255, ExpCurve.FAST),
    TANGELA("Tangela", 114, Type.GRASS, Type.NONE, 65, 55, 115, 100, 40, 60, 166, ExpCurve.MEDIUM_FAST),
    KANGASKHAN("Kangaskhan", 115, Type.NORMAL, Type.NONE, 105, 95, 80, 40, 80, 90, 175, ExpCurve.MEDIUM_FAST),
    HORSEA("Horsea", 116, Type.WATER, Type.NONE, 30, 40, 70, 70, 25, 60, 83, ExpCurve.MEDIUM_FAST),
    SEADRA("Seadra", 117, Type.WATER, Type.NONE, 55, 65, 95, 95, 45, 85, 155, ExpCurve.MEDIUM_FAST),
    GOLDEEN("Goldeen", 118, Type.WATER, Type.NONE, 45, 67, 60, 35, 50, 63, 111, ExpCurve.MEDIUM_FAST),
    SEAKING("Seaking", 119, Type.WATER, Type.NONE, 80, 92, 65, 65, 80, 68, 170, ExpCurve.MEDIUM_FAST),
    STARYU("Staryu", 120, Type.WATER, Type.NONE, 30, 45, 55, 70, 55, 85, 106, ExpCurve.SLOW),
    STARMIE("Starmie", 121, Type.WATER, Type.PSYCHIC, 60, 75, 85, 100, 85, 115, 207, ExpCurve.SLOW),
    MRMIME("Mr.Mime", 122, Type.PSYCHIC, Type.NONE, 40, 45, 65, 100, 120, 90, 136, ExpCurve.MEDIUM_FAST),
    SCYTHER("Scyther", 123, Type.BUG, Type.FLYING, 70, 110, 80, 55, 80, 105, 187, ExpCurve.MEDIUM_FAST),
    JYNX("Jynx", 124, Type.ICE, Type.PSYCHIC, 65, 50, 35, 115, 95, 95, 137, ExpCurve.MEDIUM_FAST),
    ELECTABUZZ("Electabuzz", 125, Type.ELECTRIC, Type.NONE, 65, 83, 57, 95, 85, 105, 156, ExpCurve.MEDIUM_FAST),
    MAGMAR("Magmar", 126, Type.FIRE, Type.NONE, 65, 95, 57, 100, 85, 93, 167, ExpCurve.MEDIUM_FAST),
    PINSIR("Pinsir", 127, Type.BUG, Type.NONE, 65, 125, 100, 55, 70, 85, 200, ExpCurve.SLOW),
    TAUROS("Tauros", 128, Type.NORMAL, Type.NONE, 75, 100, 95, 40, 70, 110, 211, ExpCurve.SLOW),
    MAGIKARP("Magikarp", 129, Type.WATER, Type.NONE, 20, 10, 55, 15, 20, 80, 20, ExpCurve.SLOW),
    GYARADOS("Gyarados", 130, Type.WATER, Type.FLYING, 95, 125, 79, 60, 100, 81, 214, ExpCurve.SLOW),
    LAPRAS("Lapras", 131, Type.WATER, Type.ICE, 130, 85, 80, 85, 95, 60, 219, ExpCurve.SLOW),
    DITTO("Ditto", 132, Type.NORMAL, Type.NONE, 48, 48, 48, 48, 48, 48, 61, ExpCurve.MEDIUM_FAST),
    EEVEE("Eevee", 133, Type.NORMAL, Type.NONE, 55, 55, 50, 45, 65, 55, 92, ExpCurve.MEDIUM_FAST),
    VAPOREON("Vaporeon", 134, Type.WATER, Type.NONE, 130, 65, 60, 110, 95, 65, 196, ExpCurve.MEDIUM_FAST),
    JOLTEON("Jolteon", 135, Type.ELECTRIC, Type.NONE, 65, 65, 60, 110, 95, 130, 197, ExpCurve.MEDIUM_FAST),
    FLAREON("Flareon", 136, Type.FIRE, Type.NONE, 65, 130, 60, 95, 110, 65, 198, ExpCurve.MEDIUM_FAST),
    PORYGON("Porygon", 137, Type.NORMAL, Type.NONE, 65, 60, 70, 85, 75, 40, 130, ExpCurve.MEDIUM_FAST),
    OMANYTE("Omanyte", 138, Type.ROCK, Type.WATER, 35, 40, 100, 90, 55, 35, 120, ExpCurve.MEDIUM_FAST),
    OMASTAR("Omastar", 139, Type.ROCK, Type.WATER, 70, 60, 125, 115, 70, 55, 199, ExpCurve.MEDIUM_FAST),
    KABUTO("Kabuto", 140, Type.ROCK, Type.WATER, 30, 80, 90, 55, 45, 55, 119, ExpCurve.MEDIUM_FAST),
    KABUTOPS("Kabutops", 141, Type.ROCK, Type.WATER, 60, 115, 105, 65, 70, 80, 201, ExpCurve.MEDIUM_FAST),
    AERODACTYL("Aerodactyl", 142, Type.ROCK, Type.FLYING, 80, 105, 65, 60, 75, 130, 202, ExpCurve.SLOW),
    SNORLAX("Snorlax", 143, Type.NORMAL, Type.NONE, 160, 110, 65, 65, 110, 30, 154, ExpCurve.SLOW),
    ARTICUNO("Articuno", 144, Type.ICE, Type.FLYING, 90, 85, 100, 95, 125, 85, 215, ExpCurve.SLOW),
    ZAPDOS("Zapdos", 145, Type.ELECTRIC, Type.FLYING, 90, 90, 85, 125, 90, 100, 216, ExpCurve.SLOW),
    MOLTRES("Moltres", 146, Type.FIRE, Type.FLYING, 90, 100, 90, 125, 85, 90, 217, ExpCurve.SLOW),
    DRATINI("Dratini", 147, Type.DRAGON, Type.NONE, 41, 64, 45, 50, 50, 50, 67, ExpCurve.SLOW),
    DRAGONAIR("Dragonair", 148, Type.DRAGON, Type.NONE, 61, 84, 65, 70, 70, 70, 144, ExpCurve.SLOW),
    DRAGONITE("Dragonite", 149, Type.DRAGON, Type.FLYING, 91, 134, 95, 100, 100, 80, 218, ExpCurve.SLOW),
    MEWTWO("Mewtwo", 150, Type.PSYCHIC, Type.NONE, 106, 110, 90, 154, 90, 130, 220, ExpCurve.SLOW),
    MEW("Mew", 151, Type.PSYCHIC, Type.NONE, 100, 100, 100, 100, 100, 100, 64, ExpCurve.MEDIUM_SLOW),
    CHIKORITA("Chikorita", 152, Type.GRASS, Type.NONE, 45, 49, 65, 49, 65, 45, 64, ExpCurve.MEDIUM_SLOW),
    BAYLEEF("Bayleef", 153, Type.GRASS, Type.NONE, 60, 62, 80, 63, 80, 60, 141, ExpCurve.MEDIUM_SLOW),
    MEGANIUM("Meganium", 154, Type.GRASS, Type.NONE, 80, 82, 100, 83, 100, 80, 208, ExpCurve.MEDIUM_SLOW),
    CYNDAQUIL("Cyndaquil", 155, Type.FIRE, Type.NONE, 39, 52, 43, 60, 50, 65, 65, ExpCurve.MEDIUM_SLOW),
    QUILAVA("Quilava", 156, Type.FIRE, Type.NONE, 58, 64, 58, 80, 65, 80, 142, ExpCurve.MEDIUM_SLOW),
    TYPHLOSION("Typhlosion", 157, Type.FIRE, Type.NONE, 78, 84, 78, 109, 85, 100, 209, ExpCurve.MEDIUM_SLOW),
    TOTODILE("Totodile", 158, Type.WATER, Type.NONE, 50, 65, 64, 44, 48, 43, 66, ExpCurve.MEDIUM_SLOW),
    CROCONAW("Croconaw", 159, Type.WATER, Type.NONE, 65, 80, 80, 59, 63, 58, 143, ExpCurve.MEDIUM_SLOW),
    FERALIGATR("Feraligatr", 160, Type.WATER, Type.NONE, 85, 105, 100, 79, 83, 78, 210, ExpCurve.MEDIUM_SLOW),
    SENTRET("Sentret", 161, Type.NORMAL, Type.NONE, 35, 46, 34, 35, 45, 20, 57, ExpCurve.MEDIUM_FAST),
    FURRET("Furret", 162, Type.NORMAL, Type.NONE, 85, 76, 64, 45, 55, 90, 116, ExpCurve.MEDIUM_FAST),
    HOOTHOOT("Hoothoot", 163, Type.NORMAL, Type.FLYING, 60, 30, 30, 36, 56, 50, 58, ExpCurve.MEDIUM_FAST),
    NOCTOWL("Noctowl", 164, Type.NORMAL, Type.FLYING, 100, 50, 50, 76, 96, 70, 162, ExpCurve.MEDIUM_FAST),
    LEDYBA("Ledyba", 165, Type.BUG, Type.FLYING, 40, 20, 30, 40, 80, 55, 54, ExpCurve.FAST),
    LEDIAN("Ledian", 166, Type.BUG, Type.FLYING, 55, 35, 50, 55, 110, 85, 134, ExpCurve.FAST),
    SPINARAK("Spinarak", 167, Type.BUG, Type.POISON, 40, 60, 40, 40, 40, 30, 54, ExpCurve.FAST),
    ARIADOS("Ariados", 168, Type.BUG, Type.POISON, 70, 90, 70, 60, 60, 40, 134, ExpCurve.FAST),
    CROBAT("Crobat", 169, Type.POISON, Type.FLYING, 85, 90, 80, 70, 80, 130, 204, ExpCurve.MEDIUM_FAST),
    CHINCHOU("Chinchou", 170, Type.WATER, Type.ELECTRIC, 75, 38, 38, 56, 56, 67, 90, ExpCurve.SLOW),
    LANTURN("Lanturn", 171, Type.WATER, Type.ELECTRIC, 125, 58, 58, 76, 76, 67, 156, ExpCurve.SLOW),
    PICHU("Pichu", 172, Type.ELECTRIC, Type.NONE, 20, 40, 15, 35, 35, 60, 42, ExpCurve.MEDIUM_FAST),
    CLEFFA("Cleffa", 173, Type.NORMAL, Type.NONE, 50, 25, 28, 45, 55, 15, 37, ExpCurve.FAST),
    IGGLYBUFF("Igglybuff", 174, Type.NORMAL, Type.NONE, 90, 30, 15, 40, 20, 15, 39, ExpCurve.FAST),
    TOGEPI("Togepi", 175, Type.NORMAL, Type.NONE, 35, 20, 65, 40, 65, 20, 74, ExpCurve.FAST),
    TOGETIC("Togetic", 176, Type.NORMAL, Type.FLYING, 55, 40, 85, 80, 105, 40, 114, ExpCurve.FAST),
    NATU("Natu", 177, Type.PSYCHIC, Type.FLYING, 40, 50, 45, 70, 45, 70, 73, ExpCurve.MEDIUM_FAST),
    XATU("Xatu", 178, Type.PSYCHIC, Type.FLYING, 65, 75, 70, 95, 70, 95, 171, ExpCurve.MEDIUM_FAST),
    MAREEP("Mareep", 179, Type.ELECTRIC, Type.NONE, 55, 40, 40, 65, 45, 35, 59, ExpCurve.MEDIUM_SLOW),
    FLAAFFY("Flaaffy", 180, Type.ELECTRIC, Type.NONE, 70, 55, 55, 80, 60, 45, 117, ExpCurve.MEDIUM_SLOW),
    AMPHAROS("Ampharos", 181, Type.ELECTRIC, Type.NONE, 90, 75, 75, 115, 90, 55, 194, ExpCurve.MEDIUM_SLOW),
    BELLOSSOM("Bellossom", 182, Type.GRASS, Type.NONE, 75, 80, 85, 90, 100, 50, 184, ExpCurve.MEDIUM_SLOW),
    MARILL("Marill", 183, Type.WATER, Type.NONE, 70, 20, 50, 20, 50, 40, 58, ExpCurve.FAST),
    AZUMARILL("Azumarill", 184, Type.WATER, Type.NONE, 100, 50, 80, 50, 80, 50, 153, ExpCurve.FAST),
    SUDOWOODO("Sudowoodo", 185, Type.ROCK, Type.NONE, 70, 100, 115, 30, 65, 30, 135, ExpCurve.MEDIUM_FAST),
    POLITOED("Politoed", 186, Type.WATER, Type.NONE, 90, 75, 75, 90, 100, 70, 185, ExpCurve.MEDIUM_SLOW),
    HOPPIP("Hoppip", 187, Type.GRASS, Type.FLYING, 35, 35, 40, 35, 55, 50, 74, ExpCurve.MEDIUM_SLOW),
    SKIPLOOM("Skiploom", 188, Type.GRASS, Type.FLYING, 55, 45, 50, 45, 65, 80, 136, ExpCurve.MEDIUM_SLOW),
    JUMPLUFF("Jumpluff", 189, Type.GRASS, Type.FLYING, 75, 55, 70, 55, 85, 110, 176, ExpCurve.MEDIUM_SLOW),
    AIPOM("Aipom", 190, Type.NORMAL, Type.NONE, 55, 70, 55, 40, 55, 85, 94, ExpCurve.FAST),
    SUNKERN("Sunkern", 191, Type.GRASS, Type.NONE, 30, 30, 30, 30, 30, 30, 52, ExpCurve.MEDIUM_SLOW),
    SUNFLORA("Sunflora", 192, Type.GRASS, Type.NONE, 75, 75, 55, 105, 85, 30, 146, ExpCurve.MEDIUM_SLOW),
    YANMA("Yanma", 193, Type.BUG, Type.FLYING, 65, 65, 45, 75, 45, 95, 147, ExpCurve.MEDIUM_FAST),
    WOOPER("Wooper", 194, Type.WATER, Type.GROUND, 55, 45, 45, 25, 25, 15, 52, ExpCurve.MEDIUM_FAST),
    QUAGSIRE("Quagsire", 195, Type.WATER, Type.GROUND, 95, 85, 85, 65, 65, 35, 137, ExpCurve.MEDIUM_FAST),
    ESPEON("Espeon", 196, Type.PSYCHIC, Type.NONE, 65, 65, 60, 130, 95, 110, 197, ExpCurve.MEDIUM_FAST),
    UMBREON("Umbreon", 197, Type.DARK, Type.NONE, 95, 65, 110, 60, 130, 65, 197, ExpCurve.MEDIUM_FAST),
    MURKROW("Murkrow", 198, Type.DARK, Type.FLYING, 60, 85, 42, 85, 42, 91, 107, ExpCurve.MEDIUM_SLOW),
    SLOWKING("Slowking", 199, Type.WATER, Type.PSYCHIC, 95, 75, 80, 100, 110, 30, 164, ExpCurve.MEDIUM_FAST),
    MISDREAVUS("Misdreavus", 200, Type.GHOST, Type.NONE, 60, 60, 60, 85, 85, 85, 147, ExpCurve.FAST),
    UNOWN("Unown", 201, Type.PSYCHIC, Type.NONE, 48, 72, 48, 72, 48, 48, 61, ExpCurve.MEDIUM_FAST),
    WOBBUFFET("Wobbuffet", 202, Type.PSYCHIC, Type.NONE, 190, 33, 58, 33, 58, 33, 177, ExpCurve.MEDIUM_FAST),
    GIRAFARIG("Girafarig", 203, Type.NORMAL, Type.PSYCHIC, 70, 80, 65, 90, 65, 85, 149, ExpCurve.MEDIUM_FAST),
    PINECO("Pineco", 204, Type.BUG, Type.NONE, 50, 65, 90, 35, 35, 15, 60, ExpCurve.MEDIUM_FAST),
    FORRETRESS("Forretress", 205, Type.BUG, Type.STEEL, 75, 90, 140, 60, 60, 40, 118, ExpCurve.MEDIUM_FAST),
    DUNSPARCE("Dunsparce", 206, Type.NORMAL, Type.NONE, 100, 70, 70, 65, 65, 45, 75, ExpCurve.MEDIUM_FAST),
    GLIGAR("Gligar", 207, Type.GROUND, Type.FLYING, 65, 75, 105, 35, 65, 85, 108, ExpCurve.MEDIUM_SLOW),
    STEELIX("Steelix", 208, Type.STEEL, Type.GROUND, 75, 85, 200, 55, 65, 30, 196, ExpCurve.MEDIUM_FAST),
    SNUBBULL("Snubbull", 209, Type.NORMAL, Type.NONE, 60, 80, 50, 40, 40, 30, 63, ExpCurve.FAST),
    GRANBULL("Granbull", 210, Type.NORMAL, Type.NONE, 90, 120, 75, 60, 60, 45, 178, ExpCurve.FAST),
    QWILFISH("Qwilfish", 211, Type.WATER, Type.POISON, 65, 95, 75, 55, 55, 85, 100, ExpCurve.MEDIUM_FAST),
    SCIZOR("Scizor", 212, Type.BUG, Type.STEEL, 70, 130, 100, 55, 80, 65, 200, ExpCurve.MEDIUM_FAST),
    SHUCKLE("Shuckle", 213, Type.BUG, Type.ROCK, 20, 10, 230, 10, 230, 5, 80, ExpCurve.MEDIUM_SLOW),
    HERACROSS("Heracross", 214, Type.BUG, Type.FIGHTING, 80, 125, 75, 40, 95, 85, 200, ExpCurve.SLOW),
    SNEASEL("Sneasel", 215, Type.DARK, Type.ICE, 55, 95, 55, 35, 75, 115, 132, ExpCurve.MEDIUM_SLOW),
    TEDDIURSA("Teddiursa", 216, Type.NORMAL, Type.NONE, 60, 80, 50, 50, 50, 40, 124, ExpCurve.MEDIUM_FAST),
    URSARING("Ursaring", 217, Type.NORMAL, Type.NONE, 90, 130, 75, 75, 75, 55, 189, ExpCurve.MEDIUM_FAST),
    SLUGMA("Slugma", 218, Type.FIRE, Type.NONE, 40, 40, 40, 70, 40, 20, 78, ExpCurve.MEDIUM_FAST),
    MAGCARGO("Magcargo", 219, Type.FIRE, Type.ROCK, 50, 50, 120, 80, 80, 30, 154, ExpCurve.MEDIUM_FAST),
    SWINUB("Swinub", 220, Type.ICE, Type.GROUND, 50, 50, 40, 30, 30, 50, 78, ExpCurve.SLOW),
    PILOSWINE("Piloswine", 221, Type.ICE, Type.GROUND, 100, 100, 80, 60, 60, 50, 160, ExpCurve.SLOW),
    CORSOLA("Corsola", 222, Type.WATER, Type.ROCK, 55, 55, 85, 65, 85, 35, 113, ExpCurve.FAST),
    REMORAID("Remoraid", 223, Type.WATER, Type.NONE, 35, 65, 35, 65, 35, 65, 78, ExpCurve.MEDIUM_FAST),
    OCTILLERY("Octillery", 224, Type.WATER, Type.NONE, 75, 105, 75, 105, 75, 45, 164, ExpCurve.MEDIUM_FAST),
    DELIBIRD("Delibird", 225, Type.ICE, Type.FLYING, 45, 55, 45, 65, 45, 75, 183, ExpCurve.FAST),
    MANTINE("Mantine", 226, Type.WATER, Type.FLYING, 65, 40, 70, 80, 140, 70, 168, ExpCurve.SLOW),
    SKARMORY("Skarmory", 227, Type.STEEL, Type.FLYING, 65, 80, 140, 40, 70, 70, 168, ExpCurve.SLOW),
    HOUNDOUR("Houndour", 228, Type.DARK, Type.FIRE, 45, 60, 30, 80, 50, 65, 114, ExpCurve.SLOW),
    HOUNDOOM("Houndoom", 229, Type.DARK, Type.FIRE, 75, 90, 50, 110, 80, 95, 204, ExpCurve.SLOW),
    KINGDRA("Kingdra", 230, Type.WATER, Type.DRAGON, 75, 95, 95, 95, 95, 85, 207, ExpCurve.MEDIUM_FAST),
    PHANPY("Phanpy", 231, Type.GROUND, Type.NONE, 90, 60, 60, 40, 40, 40, 124, ExpCurve.MEDIUM_FAST),
    DONPHAN("Donphan", 232, Type.GROUND, Type.NONE, 90, 120, 120, 60, 60, 50, 189, ExpCurve.MEDIUM_FAST),
    PORYGON2("Porygon2", 233, Type.NORMAL, Type.NONE, 85, 80, 90, 105, 95, 60, 180, ExpCurve.MEDIUM_FAST),
    STANTLER("Stantler", 234, Type.NORMAL, Type.NONE, 73, 95, 62, 85, 65, 85, 165, ExpCurve.SLOW),
    SMEARGLE("Smeargle", 235, Type.NORMAL, Type.NONE, 55, 20, 35, 20, 45, 75, 106, ExpCurve.FAST),
    TYROGUE("Tyrogue", 236, Type.FIGHTING, Type.NONE, 35, 35, 35, 35, 35, 35, 91, ExpCurve.MEDIUM_FAST),
    HITMONTOP("Hitmontop", 237, Type.FIGHTING, Type.NONE, 50, 95, 95, 35, 110, 70, 138, ExpCurve.MEDIUM_FAST),
    SMOOCHUM("Smoochum", 238, Type.ICE, Type.PSYCHIC, 45, 30, 15, 85, 65, 65, 87, ExpCurve.MEDIUM_FAST),
    ELEKID("Elekid", 239, Type.ELECTRIC, Type.NONE, 45, 63, 37, 65, 55, 95, 106, ExpCurve.MEDIUM_FAST),
    MAGBY("Magby", 240, Type.FIRE, Type.NONE, 45, 75, 37, 70, 55, 83, 117, ExpCurve.MEDIUM_FAST),
    MILTANK("Miltank", 241, Type.NORMAL, Type.NONE, 95, 80, 105, 40, 70, 100, 200, ExpCurve.SLOW),
    BLISSEY("Blissey", 242, Type.NORMAL, Type.NONE, 255, 10, 10, 75, 135, 55, 255, ExpCurve.FAST),
    RAIKOU("Raikou", 243, Type.ELECTRIC, Type.NONE, 90, 85, 75, 115, 100, 115, 216, ExpCurve.SLOW),
    ENTEI("Entei", 244, Type.FIRE, Type.NONE, 115, 115, 85, 90, 75, 100, 217, ExpCurve.SLOW),
    SUICUNE("Suicune", 245, Type.WATER, Type.NONE, 100, 75, 115, 90, 115, 85, 215, ExpCurve.SLOW),
    LARVITAR("Larvitar", 246, Type.ROCK, Type.GROUND, 50, 64, 50, 45, 50, 41, 67, ExpCurve.SLOW),
    PUPITAR("Pupitar", 247, Type.ROCK, Type.GROUND, 70, 84, 70, 65, 70, 51, 144, ExpCurve.SLOW),
    TYRANITAR("Tyranitar", 248, Type.ROCK, Type.DARK, 100, 134, 110, 95, 100, 61, 218, ExpCurve.SLOW),
    LUGIA("Lugia", 249, Type.PSYCHIC, Type.FLYING, 106, 90, 130, 90, 154, 110, 220, ExpCurve.SLOW),
    HOOH("Ho-Oh", 250, Type.FIRE, Type.FLYING, 106, 130, 90, 110, 154, 90, 220, ExpCurve.SLOW),
    CELEBI("Celebi", 251, Type.PSYCHIC, Type.GRASS, 100, 100, 100, 100, 100, 100, 64, ExpCurve.MEDIUM_SLOW);

    private String name;
    private int dexNum;
    private Type type1;
    private Type type2;
    private int baseHP;
    private int baseAtk;
    private int baseDef;
    private int baseSpcAtk;
    private int baseSpcDef;
    private int baseSpd;
    private int killExp;
    private ExpCurve expCurve;

    Species(String name, int dexNum, Type type1, Type type2, int baseHP, int baseAtk, int baseDef, int baseSpcAtk,
            int baseSpcDef, int baseSpd, int killExp, ExpCurve expCurve) {
        this.name = name;
        this.dexNum = dexNum;
        this.type1 = type1;
        this.type2 = type2;
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpcAtk = baseSpcAtk;
        this.baseSpcDef = baseSpcDef;
        this.baseSpd = baseSpd;
        this.killExp = killExp;
        this.expCurve = expCurve;
    }

    public String getName() {
        return name;
    }

    public int getDexNum() {
        return dexNum;
    }

    public Type getType1() {
        return type1;
    }

    public Type getType2() {
        return type2;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public int getBaseSpcAtk() {
        return baseSpcAtk;
    }

    public int getBaseSpcDef() {
        return baseSpcDef;
    }

    public int getBaseSpd() {
        return baseSpd;
    }

    public int getKillExp() {
        return killExp;
    }

    public ExpCurve getExpCurve() {
        return expCurve;
    }
}
