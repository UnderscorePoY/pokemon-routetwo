
public enum Weather {
	NONE, RAIN, SUN, SANDSTORM;
	
	public static Weather getWeatherFromName(String s) {
		for(Weather w : Weather.values()) {
			if("0".equals(s)) return NONE;
			
			if(w.toString().equalsIgnoreCase(s))
				return w;
		}
		
		return null;
	}

	public static Weather[] getEmptyArray() {
		return new Weather[] {NONE, NONE, NONE, NONE, NONE, NONE};
	}
	
	public static Weather[] getUniqueArray(Weather w) {
		if(w == null)
			return getEmptyArray();
		
		return new Weather[] {w, w, w, w, w, w};
	}
}
