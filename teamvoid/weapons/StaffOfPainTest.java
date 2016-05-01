package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaffOfPainTest {

	StaffOfPain staffOfPain;
	
	@Before
	public void setUp() throws Exception {
		staffOfPain = new StaffOfPain();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(0, staffOfPain.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(1, staffOfPain.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(true, staffOfPain.isArmorPiercing());
	}
}