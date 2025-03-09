package com.gildedrose.product.evolve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.builder;

public class StandardProductEvolveTest {

    private final StandardProductEvolve standardProductEvolve = new StandardProductEvolve();

    @Test
    public void getNextSellInValue_decrements_sellIn_by_1() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name("OTHER")
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(2, standardProductEvolve.getNextSellInValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_decrements_quality_by_1() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name("OTHER")
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(9, standardProductEvolve.getNextQualityValue(itemWrapper));
    }
}
