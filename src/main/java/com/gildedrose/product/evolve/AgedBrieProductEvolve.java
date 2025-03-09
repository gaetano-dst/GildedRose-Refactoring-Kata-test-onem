package com.gildedrose.product.evolve;

import com.gildedrose.ItemWrapper;

class AgedBrieProductEvolve extends StandardProductEvolve {

    @Override
    public int getNextQualityValue(ItemWrapper itemWrapper) {
        int newQuality = itemWrapper.getItem().sellIn < SELL_IN_ZERO
            ? itemWrapper.getItem().quality + UNIT_BY_2
            : itemWrapper.getItem().quality + UNIT_BY_1;

        return Math.min(newQuality, MAX_QUALITY);
    }

}
