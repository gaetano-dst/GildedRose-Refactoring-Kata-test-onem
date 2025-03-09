package com.gildedrose.product.evolve;

import com.gildedrose.exceptions.GildedRoseProductException;

import java.util.Optional;
import java.util.function.Function;


/**
 * Apply the life evolution on the products
 */
public class ProductTimeLife implements Function<ItemWrapper, ItemWrapper> {

    private final ProductEvolve productEvolve;

    public ProductTimeLife(ProductEvolve productEvolve) {
        this.productEvolve = Optional.ofNullable(productEvolve)
            .orElseThrow(() -> new GildedRoseProductException("ProductEvolve is not allowed in Timelife"));
    }

    @Override
    public ItemWrapper apply(ItemWrapper itemWrapper) {
        itemWrapper.updateSellIn(productEvolve.getNextSellInValue(itemWrapper));
        itemWrapper.updateQuality(productEvolve.getNextQualityValue(itemWrapper));

        return itemWrapper;
    }

}
