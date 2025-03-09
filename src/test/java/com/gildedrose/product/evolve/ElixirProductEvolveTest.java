package com.gildedrose.product.evolve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemBuilder.builder;
import static com.gildedrose.ProductType.ELIXIR;
import static com.gildedrose.testutils.ProductNameTestUtils.ELIXIR_NAME;

public class ElixirProductEvolveTest {

    private final ElixirProductEvolve elixirProductEvolve = new ElixirProductEvolve();

    @Test
    public void getNextSellInValue_decrements_sellIn_by_1() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(ELIXIR_NAME)
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(2, elixirProductEvolve.getNextSellInValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_decrements_quality_by_1_when_sellIn_equals_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(ELIXIR.getName())
            .sellIn(0)
            .quality(10)
            .build());

        Assertions.assertEquals(9, elixirProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_decrements_quality_by_1_when_sellIn_more_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(ELIXIR_NAME)
            .sellIn(3)
            .quality(10)
            .build());

        Assertions.assertEquals(9, elixirProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_decrements_quality_by_2_when_sellIn_less_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(ELIXIR_NAME)
            .sellIn(-1)
            .quality(10)
            .build());

        Assertions.assertEquals(8, elixirProductEvolve.getNextQualityValue(itemWrapper));
    }

    @Test
    public void getNextQualityValue_never_gives_quality_less_than_0() {
        ItemWrapper itemWrapper = new ItemWrapper(builder()
            .name(ELIXIR_NAME)
            .sellIn(-1)
            .quality(1)
            .build());

        Assertions.assertEquals(0, elixirProductEvolve.getNextQualityValue(itemWrapper));
    }
}

