package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GoblinClubTest {

	GoblinClub goblinClub;
	
	@Before
	public void setUp() throws Exception {
		goblinClub = new GoblinClub();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(1, goblinClub.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(0, goblinClub.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(false, goblinClub.isArmorPiercing());
	}
}