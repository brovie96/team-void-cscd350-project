package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RingTest {

	Ring ring;
	
	@Before
	public void setUp() throws Exception {
		ring = new Ring();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(0, ring.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(1, ring.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(false, ring.isArmorPiercing());
	}
}