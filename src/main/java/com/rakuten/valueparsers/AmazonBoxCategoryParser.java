package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonBoxCategoryParser implements StringValueParser {
    private static final String CATEGORY_SELECTOR = ".a-box-inner";
    @Override
    public String parseValue(Document doc) {
        Elements parentBox = doc.select(CATEGORY_SELECTOR);
        assertParseSucceeded(parentBox, CATEGORY_SELECTOR);
        return parentBox.first().select("a").text().trim();
    }
}
