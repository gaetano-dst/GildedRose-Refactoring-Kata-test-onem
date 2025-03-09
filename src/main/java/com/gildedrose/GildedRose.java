package com.gildedrose;

import com.gildedrose.product.evolve.ItemWrapper;
import com.gildedrose.product.evolve.ProductTimeLife;

import java.util.Arrays;
import java.util.Optional;

import static com.gildedrose.product.evolve.ProductEvolveProvider.getEvolve;

class GildedRose {

    private ItemWrapper[] itemWrappers;

    GildedRose(Item[] items) {
        this.itemWrappers = copyItems(Optional.ofNullable(items).orElse(new Item[0]));
    }

    void updateQuality() {
        this.itemWrappers = Arrays.stream(this.itemWrappers)
            .map(itemWrapper -> new ProductTimeLife(getEvolve(itemWrapper.getProductType())).apply(itemWrapper))
            .toArray(ItemWrapper[]::new);
    }

    private ItemWrapper[] copyItems(Item[] items) {
        return Arrays.stream(items)
            .map(ItemWrapper::new)
            .toArray(ItemWrapper[]::new);
    }

    public Item[] getItems() {
        return Arrays.stream(this.itemWrappers)
            .map(wrapper -> new Item(wrapper.getName(), wrapper.getSellIn(), wrapper.getQuality()))
            .toArray(Item[]::new);
    }
}
