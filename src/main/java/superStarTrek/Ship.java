package superStarTrek;

import java.util.HashMap;
import java.util.Map;

public class Ship {
	public Ship() {
		subsystems = new HashMap<String, Subsystem>();
		subsystems.put(SubsystemNames.Phaser, new Subsystem());
		subsystems.put(SubsystemNames.Torpedo, new Subsystem());
		subsystems.put(SubsystemNames.Shield, new Shield());
		subsystems.put(SubsystemNames.Engine, new Subsystem());
	}
	
	public Map<String, Subsystem> getSubsystems() {
		return subsystems;
	}
	
	public void setSubsystems(Map<String, Subsystem> subsystems) {
		this.subsystems = subsystems;
	}

	public class SubsystemNames {
		public static final String Phaser = "Phaser";
		public static final String Torpedo = "Torpedo";
		public static final String Shield = "Shield";
		public static final String Engine = "Engine";
	}
	
	private Map<String, Subsystem> subsystems;
	private int energy = 8000;
}
