package gume;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutoGumaTest {
	
	AutoGuma ag;

	@Before
	public void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@After
	public void tearDown() throws Exception {
		ag = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelNull() {
		ag.setMarkaModel(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelManjeOd3() {
		ag.setMarkaModel("BM");
	}
	
	@Test
	public void testSetMarkaModelVeceOd3() {
		ag.setMarkaModel("Pollo");
		assertEquals("Pollo", ag.getMarkaModel());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikVanOpsega() {
		ag.setPrecnik(10);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPrecnikVanOpsega2() {
		ag.setPrecnik(100);
	}
	
	@Test 
	public void testSetPrecnikUOpsegu() {
		ag.setPrecnik(15);
		assertEquals(15, ag.getPrecnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSirinaVanOpsega() {
		ag.setSirina(50);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSirinaVanOpsega2() {
		ag.setSirina(1000);
	}
	
	@Test
	public void testSetSirinaUOpsegu() {
		ag.setSirina(300);
		assertEquals(300, ag.getSirina());	
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVisinaVanOpsega() {
		ag.setVisina(20);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetVisinaVanOpsega2() {
		ag.setVisina(300);
	}
	
	@Test
	public void testSetVisinaUOpsegu() {
		ag.setVisina(50);
		assertEquals(50, ag.getVisina());
	}

	@Test
	public void testToStringMarkaModela() {
		ag.setMarkaModel("Pollo");
		
		String s = ag.toString();
		
		assertTrue(s.contains("Pollo"));
	}
	
	@Test
	public void testToStringPrecnik() {
		ag.setPrecnik(20);
		
		String s = ag.toString();
		
		assertTrue(s.contains("20"));
	}
	
	@Test
	public void testToStringMarkaSirina() {
		ag.setSirina(150);
		
		String s = ag.toString();
		
		assertTrue(s.contains("150"));
	}
	
	@Test
	public void testToStringMarkaVisina() {
		ag.setVisina(30);
		
		String s = ag.toString();
		
		assertTrue(s.contains("30"));
	}

	@Test
	public void testEqualsObjectNULL() {
		assertFalse(ag.equals(null));
	}
	
	@Test
	public void testEqualsObjectPogresnaKlasa() {
		assertFalse( ag.equals(new Object() ) );
	}
	
	@Test
	public void testEqualsObjectSviIsti() {
		ag.setMarkaModel("Pollo");
		ag.setPrecnik(20);
		ag.setSirina(150);
		ag.setVisina(50);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Pollo");
		ag2.setPrecnik(20);
		ag2.setSirina(150);
		ag2.setVisina(50);

		assertTrue( ag.equals(ag2) );	
	}
	
	@Test
	public void testEqualsObjectSviRazliciti() {
		ag.setMarkaModel("Pollo");
		ag.setPrecnik(20);
		ag.setSirina(150);
		ag.setVisina(50);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Polllooo");
		ag2.setPrecnik(20);
		ag2.setSirina(150);
		ag2.setVisina(50);

		assertFalse( ag.equals(ag2) );	
	}

}
