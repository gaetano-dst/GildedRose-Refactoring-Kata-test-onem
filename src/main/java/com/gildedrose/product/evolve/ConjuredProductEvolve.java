package com.gildedrose.product.evolve;


class ConjuredProductEvolve extends StandardProductEvolve {

    @Override
    public int getNextQualityValue(ItemWrapper itemWrapper) {
        int newQuality = itemWrapper.getQuality() - UNIT_BY_2;
        return Math.max(newQuality, MIN_QUALITY);
    }
}
