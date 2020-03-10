package gume.radnja;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gume.AutoGuma;

public class VulkanizerskaRadnjaTest {
	
	VulkanizerskaRadnja vr;
	AutoGuma ag1, ag2;

	@Before
	public void setUp() throws Exception {
		vr = new VulkanizerskaRadnja();
		
		ag1 = new AutoGuma();
		ag1.setMarkaModel("Pollo1");
		ag1.setPrecnik(20);
		ag1.setSirina(150);
		ag1.setVisina(50);
		
		ag2 = new AutoGuma();
		ag2.setMarkaModel("Pollo2");
		ag2.setPrecnik(21);
		ag2.setSirina(151);
		ag2.setVisina(51);
	}

	@After
	public void tearDown() throws Exception {
		vr = null;
		ag1 = null;
		ag2 = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajGumuNULL() {
		vr.dodajGumu(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajGumuVecPostoji() {
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag1);
	}
	
	@Test 
	public void testDodajGumu() {
		vr.dodajGumu(ag1);
		
		List<AutoGuma> sveGume = vr.gume;
		
		assertTrue(sveGume.size() == 1);
		assertEquals( ag1, sveGume.get(0) );
	}
	
	@Test 
	public void testDodajGumu2() {
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);
		
		List<AutoGuma> sveGume = vr.gume;
		
		assertTrue(sveGume.size() == 2);
		assertEquals( ag1, sveGume.get(0) );
		assertEquals( ag2, sveGume.get(1) );
	}
	

	@Test
	public void testPronadjiGumuNULL() {
		LinkedList<AutoGuma> rezultat = vr.pronadjiGumu(null);

		assertNull(rezultat);
	}
	
	@Test
	public void testPronadjiGumu() {
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);
		
		LinkedList<AutoGuma> rezultat = vr.pronadjiGumu("Pollo1");

		assertTrue(rezultat.size() == 1);
		assertEquals(ag1, rezultat.get(0) );	
	}
	
	@Test
	public void testPronadjiGumuNemaRezultata() {
		vr.dodajGumu(ag1);
		vr.dodajGumu(ag2);
		
		LinkedList<AutoGuma> rezultat = vr.pronadjiGumu("Pollo");
	
		assertNull(rezultat);
	}
	
	@Test
	public void testPronadjiGumuViseRezultata() {
		vr.dodajGumu(ag1);
		
		ag2.setMarkaModel("Pollo1");
		vr.dodajGumu(ag2);
		
		LinkedList<AutoGuma> rezultat = vr.pronadjiGumu("Pollo1");

		assertTrue(rezultat.size() == 2);
		assertEquals(ag1, rezultat.get(0) );
		assertEquals(ag2, rezultat.get(1) );	
	}

}
