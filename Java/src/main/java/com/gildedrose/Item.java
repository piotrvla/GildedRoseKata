package com.gildedrose;

public class Item {
    final String AGED_BRIE = "Aged Brie";
    final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    final String CONJURED = "Conjured";
    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        if(name==null || name.length()==0)
            throw new IllegalArgumentException("Cannot be empty or null.");
        if(sellIn<0)
            // it is not mentioned in requirements
            throw new IllegalArgumentException("Cannot list expired items");
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality(){

        if(name.equals(AGED_BRIE)){
            increaseQuality();
        }
        else if(name.equals(BACKSTAGE)){
            manageBackstagePass();
        }else if(isNormalItem()){
            decreaseQuality();
            if(this.name.split(" ")[0].equals(CONJURED))
                decreaseQuality();
        }

        if(!name.equals(SULFURAS)){
            decreaseSellIn();
        }

        if(this.sellIn<0){
            if(isNormalItem())
                decreaseQuality();
            else if (name.equals(BACKSTAGE))
                this.quality=0;
            else if(name.equals(AGED_BRIE))
                increaseQuality();
        }
    }
    public String getName(){
        return this.name;
    }

    public int getQuality() {
        return this.quality;
    }
    public int getSellIn(){
        return this.sellIn;
    }

    private void increaseQuality(){
        if (this.quality < 50) {
            this.quality++;
        }
    }
    private void decreaseQuality(){
        if(this.quality>0)
            this.quality--;
    }
    private void decreaseSellIn(){
        this.sellIn--;
    }
    private void manageBackstagePass(){
        increaseQuality();

        if (this.sellIn < 11) {
            increaseQuality();
        }

        if (this.sellIn < 6) {
            increaseQuality();
        }
    }
    private boolean isNormalItem(){
        return !this.name.equals("Backstage passes to a TAFKAL80ETC concert")
            && !this.name.equals("Sulfuras, Hand of Ragnaros") && !this.name.equals("Aged Brie");
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
