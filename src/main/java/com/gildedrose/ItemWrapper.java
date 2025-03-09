package com.gildedrose;

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

    private static void validateItem(Item item) {
        if (item == null) {
            throw new GildedRoseProductException("Null Item is not allowed to create ItemWrapper");
        }
    }

    public Item getItem() {
        return item;
    }

    public ProductType getProductType() {
        return productType;
    }
}
