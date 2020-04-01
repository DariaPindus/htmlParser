package com.rakuten;

import org.jsoup.nodes.Document;

@FunctionalInterface
public interface StringValueParser {
    String parseValue(Document doc);
}
