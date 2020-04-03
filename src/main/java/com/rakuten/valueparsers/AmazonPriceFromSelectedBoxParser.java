package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class AmazonPriceFromSelectedBoxParser extends StringFieldParser {

    public AmazonPriceFromSelectedBoxParser() {
        super("#tmmSwatches > ul > .selected a[role] .a-color-price");
    }

    @Override
    public String parseValue(Document doc) {
        Elements priceTag = doc.select(SELECTOR);
        return priceTag.first().text();
    }
}
