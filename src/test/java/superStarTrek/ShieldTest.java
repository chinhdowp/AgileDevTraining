package superStarTrek;
import org.junit.*;

import superStarTrek.Shield;

public class ShieldTest {
	@Before
	public void init() {
		shield = new Shield();
	}
	
	@Test
	public void canInitialize() {
		Assert.assertFalse(shield.isUp());
		Assert.assertEquals(5000, shield.energy());
	}
	
	@Test
	public void canRaiseShield() {
		shield.raise();
		Assert.assertTrue(shield.isUp());
	}
		
	@Test
	public void canTransferEnergy_0() {
		int prevEnergy = shield.energy();
		shield.transferAndReturnUnused(0);
		Assert.assertEquals(prevEnergy, shield.energy());
	}
	
	@Test
	public void canTransferEnergy_1() {
		int xFerAmt = 1;
		int prevEnergy = shield.energy();
		shield.transferAndReturnUnused(xFerAmt);
		Assert.assertEquals(prevEnergy + xFerAmt, shield.energy());
	}
	
	@Test
	public void canTransferEnergy_UpToMaxAmt() {
		int prevEnergy = shield.energy();
		shield.transferAndReturnUnused(Shield.MAX_ENERGY - shield.energy());
		Assert.assertEquals(Shield.MAX_ENERGY, shield.energy());
	} 
	
	@Test public void canTransfer_MoreThanMaxAmtAndGetBackRemainder() {
		int remain = shield.transferAndReturnUnused(6000);
		Assert.assertEquals(1000, remain);
		Assert.assertEquals(Subsystem.MAX_ENERGY, shield.energy());
	}
	
	@Test
	public void canTakeAHit_1() {
		shield.raise();
		int extraDamage = shield.takeHit(1);
		Assert.assertEquals(Shield.INITIAL_ENERGY - 1, shield.energy());
		Assert.assertEquals(0, extraDamage);
	}
	
	@Test
	public void canTakeAHit_AndReturnExtra() {
		int expectedExtra = 1000;
		shield.raise();
		int actualExtra = shield.takeHit(Shield.MAX_ENERGY - shield.energy() + expectedExtra);
		Assert.assertEquals(0, shield.energy());
		Assert.assertEquals(expectedExtra, actualExtra);
		Assert.assertFalse(shield.isUp());
	}
	
	Shield shield;
}
