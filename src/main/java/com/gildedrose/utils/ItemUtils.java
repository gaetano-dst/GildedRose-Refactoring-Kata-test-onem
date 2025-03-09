package com.gildedrose.utils;

import com.gildedrose.Item;
import com.gildedrose.ItemBuilder;

public class ItemUtils {

    private ItemUtils() {
    }

    public static Item getCopy(Item item) {
        return ItemBuilder
            .builder()
            .name(item.name)
            .sellIn(item.sellIn)
            .quality(item.quality)
            .build();
    }

}
