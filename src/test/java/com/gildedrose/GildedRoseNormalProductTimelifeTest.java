package com.gildedrose;

import com.gildedrose.testutils.ExpectedState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gildedrose.ItemBuilder.builder;

class GildedRoseNormalProductTimelifeTest {


    @DisplayName("'Dexterity Elixir' (normal or standard product) - quality decrements by 1 for each day sellIn decrements by 1 - When sellIn > 0")
    @Test
    void updateQuality_on_single_item_Dexterity_product_gives_decrement_both_sellIn_and_quality_by_one() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("+5 Dexterity Vest")
                .sellIn(10)
                .quality(20)
                .build(),
            builder()
                .name("Elixir of the Mongoose")
                .sellIn(10)
                .quality(20)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(10, 20), // Initial day
            new ExpectedState(9, 19), // After 1 day
            new ExpectedState(8, 18)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Dexterity Elixir' (normal or standard product) - quality decrements by 2 for each day sellIn decrements by 1 - When sellIn < 0 (product expired)")
    @Test
    void updateQuality_on_single_item_Dexterity_product_gives_decrement_sellIn_by_one_and_quality_by_two_when_sellIn_is_expired() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("+5 Dexterity Vest")
                .sellIn(0)
                .quality(20)
                .build(),
            builder()
                .name("Elixir of the Mongoose")
                .sellIn(0)
                .quality(20)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(0, 20), // Initial day
            new ExpectedState(-1, 18), // After 1 day
            new ExpectedState(-2, 16)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Dexterity Elixir' (normal or standard product) - quality never less than 0")
    @Test
    void updateQuality_on_single_item_Dexterity_product_quality_is_never_less_than_0() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("+5 Dexterity Vest")
                .sellIn(0)
                .quality(1)
                .build(),
            builder()
                .name("Elixir of the Mongoose")
                .sellIn(0)
                .quality(1)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(0, 1), // Initial day
            new ExpectedState(-1, 0), // After 1 day
            new ExpectedState(-2, 0)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }
}
