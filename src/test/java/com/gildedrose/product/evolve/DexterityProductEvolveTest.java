package com.gildedrose.product.evolve;

import com.gildedrose.ItemWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.builder;
import static com.gildedrose.testutils.ProductNameTestUtils.DEXTERITY_NAME;

public class DexterityProductEvolveTest {

    private final DexterityProductEvolve dexterityProductEvolve = new DexterityProductEvolve();

    @Test
    public void getNextSellInValue_decrements_sellIn_by_1() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(DEXTERITY_NAME)
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(2, dexterityProductEvolve.getNextSellInValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_decrements_quality_by_2_when_sellIn_less_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(DEXTERITY_NAME)
            .sellIn(-1)
            .quality(10)
            .build());

        Assertions.assertEquals(8, dexterityProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_decrements_quality_by_1_when_sellIn_more_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(DEXTERITY_NAME)
            .sellIn(10)
            .quality(10)
            .build());

        Assertions.assertEquals(9, dexterityProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_never_gives_quality_less_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(DEXTERITY_NAME)
            .sellIn(-1)
            .quality(1)
            .build());

        Assertions.assertEquals(0, dexterityProductEvolve.getNextQualityValue(itemWrapper));
    }
}

