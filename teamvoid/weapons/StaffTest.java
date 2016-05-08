package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaffTest {

	Staff staff;
	
	@Before
	public void setUp() throws Exception {
		staff = new Staff();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(0, staff.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(2, staff.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(false, staff.isArmorPiercing());
	}
}