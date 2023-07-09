package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    public void checkInitialization(){
        Item[] items = new Item[] { new Item("Stronk Hammer", 5, 2),
            new Item("XDF05",2,8) };
        GildedRose app = new GildedRose(items);
        assertEquals(app.items,items);
    }
    @Test
    public void itemQualityNeverNegative(){
        Item[] items = new Item[] { new Item("Bowwy bow", 4, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].getQuality());
    }
    @Test
    public void checkSulfurasIfQualityChanges(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80,app.items[0].getQuality());
    }
    @Test
    public void decreasedValueConjuredItem(){
        Item[] items = new Item[] { new Item("Conjured Wand", 5, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].getQuality());
    }
    @Test
    public void decreasedValueConjuredItemExpired(){
        Item[] items = new Item[] { new Item("Conjured Axe", 0, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22,app.items[0].getQuality());
    }
    @Test
    public void increasedValueOfAgedBrieWhileSellInDecreases(){
        Item[] items = new Item[] { new Item("Aged Brie", 8, 14) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(15,app.items[0].getQuality());
    }
    @Test
    public void increasedValueOfAgedBrieWhileMultipleDaysPassed(){
        Item[] items = new Item[] { new Item("Aged Brie", 8, 14) };
        GildedRose app = new GildedRose(items);
        for(int i =0; i<5;i++){
            app.updateQuality();
        }
        assertEquals(19,app.items[0].getQuality());
    }
    @Test
    public void increasedValueOfAgedBrieWhenExpires(){
        Item[] items = new Item[] { new Item("Aged Brie", 8, 14) };
        GildedRose app = new GildedRose(items);
        for(int i =0; i<8;i++){
            app.updateQuality();
        }
        assertEquals(22,app.items[0].getQuality());
    }
    @Test
    public void increasedValueOfAgedBrieWhenExpired(){
        Item[] items = new Item[] { new Item("Aged Brie", 8, 14) };
        GildedRose app = new GildedRose(items);
        for(int i =0; i<10;i++){
            app.updateQuality();
        }
        assertEquals(26,app.items[0].getQuality());
    }
    @Test
    public void backstageTenDaysBefore(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22,app.items[0].getQuality());
    }
    @Test
    public void backstageFiveDaysBefore(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 14) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(16,app.items[0].getQuality());
        }

    @Test
    public void backstageTwoDaysBefore() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 14)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17, app.items[0].getQuality());
    }
    @Test
    public void backstageExpires(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 14) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(17,app.items[0].getQuality());
    }
    @Test
    public void backstageExpired(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 14) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].getQuality());
    }
    @Test
    public void backstageQualityAt47IncreasesBy3(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 47) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].getQuality());
    }
    @Test
    public void backstageQualityAt49IncreasesBy3(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].getQuality());
    }
    @Test
    public void backstageMultipleDaysPassedByExpired(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 14) };
        GildedRose app = new GildedRose(items);
        for(int i =0;i<8;i++)
            app.updateQuality();
        assertEquals(0,app.items[0].getQuality());
    }

}
