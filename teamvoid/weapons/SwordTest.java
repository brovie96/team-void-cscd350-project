package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SwordTest {

	Sword sword;
	
	@Before
	public void setUp() throws Exception {
		sword = new Sword();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(2, sword.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(0, sword.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(false, sword.isArmorPiercing());
	}
}