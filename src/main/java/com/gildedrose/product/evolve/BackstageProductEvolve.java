package com.gildedrose.product.evolve;

import com.gildedrose.ItemWrapper;

class BackstageProductEvolve extends StandardProductEvolve {

    private static final int SELL_IN_5_DAYS = 5;
    private static final int SELL_IN_10_DAYS = 10;
    private static final int UNIT_BY_3 = 3;

    @Override
    public int getNextQualityValue(ItemWrapper itemWrapper) {
        if (itemWrapper.getItem().sellIn < SELL_IN_ZERO) {
            return SELL_IN_ZERO;
        }

        return Math.min(incrementQuality(itemWrapper), MAX_QUALITY);
    }

    private int incrementQuality(ItemWrapper product) {
        if (product.getItem().sellIn > SELL_IN_10_DAYS) {
            return product.getItem().quality + UNIT_BY_1;
        } else if (product.getItem().sellIn > SELL_IN_5_DAYS) {
            return product.getItem().quality + UNIT_BY_2;
        } else {
            return product.getItem().quality + UNIT_BY_3;
        }
    }

}
