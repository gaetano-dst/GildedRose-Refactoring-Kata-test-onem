package com.gildedrose;

import com.gildedrose.testutils.ExpectedState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gildedrose.ItemBuilder.builder;

class GildedRoseBackstageProductTimelifeTest {


    @DisplayName("'Backstage' - quality increments by 1 for each day sellIn decrements by 1 - When sellIn > 10 (start at more than 10 days expiration)")
    @Test
    void updateQuality_on_single_item_Backstage_product_gives_decrement_sellIn_by_one_and_increment_quality_by_one_when_more_than_10_days_of_expiration() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(15)
                .quality(20)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(15, 20), // Initial day
            new ExpectedState(14, 21), // After 1 day
            new ExpectedState(13, 22),  // After 2 days
            new ExpectedState(12, 23)  // After 3 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Backstage' - quality increments by 2 for each day sellIn decrements by 1 - When sellIn is between 5 and 10 (start at 11 days expiration)")
    @Test
    void updateQuality_on_single_item_Backstage_product_gives_decrements_sellIn_by_one_and_quality_increments_by_two_when_sellIn_between_5_and_10() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(11)
                .quality(20)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(11, 20), // Initial day
            new ExpectedState(10, 21), // After 1 day (quality +1)
            new ExpectedState(9, 23), // After 2 days (quality +2)
            new ExpectedState(8, 25),  // After 3 days
            new ExpectedState(7, 27)  // After 4 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Backstage' - quality increments by 3 for each day sellIn decrements by 1 - When sellIn is between 0 and 5 (start at 6 days expiration)")
    @Test
    void updateQuality_on_single_item_Backstage_product_gives_decrements_sellIn_by_one_and_quality_increments_by_three_when_sellIn_between_0_and_5() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(6)
                .quality(20)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(6, 20), // Initial day
            new ExpectedState(5, 22), // After 1 day (quality +2)
            new ExpectedState(4, 25), // After 2 days (quality +3)
            new ExpectedState(3, 28),  // After 3 days
            new ExpectedState(2, 31),  // After 4 days
            new ExpectedState(1, 34),  // After 5 days
            new ExpectedState(0, 37)  // After 6 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Backstage' - quality never more than 50")
    @Test
    void updateQuality_on_single_item_Backstage_product_gives_quality_never_more_than_50() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(15)
                .quality(49)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(15, 49), // Initial day
            new ExpectedState(14, 50), // After 1 day (quality +1)
            new ExpectedState(13, 50), // After 2 days (max 50)
            new ExpectedState(12, 50)  // After 3 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Backstage' - quality is 0 when sellIn expired ( (sellIn < 0)")
    @Test
    void updateQuality_on_single_item_Backstage_product_gives_quality_0_when_expired() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Backstage passes to a TAFKAL80ETC concert")
                .sellIn(0)
                .quality(49)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(0, 49), // Initial day
            new ExpectedState(-1, 0), // After 1 day (quality 0)
            new ExpectedState(-2, 0), // After 2 days
            new ExpectedState(-3, 0)  // After 3 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

}
