package com.gildedrose.product.evolve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.builder;
import static com.gildedrose.testutils.ProductNameTestUtils.BACKSTAGE_NAME;

public class BackstageProductEvolveTest {

    private final BackstageProductEvolve backstageProductEvolve = new BackstageProductEvolve();

    @Test
    public void getNextSellInValue_decrements_sellIn_by_1() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(2, backstageProductEvolve.getNextSellInValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_1_when_sellIn_more_than_10() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(15)
            .quality(10)
            .build());

        Assertions.assertEquals(11, backstageProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_2_when_sellIn_equals_10() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(10)
            .quality(10)
            .build());

        Assertions.assertEquals(12, backstageProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_2_when_sellIn_more_than_5_and_less_than_10() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(7)
            .quality(10)
            .build());

        Assertions.assertEquals(12, backstageProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_3_when_sellIn_equals_5() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(5)
            .quality(10)
            .build());

        Assertions.assertEquals(13, backstageProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_increments_quality_by_3_when_sellIn_less_than_5() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(4)
            .quality(10)
            .build());

        Assertions.assertEquals(13, backstageProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_never_gives_quality_more_than_50() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(BACKSTAGE_NAME)
            .sellIn(2)
            .quality(50)
            .build());

        Assertions.assertEquals(50, backstageProductEvolve.getNextQualityValue(itemWrapper));
    }
}

