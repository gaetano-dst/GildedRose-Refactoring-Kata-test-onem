package com.gildedrose;

import com.gildedrose.product.evolve.ProductTimeLife;
import com.gildedrose.utils.ItemUtils;

import java.util.Arrays;
import java.util.Optional;

import static com.gildedrose.product.evolve.ProductEvolveProvider.getEvolve;

class GildedRose {

    Item[] items;

    GildedRose(Item[] items) {
        this.items = copyItems(items);
    }

    void updateQuality() {
        this.items = Arrays.stream(this.items)
            .map(ItemWrapper::new)
            .map(itemWrapper -> new ProductTimeLife(getEvolve(itemWrapper.getProductType())).apply(itemWrapper))
            .map(ItemWrapper::getItem)
            .toArray(Item[]::new);
    }

    private Item[] copyItems(Item[] items) {
        return Optional.ofNullable(items)
            .stream()
            .flatMap(Arrays::stream)
            .map(ItemUtils::getCopy)
            .toArray(Item[]::new);
    }

}
