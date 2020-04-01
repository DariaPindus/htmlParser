package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonNameParser implements StringValueParser {

    private static final String NAME_SELECTOR = "#productTitle";

    @Override
    public String parseValue(Document doc) {
        Elements name = doc.select(NAME_SELECTOR);
        assertParseSucceeded(name, NAME_SELECTOR);
        return name.first().text().trim();
    }
}
