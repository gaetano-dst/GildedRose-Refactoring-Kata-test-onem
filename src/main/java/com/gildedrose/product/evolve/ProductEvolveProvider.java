package com.gildedrose.product.evolve;

import com.gildedrose.ProductType;
import com.gildedrose.exceptions.GildedRoseProductException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductEvolveProvider {
    private static final Map<ProductType, ProductEvolve> EVOLVES = new HashMap<>();

    static {
        EVOLVES.put(ProductType.STANDARD, new StandardProductEvolve());
        EVOLVES.put(ProductType.AGED_BRIE, new AgedBrieProductEvolve());
        EVOLVES.put(ProductType.BACKSTAGE, new BackstageProductEvolve());
        EVOLVES.put(ProductType.DEXTERITY, new DexterityProductEvolve());
        EVOLVES.put(ProductType.ELIXIR, new ElixirProductEvolve());
        EVOLVES.put(ProductType.SULFURAS, new SulfurasProductEvolve());
        EVOLVES.put(ProductType.CONJURED, new ConjuredProductEvolve());
    }

    private ProductEvolveProvider() {
    }

    /**
     *
     * @param productType not null
     * @return the right evolve based on the product type
     */
    public static ProductEvolve getEvolve(ProductType productType) {
        return Optional.ofNullable(productType)
            .map(EVOLVES::get)
            .orElseThrow(() -> new GildedRoseProductException("ProductType cannot be null to find ProductEvolve"));
    }

}
