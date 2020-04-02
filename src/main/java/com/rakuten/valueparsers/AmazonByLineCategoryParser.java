package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonByLineCategoryParser implements StringValueParser {
    private static final String CATEGORY_SELECTOR = "#bylineInfo";

    @Override
    public String parseValue(Document doc) {
        Elements name = doc.select(CATEGORY_SELECTOR);
        assertParseSucceeded(name, CATEGORY_SELECTOR);
        return name.first().text().trim();
    }
}
