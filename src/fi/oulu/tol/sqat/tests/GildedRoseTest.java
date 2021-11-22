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
	
}