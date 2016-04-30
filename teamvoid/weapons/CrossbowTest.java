package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CrossbowTest {

	Crossbow crossbow;
	
	@Before
	public void setUp() throws Exception {
		crossbow = new Crossbow();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(1, crossbow.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(0, crossbow.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(true, crossbow.isArmorPiercing());
	}

}
