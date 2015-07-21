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
		Assert.assertEquals(5000, shield.getEnergy());
	}
	
	@Test
	public void canRaiseShield() {
		shield.raise();
		Assert.assertTrue(shield.isUp());
	}
		
	@Test
	public void canTransferEnergy_0() {
		int prevEnergy = shield.getEnergy();
		shield.transferAndReturnUnused(0);
		Assert.assertEquals(prevEnergy, shield.getEnergy());
	}
	
	@Test
	public void canTransferEnergy_1() {
		int xFerAmt = 1;
		int prevEnergy = shield.getEnergy();
		shield.transferAndReturnUnused(xFerAmt);
		Assert.assertEquals(prevEnergy + xFerAmt, shield.getEnergy());
	}
	
	@Test
	public void canTransferEnergy_UpToMaxAmt() {
		shield.transferAndReturnUnused(Shield.MAX_ENERGY - shield.getEnergy());
		Assert.assertEquals(Shield.MAX_ENERGY, shield.getEnergy());
	} 
	
	@Test public void canTransfer_MoreThanMaxAmtAndGetBackRemainder() {
		int remain = shield.transferAndReturnUnused(6000);
		Assert.assertEquals(1000, remain);
		Assert.assertEquals(Shield.MAX_ENERGY, shield.getEnergy());
	}
	
	@Test
	public void canTakeAHit_1() {
		shield.raise();
		int extraDamage = shield.takeHit(1);
		Assert.assertEquals(Shield.INITIAL_ENERGY - 1, shield.getEnergy());
		Assert.assertEquals(0, extraDamage);
	}
	
	@Test
	public void canTakeAHit_AndReturnExtra() {
		int expectedRemainingEnergy = 1000;
		shield.raise();
		int actualRemainingEnergy = shield.takeHit(Shield.MAX_ENERGY - shield.getEnergy() + expectedRemainingEnergy);
		Assert.assertEquals(0, shield.getEnergy());
		Assert.assertEquals(expectedRemainingEnergy, actualRemainingEnergy);
		Assert.assertFalse(shield.isUp());
		
		// Damage random subsystem
//		int totalSubsystemEnergyBefore = parent.getTotalSubsystemEnergy();
//		parent.damageSubsystem(actualRemainingEnergy);
//		Assert.assertEquals(totalSubsystemEnergyBefore - actualRemainingEnergy, parent.getTotalSubsystemEnergy());
		
	}
	
	Shield shield;
}
