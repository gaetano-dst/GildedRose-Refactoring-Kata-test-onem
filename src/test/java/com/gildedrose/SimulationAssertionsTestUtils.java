package com.gildedrose;


import com.gildedrose.testutils.ExpectedState;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * This class only used in tests for simulate the update on products items
 * And Asserts that the values are the expected ones
 *
 */
public class SimulationAssertionsTestUtils {

    private SimulationAssertionsTestUtils() {
    }


    public static void simulateAndAssert(List<ExpectedState> expectedStates, GildedRose app) {
        // Each day simulation
        for (int day = 0; day < expectedStates.size(); day++) {
            System.out.println("-------- day " + day + " --------");
            System.out.println("name, sellIn, quality");

            // Get expected values for the current day
            ExpectedState expectedState = expectedStates.get(day);

            for (Item item : app.getItems()) {
                System.out.println(item);

                // Assertions
                Assertions.assertEquals(expectedState.expectedSellIn(), app.getItems()[0].sellIn, "SellIn not correct on day " + day);
                Assertions.assertEquals(expectedState.expectedQuality(), app.getItems()[0].quality, "Quality not correct on day " + day);
            }

            // Update for next day
            app.updateQuality();
        }
    }

}
