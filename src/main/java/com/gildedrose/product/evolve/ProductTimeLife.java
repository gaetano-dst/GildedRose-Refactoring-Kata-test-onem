package com.gildedrose.product.evolve;

import com.gildedrose.ItemWrapper;
import com.gildedrose.exceptions.GildedRoseProductException;

import java.util.Optional;
import java.util.function.Function;

import static com.gildedrose.utils.ItemUtils.getCopyWithNewQuality;
import static com.gildedrose.utils.ItemUtils.getCopyWithNewSellIn;

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
        ItemWrapper itemWithNewSellIn = this.applyOnSellIn(itemWrapper);
        return this.applyOnQuality(itemWithNewSellIn);
    }

    private ItemWrapper applyOnQuality(ItemWrapper product) {
        return new ItemWrapper(getCopyWithNewQuality(product.getItem(), productEvolve.getNextQualityValue(product)));
    }

    private ItemWrapper applyOnSellIn(ItemWrapper product) {
        return new ItemWrapper(getCopyWithNewSellIn(product.getItem(), productEvolve.getNextSellInValue(product)));
    }
}
