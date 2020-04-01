package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

@FunctionalInterface
public interface StringValueParser {

    default void assertParseSucceeded(Elements elements, String selector) {
        if (elements.isEmpty())
            throw new IllegalStateException(selector + " not found on page");
    }

    String parseValue(Document doc);
}
