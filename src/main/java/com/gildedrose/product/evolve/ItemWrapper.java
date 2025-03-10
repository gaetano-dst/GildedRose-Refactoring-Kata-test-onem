package com.gildedrose.product.evolve;

import com.gildedrose.Item;
import com.gildedrose.ProductType;
import com.gildedrose.exceptions.GildedRoseProductException;
import com.gildedrose.utils.ItemUtils;

import static com.gildedrose.ProductType.fromName;


/**
 * Item class may not be modified by requirements !
 * This wrapper allow to get immutable Item
 */
public class ItemWrapper {

    private final ProductType productType;
    private final Item item;

    public ItemWrapper(Item item) {
        validateItem(item);
        this.productType = fromName(item.name);
        this.item = ItemUtils.getCopy(item);
    }

    public int getQuality() {
        return this.item.quality;
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public String getName() {
        return this.item.name;
    }

    public ProductType getProductType() {
        return productType;
    }

    void updateSellIn(int sellIn) {
        this.item.sellIn = sellIn;
    }

    void updateQuality(int quality) {
        this.item.quality = quality;
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new GildedRoseProductException("Null Item is not allowed to create ItemWrapper");
        }
    }

}
