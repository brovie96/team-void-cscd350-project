package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EvilPotTest {

	EvilPot evilPot;
	
	@Before
	public void setUp() throws Exception {
		evilPot = new EvilPot();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(0, evilPot.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(2, evilPot.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(false, evilPot.isArmorPiercing());
	}
}
