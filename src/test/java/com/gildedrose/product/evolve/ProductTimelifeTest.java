package com.gildedrose.product.evolve;

import com.gildedrose.ItemBuilder;
import com.gildedrose.exceptions.GildedRoseProductException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static com.gildedrose.testutils.ProductNameTestUtils.AGED_BRIE_NAME;


public class ProductTimelifeTest {

    private ProductTimeLife productTimelife;
    private ProductEvolve productEvolve;

    @BeforeEach
    public void init() {
        productEvolve = Mockito.mock(ProductEvolve.class);
        productTimelife = new ProductTimeLife(productEvolve);
    }

    @Test
    public void aging_item_call_updateSellIn_and_then_updateQuality_of_ProductEvolve_implementation() {
        productTimelife.apply(givenItemWrapper());

        InOrder productEvolveVerifier = Mockito.inOrder(productEvolve);
        productEvolveVerifier.verify(productEvolve, Mockito.times(1)).getNextSellInValue(Mockito.any(ItemWrapper.class));
        productEvolveVerifier.verify(productEvolve, Mockito.times(1)).getNextQualityValue(Mockito.any(ItemWrapper.class));
    }

    @Test
    public void new_ProductTimelife_throws_GiledRoseProductException_when_productEvolve_is_null() {
        Assertions.assertThrows(GildedRoseProductException.class, () -> new ProductTimeLife(null));
    }

    private ItemWrapper givenItemWrapper() {
        return new ItemWrapper(
            ItemBuilder
                .builder()
                .name(AGED_BRIE_NAME)
                .sellIn(10)
                .quality(15)
                .build());
    }
}
