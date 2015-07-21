package superStarTrek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ship {
	
	private LinkedHashMap<String, Subsystem> subsystems;
	private int energy = 8000;
	private Random generator;
	
	public Ship(Random generator) {
		subsystems = new LinkedHashMap<String, Subsystem>();
		subsystems.put(SubsystemNames.Phaser, new Phaser());
		subsystems.put(SubsystemNames.Torpedo, new Phaser());
		subsystems.put(SubsystemNames.Engine, new Engine());
		subsystems.put(SubsystemNames.Shield, new Shield());
		this.generator = generator;
	}
	
	public Map<String, Subsystem> getSubsystems() {
		return subsystems;
	}
	
	public void setSubsystems(LinkedHashMap<String, Subsystem> subsystems) {
		this.subsystems = subsystems;
	}

	public class SubsystemNames {
		public static final String Phaser = "Phaser";
		public static final String Torpedo = "Torpedo";
		public static final String Shield = "Shield";
		public static final String Engine = "Engine";
	}
	
	public void causeDamage(int damageAmt) {
		int r = generator.next(subsystems.size() - 1);
		Subsystem subsystem = new ArrayList<Subsystem>(subsystems.values()).get(r);
		subsystem.causeDamage(damageAmt);
	}
	
}
