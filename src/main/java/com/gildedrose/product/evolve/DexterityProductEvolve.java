package com.gildedrose.product.evolve;

class DexterityProductEvolve extends StandardProductEvolve {

    @Override
    public int getNextQualityValue(ItemWrapper itemWrapper) {
        int newQuality = itemWrapper.getSellIn() < SELL_IN_ZERO
            ? itemWrapper.getQuality() - UNIT_BY_2
            : itemWrapper.getQuality() - UNIT_BY_1;

        return Math.max(newQuality, MIN_QUALITY);
    }

}
