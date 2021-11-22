package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void testMain() {
		GildedRose inn = new GildedRose();
		String[] args = null;
		GildedRose.main(args);
		
		List<Item> items = inn.getItems();
		int vestQuality = items.get(0).getQuality();
		int brieQuality = items.get(1).getQuality();
		int elixirQuality = items.get(2).getQuality();
		int sulfurasQuality = items.get(3).getQuality();
		int passQuality = items.get(4).getQuality();
		int cakeQuality = items.get(5).getQuality();
		
		assertEquals("Failed quality for Dexterity Vest", 19, vestQuality);
		assertEquals("Failed quality for Aged Brie", 1, brieQuality);
		assertEquals("Failed quality for Elixir of the Mongoose", 6, elixirQuality);
		assertEquals("Failed quality for Sulfuras, Hand of Ragnaros", 80, sulfurasQuality);
		assertEquals("Failed quality for Backstage passes to a TAFKAL80ETC concert", 21, passQuality);
		assertEquals("Failed quality for Conjured Mana Cake", 5, cakeQuality);
	}
	
	@Test
	public void testDoubleDegradation() {
		//create an inn, add an item, and simulate 4 days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));;
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by 5
		assertEquals("Failed quality for Mana Cake", 1, quality);
	}
	
	
	@Test
	public void testAgedBrie() {
		//create an inn, add an item, and simulate 3 days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));;
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by 4
		assertEquals("Failed quality for Aged Brie", 4, quality);
	}
	
	@Test
	public void testBackPasses() {
		//create an inn, add an item, and simulate 3 days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 25));;
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by 5
		assertEquals("Failed 1st quality check for Backstage passes", 30, quality);
		
		//simulate 4 more days
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		quality = items.get(0).getQuality();
		
		//assert quality has increased by 9
		assertEquals("Failed 2nd quality check for Backstage passes", 39, quality);
		
		//simulate 4 more days
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		quality = items.get(0).getQuality();
		
		//assert quality has increased by 12 and hit max value of 50
		assertEquals("Failed 3nd quality check for Backstage passes", 50, quality);
		
		//simulate 1 more days
		inn.oneDay();
		
		quality = items.get(0).getQuality();
		//assert quality has increased to 0
		assertEquals("Failed 4nd quality check for Backstage passes", 0, quality);
	}
}