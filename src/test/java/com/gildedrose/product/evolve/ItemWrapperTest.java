package com.gildedrose.product.evolve;

import com.gildedrose.ItemBuilder;
import com.gildedrose.ProductType;
import com.gildedrose.exceptions.GildedRoseProductException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.testutils.ProductNameTestUtils.*;

class ItemWrapperTest {

    @Test
    void create_wrapper_give_GildedRoseProductException_when_item_is_null() {
        Assertions.assertThrows(GildedRoseProductException.class, () -> new ItemWrapper(null));
    }


    @Test
    void create_wrapper_give_item_with_same_properties_value() {
        ItemWrapper itemWrapper = new ItemWrapper(ItemBuilder.builder()
            .name(AGED_BRIE_NAME)
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals("Aged Brie", itemWrapper.getName());
        Assertions.assertEquals(0, itemWrapper.getSellIn());
        Assertions.assertEquals(10, itemWrapper.getQuality());
    }

    @Test
    void create_wrapper_give_ProductType_AGED_BRIE_when_name_is_Aged_Brie() {
        ItemWrapper itemWrapper = new ItemWrapper(ItemBuilder.builder()
            .name(AGED_BRIE_NAME)
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals(ProductType.AGED_BRIE, itemWrapper.getProductType());
    }

    @Test
    void create_wrapper_give_ProductType_BACKSTAGE_when_name_is_full_Backstage_name() {
        ItemWrapper itemWrapper = new ItemWrapper(ItemBuilder.builder()
            .name(BACKSTAGE_NAME)
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals(ProductType.BACKSTAGE, itemWrapper.getProductType());
    }

    @Test
    void create_wrapper_give_ProductType_DEXTERITY_when_name_is_full_Dexterity_name() {
        ItemWrapper itemWrapper = new ItemWrapper(ItemBuilder.builder()
            .name(DEXTERITY_NAME)
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals(ProductType.DEXTERITY, itemWrapper.getProductType());
    }

    @Test
    void create_wrapper_give_ProductType_ELIXIR_when_name_is_full_Elixir_name() {
        ItemWrapper itemWrapper = new ItemWrapper(ItemBuilder.builder()
            .name(ELIXIR_NAME)
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals(ProductType.ELIXIR, itemWrapper.getProductType());
    }

    @Test
    void create_wrapper_give_ProductType_SULFURAS_when_name_is_full_Sulfuras_name() {
        ItemWrapper itemWrapper = new ItemWrapper(ItemBuilder.builder()
            .name(SULFURAS_NAME)
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals(ProductType.SULFURAS, itemWrapper.getProductType());
    }


}
