package com.gildedrose;

import com.gildedrose.testutils.ExpectedState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gildedrose.ItemBuilder.builder;

class GildedRoseAgedBrieProductTimeLifeTest {


    @DisplayName("'Aged Brie' - quality increments by 1 for each day sellIn decrements by 1 - When sellIn > 0")
    @Test
    void updateQuality_on_single_item_Brie_gives_decrement_sellIn_by_one_and_increment_quality_by_one() {
        GildedRose app = new GildedRose(new Item[]{
            builder()
                .name("Aged Brie")
                .sellIn(2)
                .quality(0)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(2, 0), // Initial day
            new ExpectedState(1, 1), // After 1 day
            new ExpectedState(0, 2)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }



    @DisplayName("'Aged Brie' - quality increments by 2 for each day sellIn decrements by 1 - When sellIn is expired (starts at 0)")
    @Test
    void updateQuality_on_single_item_Brie_gives_decrement_sellIn_by_one_and_quality_by_two_when_sellIn_is_expired() {
        GildedRose app = new GildedRose(new Item[]{
            builder()
                .name("Aged Brie")
                .sellIn(0)
                .quality(0)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(0, 0), // Initial day
            new ExpectedState(-1, 2), // After 1 day
            new ExpectedState(-2, 4),  // After 2 days
            new ExpectedState(-3, 6)  // After 3 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Aged Brie' - quality will never be more than 50")
    @Test
    void updateQuality_on_single_item_Brie_quality_is_never_more_than_50() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Aged Brie")
                .sellIn(0)
                .quality(49)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(0, 49), // Initial day
            new ExpectedState(-1, 50), // After 1 day
            new ExpectedState(-2, 50),  // After 2 days
            new ExpectedState(-3, 50)  // After 3 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

}
