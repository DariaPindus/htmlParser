package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonCarNameValueParser implements StringValueParser {
    private static final String NAME_SELECTOR = "#product-title";

    @Override
    public String parseValue(Document doc) {
        Elements nameDiv = doc.select(NAME_SELECTOR);
        assertParseSucceeded(nameDiv, NAME_SELECTOR);
        return nameDiv.first().select("h1").first().text();
    }
}
