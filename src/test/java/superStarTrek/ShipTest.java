package superStarTrek;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	@Before
	public void init() {
		ship = new Ship(new Random(1));
	}
	
	@Test
	public void canInitialize() {
		
	}
	
	@Test
	public void canCauseDamageToRandomSubsystem() {
		ship.causeDamage(1000);
		Assert.assertEquals(100, ship.getSubsystems().get(Ship.SubsystemNames.Torpedo).getDamage());
	}
	
	Ship ship;
}
