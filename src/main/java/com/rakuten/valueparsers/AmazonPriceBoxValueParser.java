package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class AmazonPriceBoxValueParser implements StringValueParser {
    private static final String PRICE_SELECTOR = "#priceblock_ourprice";

    @Override
    public String parseValue(Document doc) {
        Elements priceTag = doc.select(PRICE_SELECTOR);
        assertParseSucceeded(priceTag, PRICE_SELECTOR);
        return priceTag.first().text();
    }
}
