package com.gildedrose.product.evolve;

class StandardProductEvolve implements ProductEvolve {

    static final int UNIT_BY_1 = 1;
    static final int UNIT_BY_2 = 2;
    static final int MAX_QUALITY = 50;
    static final int MIN_QUALITY = 0;
    static final int SELL_IN_ZERO = 0;

    @Override
    public int getNextSellInValue(ItemWrapper itemWrapper) {
        return itemWrapper.getSellIn() - UNIT_BY_1;
    }

    @Override
    public int getNextQualityValue(ItemWrapper itemWrapper) {
        return itemWrapper.getQuality() - UNIT_BY_1;
    }
}
