package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isSulfuras(items[i])) {
                continue;
            }

            if (isDefaultProduct(items[i])) {
                decreaseQuality(items[i]);
            } else {
                increaseQuality(items[i]);
                updateBackstagePass(items[i]);
            }

            decreaseSellIn(items[i]);

            if (items[i].sellIn < 0) {
                updateQuality(items[i]);
            }
        }
    }

    private void updateQuality(Item item) {
        if (isNotAgedBrie(item)) {
            if (!isBackstagePass(item)) {
                decreaseQuality(item);
            } else {
                item.quality = 0;
            }
        } else {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateBackstagePass(Item item) {
        if (isBackstagePass(item)) {
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isNotAgedBrie(Item item) {
        return !item.name.equals("Aged Brie");
    }

    private boolean isNotSulfuras(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isDefaultProduct(Item item) {
        return isNotAgedBrie(item)
            && !isBackstagePass(item);
    }

    private static boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}
