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
		shield.transferAndReturnUnused(Shield.MAX_ENERGY - shield.energy());
		Assert.assertEquals(Shield.MAX_ENERGY, shield.energy());
	} 
	
	@Test public void canTransfer_MoreThanMaxAmtAndGetBackRemainder() {
		int remain = shield.transferAndReturnUnused(6000);
		Assert.assertEquals(1000, remain);
		Assert.assertEquals(Shield.MAX_ENERGY, shield.energy());
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
		int expectedRemainingEnergy = 1000;
		shield.raise();
		int actualRemainingEnergy = shield.takeHit(Shield.MAX_ENERGY - shield.energy() + expectedRemainingEnergy);
		Assert.assertEquals(0, shield.energy());
		Assert.assertEquals(expectedRemainingEnergy, actualRemainingEnergy);
		Assert.assertFalse(shield.isUp());
		
		// Damage random subsystem
		int totalSubsystemEnergyBefore = parent.getTotalSubsystemEnergy();
		parent.damageSubsystem(actualRemainingEnergy);
		Assert.assertEquals(totalSubsystemEnergyBefore - actualRemainingEnergy, parent.getTotalSubsystemEnergy());
		
	}
	
	Shield shield;
}
