package com.gildedrose.product.evolve;

class AgedBrieProductEvolve extends StandardProductEvolve {

    @Override
    public int getNextQualityValue(ItemWrapper itemWrapper) {
        int newQuality = itemWrapper.getSellIn() < SELL_IN_ZERO
            ? itemWrapper.getQuality() + UNIT_BY_2
            : itemWrapper.getQuality() + UNIT_BY_1;

        return Math.min(newQuality, MAX_QUALITY);
    }

}
