package com.gildedrose;

import com.gildedrose.testutils.ExpectedState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.gildedrose.ItemBuilder.builder;

public class GildedRoseSulfurasProductTimeLifeTest {


    @DisplayName("'Sulfuras' - quality gives always same initialized sellIn and Quality always 80 - Whatever sellIn value is (start from 0)")
    @Test
    public void updateQuality_on_items_Sulfuras_products_give_always_same_sellIn_and_quality_to_80_after_update() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(0)
                .quality(80)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(0, 80), // Initial day
            new ExpectedState(0, 80), // After 1 day
            new ExpectedState(0, 80)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Sulfuras' - quality gives always same initialized sellIn and Quality always 80 - Whatever sellIn value is (start from -1)")
    @Test
    public void updateQuality_on_items_Sulfuras_products_give_always_same_sellIn_and_quality_after_update_when_sellIn_expired() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(-1)
                .quality(80)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(-1, 80), // Initial day
            new ExpectedState(-1, 80), // After 1 day
            new ExpectedState(-1, 80)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

    @DisplayName("'Sulfuras' - quality gives always same initialized sellIn and Quality always 80 - Whatever sellIn value is (start from 3)")
    @Test
    public void updateQuality_on_items_Sulfuras_products_should_always_be_80() {
        GildedRose app = new GildedRose(new Item[] {
            builder()
                .name("Sulfuras, Hand of Ragnaros")
                .sellIn(3)
                .quality(10)
                .build()
        });

        // Expected values
        List<ExpectedState> expectedStates = List.of(
            new ExpectedState(3, 10), // Initial day (before update)
            new ExpectedState(3, 80), // After 1 day
            new ExpectedState(3, 80)  // After 2 days
        );

        SimulationAssertionsTestUtils.simulateAndAssert(expectedStates, app);
    }

}
