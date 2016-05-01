package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpearTest {

	Spear spear;
	
	@Before
	public void setUp() throws Exception {
		spear = new Spear();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(3, spear.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(0, spear.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(false, spear.isArmorPiercing());
	}
}