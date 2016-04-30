package teamvoid.weapons;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FireSpellbookTest {

	FireSpellbook fireSpellbook;
	
	@Before
	public void setUp() throws Exception {
		fireSpellbook = new FireSpellbook();
	}

	@Test
	public void testGetAttackBoost() {
		assertEquals(0, fireSpellbook.getAttackBoost());
	}

	@Test
	public void testGetMagicPowerBoost() {
		assertEquals(2, fireSpellbook.getMagicPowerBoost());
	}

	@Test
	public void testIsArmorPiercing() {
		assertEquals(true, fireSpellbook.isArmorPiercing());
	}
}