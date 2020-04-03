package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonPriceByPriceIdParser extends StringFieldParser {
    public AmazonPriceByPriceIdParser() {
        super("#priceblock_ourprice");
    }

    @Override
    public String parseValue(Document doc) {
        Elements priceBlock = doc.select(SELECTOR);
        return priceBlock.text();
    }
}
