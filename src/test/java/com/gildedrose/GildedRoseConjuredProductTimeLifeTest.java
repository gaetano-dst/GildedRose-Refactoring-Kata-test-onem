package com.gildedrose;

import com.gildedrose.testutils.ExpectedState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gildedrose.ItemBuilder.builder;
import static com.gildedrose.ProductType.CONJURED;


class GildedRoseConjuredProductTimeLifeTest {



    @DisplayName("'Conjured' - quality decrements by 2 for each day sellIn decrements by 1 - When sellIn > 0")
    @Test
     void updateQuality_on_single_item_Conjured_product_gives_decrement_sellIn_by_one_and_quality_by_two() {
        GildedRose app = new GildedRose(new Item[]{
            builder()
            .name(CONJURED.getName())
            .sellIn(3)
            .quality(6)
            .build()
        });


        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(3, 6), // Initial day
            new ExpectedState(2, 4), // After 1 day
            new ExpectedState(1, 2)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Conjured' - quality never less than 0")
    @Test
     void updateQuality_on_single_item_Conjured_product_quality_is_never_less_than_0() {
        GildedRose app = new GildedRose(new Item[]{
            builder()
            .name(CONJURED.getName())
            .sellIn(10)
            .quality(1)
            .build()
        });


        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(10, 1), // Initial day
            new ExpectedState(9, 0), // After 1 day
            new ExpectedState(8, 0)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }
}
