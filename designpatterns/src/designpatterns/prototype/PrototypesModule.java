package designpatterns.prototype;

import java.util.HashSet;

public class PrototypesModule {
	private static HashSet<Prototype> prototypesList = new HashSet<Prototype>();
	
	public static void registerPrototype(Prototype proto) {
		prototypesList.add(proto);
	}
	
	public static Object clone(String name) {
		for(Prototype tmp : prototypesList) {
			if(name.equalsIgnoreCase(tmp.getName())) {
				return tmp.clone();
			}
		}
		
		return null;
	}
}
