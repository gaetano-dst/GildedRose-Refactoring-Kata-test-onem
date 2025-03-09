package com.gildedrose;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.gildedrose.testutils.ProductNameTestUtils.*;

public class ProductTypeTest {

    @Test
    public void fromName_gives_ProductType_AGED_BRIE_when_Aged_Brie_name() {
        Assertions.assertEquals(ProductType.AGED_BRIE, ProductType.fromName(AGED_BRIE_NAME));
    }

    @Test
    public void fromName_gives_ProductType_BACKSTAGE_when_Backstage_name() {
        Assertions.assertEquals(ProductType.BACKSTAGE, ProductType.fromName(BACKSTAGE_NAME));
    }

    @Test
    public void fromName_gives_ProductType_DEXTERITY_when_Aged_Brie_name() {
        Assertions.assertEquals(ProductType.DEXTERITY, ProductType.fromName(DEXTERITY_NAME));
    }

    @Test
    public void fromName_gives_ProductType_ELIXIR_when_Aged_Brie_name() {
        Assertions.assertEquals(ProductType.ELIXIR, ProductType.fromName(ELIXIR_NAME));
    }

    @Test
    public void fromName_gives_ProductType_SULFURAS_when_Aged_Brie_name() {
        Assertions.assertEquals(ProductType.SULFURAS, ProductType.fromName(SULFURAS_NAME));
    }

    @Test
    public void fromName_gives_ProductType_STANDARD_when_no_name_corresponding() {
        Assertions.assertEquals(ProductType.STANDARD, ProductType.fromName("OTHER"));
    }
}
