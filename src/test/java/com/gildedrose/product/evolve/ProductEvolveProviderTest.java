package com.gildedrose.product.evolve;

import com.gildedrose.ProductType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.product.evolve.ProductEvolveProvider.getEvolve;

public class ProductEvolveProviderTest {

    @Test
    public void getEvolve_give_StandardProductEvolve_when_ProductType_STANDARD() {
        Assertions.assertEquals(StandardProductEvolve.class, getEvolve(ProductType.STANDARD).getClass());
    }

    @Test
    public void getEvolve_give_AgedBrieProductProductEvolve_when_ProductType_AGED_BRIE() {
        Assertions.assertEquals(AgedBrieProductEvolve.class, getEvolve(ProductType.AGED_BRIE).getClass());
    }

    @Test
    public void getEvolve_give_BackstageProductProductEvolve_when_ProductType_BACKSTAGE() {
        Assertions.assertEquals(BackstageProductEvolve.class, getEvolve(ProductType.BACKSTAGE).getClass());
    }

    @Test
    public void getEvolve_give_DexterityProductProductEvolve_when_ProductType_DEXTERITY() {
        Assertions.assertEquals(DexterityProductEvolve.class, getEvolve(ProductType.DEXTERITY).getClass());
    }

    @Test
    public void getEvolve_give_ElixirProductProductEvolve_when_ProductType_ELIXIR() {
        Assertions.assertEquals(ElixirProductEvolve.class, getEvolve(ProductType.ELIXIR).getClass());
    }

    @Test
    public void getEvolve_give_SulfurasProductEvolve_when_ProductType_SULFURAS() {
        Assertions.assertEquals(SulfurasProductEvolve.class, getEvolve(ProductType.SULFURAS).getClass());
    }
}
