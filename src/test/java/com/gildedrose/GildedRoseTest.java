package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.builder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String FOO_PRODUCT_NAME = "foo";

    @Test
    void updateQuality_does_not_alter_item_name() {
        Item[] items = new Item[] {
            builder()
            .name(FOO_PRODUCT_NAME)
            .sellIn(0)
            .quality(0)
            .build()
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(FOO_PRODUCT_NAME, app.getItems()[0].name);
    }

}
