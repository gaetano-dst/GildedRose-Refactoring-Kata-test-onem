package com.gildedrose.product.evolve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.builder;
import static com.gildedrose.testutils.ProductNameTestUtils.AGED_BRIE_NAME;

public class AgedBrieProductEvolveTest {

    private final AgedBrieProductEvolve agedBrieProductEvolve = new AgedBrieProductEvolve();

    @Test
    public void getNextSellInValue_decrements_sellIn_by_1() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(AGED_BRIE_NAME)
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(2, agedBrieProductEvolve.getNextSellInValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_2_when_sellIn_less_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(AGED_BRIE_NAME)
            .sellIn(-1)
            .quality(10)
            .build());

        Assertions.assertEquals(12, agedBrieProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_1_when_sellIn_more_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(AGED_BRIE_NAME)
            .sellIn(1)
            .quality(10)
            .build());

        Assertions.assertEquals(11, agedBrieProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_never_gives_quality_more_than_50() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(AGED_BRIE_NAME)
            .sellIn(2)
            .quality(50)
            .build());

        Assertions.assertEquals(50, agedBrieProductEvolve.getNextQualityValue(itemWrapper));
    }
}
